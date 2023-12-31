import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {AvoirVenteAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteAdmin.service';
import {AvoirVenteDto} from 'src/app/controller/model/stock/AvoirVente.model';
import {AvoirVenteCriteria} from 'src/app/controller/criteria/stock/AvoirVenteCriteria.model';


import {EtatAvoirVenteDto} from 'src/app/controller/model/commun/EtatAvoirVente.model';
import {EtatAvoirVenteAdminService} from 'src/app/controller/service/admin/commun/EtatAvoirVenteAdmin.service';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';
import {AvoirVenteItemDto} from 'src/app/controller/model/stock/AvoirVenteItem.model';
import {AvoirVenteItemAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteItemAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {AchatDto} from 'src/app/controller/model/stock/Achat.model';
import {AchatAdminService} from 'src/app/controller/service/admin/stock/AchatAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';
import {ClientDto} from 'src/app/controller/model/commun/Client.model';
import {ClientAdminService} from 'src/app/controller/service/admin/commun/ClientAdmin.service';

@Component({
  selector: 'app-avoir-vente-edit-admin',
  templateUrl: './avoir-vente-edit-admin.component.html'
})
export class AvoirVenteEditAdminComponent extends AbstractEditController<AvoirVenteDto, AvoirVenteCriteria, AvoirVenteAdminService>   implements OnInit {

    private _avoirVenteItemsElement = new AvoirVenteItemDto();
    private _avoirsElement = new AvoirVenteItemDto();

    private _validAvoirVenteBarCode = true;
    private _validAvoirVenteEntrepriseSociete = true;
    private _validAvoirVenteCodeAvoirVente = true;
    private _validAvoirVenteNumeroFactureAvoirVente = true;
    private _validAvoirVenteDateFactureAvoirVente = true;
    private _validAvoirVenteClient = true;
    private _validAvoirVenteMontantTtc = true;

    private _validEntrepriseSocieteNom = true;
    private _validClientCin = true;
    private _validEtatAvoirVenteLibelle = true;
    private _validAvoirVenteItemsBarCode = true;
    private _validAvoirVenteItemsDepot = true;
    private _validAvoirVenteItemsProduit = true;
    private _validAvoirVenteItemsQuantite = true;
    private _validAvoirVenteItemsQuantiteVendue = true;
    private _validAvoirVenteItemsPrixUnitaireHt = true;
    private _validAvoirVenteItemsPrixUnitaireTtc = true;
    private _validAvoirVenteItemsRemise = true;
    private _validAvoirVenteItemsMontantHt = true;
    private _validAvoirVenteItemsMontantTtc = true;
    private _validAvoirsBarCode = true;
    private _validAvoirsDepot = true;
    private _validAvoirsProduit = true;
    private _validAvoirsQuantite = true;
    private _validAvoirsQuantiteVendue = true;
    private _validAvoirsPrixUnitaireHt = true;
    private _validAvoirsPrixUnitaireTtc = true;
    private _validAvoirsRemise = true;
    private _validAvoirsMontantHt = true;
    private _validAvoirsMontantTtc = true;
    private _validAchatDateFacture = true;
    private _validAchatFournisseur = true;
    private _validAchatMontantHt = true;
    private _validAchatMontantTva = true;
    private _validAchatMontantTtc = true;



    constructor( private avoirVenteService: AvoirVenteAdminService , private produitService: ProduitAdminService, private etatAvoirVenteService: EtatAvoirVenteAdminService, private achatService: AchatAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService, private clientService: ClientAdminService, private depotService: DepotAdminService, private taxeService: TaxeAdminService, private avoirVenteItemService: AvoirVenteItemAdminService) {
        super(avoirVenteService);
    }

    ngOnInit(): void {
        this.avoirVenteItemsElement.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);
        this.avoirVenteItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.avoirVenteItemsElement.taxe = new TaxeDto();
        this.taxeService.findAll().subscribe((data) => this.taxes = data);

        this.avoirsElement.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);
        this.avoirsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.avoirsElement.taxe = new TaxeDto();
        this.taxeService.findAll().subscribe((data) => this.taxes = data);

        this.entrepriseSociete = new EntrepriseSocieteDto();
        this.entrepriseSocieteService.findAll().subscribe((data) => this.entrepriseSocietes = data);
        this.client = new ClientDto();
        this.clientService.findAll().subscribe((data) => this.clients = data);
        this.etatAvoirVente = new EtatAvoirVenteDto();
        this.etatAvoirVenteService.findAll().subscribe((data) => this.etatAvoirVentes = data);
        this.achat = new AchatDto();
        this.achatService.findAll().subscribe((data) => this.achats = data);
    }
    public prepareEdit() {
        this.item.dateFactureAvoirVente = this.avoirVenteService.format(this.item.dateFactureAvoirVente);
    }



    public validateAvoirVenteItems(){
        this.errorMessages = new Array();
        this.validateAvoirVenteItemsBarCode();
        this.validateAvoirVenteItemsDepot();
        this.validateAvoirVenteItemsProduit();
        this.validateAvoirVenteItemsQuantite();
        this.validateAvoirVenteItemsQuantiteVendue();
        this.validateAvoirVenteItemsPrixUnitaireHt();
        this.validateAvoirVenteItemsPrixUnitaireTtc();
        this.validateAvoirVenteItemsRemise();
        this.validateAvoirVenteItemsMontantHt();
        this.validateAvoirVenteItemsMontantTtc();
    }
    public validateAvoirs(){
        this.errorMessages = new Array();
        this.validateAvoirsBarCode();
        this.validateAvoirsDepot();
        this.validateAvoirsProduit();
        this.validateAvoirsQuantite();
        this.validateAvoirsQuantiteVendue();
        this.validateAvoirsPrixUnitaireHt();
        this.validateAvoirsPrixUnitaireTtc();
        this.validateAvoirsRemise();
        this.validateAvoirsMontantHt();
        this.validateAvoirsMontantTtc();
    }
    public setValidation(value: boolean){
        this.validAvoirVenteBarCode = value;
        this.validAvoirVenteEntrepriseSociete = value;
        this.validAvoirVenteCodeAvoirVente = value;
        this.validAvoirVenteNumeroFactureAvoirVente = value;
        this.validAvoirVenteDateFactureAvoirVente = value;
        this.validAvoirVenteClient = value;
        this.validAvoirVenteMontantTtc = value;
        this.validAvoirVenteItemsBarCode = value;
        this.validAvoirVenteItemsDepot = value;
        this.validAvoirVenteItemsProduit = value;
        this.validAvoirVenteItemsQuantite = value;
        this.validAvoirVenteItemsQuantiteVendue = value;
        this.validAvoirVenteItemsPrixUnitaireHt = value;
        this.validAvoirVenteItemsPrixUnitaireTtc = value;
        this.validAvoirVenteItemsRemise = value;
        this.validAvoirVenteItemsMontantHt = value;
        this.validAvoirVenteItemsMontantTtc = value;
        this.validAvoirsBarCode = value;
        this.validAvoirsDepot = value;
        this.validAvoirsProduit = value;
        this.validAvoirsQuantite = value;
        this.validAvoirsQuantiteVendue = value;
        this.validAvoirsPrixUnitaireHt = value;
        this.validAvoirsPrixUnitaireTtc = value;
        this.validAvoirsRemise = value;
        this.validAvoirsMontantHt = value;
        this.validAvoirsMontantTtc = value;
        }
   public addAvoirVenteItems() {
        if( this.item.avoirVenteItems == null )
            this.item.avoirVenteItems = new Array<AvoirVenteItemDto>();
       this.validateAvoirVenteItems();
       if (this.errorMessages.length === 0) {
            if(this.avoirVenteItemsElement.id == null){
                this.item.avoirVenteItems.push(this.avoirVenteItemsElement);
            }else{
                const index = this.item.avoirVenteItems.findIndex(e => e.id == this.avoirVenteItemsElement.id);
                this.item.avoirVenteItems[index] = this.avoirVenteItemsElement;
            }
          this.avoirVenteItemsElement = new AvoirVenteItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteAvoirVenteItems(p: AvoirVenteItemDto) {
        this.item.avoirVenteItems.forEach((element, index) => {
            if (element === p) { this.item.avoirVenteItems.splice(index, 1); }
        });
    }

    public editAvoirVenteItems(p: AvoirVenteItemDto) {
        this.avoirVenteItemsElement = {... p};
        this.activeTab = 0;
    }
   public addAvoirs() {
        if( this.item.avoirs == null )
            this.item.avoirs = new Array<AvoirVenteItemDto>();
       this.validateAvoirs();
       if (this.errorMessages.length === 0) {
            if(this.avoirsElement.id == null){
                this.item.avoirs.push(this.avoirsElement);
            }else{
                const index = this.item.avoirs.findIndex(e => e.id == this.avoirsElement.id);
                this.item.avoirs[index] = this.avoirsElement;
            }
          this.avoirsElement = new AvoirVenteItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteAvoirs(p: AvoirVenteItemDto) {
        this.item.avoirs.forEach((element, index) => {
            if (element === p) { this.item.avoirs.splice(index, 1); }
        });
    }

    public editAvoirs(p: AvoirVenteItemDto) {
        this.avoirsElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateAvoirVenteBarCode();
        this.validateAvoirVenteEntrepriseSociete();
        this.validateAvoirVenteCodeAvoirVente();
        this.validateAvoirVenteNumeroFactureAvoirVente();
        this.validateAvoirVenteDateFactureAvoirVente();
        this.validateAvoirVenteClient();
        this.validateAvoirVenteMontantTtc();
    }
    public validateAvoirVenteBarCode(){
        if (this.stringUtilService.isEmpty(this.item.barCode)) {
            this.errorMessages.push('Bar code non valide');
            this.validAvoirVenteBarCode = false;
        } else {
            this.validAvoirVenteBarCode = true;
        }
    }
    public validateAvoirVenteEntrepriseSociete(){
        if (this.stringUtilService.isEmpty(this.item.entrepriseSociete)) {
            this.errorMessages.push('Entreprise societe non valide');
            this.validAvoirVenteEntrepriseSociete = false;
        } else {
            this.validAvoirVenteEntrepriseSociete = true;
        }
    }
    public validateAvoirVenteCodeAvoirVente(){
        if (this.stringUtilService.isEmpty(this.item.codeAvoirVente)) {
            this.errorMessages.push('Code avoir vente non valide');
            this.validAvoirVenteCodeAvoirVente = false;
        } else {
            this.validAvoirVenteCodeAvoirVente = true;
        }
    }
    public validateAvoirVenteNumeroFactureAvoirVente(){
        if (this.stringUtilService.isEmpty(this.item.numeroFactureAvoirVente)) {
            this.errorMessages.push('Numero facture avoir vente non valide');
            this.validAvoirVenteNumeroFactureAvoirVente = false;
        } else {
            this.validAvoirVenteNumeroFactureAvoirVente = true;
        }
    }
    public validateAvoirVenteDateFactureAvoirVente(){
        if (this.stringUtilService.isEmpty(this.item.dateFactureAvoirVente)) {
            this.errorMessages.push('Date facture avoir vente non valide');
            this.validAvoirVenteDateFactureAvoirVente = false;
        } else {
            this.validAvoirVenteDateFactureAvoirVente = true;
        }
    }
    public validateAvoirVenteClient(){
        if (this.stringUtilService.isEmpty(this.item.client)) {
            this.errorMessages.push('Client non valide');
            this.validAvoirVenteClient = false;
        } else {
            this.validAvoirVenteClient = true;
        }
    }
    public validateAvoirVenteMontantTtc(){
        if (this.stringUtilService.isEmpty(this.item.montantTtc)) {
            this.errorMessages.push('Montant ttc non valide');
            this.validAvoirVenteMontantTtc = false;
        } else {
            this.validAvoirVenteMontantTtc = true;
        }
    }


    private validateAvoirVenteItemsBarCode(){
        if (this.avoirVenteItemsElement.barCode == null) {
        this.errorMessages.push('BarCode de la avoirVenteItem est  invalide');
            this.validAvoirVenteItemsBarCode = false;
        } else {
            this.validAvoirVenteItemsBarCode = true;
        }
    }
    private validateAvoirVenteItemsDepot(){
        if (this.avoirVenteItemsElement.depot == null) {
        this.errorMessages.push('Depot de la avoirVenteItem est  invalide');
            this.validAvoirVenteItemsDepot = false;
        } else {
            this.validAvoirVenteItemsDepot = true;
        }
    }
    private validateAvoirVenteItemsProduit(){
        if (this.avoirVenteItemsElement.produit == null) {
        this.errorMessages.push('Produit de la avoirVenteItem est  invalide');
            this.validAvoirVenteItemsProduit = false;
        } else {
            this.validAvoirVenteItemsProduit = true;
        }
    }
    private validateAvoirVenteItemsQuantite(){
        if (this.avoirVenteItemsElement.quantite == null) {
        this.errorMessages.push('Quantite de la avoirVenteItem est  invalide');
            this.validAvoirVenteItemsQuantite = false;
        } else {
            this.validAvoirVenteItemsQuantite = true;
        }
    }
    private validateAvoirVenteItemsQuantiteVendue(){
        if (this.avoirVenteItemsElement.quantiteVendue == null) {
        this.errorMessages.push('QuantiteVendue de la avoirVenteItem est  invalide');
            this.validAvoirVenteItemsQuantiteVendue = false;
        } else {
            this.validAvoirVenteItemsQuantiteVendue = true;
        }
    }
    private validateAvoirVenteItemsPrixUnitaireHt(){
        if (this.avoirVenteItemsElement.prixUnitaireHt == null) {
        this.errorMessages.push('PrixUnitaireHt de la avoirVenteItem est  invalide');
            this.validAvoirVenteItemsPrixUnitaireHt = false;
        } else {
            this.validAvoirVenteItemsPrixUnitaireHt = true;
        }
    }
    private validateAvoirVenteItemsPrixUnitaireTtc(){
        if (this.avoirVenteItemsElement.prixUnitaireTtc == null) {
        this.errorMessages.push('PrixUnitaireTtc de la avoirVenteItem est  invalide');
            this.validAvoirVenteItemsPrixUnitaireTtc = false;
        } else {
            this.validAvoirVenteItemsPrixUnitaireTtc = true;
        }
    }
    private validateAvoirVenteItemsRemise(){
        if (this.avoirVenteItemsElement.remise == null) {
        this.errorMessages.push('Remise de la avoirVenteItem est  invalide');
            this.validAvoirVenteItemsRemise = false;
        } else {
            this.validAvoirVenteItemsRemise = true;
        }
    }
    private validateAvoirVenteItemsMontantHt(){
        if (this.avoirVenteItemsElement.montantHt == null) {
        this.errorMessages.push('MontantHt de la avoirVenteItem est  invalide');
            this.validAvoirVenteItemsMontantHt = false;
        } else {
            this.validAvoirVenteItemsMontantHt = true;
        }
    }
    private validateAvoirVenteItemsMontantTtc(){
        if (this.avoirVenteItemsElement.montantTtc == null) {
        this.errorMessages.push('MontantTtc de la avoirVenteItem est  invalide');
            this.validAvoirVenteItemsMontantTtc = false;
        } else {
            this.validAvoirVenteItemsMontantTtc = true;
        }
    }
    private validateAvoirsBarCode(){
        if (this.avoirsElement.barCode == null) {
        this.errorMessages.push('BarCode de la avoirVenteItem est  invalide');
            this.validAvoirsBarCode = false;
        } else {
            this.validAvoirsBarCode = true;
        }
    }
    private validateAvoirsDepot(){
        if (this.avoirsElement.depot == null) {
        this.errorMessages.push('Depot de la avoirVenteItem est  invalide');
            this.validAvoirsDepot = false;
        } else {
            this.validAvoirsDepot = true;
        }
    }
    private validateAvoirsProduit(){
        if (this.avoirsElement.produit == null) {
        this.errorMessages.push('Produit de la avoirVenteItem est  invalide');
            this.validAvoirsProduit = false;
        } else {
            this.validAvoirsProduit = true;
        }
    }
    private validateAvoirsQuantite(){
        if (this.avoirsElement.quantite == null) {
        this.errorMessages.push('Quantite de la avoirVenteItem est  invalide');
            this.validAvoirsQuantite = false;
        } else {
            this.validAvoirsQuantite = true;
        }
    }
    private validateAvoirsQuantiteVendue(){
        if (this.avoirsElement.quantiteVendue == null) {
        this.errorMessages.push('QuantiteVendue de la avoirVenteItem est  invalide');
            this.validAvoirsQuantiteVendue = false;
        } else {
            this.validAvoirsQuantiteVendue = true;
        }
    }
    private validateAvoirsPrixUnitaireHt(){
        if (this.avoirsElement.prixUnitaireHt == null) {
        this.errorMessages.push('PrixUnitaireHt de la avoirVenteItem est  invalide');
            this.validAvoirsPrixUnitaireHt = false;
        } else {
            this.validAvoirsPrixUnitaireHt = true;
        }
    }
    private validateAvoirsPrixUnitaireTtc(){
        if (this.avoirsElement.prixUnitaireTtc == null) {
        this.errorMessages.push('PrixUnitaireTtc de la avoirVenteItem est  invalide');
            this.validAvoirsPrixUnitaireTtc = false;
        } else {
            this.validAvoirsPrixUnitaireTtc = true;
        }
    }
    private validateAvoirsRemise(){
        if (this.avoirsElement.remise == null) {
        this.errorMessages.push('Remise de la avoirVenteItem est  invalide');
            this.validAvoirsRemise = false;
        } else {
            this.validAvoirsRemise = true;
        }
    }
    private validateAvoirsMontantHt(){
        if (this.avoirsElement.montantHt == null) {
        this.errorMessages.push('MontantHt de la avoirVenteItem est  invalide');
            this.validAvoirsMontantHt = false;
        } else {
            this.validAvoirsMontantHt = true;
        }
    }
    private validateAvoirsMontantTtc(){
        if (this.avoirsElement.montantTtc == null) {
        this.errorMessages.push('MontantTtc de la avoirVenteItem est  invalide');
            this.validAvoirsMontantTtc = false;
        } else {
            this.validAvoirsMontantTtc = true;
        }
    }

   public async openCreateProduit(produit: string) {
        const isPermistted = await this.roleService.isPermitted('Produit', 'edit');
        if (isPermistted) {
             this.produit = new ProduitDto();
             this.createProduitDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateTaxe(taxe: string) {
        const isPermistted = await this.roleService.isPermitted('Taxe', 'edit');
        if (isPermistted) {
             this.taxe = new TaxeDto();
             this.createTaxeDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateAchat(achat: string) {
        const isPermistted = await this.roleService.isPermitted('Achat', 'edit');
        if (isPermistted) {
             this.achat = new AchatDto();
             this.createAchatDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get produit(): ProduitDto {
       return this.produitService.item;
   }
  set produit(value: ProduitDto) {
        this.produitService.item = value;
   }
   get produits(): Array<ProduitDto> {
        return this.produitService.items;
   }
   set produits(value: Array<ProduitDto>) {
        this.produitService.items = value;
   }
   get createProduitDialog(): boolean {
       return this.produitService.createDialog;
   }
  set createProduitDialog(value: boolean) {
       this.produitService.createDialog= value;
   }
   get client(): ClientDto {
       return this.clientService.item;
   }
  set client(value: ClientDto) {
        this.clientService.item = value;
   }
   get clients(): Array<ClientDto> {
        return this.clientService.items;
   }
   set clients(value: Array<ClientDto>) {
        this.clientService.items = value;
   }
   get createClientDialog(): boolean {
       return this.clientService.createDialog;
   }
  set createClientDialog(value: boolean) {
       this.clientService.createDialog= value;
   }
   get depot(): DepotDto {
       return this.depotService.item;
   }
  set depot(value: DepotDto) {
        this.depotService.item = value;
   }
   get depots(): Array<DepotDto> {
        return this.depotService.items;
   }
   set depots(value: Array<DepotDto>) {
        this.depotService.items = value;
   }
   get createDepotDialog(): boolean {
       return this.depotService.createDialog;
   }
  set createDepotDialog(value: boolean) {
       this.depotService.createDialog= value;
   }
   get taxe(): TaxeDto {
       return this.taxeService.item;
   }
  set taxe(value: TaxeDto) {
        this.taxeService.item = value;
   }
   get taxes(): Array<TaxeDto> {
        return this.taxeService.items;
   }
   set taxes(value: Array<TaxeDto>) {
        this.taxeService.items = value;
   }
   get createTaxeDialog(): boolean {
       return this.taxeService.createDialog;
   }
  set createTaxeDialog(value: boolean) {
       this.taxeService.createDialog= value;
   }
   get achat(): AchatDto {
       return this.achatService.item;
   }
  set achat(value: AchatDto) {
        this.achatService.item = value;
   }
   get achats(): Array<AchatDto> {
        return this.achatService.items;
   }
   set achats(value: Array<AchatDto>) {
        this.achatService.items = value;
   }
   get createAchatDialog(): boolean {
       return this.achatService.createDialog;
   }
  set createAchatDialog(value: boolean) {
       this.achatService.createDialog= value;
   }
   get entrepriseSociete(): EntrepriseSocieteDto {
       return this.entrepriseSocieteService.item;
   }
  set entrepriseSociete(value: EntrepriseSocieteDto) {
        this.entrepriseSocieteService.item = value;
   }
   get entrepriseSocietes(): Array<EntrepriseSocieteDto> {
        return this.entrepriseSocieteService.items;
   }
   set entrepriseSocietes(value: Array<EntrepriseSocieteDto>) {
        this.entrepriseSocieteService.items = value;
   }
   get createEntrepriseSocieteDialog(): boolean {
       return this.entrepriseSocieteService.createDialog;
   }
  set createEntrepriseSocieteDialog(value: boolean) {
       this.entrepriseSocieteService.createDialog= value;
   }
   get etatAvoirVente(): EtatAvoirVenteDto {
       return this.etatAvoirVenteService.item;
   }
  set etatAvoirVente(value: EtatAvoirVenteDto) {
        this.etatAvoirVenteService.item = value;
   }
   get etatAvoirVentes(): Array<EtatAvoirVenteDto> {
        return this.etatAvoirVenteService.items;
   }
   set etatAvoirVentes(value: Array<EtatAvoirVenteDto>) {
        this.etatAvoirVenteService.items = value;
   }
   get createEtatAvoirVenteDialog(): boolean {
       return this.etatAvoirVenteService.createDialog;
   }
  set createEtatAvoirVenteDialog(value: boolean) {
       this.etatAvoirVenteService.createDialog= value;
   }

    get avoirVenteItemsElement(): AvoirVenteItemDto {
        if( this._avoirVenteItemsElement == null )
            this._avoirVenteItemsElement = new AvoirVenteItemDto();
         return this._avoirVenteItemsElement;
    }

    set avoirVenteItemsElement(value: AvoirVenteItemDto) {
        this._avoirVenteItemsElement = value;
    }
    get avoirsElement(): AvoirVenteItemDto {
        if( this._avoirsElement == null )
            this._avoirsElement = new AvoirVenteItemDto();
         return this._avoirsElement;
    }

    set avoirsElement(value: AvoirVenteItemDto) {
        this._avoirsElement = value;
    }

    get validAvoirVenteBarCode(): boolean {
        return this._validAvoirVenteBarCode;
    }
    set validAvoirVenteBarCode(value: boolean) {
        this._validAvoirVenteBarCode = value;
    }
    get validAvoirVenteEntrepriseSociete(): boolean {
        return this._validAvoirVenteEntrepriseSociete;
    }
    set validAvoirVenteEntrepriseSociete(value: boolean) {
        this._validAvoirVenteEntrepriseSociete = value;
    }
    get validAvoirVenteCodeAvoirVente(): boolean {
        return this._validAvoirVenteCodeAvoirVente;
    }
    set validAvoirVenteCodeAvoirVente(value: boolean) {
        this._validAvoirVenteCodeAvoirVente = value;
    }
    get validAvoirVenteNumeroFactureAvoirVente(): boolean {
        return this._validAvoirVenteNumeroFactureAvoirVente;
    }
    set validAvoirVenteNumeroFactureAvoirVente(value: boolean) {
        this._validAvoirVenteNumeroFactureAvoirVente = value;
    }
    get validAvoirVenteDateFactureAvoirVente(): boolean {
        return this._validAvoirVenteDateFactureAvoirVente;
    }
    set validAvoirVenteDateFactureAvoirVente(value: boolean) {
        this._validAvoirVenteDateFactureAvoirVente = value;
    }
    get validAvoirVenteClient(): boolean {
        return this._validAvoirVenteClient;
    }
    set validAvoirVenteClient(value: boolean) {
        this._validAvoirVenteClient = value;
    }
    get validAvoirVenteMontantTtc(): boolean {
        return this._validAvoirVenteMontantTtc;
    }
    set validAvoirVenteMontantTtc(value: boolean) {
        this._validAvoirVenteMontantTtc = value;
    }

    get validEntrepriseSocieteNom(): boolean {
        return this._validEntrepriseSocieteNom;
    }
    set validEntrepriseSocieteNom(value: boolean) {
        this._validEntrepriseSocieteNom = value;
    }
    get validClientCin(): boolean {
        return this._validClientCin;
    }
    set validClientCin(value: boolean) {
        this._validClientCin = value;
    }
    get validEtatAvoirVenteLibelle(): boolean {
        return this._validEtatAvoirVenteLibelle;
    }
    set validEtatAvoirVenteLibelle(value: boolean) {
        this._validEtatAvoirVenteLibelle = value;
    }
    get validAvoirVenteItemsBarCode(): boolean {
        return this._validAvoirVenteItemsBarCode;
    }
    set validAvoirVenteItemsBarCode(value: boolean) {
        this._validAvoirVenteItemsBarCode = value;
    }
    get validAvoirVenteItemsDepot(): boolean {
        return this._validAvoirVenteItemsDepot;
    }
    set validAvoirVenteItemsDepot(value: boolean) {
        this._validAvoirVenteItemsDepot = value;
    }
    get validAvoirVenteItemsProduit(): boolean {
        return this._validAvoirVenteItemsProduit;
    }
    set validAvoirVenteItemsProduit(value: boolean) {
        this._validAvoirVenteItemsProduit = value;
    }
    get validAvoirVenteItemsQuantite(): boolean {
        return this._validAvoirVenteItemsQuantite;
    }
    set validAvoirVenteItemsQuantite(value: boolean) {
        this._validAvoirVenteItemsQuantite = value;
    }
    get validAvoirVenteItemsQuantiteVendue(): boolean {
        return this._validAvoirVenteItemsQuantiteVendue;
    }
    set validAvoirVenteItemsQuantiteVendue(value: boolean) {
        this._validAvoirVenteItemsQuantiteVendue = value;
    }
    get validAvoirVenteItemsPrixUnitaireHt(): boolean {
        return this._validAvoirVenteItemsPrixUnitaireHt;
    }
    set validAvoirVenteItemsPrixUnitaireHt(value: boolean) {
        this._validAvoirVenteItemsPrixUnitaireHt = value;
    }
    get validAvoirVenteItemsPrixUnitaireTtc(): boolean {
        return this._validAvoirVenteItemsPrixUnitaireTtc;
    }
    set validAvoirVenteItemsPrixUnitaireTtc(value: boolean) {
        this._validAvoirVenteItemsPrixUnitaireTtc = value;
    }
    get validAvoirVenteItemsRemise(): boolean {
        return this._validAvoirVenteItemsRemise;
    }
    set validAvoirVenteItemsRemise(value: boolean) {
        this._validAvoirVenteItemsRemise = value;
    }
    get validAvoirVenteItemsMontantHt(): boolean {
        return this._validAvoirVenteItemsMontantHt;
    }
    set validAvoirVenteItemsMontantHt(value: boolean) {
        this._validAvoirVenteItemsMontantHt = value;
    }
    get validAvoirVenteItemsMontantTtc(): boolean {
        return this._validAvoirVenteItemsMontantTtc;
    }
    set validAvoirVenteItemsMontantTtc(value: boolean) {
        this._validAvoirVenteItemsMontantTtc = value;
    }
    get validAvoirsBarCode(): boolean {
        return this._validAvoirsBarCode;
    }
    set validAvoirsBarCode(value: boolean) {
        this._validAvoirsBarCode = value;
    }
    get validAvoirsDepot(): boolean {
        return this._validAvoirsDepot;
    }
    set validAvoirsDepot(value: boolean) {
        this._validAvoirsDepot = value;
    }
    get validAvoirsProduit(): boolean {
        return this._validAvoirsProduit;
    }
    set validAvoirsProduit(value: boolean) {
        this._validAvoirsProduit = value;
    }
    get validAvoirsQuantite(): boolean {
        return this._validAvoirsQuantite;
    }
    set validAvoirsQuantite(value: boolean) {
        this._validAvoirsQuantite = value;
    }
    get validAvoirsQuantiteVendue(): boolean {
        return this._validAvoirsQuantiteVendue;
    }
    set validAvoirsQuantiteVendue(value: boolean) {
        this._validAvoirsQuantiteVendue = value;
    }
    get validAvoirsPrixUnitaireHt(): boolean {
        return this._validAvoirsPrixUnitaireHt;
    }
    set validAvoirsPrixUnitaireHt(value: boolean) {
        this._validAvoirsPrixUnitaireHt = value;
    }
    get validAvoirsPrixUnitaireTtc(): boolean {
        return this._validAvoirsPrixUnitaireTtc;
    }
    set validAvoirsPrixUnitaireTtc(value: boolean) {
        this._validAvoirsPrixUnitaireTtc = value;
    }
    get validAvoirsRemise(): boolean {
        return this._validAvoirsRemise;
    }
    set validAvoirsRemise(value: boolean) {
        this._validAvoirsRemise = value;
    }
    get validAvoirsMontantHt(): boolean {
        return this._validAvoirsMontantHt;
    }
    set validAvoirsMontantHt(value: boolean) {
        this._validAvoirsMontantHt = value;
    }
    get validAvoirsMontantTtc(): boolean {
        return this._validAvoirsMontantTtc;
    }
    set validAvoirsMontantTtc(value: boolean) {
        this._validAvoirsMontantTtc = value;
    }
    get validAchatDateFacture(): boolean {
        return this._validAchatDateFacture;
    }
    set validAchatDateFacture(value: boolean) {
        this._validAchatDateFacture = value;
    }
    get validAchatFournisseur(): boolean {
        return this._validAchatFournisseur;
    }
    set validAchatFournisseur(value: boolean) {
        this._validAchatFournisseur = value;
    }
    get validAchatMontantHt(): boolean {
        return this._validAchatMontantHt;
    }
    set validAchatMontantHt(value: boolean) {
        this._validAchatMontantHt = value;
    }
    get validAchatMontantTva(): boolean {
        return this._validAchatMontantTva;
    }
    set validAchatMontantTva(value: boolean) {
        this._validAchatMontantTva = value;
    }
    get validAchatMontantTtc(): boolean {
        return this._validAchatMontantTtc;
    }
    set validAchatMontantTtc(value: boolean) {
        this._validAchatMontantTtc = value;
    }
}
