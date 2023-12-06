import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {TacheAdminService} from 'src/app/controller/service/admin/stock/TacheAdmin.service';
import {TacheDto} from 'src/app/controller/model/stock/Tache.model';
import {TacheCriteria} from 'src/app/controller/criteria/stock/TacheCriteria.model';
import {CollaborateurDto} from 'src/app/controller/model/commun/Collaborateur.model';
import {CollaborateurAdminService} from 'src/app/controller/service/admin/commun/CollaborateurAdmin.service';
@Component({
  selector: 'app-tache-create-admin',
  templateUrl: './tache-create-admin.component.html'
})
export class TacheCreateAdminComponent extends AbstractCreateController<TacheDto, TacheCriteria, TacheAdminService>  implements OnInit {



    private _validLierAPrenom = true;

    constructor( private tacheService: TacheAdminService , private collaborateurService: CollaborateurAdminService) {
        super(tacheService);
    }

    ngOnInit(): void {
        this.lierA = new CollaborateurDto();
        this.collaborateurService.findAll().subscribe((data) => this.lierAs = data);
    }





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }




    get lierA(): CollaborateurDto {
        return this.collaborateurService.item;
    }
    set lierA(value: CollaborateurDto) {
        this.collaborateurService.item = value;
    }
    get lierAs(): Array<CollaborateurDto> {
        return this.collaborateurService.items;
    }
    set lierAs(value: Array<CollaborateurDto>) {
        this.collaborateurService.items = value;
    }
    get createLierADialog(): boolean {
       return this.collaborateurService.createDialog;
    }
    set createLierADialog(value: boolean) {
        this.collaborateurService.createDialog= value;
    }




    get validLierAPrenom(): boolean {
        return this._validLierAPrenom;
    }
    set validLierAPrenom(value: boolean) {
        this._validLierAPrenom = value;
    }


}
