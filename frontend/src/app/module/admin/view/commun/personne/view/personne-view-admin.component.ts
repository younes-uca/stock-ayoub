import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PersonneAdminService} from 'src/app/controller/service/admin/commun/PersonneAdmin.service';
import {PersonneDto} from 'src/app/controller/model/commun/Personne.model';
import {PersonneCriteria} from 'src/app/controller/criteria/commun/PersonneCriteria.model';

import {VilleDto} from 'src/app/controller/model/commun/Ville.model';
import {VilleAdminService} from 'src/app/controller/service/admin/commun/VilleAdmin.service';
@Component({
  selector: 'app-personne-view-admin',
  templateUrl: './personne-view-admin.component.html'
})
export class PersonneViewAdminComponent extends AbstractViewController<PersonneDto, PersonneCriteria, PersonneAdminService> implements OnInit {


    constructor(private personneService: PersonneAdminService, private villeService: VilleAdminService){
        super(personneService);
    }

    ngOnInit(): void {
    }


    get ville(): VilleDto {
       return this.villeService.item;
    }
    set ville(value: VilleDto) {
        this.villeService.item = value;
    }
    get villes(): Array<VilleDto> {
       return this.villeService.items;
    }
    set villes(value: Array<VilleDto>) {
        this.villeService.items = value;
    }


}
