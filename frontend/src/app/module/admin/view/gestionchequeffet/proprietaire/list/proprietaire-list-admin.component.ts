import {Component, OnInit} from '@angular/core';
import {ProprietaireAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ProprietaireAdmin.service';
import {ProprietaireDto} from 'src/app/controller/model/gestionchequeffet/Proprietaire.model';
import {ProprietaireCriteria} from 'src/app/controller/criteria/gestionchequeffet/ProprietaireCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {PersonneDto} from 'src/app/controller/model/commun/Personne.model';
import {PersonneAdminService} from 'src/app/controller/service/admin/commun/PersonneAdmin.service';


@Component({
  selector: 'app-proprietaire-list-admin',
  templateUrl: './proprietaire-list-admin.component.html'
})
export class ProprietaireListAdminComponent extends AbstractListController<ProprietaireDto, ProprietaireCriteria, ProprietaireAdminService>  implements OnInit {

    fileName = 'Proprietaire';

    personnes: Array<PersonneDto>;


    constructor( private proprietaireService: ProprietaireAdminService  , private personneService: PersonneAdminService) {
        super(proprietaireService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadPersonne();
    }


    public initCol() {
        this.cols = [
            {field: 'personne?.telephone', header: 'Personne'},
        ];
    }


    public async loadPersonne(){
       this.personneService.findAllOptimized().subscribe(personnes => this.personnes = personnes, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Personne': e.personne?.telephone ,
            }
        });

        this.criteriaData = [{
        //'Personne': this.criteria.personne?.telephone ? this.criteria.personne?.telephone : environment.emptyForExport ,
        }];
      }
}
