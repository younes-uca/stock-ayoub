import {Component, OnInit} from '@angular/core';
import {TacheAdminService} from 'src/app/controller/service/admin/stock/TacheAdmin.service';
import {TacheDto} from 'src/app/controller/model/stock/Tache.model';
import {TacheCriteria} from 'src/app/controller/criteria/stock/TacheCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {CollaborateurDto} from 'src/app/controller/model/commun/Collaborateur.model';
import {CollaborateurAdminService} from 'src/app/controller/service/admin/commun/CollaborateurAdmin.service';


@Component({
  selector: 'app-tache-list-admin',
  templateUrl: './tache-list-admin.component.html'
})
export class TacheListAdminComponent extends AbstractListController<TacheDto, TacheCriteria, TacheAdminService>  implements OnInit {

    fileName = 'Tache';

    lierAs: Array<CollaborateurDto>;


    constructor( private tacheService: TacheAdminService  , private collaborateurService: CollaborateurAdminService) {
        super(tacheService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadLierA();
    }


    public initCol() {
        this.cols = [
            {field: 'dateDebut', header: 'Date debut'},
            {field: 'dateFin', header: 'Date fin'},
            {field: 'lierA?.prenom', header: 'Lier a'},
        ];
    }


    public async loadLierA(){
       this.collaborateurService.findAllOptimized().subscribe(lierAs => this.lierAs = lierAs, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Date debut': this.datePipe.transform(e.dateDebut , 'dd/MM/yyyy hh:mm'),
                'Date fin': this.datePipe.transform(e.dateFin , 'dd/MM/yyyy hh:mm'),
                'Lier a': e.lierA?.prenom ,
                 'Description': e.description ,
            }
        });

        this.criteriaData = [{
            'Date debut Min': this.criteria.dateDebutFrom ? this.datePipe.transform(this.criteria.dateDebutFrom , this.dateFormat) : environment.emptyForExport ,
            'Date debut Max': this.criteria.dateDebutTo ? this.datePipe.transform(this.criteria.dateDebutTo , this.dateFormat) : environment.emptyForExport ,
            'Date fin Min': this.criteria.dateFinFrom ? this.datePipe.transform(this.criteria.dateFinFrom , this.dateFormat) : environment.emptyForExport ,
            'Date fin Max': this.criteria.dateFinTo ? this.datePipe.transform(this.criteria.dateFinTo , this.dateFormat) : environment.emptyForExport ,
        //'Lier a': this.criteria.lierA?.prenom ? this.criteria.lierA?.prenom : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        }];
      }
}
