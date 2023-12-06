import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {InstrumentAdminService} from 'src/app/controller/service/admin/chequeffet/InstrumentAdmin.service';
import {InstrumentDto} from 'src/app/controller/model/chequeffet/Instrument.model';
import {InstrumentCriteria} from 'src/app/controller/criteria/chequeffet/InstrumentCriteria.model';
import {ChequeEffetDto} from 'src/app/controller/model/gestionchequeffet/ChequeEffet.model';
import {ChequeEffetAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ChequeEffetAdmin.service';
import {TypeInstrumentDto} from 'src/app/controller/model/gestionchequeffet/TypeInstrument.model';
import {TypeInstrumentAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TypeInstrumentAdmin.service';
@Component({
  selector: 'app-instrument-create-admin',
  templateUrl: './instrument-create-admin.component.html'
})
export class InstrumentCreateAdminComponent extends AbstractCreateController<InstrumentDto, InstrumentCriteria, InstrumentAdminService>  implements OnInit {



   private _validInstrumentDateEmission = true;
   private _validInstrumentMontant = true;
    private _validTypeInstrumentLibelle = true;
    private _validChequeEffetNumeroChequeEffet = true;
    private _validChequeEffetDateEmission = true;
    private _validChequeEffetMontant = true;

    constructor( private instrumentService: InstrumentAdminService , private chequeEffetService: ChequeEffetAdminService, private typeInstrumentService: TypeInstrumentAdminService) {
        super(instrumentService);
    }

    ngOnInit(): void {
        this.typeInstrument = new TypeInstrumentDto();
        this.typeInstrumentService.findAll().subscribe((data) => this.typeInstruments = data);
        this.chequeEffet = new ChequeEffetDto();
        this.chequeEffetService.findAll().subscribe((data) => this.chequeEffets = data);
    }





    public setValidation(value: boolean){
        this.validInstrumentDateEmission = value;
        this.validInstrumentMontant = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateInstrumentDateEmission();
        this.validateInstrumentMontant();
    }

    public validateInstrumentDateEmission(){
        if (this.stringUtilService.isEmpty(this.item.dateEmission)) {
        this.errorMessages.push('Date emission non valide');
        this.validInstrumentDateEmission = false;
        } else {
            this.validInstrumentDateEmission = true;
        }
    }
    public validateInstrumentMontant(){
        if (this.stringUtilService.isEmpty(this.item.montant)) {
        this.errorMessages.push('Montant non valide');
        this.validInstrumentMontant = false;
        } else {
            this.validInstrumentMontant = true;
        }
    }



    get typeInstrument(): TypeInstrumentDto {
        return this.typeInstrumentService.item;
    }
    set typeInstrument(value: TypeInstrumentDto) {
        this.typeInstrumentService.item = value;
    }
    get typeInstruments(): Array<TypeInstrumentDto> {
        return this.typeInstrumentService.items;
    }
    set typeInstruments(value: Array<TypeInstrumentDto>) {
        this.typeInstrumentService.items = value;
    }
    get createTypeInstrumentDialog(): boolean {
       return this.typeInstrumentService.createDialog;
    }
    set createTypeInstrumentDialog(value: boolean) {
        this.typeInstrumentService.createDialog= value;
    }
    get chequeEffet(): ChequeEffetDto {
        return this.chequeEffetService.item;
    }
    set chequeEffet(value: ChequeEffetDto) {
        this.chequeEffetService.item = value;
    }
    get chequeEffets(): Array<ChequeEffetDto> {
        return this.chequeEffetService.items;
    }
    set chequeEffets(value: Array<ChequeEffetDto>) {
        this.chequeEffetService.items = value;
    }
    get createChequeEffetDialog(): boolean {
       return this.chequeEffetService.createDialog;
    }
    set createChequeEffetDialog(value: boolean) {
        this.chequeEffetService.createDialog= value;
    }



    get validInstrumentDateEmission(): boolean {
        return this._validInstrumentDateEmission;
    }

    set validInstrumentDateEmission(value: boolean) {
         this._validInstrumentDateEmission = value;
    }
    get validInstrumentMontant(): boolean {
        return this._validInstrumentMontant;
    }

    set validInstrumentMontant(value: boolean) {
         this._validInstrumentMontant = value;
    }

    get validTypeInstrumentLibelle(): boolean {
        return this._validTypeInstrumentLibelle;
    }
    set validTypeInstrumentLibelle(value: boolean) {
        this._validTypeInstrumentLibelle = value;
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


}
