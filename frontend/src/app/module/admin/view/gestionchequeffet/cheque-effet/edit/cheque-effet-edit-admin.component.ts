import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {ChequeEffetAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ChequeEffetAdmin.service';
import {ChequeEffetDto} from 'src/app/controller/model/gestionchequeffet/ChequeEffet.model';
import {ChequeEffetCriteria} from 'src/app/controller/criteria/gestionchequeffet/ChequeEffetCriteria.model';


import {FournisseurDto} from 'src/app/controller/model/commun/Fournisseur.model';
import {FournisseurAdminService} from 'src/app/controller/service/admin/commun/FournisseurAdmin.service';

@Component({
  selector: 'app-cheque-effet-edit-admin',
  templateUrl: './cheque-effet-edit-admin.component.html'
})
export class ChequeEffetEditAdminComponent extends AbstractEditController<ChequeEffetDto, ChequeEffetCriteria, ChequeEffetAdminService>   implements OnInit {


    private _validChequeEffetNumeroChequeEffet = true;
    private _validChequeEffetDateEmission = true;
    private _validChequeEffetMontant = true;

    private _validBeneficiaireIce = true;



    constructor( private chequeEffetService: ChequeEffetAdminService , private fournisseurService: FournisseurAdminService) {
        super(chequeEffetService);
    }

    ngOnInit(): void {
        this.beneficiaire = new FournisseurDto();
        this.fournisseurService.findAll().subscribe((data) => this.beneficiaires = data);
    }
    public prepareEdit() {
        this.item.dateEmission = this.chequeEffetService.format(this.item.dateEmission);
    }



    public setValidation(value: boolean){
        this.validChequeEffetNumeroChequeEffet = value;
        this.validChequeEffetDateEmission = value;
        this.validChequeEffetMontant = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateChequeEffetNumeroChequeEffet();
        this.validateChequeEffetDateEmission();
        this.validateChequeEffetMontant();
    }
    public validateChequeEffetNumeroChequeEffet(){
        if (this.stringUtilService.isEmpty(this.item.numeroChequeEffet)) {
            this.errorMessages.push('Numero cheque effet non valide');
            this.validChequeEffetNumeroChequeEffet = false;
        } else {
            this.validChequeEffetNumeroChequeEffet = true;
        }
    }
    public validateChequeEffetDateEmission(){
        if (this.stringUtilService.isEmpty(this.item.dateEmission)) {
            this.errorMessages.push('Date emission non valide');
            this.validChequeEffetDateEmission = false;
        } else {
            this.validChequeEffetDateEmission = true;
        }
    }
    public validateChequeEffetMontant(){
        if (this.stringUtilService.isEmpty(this.item.montant)) {
            this.errorMessages.push('Montant non valide');
            this.validChequeEffetMontant = false;
        } else {
            this.validChequeEffetMontant = true;
        }
    }




   get beneficiaire(): FournisseurDto {
       return this.fournisseurService.item;
   }
  set beneficiaire(value: FournisseurDto) {
        this.fournisseurService.item = value;
   }
   get beneficiaires(): Array<FournisseurDto> {
        return this.fournisseurService.items;
   }
   set beneficiaires(value: Array<FournisseurDto>) {
        this.fournisseurService.items = value;
   }
   get createBeneficiaireDialog(): boolean {
       return this.fournisseurService.createDialog;
   }
  set createBeneficiaireDialog(value: boolean) {
       this.fournisseurService.createDialog= value;
   }


    get validChequeEffetNumeroChequeEffet(): boolean {
        return this._validChequeEffetNumeroChequeEffet;
    }
    set validChequeEffetNumeroChequeEffet(value: boolean) {
        this._validChequeEffetNumeroChequeEffet = value;
    }
    get validChequeEffetDateEmission(): boolean {
        return this._validChequeEffetDateEmission;
    }
    set validChequeEffetDateEmission(value: boolean) {
        this._validChequeEffetDateEmission = value;
    }
    get validChequeEffetMontant(): boolean {
        return this._validChequeEffetMontant;
    }
    set validChequeEffetMontant(value: boolean) {
        this._validChequeEffetMontant = value;
    }

    get validBeneficiaireIce(): boolean {
        return this._validBeneficiaireIce;
    }
    set validBeneficiaireIce(value: boolean) {
        this._validBeneficiaireIce = value;
    }
}
