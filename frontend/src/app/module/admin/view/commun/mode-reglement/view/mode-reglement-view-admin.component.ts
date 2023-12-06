import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ModeReglementAdminService} from 'src/app/controller/service/admin/commun/ModeReglementAdmin.service';
import {ModeReglementDto} from 'src/app/controller/model/commun/ModeReglement.model';
import {ModeReglementCriteria} from 'src/app/controller/criteria/commun/ModeReglementCriteria.model';

@Component({
  selector: 'app-mode-reglement-view-admin',
  templateUrl: './mode-reglement-view-admin.component.html'
})
export class ModeReglementViewAdminComponent extends AbstractViewController<ModeReglementDto, ModeReglementCriteria, ModeReglementAdminService> implements OnInit {


    constructor(private modeReglementService: ModeReglementAdminService){
        super(modeReglementService);
    }

    ngOnInit(): void {
    }




}
