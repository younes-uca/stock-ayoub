import {Component, OnInit} from '@angular/core';
import {PersonneAdminService} from 'src/app/controller/service/admin/commun/PersonneAdmin.service';
import {PersonneDto} from 'src/app/controller/model/commun/Personne.model';
import {PersonneCriteria} from 'src/app/controller/criteria/commun/PersonneCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {VilleDto} from 'src/app/controller/model/commun/Ville.model';
import {VilleAdminService} from 'src/app/controller/service/admin/commun/VilleAdmin.service';


@Component({
  selector: 'app-personne-list-admin',
  templateUrl: './personne-list-admin.component.html'
})
export class PersonneListAdminComponent extends AbstractListController<PersonneDto, PersonneCriteria, PersonneAdminService>  implements OnInit {

    fileName = 'Personne';

    villes: Array<VilleDto>;


    constructor( private personneService: PersonneAdminService  , private villeService: VilleAdminService) {
        super(personneService);
        this.pdfName = 'Personne.pdf';
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadVille();
    }


    public initCol() {
        this.cols = [
            {field: 'nom', header: 'Nom'},
            {field: 'telephone', header: 'Telephone'},
            {field: 'ville?.id', header: 'Ville'},
            {field: 'creance', header: 'Creance'},
        ];
    }


    public async loadVille(){
       this.villeService.findAll().subscribe(villes => this.villes = villes, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Nom': e.nom ,
                 'Telephone': e.telephone ,
                'Ville': e.ville?.id ,
                 'Adresse': e.adresse ,
                 'Creance': e.creance ,
                 'Description': e.description ,
            }
        });

        this.criteriaData = [{
            'Nom': this.criteria.nom ? this.criteria.nom : environment.emptyForExport ,
            'Telephone': this.criteria.telephone ? this.criteria.telephone : environment.emptyForExport ,
        //'Ville': this.criteria.ville?.id ? this.criteria.ville?.id : environment.emptyForExport ,
            'Adresse': this.criteria.adresse ? this.criteria.adresse : environment.emptyForExport ,
            'Creance Min': this.criteria.creanceMin ? this.criteria.creanceMin : environment.emptyForExport ,
            'Creance Max': this.criteria.creanceMax ? this.criteria.creanceMax : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        }];
      }
}
