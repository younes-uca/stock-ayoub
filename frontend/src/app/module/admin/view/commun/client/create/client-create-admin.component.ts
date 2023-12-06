import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ClientAdminService} from 'src/app/controller/service/admin/commun/ClientAdmin.service';
import {ClientDto} from 'src/app/controller/model/commun/Client.model';
import {ClientCriteria} from 'src/app/controller/criteria/commun/ClientCriteria.model';
@Component({
  selector: 'app-client-create-admin',
  templateUrl: './client-create-admin.component.html'
})
export class ClientCreateAdminComponent extends AbstractCreateController<ClientDto, ClientCriteria, ClientAdminService>  implements OnInit {



   private _validClientCin = true;

    constructor( private clientService: ClientAdminService ) {
        super(clientService);
    }

    ngOnInit(): void {
    }





    public setValidation(value: boolean){
        this.validClientCin = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateClientCin();
    }

    public validateClientCin(){
        if (this.stringUtilService.isEmpty(this.item.cin)) {
        this.errorMessages.push('Cin non valide');
        this.validClientCin = false;
        } else {
            this.validClientCin = true;
        }
    }






    get validClientCin(): boolean {
        return this._validClientCin;
    }

    set validClientCin(value: boolean) {
         this._validClientCin = value;
    }



}
