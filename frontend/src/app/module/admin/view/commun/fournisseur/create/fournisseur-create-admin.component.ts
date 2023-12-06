import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {FournisseurAdminService} from 'src/app/controller/service/admin/commun/FournisseurAdmin.service';
import {FournisseurDto} from 'src/app/controller/model/commun/Fournisseur.model';
import {FournisseurCriteria} from 'src/app/controller/criteria/commun/FournisseurCriteria.model';
@Component({
  selector: 'app-fournisseur-create-admin',
  templateUrl: './fournisseur-create-admin.component.html'
})
export class FournisseurCreateAdminComponent extends AbstractCreateController<FournisseurDto, FournisseurCriteria, FournisseurAdminService>  implements OnInit {



   private _validFournisseurIce = true;

    constructor( private fournisseurService: FournisseurAdminService ) {
        super(fournisseurService);
    }

    ngOnInit(): void {
    }





    public setValidation(value: boolean){
        this.validFournisseurIce = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateFournisseurIce();
    }

    public validateFournisseurIce(){
        if (this.stringUtilService.isEmpty(this.item.ice)) {
        this.errorMessages.push('Ice non valide');
        this.validFournisseurIce = false;
        } else {
            this.validFournisseurIce = true;
        }
    }






    get validFournisseurIce(): boolean {
        return this._validFournisseurIce;
    }

    set validFournisseurIce(value: boolean) {
         this._validFournisseurIce = value;
    }



}
