import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {VenteAdminService} from 'src/app/controller/service/admin/stock/VenteAdmin.service';
import {VenteDto} from 'src/app/controller/model/stock/Vente.model';
import {VenteCriteria} from 'src/app/controller/criteria/stock/VenteCriteria.model';


import {AvoirVenteDto} from 'src/app/controller/model/stock/AvoirVente.model';
import {AvoirVenteAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteAdmin.service';
import {VenteItemDto} from 'src/app/controller/model/stock/VenteItem.model';
import {VenteItemAdminService} from 'src/app/controller/service/admin/stock/VenteItemAdmin.service';
import {AchatDto} from 'src/app/controller/model/stock/Achat.model';
import {AchatAdminService} from 'src/app/controller/service/admin/stock/AchatAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';
import {EtatAvoirVenteDto} from 'src/app/controller/model/commun/EtatAvoirVente.model';
import {EtatAvoirVenteAdminService} from 'src/app/controller/service/admin/commun/EtatAvoirVenteAdmin.service';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';
import {AvoirVenteItemDto} from 'src/app/controller/model/stock/AvoirVenteItem.model';
import {AvoirVenteItemAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteItemAdmin.service';
import {EtatVenteDto} from 'src/app/controller/model/commun/EtatVente.model';
import {EtatVenteAdminService} from 'src/app/controller/service/admin/commun/EtatVenteAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {ClientDto} from 'src/app/controller/model/commun/Client.model';
import {ClientAdminService} from 'src/app/controller/service/admin/commun/ClientAdmin.service';

@Component({
  selector: 'app-vente-edit-admin',
  templateUrl: './vente-edit-admin.component.html'
})
export class VenteEditAdminComponent extends AbstractEditController<VenteDto, VenteCriteria, VenteAdminService>   implements OnInit {

    private _venteItemsElement = new VenteItemDto();
    private _avoirsElement = new AvoirVenteDto();

    private _validVenteBarCode = true;
    private _validVenteEntrepriseSociete = true;
    private _validVenteCodeVente = true;
    private _validVenteDateFacture = true;
    private _validVenteNumeroFacture = true;
    private _validVenteClient = true;
    private _validVenteMontantHt = true;
    private _validVenteMontantTva = true;
    private _validVenteMontantTtc = true;

    private _validEntrepriseSocieteNom = true;
    private _validClientCin = true;
    private _validEtatVenteLibelle = true;
    private _validVenteItemsBarCode = true;
    private _validVenteItemsQuantite = true;
    private _validVenteItemsQuantiteVendue = true;
    private _validVenteItemsPrixUnitaireHt = true;
    private _validVenteItemsPrixUnitaireTtc = true;
    private _validVenteItemsRemise = true;
    private _validVenteItemsMontantHt = true;
    private _validVenteItemsMontantTtc = true;
    private _validAvoirsBarCode = true;
    private _validAvoirsEntrepriseSociete = true;
    private _validAvoirsCodeAvoirVente = true;
    private _validAvoirsNumeroFactureAvoirVente = true;
    private _validAvoirsDateFactureAvoirVente = true;
    private _validAvoirsClient = true;
    private _validAvoirsMontantTtc = true;



    constructor( private venteService: VenteAdminService , private etatVenteService: EtatVenteAdminService, private produitService: ProduitAdminService, private etatAvoirVenteService: EtatAvoirVenteAdminService, private achatService: AchatAdminService, private avoirVenteService: AvoirVenteAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService, private venteItemService: VenteItemAdminService, private clientService: ClientAdminService, private depotService: DepotAdminService, private taxeService: TaxeAdminService) {
        super(venteService);
    }

    ngOnInit(): void {
        this.venteItemsElement.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);
        this.venteItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.venteItemsElement.taxe = new TaxeDto();
        this.taxeService.findAll().subscribe((data) => this.taxes = data);

        this.avoirsElement.entrepriseSociete = new EntrepriseSocieteDto();
        this.entrepriseSocieteService.findAll().subscribe((data) => this.entrepriseSocietes = data);
        this.avoirsElement.client = new ClientDto();
        this.clientService.findAll().subscribe((data) => this.clients = data);
        this.avoirsElement.etatAvoirVente = new EtatAvoirVenteDto();
        this.etatAvoirVenteService.findAll().subscribe((data) => this.etatAvoirVentes = data);
        this.avoirsElement.achat = new AchatDto();
        this.achatService.findAll().subscribe((data) => this.achats = data);

        this.entrepriseSociete = new EntrepriseSocieteDto();
        this.entrepriseSocieteService.findAll().subscribe((data) => this.entrepriseSocietes = data);
        this.client = new ClientDto();
        this.clientService.findAll().subscribe((data) => this.clients = data);
        this.etatVente = new EtatVenteDto();
        this.etatVenteService.findAll().subscribe((data) => this.etatVentes = data);
    }
    public prepareEdit() {
        this.item.dateFacture = this.venteService.format(this.item.dateFacture);
    }



    public validateVenteItems(){
        this.errorMessages = new Array();
        this.validateVenteItemsBarCode();
        this.validateVenteItemsQuantite();
        this.validateVenteItemsQuantiteVendue();
        this.validateVenteItemsPrixUnitaireHt();
        this.validateVenteItemsPrixUnitaireTtc();
        this.validateVenteItemsRemise();
        this.validateVenteItemsMontantHt();
        this.validateVenteItemsMontantTtc();
    }
    public validateAvoirs(){
        this.errorMessages = new Array();
        this.validateAvoirsBarCode();
        this.validateAvoirsEntrepriseSociete();
        this.validateAvoirsCodeAvoirVente();
        this.validateAvoirsNumeroFactureAvoirVente();
        this.validateAvoirsDateFactureAvoirVente();
        this.validateAvoirsClient();
        this.validateAvoirsMontantTtc();
    }
    public setValidation(value: boolean){
        this.validVenteBarCode = value;
        this.validVenteEntrepriseSociete = value;
        this.validVenteCodeVente = value;
        this.validVenteDateFacture = value;
        this.validVenteNumeroFacture = value;
        this.validVenteClient = value;
        this.validVenteMontantHt = value;
        this.validVenteMontantTva = value;
        this.validVenteMontantTtc = value;
        this.validVenteItemsBarCode = value;
        this.validVenteItemsQuantite = value;
        this.validVenteItemsQuantiteVendue = value;
        this.validVenteItemsPrixUnitaireHt = value;
        this.validVenteItemsPrixUnitaireTtc = value;
        this.validVenteItemsRemise = value;
        this.validVenteItemsMontantHt = value;
        this.validVenteItemsMontantTtc = value;
        this.validAvoirsBarCode = value;
        this.validAvoirsEntrepriseSociete = value;
        this.validAvoirsCodeAvoirVente = value;
        this.validAvoirsNumeroFactureAvoirVente = value;
        this.validAvoirsDateFactureAvoirVente = value;
        this.validAvoirsClient = value;
        this.validAvoirsMontantTtc = value;
        }
   public addVenteItems() {
        if( this.item.venteItems == null )
            this.item.venteItems = new Array<VenteItemDto>();
       this.validateVenteItems();
       if (this.errorMessages.length === 0) {
            if(this.venteItemsElement.id == null){
                this.item.venteItems.push(this.venteItemsElement);
            }else{
                const index = this.item.venteItems.findIndex(e => e.id == this.venteItemsElement.id);
                this.item.venteItems[index] = this.venteItemsElement;
            }
          this.venteItemsElement = new VenteItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteVenteItems(p: VenteItemDto) {
        this.item.venteItems.forEach((element, index) => {
            if (element === p) { this.item.venteItems.splice(index, 1); }
        });
    }

    public editVenteItems(p: VenteItemDto) {
        this.venteItemsElement = {... p};
        this.activeTab = 0;
    }
   public addAvoirs() {
        if( this.item.avoirs == null )
            this.item.avoirs = new Array<AvoirVenteDto>();
       this.validateAvoirs();
       if (this.errorMessages.length === 0) {
            if(this.avoirsElement.id == null){
                this.item.avoirs.push(this.avoirsElement);
            }else{
                const index = this.item.avoirs.findIndex(e => e.id == this.avoirsElement.id);
                this.item.avoirs[index] = this.avoirsElement;
            }
          this.avoirsElement = new AvoirVenteDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteAvoirs(p: AvoirVenteDto) {
        this.item.avoirs.forEach((element, index) => {
            if (element === p) { this.item.avoirs.splice(index, 1); }
        });
    }

    public editAvoirs(p: AvoirVenteDto) {
        this.avoirsElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateVenteBarCode();
        this.validateVenteEntrepriseSociete();
        this.validateVenteCodeVente();
        this.validateVenteDateFacture();
        this.validateVenteNumeroFacture();
        this.validateVenteClient();
        this.validateVenteMontantHt();
        this.validateVenteMontantTva();
        this.validateVenteMontantTtc();
    }
    public validateVenteBarCode(){
        if (this.stringUtilService.isEmpty(this.item.barCode)) {
            this.errorMessages.push('Bar code non valide');
            this.validVenteBarCode = false;
        } else {
            this.validVenteBarCode = true;
        }
    }
    public validateVenteEntrepriseSociete(){
        if (this.stringUtilService.isEmpty(this.item.entrepriseSociete)) {
            this.errorMessages.push('Entreprise societe non valide');
            this.validVenteEntrepriseSociete = false;
        } else {
            this.validVenteEntrepriseSociete = true;
        }
    }
    public validateVenteCodeVente(){
        if (this.stringUtilService.isEmpty(this.item.codeVente)) {
            this.errorMessages.push('Code vente non valide');
            this.validVenteCodeVente = false;
        } else {
            this.validVenteCodeVente = true;
        }
    }
    public validateVenteDateFacture(){
        if (this.stringUtilService.isEmpty(this.item.dateFacture)) {
            this.errorMessages.push('Date facture non valide');
            this.validVenteDateFacture = false;
        } else {
            this.validVenteDateFacture = true;
        }
    }
    public validateVenteNumeroFacture(){
        if (this.stringUtilService.isEmpty(this.item.numeroFacture)) {
            this.errorMessages.push('Numero facture non valide');
            this.validVenteNumeroFacture = false;
        } else {
            this.validVenteNumeroFacture = true;
        }
    }
    public validateVenteClient(){
        if (this.stringUtilService.isEmpty(this.item.client)) {
            this.errorMessages.push('Client non valide');
            this.validVenteClient = false;
        } else {
            this.validVenteClient = true;
        }
    }
    public validateVenteMontantHt(){
        if (this.stringUtilService.isEmpty(this.item.montantHt)) {
            this.errorMessages.push('Montant ht non valide');
            this.validVenteMontantHt = false;
        } else {
            this.validVenteMontantHt = true;
        }
    }
    public validateVenteMontantTva(){
        if (this.stringUtilService.isEmpty(this.item.montantTva)) {
            this.errorMessages.push('Montant tva non valide');
            this.validVenteMontantTva = false;
        } else {
            this.validVenteMontantTva = true;
        }
    }
    public validateVenteMontantTtc(){
        if (this.stringUtilService.isEmpty(this.item.montantTtc)) {
            this.errorMessages.push('Montant ttc non valide');
            this.validVenteMontantTtc = false;
        } else {
            this.validVenteMontantTtc = true;
        }
    }


    private validateVenteItemsBarCode(){
        if (this.venteItemsElement.barCode == null) {
        this.errorMessages.push('BarCode de la venteItem est  invalide');
            this.validVenteItemsBarCode = false;
        } else {
            this.validVenteItemsBarCode = true;
        }
    }
    private validateVenteItemsQuantite(){
        if (this.venteItemsElement.quantite == null) {
        this.errorMessages.push('Quantite de la venteItem est  invalide');
            this.validVenteItemsQuantite = false;
        } else {
            this.validVenteItemsQuantite = true;
        }
    }
    private validateVenteItemsQuantiteVendue(){
        if (this.venteItemsElement.quantiteVendue == null) {
        this.errorMessages.push('QuantiteVendue de la venteItem est  invalide');
            this.validVenteItemsQuantiteVendue = false;
        } else {
            this.validVenteItemsQuantiteVendue = true;
        }
    }
    private validateVenteItemsPrixUnitaireHt(){
        if (this.venteItemsElement.prixUnitaireHt == null) {
        this.errorMessages.push('PrixUnitaireHt de la venteItem est  invalide');
            this.validVenteItemsPrixUnitaireHt = false;
        } else {
            this.validVenteItemsPrixUnitaireHt = true;
        }
    }
    private validateVenteItemsPrixUnitaireTtc(){
        if (this.venteItemsElement.prixUnitaireTtc == null) {
        this.errorMessages.push('PrixUnitaireTtc de la venteItem est  invalide');
            this.validVenteItemsPrixUnitaireTtc = false;
        } else {
            this.validVenteItemsPrixUnitaireTtc = true;
        }
    }
    private validateVenteItemsRemise(){
        if (this.venteItemsElement.remise == null) {
        this.errorMessages.push('Remise de la venteItem est  invalide');
            this.validVenteItemsRemise = false;
        } else {
            this.validVenteItemsRemise = true;
        }
    }
    private validateVenteItemsMontantHt(){
        if (this.venteItemsElement.montantHt == null) {
        this.errorMessages.push('MontantHt de la venteItem est  invalide');
            this.validVenteItemsMontantHt = false;
        } else {
            this.validVenteItemsMontantHt = true;
        }
    }
    private validateVenteItemsMontantTtc(){
        if (this.venteItemsElement.montantTtc == null) {
        this.errorMessages.push('MontantTtc de la venteItem est  invalide');
            this.validVenteItemsMontantTtc = false;
        } else {
            this.validVenteItemsMontantTtc = true;
        }
    }
    private validateAvoirsBarCode(){
        if (this.avoirsElement.barCode == null) {
        this.errorMessages.push('BarCode de la avoirVente est  invalide');
            this.validAvoirsBarCode = false;
        } else {
            this.validAvoirsBarCode = true;
        }
    }
    private validateAvoirsEntrepriseSociete(){
        if (this.avoirsElement.entrepriseSociete == null) {
        this.errorMessages.push('EntrepriseSociete de la avoirVente est  invalide');
            this.validAvoirsEntrepriseSociete = false;
        } else {
            this.validAvoirsEntrepriseSociete = true;
        }
    }
    private validateAvoirsCodeAvoirVente(){
        if (this.avoirsElement.codeAvoirVente == null) {
        this.errorMessages.push('CodeAvoirVente de la avoirVente est  invalide');
            this.validAvoirsCodeAvoirVente = false;
        } else {
            this.validAvoirsCodeAvoirVente = true;
        }
    }
    private validateAvoirsNumeroFactureAvoirVente(){
        if (this.avoirsElement.numeroFactureAvoirVente == null) {
        this.errorMessages.push('NumeroFactureAvoirVente de la avoirVente est  invalide');
            this.validAvoirsNumeroFactureAvoirVente = false;
        } else {
            this.validAvoirsNumeroFactureAvoirVente = true;
        }
    }
    private validateAvoirsDateFactureAvoirVente(){
        if (this.avoirsElement.dateFactureAvoirVente == null) {
        this.errorMessages.push('DateFactureAvoirVente de la avoirVente est  invalide');
            this.validAvoirsDateFactureAvoirVente = false;
        } else {
            this.validAvoirsDateFactureAvoirVente = true;
        }
    }
    private validateAvoirsClient(){
        if (this.avoirsElement.client == null) {
        this.errorMessages.push('Client de la avoirVente est  invalide');
            this.validAvoirsClient = false;
        } else {
            this.validAvoirsClient = true;
        }
    }
    private validateAvoirsMontantTtc(){
        if (this.avoirsElement.montantTtc == null) {
        this.errorMessages.push('MontantTtc de la avoirVente est  invalide');
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
   get etatVente(): EtatVenteDto {
       return this.etatVenteService.item;
   }
  set etatVente(value: EtatVenteDto) {
        this.etatVenteService.item = value;
   }
   get etatVentes(): Array<EtatVenteDto> {
        return this.etatVenteService.items;
   }
   set etatVentes(value: Array<EtatVenteDto>) {
        this.etatVenteService.items = value;
   }
   get createEtatVenteDialog(): boolean {
       return this.etatVenteService.createDialog;
   }
  set createEtatVenteDialog(value: boolean) {
       this.etatVenteService.createDialog= value;
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

    get venteItemsElement(): VenteItemDto {
        if( this._venteItemsElement == null )
            this._venteItemsElement = new VenteItemDto();
         return this._venteItemsElement;
    }

    set venteItemsElement(value: VenteItemDto) {
        this._venteItemsElement = value;
    }
    get avoirsElement(): AvoirVenteDto {
        if( this._avoirsElement == null )
            this._avoirsElement = new AvoirVenteDto();
         return this._avoirsElement;
    }

    set avoirsElement(value: AvoirVenteDto) {
        this._avoirsElement = value;
    }

    get validVenteBarCode(): boolean {
        return this._validVenteBarCode;
    }
    set validVenteBarCode(value: boolean) {
        this._validVenteBarCode = value;
    }
    get validVenteEntrepriseSociete(): boolean {
        return this._validVenteEntrepriseSociete;
    }
    set validVenteEntrepriseSociete(value: boolean) {
        this._validVenteEntrepriseSociete = value;
    }
    get validVenteCodeVente(): boolean {
        return this._validVenteCodeVente;
    }
    set validVenteCodeVente(value: boolean) {
        this._validVenteCodeVente = value;
    }
    get validVenteDateFacture(): boolean {
        return this._validVenteDateFacture;
    }
    set validVenteDateFacture(value: boolean) {
        this._validVenteDateFacture = value;
    }
    get validVenteNumeroFacture(): boolean {
        return this._validVenteNumeroFacture;
    }
    set validVenteNumeroFacture(value: boolean) {
        this._validVenteNumeroFacture = value;
    }
    get validVenteClient(): boolean {
        return this._validVenteClient;
    }
    set validVenteClient(value: boolean) {
        this._validVenteClient = value;
    }
    get validVenteMontantHt(): boolean {
        return this._validVenteMontantHt;
    }
    set validVenteMontantHt(value: boolean) {
        this._validVenteMontantHt = value;
    }
    get validVenteMontantTva(): boolean {
        return this._validVenteMontantTva;
    }
    set validVenteMontantTva(value: boolean) {
        this._validVenteMontantTva = value;
    }
    get validVenteMontantTtc(): boolean {
        return this._validVenteMontantTtc;
    }
    set validVenteMontantTtc(value: boolean) {
        this._validVenteMontantTtc = value;
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
    get validEtatVenteLibelle(): boolean {
        return this._validEtatVenteLibelle;
    }
    set validEtatVenteLibelle(value: boolean) {
        this._validEtatVenteLibelle = value;
    }
    get validVenteItemsBarCode(): boolean {
        return this._validVenteItemsBarCode;
    }
    set validVenteItemsBarCode(value: boolean) {
        this._validVenteItemsBarCode = value;
    }
    get validVenteItemsQuantite(): boolean {
        return this._validVenteItemsQuantite;
    }
    set validVenteItemsQuantite(value: boolean) {
        this._validVenteItemsQuantite = value;
    }
    get validVenteItemsQuantiteVendue(): boolean {
        return this._validVenteItemsQuantiteVendue;
    }
    set validVenteItemsQuantiteVendue(value: boolean) {
        this._validVenteItemsQuantiteVendue = value;
    }
    get validVenteItemsPrixUnitaireHt(): boolean {
        return this._validVenteItemsPrixUnitaireHt;
    }
    set validVenteItemsPrixUnitaireHt(value: boolean) {
        this._validVenteItemsPrixUnitaireHt = value;
    }
    get validVenteItemsPrixUnitaireTtc(): boolean {
        return this._validVenteItemsPrixUnitaireTtc;
    }
    set validVenteItemsPrixUnitaireTtc(value: boolean) {
        this._validVenteItemsPrixUnitaireTtc = value;
    }
    get validVenteItemsRemise(): boolean {
        return this._validVenteItemsRemise;
    }
    set validVenteItemsRemise(value: boolean) {
        this._validVenteItemsRemise = value;
    }
    get validVenteItemsMontantHt(): boolean {
        return this._validVenteItemsMontantHt;
    }
    set validVenteItemsMontantHt(value: boolean) {
        this._validVenteItemsMontantHt = value;
    }
    get validVenteItemsMontantTtc(): boolean {
        return this._validVenteItemsMontantTtc;
    }
    set validVenteItemsMontantTtc(value: boolean) {
        this._validVenteItemsMontantTtc = value;
    }
    get validAvoirsBarCode(): boolean {
        return this._validAvoirsBarCode;
    }
    set validAvoirsBarCode(value: boolean) {
        this._validAvoirsBarCode = value;
    }
    get validAvoirsEntrepriseSociete(): boolean {
        return this._validAvoirsEntrepriseSociete;
    }
    set validAvoirsEntrepriseSociete(value: boolean) {
        this._validAvoirsEntrepriseSociete = value;
    }
    get validAvoirsCodeAvoirVente(): boolean {
        return this._validAvoirsCodeAvoirVente;
    }
    set validAvoirsCodeAvoirVente(value: boolean) {
        this._validAvoirsCodeAvoirVente = value;
    }
    get validAvoirsNumeroFactureAvoirVente(): boolean {
        return this._validAvoirsNumeroFactureAvoirVente;
    }
    set validAvoirsNumeroFactureAvoirVente(value: boolean) {
        this._validAvoirsNumeroFactureAvoirVente = value;
    }
    get validAvoirsDateFactureAvoirVente(): boolean {
        return this._validAvoirsDateFactureAvoirVente;
    }
    set validAvoirsDateFactureAvoirVente(value: boolean) {
        this._validAvoirsDateFactureAvoirVente = value;
    }
    get validAvoirsClient(): boolean {
        return this._validAvoirsClient;
    }
    set validAvoirsClient(value: boolean) {
        this._validAvoirsClient = value;
    }
    get validAvoirsMontantTtc(): boolean {
        return this._validAvoirsMontantTtc;
    }
    set validAvoirsMontantTtc(value: boolean) {
        this._validAvoirsMontantTtc = value;
    }
}
