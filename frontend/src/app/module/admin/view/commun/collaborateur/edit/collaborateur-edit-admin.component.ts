import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {CollaborateurAdminService} from 'src/app/controller/service/admin/commun/CollaborateurAdmin.service';
import {CollaborateurDto} from 'src/app/controller/model/commun/Collaborateur.model';
import {CollaborateurCriteria} from 'src/app/controller/criteria/commun/CollaborateurCriteria.model';



@Component({
  selector: 'app-collaborateur-edit-admin',
  templateUrl: './collaborateur-edit-admin.component.html'
})
export class CollaborateurEditAdminComponent extends AbstractEditController<CollaborateurDto, CollaborateurCriteria, CollaborateurAdminService>   implements OnInit {


    private _validCollaborateurPrenom = true;




    constructor( private collaborateurService: CollaborateurAdminService ) {
        super(collaborateurService);
    }

    ngOnInit(): void {
    }


    public setValidation(value: boolean){
        this.validCollaborateurPrenom = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateCollaborateurPrenom();
    }
    public validateCollaborateurPrenom(){
        if (this.stringUtilService.isEmpty(this.item.prenom)) {
            this.errorMessages.push('Prenom non valide');
            this.validCollaborateurPrenom = false;
        } else {
            this.validCollaborateurPrenom = true;
        }
    }






    get validCollaborateurPrenom(): boolean {
        return this._validCollaborateurPrenom;
    }
    set validCollaborateurPrenom(value: boolean) {
        this._validCollaborateurPrenom = value;
    }

}
