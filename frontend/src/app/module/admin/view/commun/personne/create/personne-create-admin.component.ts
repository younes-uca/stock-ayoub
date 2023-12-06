import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {PersonneAdminService} from 'src/app/controller/service/admin/commun/PersonneAdmin.service';
import {PersonneDto} from 'src/app/controller/model/commun/Personne.model';
import {PersonneCriteria} from 'src/app/controller/criteria/commun/PersonneCriteria.model';
import {VilleDto} from 'src/app/controller/model/commun/Ville.model';
import {VilleAdminService} from 'src/app/controller/service/admin/commun/VilleAdmin.service';
@Component({
  selector: 'app-personne-create-admin',
  templateUrl: './personne-create-admin.component.html'
})
export class PersonneCreateAdminComponent extends AbstractCreateController<PersonneDto, PersonneCriteria, PersonneAdminService>  implements OnInit {



   private _validPersonneNom = true;
   private _validPersonneTelephone = true;
    private _validVilleLibelle = true;

    constructor( private personneService: PersonneAdminService , private villeService: VilleAdminService) {
        super(personneService);
    }

    ngOnInit(): void {
        this.ville = new VilleDto();
        this.villeService.findAll().subscribe((data) => this.villes = data);
    }





    public setValidation(value: boolean){
        this.validPersonneNom = value;
        this.validPersonneTelephone = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validatePersonneNom();
        this.validatePersonneTelephone();
    }

    public validatePersonneNom(){
        if (this.stringUtilService.isEmpty(this.item.nom)) {
        this.errorMessages.push('Nom non valide');
        this.validPersonneNom = false;
        } else {
            this.validPersonneNom = true;
        }
    }
    public validatePersonneTelephone(){
        if (this.stringUtilService.isEmpty(this.item.telephone)) {
        this.errorMessages.push('Telephone non valide');
        this.validPersonneTelephone = false;
        } else {
            this.validPersonneTelephone = true;
        }
    }


    public async openCreateVille(ville: string) {
    const isPermistted = await this.roleService.isPermitted('Ville', 'add');
    if(isPermistted) {
         this.ville = new VilleDto();
         this.createVilleDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
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
    get createVilleDialog(): boolean {
       return this.villeService.createDialog;
    }
    set createVilleDialog(value: boolean) {
        this.villeService.createDialog= value;
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

    get validVilleLibelle(): boolean {
        return this._validVilleLibelle;
    }
    set validVilleLibelle(value: boolean) {
        this._validVilleLibelle = value;
    }


}
