package ma.zs.easystock.infra.bean.core.gestionchequeffet;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.infra.bean.core.chequeffet.InstrumentEntity;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;



import jakarta.persistence.*;

@Entity
@Table(name = "transaction")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionEntity   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateTransaction ;
    private LocalDateTime dateEncaissement ;
    @Column(length = 500)
    private String pathCheque;
    @Column(length = 500)
    private String description;

    private TypeTransactionEntity typeTransaction ;
    private InstrumentEntity instrument ;
    private CompteEntity compte ;


    public TransactionEntity(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="transaction_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }    public LocalDateTime getDateTransaction(){
        return this.dateTransaction;
    }
    public void setDateTransaction(LocalDateTime dateTransaction){
        this.dateTransaction = dateTransaction;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public TypeTransactionEntity getTypeTransaction(){
        return this.typeTransaction;
    }
    public void setTypeTransaction(TypeTransactionEntity typeTransaction){
        this.typeTransaction = typeTransaction;
    }
    @ManyToOne(fetch = FetchType.LAZY)

    public InstrumentEntity getInstrument(){
        return this.instrument;
    }
    public void setInstrument(InstrumentEntity instrument){
        this.instrument = instrument;
    }
    @ManyToOne(fetch = FetchType.LAZY)

    public CompteEntity getCompte(){
        return this.compte;
    }
    public void setCompte(CompteEntity compte){
        this.compte = compte;
    }
    public LocalDateTime getDateEncaissement(){
        return this.dateEncaissement;
    }
    public void setDateEncaissement(LocalDateTime dateEncaissement){
        this.dateEncaissement = dateEncaissement;
    }    public String getPathCheque(){
        return this.pathCheque;
    }
    public void setPathCheque(String pathCheque){
        this.pathCheque = pathCheque;
    }    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionEntity transaction = (TransactionEntity) o;
        return id != null && id.equals(transaction.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

