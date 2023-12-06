import {Component, OnInit} from '@angular/core';
import {AvoirAchatAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatAdmin.service';
import {AvoirAchatDto} from 'src/app/controller/model/stock/AvoirAchat.model';
import {AvoirAchatCriteria} from 'src/app/controller/criteria/stock/AvoirAchatCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {EtatAvoirAchatDto} from 'src/app/controller/model/commun/EtatAvoirAchat.model';
import {EtatAvoirAchatAdminService} from 'src/app/controller/service/admin/commun/EtatAvoirAchatAdmin.service';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';
import {FournisseurDto} from 'src/app/controller/model/commun/Fournisseur.model';
import {FournisseurAdminService} from 'src/app/controller/service/admin/commun/FournisseurAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';
import {AvoirAchatItemDto} from 'src/app/controller/model/stock/AvoirAchatItem.model';
import {AvoirAchatItemAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatItemAdmin.service';


@Component({
  selector: 'app-avoir-achat-list-admin',
  templateUrl: './avoir-achat-list-admin.component.html'
})
export class AvoirAchatListAdminComponent extends AbstractListController<AvoirAchatDto, AvoirAchatCriteria, AvoirAchatAdminService>  implements OnInit {

    fileName = 'AvoirAchat';

    entrepriseSocietes: Array<EntrepriseSocieteDto>;
    fournisseurs: Array<FournisseurDto>;
    etatAvoirAchats: Array<EtatAvoirAchatDto>;


    constructor( private avoirAchatService: AvoirAchatAdminService  , private produitService: ProduitAdminService, private etatAvoirAchatService: EtatAvoirAchatAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService, private depotService: DepotAdminService, private taxeService: TaxeAdminService, private fournisseurService: FournisseurAdminService, private avoirAchatItemService: AvoirAchatItemAdminService) {
        super(avoirAchatService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadEntrepriseSociete();
        this.loadFournisseur();
        this.loadEtatAvoirAchat();
    }


    public initCol() {
        this.cols = [
            {field: 'barCode', header: 'Bar code'},
            {field: 'entrepriseSociete?.nom', header: 'Entreprise societe'},
            {field: 'codeAvoirAchat', header: 'Code avoir achat'},
            {field: 'numeroFactureAvoirAchat', header: 'Numero facture avoir achat'},
            {field: 'dateFactureAvoirAchat', header: 'Date facture avoir achat'},
            {field: 'fournisseur?.ice', header: 'Fournisseur'},
            {field: 'etatAvoirAchat?.libelle', header: 'Etat avoir achat'},
            {field: 'montantHt', header: 'Montant ht'},
            {field: 'montantTva', header: 'Montant tva'},
            {field: 'montantTtc', header: 'Montant ttc'},
        ];
    }


    public async loadEntrepriseSociete(){
       this.entrepriseSocieteService.findAllOptimized().subscribe(entrepriseSocietes => this.entrepriseSocietes = entrepriseSocietes, error => console.log(error))
    }
    public async loadFournisseur(){
       this.fournisseurService.findAllOptimized().subscribe(fournisseurs => this.fournisseurs = fournisseurs, error => console.log(error))
    }
    public async loadEtatAvoirAchat(){
       this.etatAvoirAchatService.findAllOptimized().subscribe(etatAvoirAchats => this.etatAvoirAchats = etatAvoirAchats, error => console.log(error))
    }

	public initDuplicate(res: AvoirAchatDto) {
        if (res.avoirAchatItems != null) {
             res.avoirAchatItems.forEach(d => { d.avoirAchat = null; d.id = null; });
        }
	}


   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Bar code': e.barCode ,
                'Entreprise societe': e.entrepriseSociete?.nom ,
                 'Code avoir achat': e.codeAvoirAchat ,
                 'Numero facture avoir achat': e.numeroFactureAvoirAchat ,
                'Date facture avoir achat': this.datePipe.transform(e.dateFactureAvoirAchat , 'dd/MM/yyyy hh:mm'),
                'Fournisseur': e.fournisseur?.ice ,
                'Etat avoir achat': e.etatAvoirAchat?.libelle ,
                 'Montant ht': e.montantHt ,
                 'Montant tva': e.montantTva ,
                 'Montant ttc': e.montantTtc ,
                 'Description': e.description ,
            }
        });

        this.criteriaData = [{
            'Bar code': this.criteria.barCode ? this.criteria.barCode : environment.emptyForExport ,
        //'Entreprise societe': this.criteria.entrepriseSociete?.nom ? this.criteria.entrepriseSociete?.nom : environment.emptyForExport ,
            'Code avoir achat': this.criteria.codeAvoirAchat ? this.criteria.codeAvoirAchat : environment.emptyForExport ,
            'Numero facture avoir achat': this.criteria.numeroFactureAvoirAchat ? this.criteria.numeroFactureAvoirAchat : environment.emptyForExport ,
            'Date facture avoir achat Min': this.criteria.dateFactureAvoirAchatFrom ? this.datePipe.transform(this.criteria.dateFactureAvoirAchatFrom , this.dateFormat) : environment.emptyForExport ,
            'Date facture avoir achat Max': this.criteria.dateFactureAvoirAchatTo ? this.datePipe.transform(this.criteria.dateFactureAvoirAchatTo , this.dateFormat) : environment.emptyForExport ,
        //'Fournisseur': this.criteria.fournisseur?.ice ? this.criteria.fournisseur?.ice : environment.emptyForExport ,
        //'Etat avoir achat': this.criteria.etatAvoirAchat?.libelle ? this.criteria.etatAvoirAchat?.libelle : environment.emptyForExport ,
            'Montant ht Min': this.criteria.montantHtMin ? this.criteria.montantHtMin : environment.emptyForExport ,
            'Montant ht Max': this.criteria.montantHtMax ? this.criteria.montantHtMax : environment.emptyForExport ,
            'Montant tva Min': this.criteria.montantTvaMin ? this.criteria.montantTvaMin : environment.emptyForExport ,
            'Montant tva Max': this.criteria.montantTvaMax ? this.criteria.montantTvaMax : environment.emptyForExport ,
            'Montant ttc Min': this.criteria.montantTtcMin ? this.criteria.montantTtcMin : environment.emptyForExport ,
            'Montant ttc Max': this.criteria.montantTtcMax ? this.criteria.montantTtcMax : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        }];
      }
}
