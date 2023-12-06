package ma.zs.easystock.domain.model.gestionchequeffet;

import java.util.Objects;
import java.time.LocalDateTime;
import java.util.Date;

import ma.zs.easystock.domain.model.chequeffet.Instrument;


import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;




public class Transaction   extends AuditDomainObject     {

    private Long id;

    private LocalDateTime dateTransaction ;
    private LocalDateTime dateEncaissement ;
    private String pathCheque;
    private String description;

    private TypeTransaction typeTransaction ;
    private Instrument instrument ;
    private Compte compte ;


    public Transaction(){
        super();
    }

    public LocalDateTime getDateTransaction(){
        return this.dateTransaction;
    }
    public void setDateTransaction(LocalDateTime dateTransaction){
        this.dateTransaction = dateTransaction;
    }
    public TypeTransaction getTypeTransaction(){
        return this.typeTransaction;
    }
    public void setTypeTransaction(TypeTransaction typeTransaction){
        this.typeTransaction = typeTransaction;
    }
    public Instrument getInstrument(){
        return this.instrument;
    }
    public void setInstrument(Instrument instrument){
        this.instrument = instrument;
    }
    public Compte getCompte(){
        return this.compte;
    }
    public void setCompte(Compte compte){
        this.compte = compte;
    }
    public LocalDateTime getDateEncaissement(){
        return this.dateEncaissement;
    }
    public void setDateEncaissement(LocalDateTime dateEncaissement){
        this.dateEncaissement = dateEncaissement;
    }
    public String getPathCheque(){
        return this.pathCheque;
    }
    public void setPathCheque(String pathCheque){
        this.pathCheque = pathCheque;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction transaction = (Transaction) o;
        return id != null && id.equals(transaction.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

