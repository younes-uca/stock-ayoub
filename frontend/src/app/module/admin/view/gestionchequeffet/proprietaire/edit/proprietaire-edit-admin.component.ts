import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {ProprietaireAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ProprietaireAdmin.service';
import {ProprietaireDto} from 'src/app/controller/model/gestionchequeffet/Proprietaire.model';
import {ProprietaireCriteria} from 'src/app/controller/criteria/gestionchequeffet/ProprietaireCriteria.model';


import {PersonneDto} from 'src/app/controller/model/commun/Personne.model';
import {PersonneAdminService} from 'src/app/controller/service/admin/commun/PersonneAdmin.service';

@Component({
  selector: 'app-proprietaire-edit-admin',
  templateUrl: './proprietaire-edit-admin.component.html'
})
export class ProprietaireEditAdminComponent extends AbstractEditController<ProprietaireDto, ProprietaireCriteria, ProprietaireAdminService>   implements OnInit {



    private _validPersonneNom = true;
    private _validPersonneTelephone = true;



    constructor( private proprietaireService: ProprietaireAdminService , private personneService: PersonneAdminService) {
        super(proprietaireService);
    }

    ngOnInit(): void {
        this.personne = new PersonneDto();
        this.personneService.findAll().subscribe((data) => this.personnes = data);
    }


    public setValidation(value: boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
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
   get createPersonneDialog(): boolean {
       return this.personneService.createDialog;
   }
  set createPersonneDialog(value: boolean) {
       this.personneService.createDialog= value;
   }



    get validPersonneNom(): boolean {
        return this._validPersonneNom;
    }
    set validPersonneNom(value: boolean) {
        this._validPersonneNom = value;
    }
    get validPersonneTelephone(): boolean {
        return this._validPersonneTelephone;
    }
    set validPersonneTelephone(value: boolean) {
        this._validPersonneTelephone = value;
    }
}
