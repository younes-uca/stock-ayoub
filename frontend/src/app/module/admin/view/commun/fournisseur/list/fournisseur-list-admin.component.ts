import {Component, OnInit} from '@angular/core';
import {FournisseurAdminService} from 'src/app/controller/service/admin/commun/FournisseurAdmin.service';
import {FournisseurDto} from 'src/app/controller/model/commun/Fournisseur.model';
import {FournisseurCriteria} from 'src/app/controller/criteria/commun/FournisseurCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-fournisseur-list-admin',
  templateUrl: './fournisseur-list-admin.component.html'
})
export class FournisseurListAdminComponent extends AbstractListController<FournisseurDto, FournisseurCriteria, FournisseurAdminService>  implements OnInit {

    fileName = 'Fournisseur';



    constructor( private fournisseurService: FournisseurAdminService  ) {
        super(fournisseurService);
        this.pdfName = 'Fournisseur.pdf';
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
    }


    public initCol() {
        this.cols = [
            {field: 'ice', header: 'Ice'},
        ];
    }





   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Ice': e.ice ,
            }
        });

        this.criteriaData = [{
            'Ice': this.criteria.ice ? this.criteria.ice : environment.emptyForExport ,
        }];
      }
}
