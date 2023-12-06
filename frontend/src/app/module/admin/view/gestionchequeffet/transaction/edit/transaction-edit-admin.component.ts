import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {TransactionAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TransactionAdmin.service';
import {TransactionDto} from 'src/app/controller/model/gestionchequeffet/Transaction.model';
import {TransactionCriteria} from 'src/app/controller/criteria/gestionchequeffet/TransactionCriteria.model';


import {TypeTransactionDto} from 'src/app/controller/model/gestionchequeffet/TypeTransaction.model';
import {TypeTransactionAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TypeTransactionAdmin.service';
import {InstrumentDto} from 'src/app/controller/model/chequeffet/Instrument.model';
import {InstrumentAdminService} from 'src/app/controller/service/admin/chequeffet/InstrumentAdmin.service';
import {CompteDto} from 'src/app/controller/model/gestionchequeffet/Compte.model';
import {CompteAdminService} from 'src/app/controller/service/admin/gestionchequeffet/CompteAdmin.service';

@Component({
  selector: 'app-transaction-edit-admin',
  templateUrl: './transaction-edit-admin.component.html'
})
export class TransactionEditAdminComponent extends AbstractEditController<TransactionDto, TransactionCriteria, TransactionAdminService>   implements OnInit {


    private _validTransactionDateTransaction = true;
    private _validTransactionDateEncaissement = true;

    private _validTypeTransactionLibelle = true;
    private _validInstrumentDateEmission = true;
    private _validInstrumentMontant = true;
    private _validCompteNumeroCompte = true;



    constructor( private transactionService: TransactionAdminService , private typeTransactionService: TypeTransactionAdminService, private instrumentService: InstrumentAdminService, private compteService: CompteAdminService) {
        super(transactionService);
    }

    ngOnInit(): void {
        this.typeTransaction = new TypeTransactionDto();
        this.typeTransactionService.findAll().subscribe((data) => this.typeTransactions = data);
        this.instrument = new InstrumentDto();
        this.instrumentService.findAll().subscribe((data) => this.instruments = data);
        this.compte = new CompteDto();
        this.compteService.findAll().subscribe((data) => this.comptes = data);
    }
    public prepareEdit() {
        this.item.dateTransaction = this.transactionService.format(this.item.dateTransaction);
        this.item.dateEncaissement = this.transactionService.format(this.item.dateEncaissement);
    }



    public setValidation(value: boolean){
        this.validTransactionDateTransaction = value;
        this.validTransactionDateEncaissement = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateTransactionDateTransaction();
        this.validateTransactionDateEncaissement();
    }
    public validateTransactionDateTransaction(){
        if (this.stringUtilService.isEmpty(this.item.dateTransaction)) {
            this.errorMessages.push('Date transaction non valide');
            this.validTransactionDateTransaction = false;
        } else {
            this.validTransactionDateTransaction = true;
        }
    }
    public validateTransactionDateEncaissement(){
        if (this.stringUtilService.isEmpty(this.item.dateEncaissement)) {
            this.errorMessages.push('Date encaissement non valide');
            this.validTransactionDateEncaissement = false;
        } else {
            this.validTransactionDateEncaissement = true;
        }
    }



   public async openCreateTypeTransaction(typeTransaction: string) {
        const isPermistted = await this.roleService.isPermitted('TypeTransaction', 'edit');
        if (isPermistted) {
             this.typeTransaction = new TypeTransactionDto();
             this.createTypeTransactionDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateCompte(compte: string) {
        const isPermistted = await this.roleService.isPermitted('Compte', 'edit');
        if (isPermistted) {
             this.compte = new CompteDto();
             this.createCompteDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get typeTransaction(): TypeTransactionDto {
       return this.typeTransactionService.item;
   }
  set typeTransaction(value: TypeTransactionDto) {
        this.typeTransactionService.item = value;
   }
   get typeTransactions(): Array<TypeTransactionDto> {
        return this.typeTransactionService.items;
   }
   set typeTransactions(value: Array<TypeTransactionDto>) {
        this.typeTransactionService.items = value;
   }
   get createTypeTransactionDialog(): boolean {
       return this.typeTransactionService.createDialog;
   }
  set createTypeTransactionDialog(value: boolean) {
       this.typeTransactionService.createDialog= value;
   }
   get compte(): CompteDto {
       return this.compteService.item;
   }
  set compte(value: CompteDto) {
        this.compteService.item = value;
   }
   get comptes(): Array<CompteDto> {
        return this.compteService.items;
   }
   set comptes(value: Array<CompteDto>) {
        this.compteService.items = value;
   }
   get createCompteDialog(): boolean {
       return this.compteService.createDialog;
   }
  set createCompteDialog(value: boolean) {
       this.compteService.createDialog= value;
   }
   get instrument(): InstrumentDto {
       return this.instrumentService.item;
   }
  set instrument(value: InstrumentDto) {
        this.instrumentService.item = value;
   }
   get instruments(): Array<InstrumentDto> {
        return this.instrumentService.items;
   }
   set instruments(value: Array<InstrumentDto>) {
        this.instrumentService.items = value;
   }
   get createInstrumentDialog(): boolean {
       return this.instrumentService.createDialog;
   }
  set createInstrumentDialog(value: boolean) {
       this.instrumentService.createDialog= value;
   }


    get validTransactionDateTransaction(): boolean {
        return this._validTransactionDateTransaction;
    }
    set validTransactionDateTransaction(value: boolean) {
        this._validTransactionDateTransaction = value;
    }
    get validTransactionDateEncaissement(): boolean {
        return this._validTransactionDateEncaissement;
    }
    set validTransactionDateEncaissement(value: boolean) {
        this._validTransactionDateEncaissement = value;
    }

    get validTypeTransactionLibelle(): boolean {
        return this._validTypeTransactionLibelle;
    }
    set validTypeTransactionLibelle(value: boolean) {
        this._validTypeTransactionLibelle = value;
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
    get validCompteNumeroCompte(): boolean {
        return this._validCompteNumeroCompte;
    }
    set validCompteNumeroCompte(value: boolean) {
        this._validCompteNumeroCompte = value;
    }
}
