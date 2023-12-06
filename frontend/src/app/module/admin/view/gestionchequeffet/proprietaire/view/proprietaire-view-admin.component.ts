import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ProprietaireAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ProprietaireAdmin.service';
import {ProprietaireDto} from 'src/app/controller/model/gestionchequeffet/Proprietaire.model';
import {ProprietaireCriteria} from 'src/app/controller/criteria/gestionchequeffet/ProprietaireCriteria.model';

import {PersonneDto} from 'src/app/controller/model/commun/Personne.model';
import {PersonneAdminService} from 'src/app/controller/service/admin/commun/PersonneAdmin.service';
@Component({
  selector: 'app-proprietaire-view-admin',
  templateUrl: './proprietaire-view-admin.component.html'
})
export class ProprietaireViewAdminComponent extends AbstractViewController<ProprietaireDto, ProprietaireCriteria, ProprietaireAdminService> implements OnInit {


    constructor(private proprietaireService: ProprietaireAdminService, private personneService: PersonneAdminService){
        super(proprietaireService);
    }

    ngOnInit(): void {
    }


    get personne(): PersonneDto {
       return this.personneService.item;
    }
    set personne(value: PersonneDto) {
        this.personneService.item = value;
    }
    get personnes(): Array<PersonneDto> {
       return this.personneService.items;
    }
    set personnes(value: Array<PersonneDto>) {
        this.personneService.items = value;
    }


}
