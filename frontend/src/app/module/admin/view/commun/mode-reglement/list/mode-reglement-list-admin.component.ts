import {Component, OnInit} from '@angular/core';
import {ModeReglementAdminService} from 'src/app/controller/service/admin/commun/ModeReglementAdmin.service';
import {ModeReglementDto} from 'src/app/controller/model/commun/ModeReglement.model';
import {ModeReglementCriteria} from 'src/app/controller/criteria/commun/ModeReglementCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-mode-reglement-list-admin',
  templateUrl: './mode-reglement-list-admin.component.html'
})
export class ModeReglementListAdminComponent extends AbstractListController<ModeReglementDto, ModeReglementCriteria, ModeReglementAdminService>  implements OnInit {

    fileName = 'ModeReglement';



    constructor( private modeReglementService: ModeReglementAdminService  ) {
        super(modeReglementService);
        this.pdfName = 'ModeReglement.pdf';
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
        ];
    }





   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
        }];
      }
}
