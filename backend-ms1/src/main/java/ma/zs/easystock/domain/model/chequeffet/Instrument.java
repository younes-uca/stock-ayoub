package ma.zs.easystock.domain.model.chequeffet;

import java.util.Objects;
import java.time.LocalDateTime;
import java.util.Date;

import ma.zs.easystock.domain.model.gestionchequeffet.ChequeEffet;
import ma.zs.easystock.domain.model.gestionchequeffet.TypeInstrument;


import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;

import java.math.BigDecimal;



public class Instrument   extends AuditDomainObject     {

    private Long id;

    private LocalDateTime dateEmission ;
    private BigDecimal montant = BigDecimal.ZERO;

    private TypeInstrument typeInstrument ;
    private ChequeEffet chequeEffet ;


    public Instrument(){
        super();
    }

    public TypeInstrument getTypeInstrument(){
        return this.typeInstrument;
    }
    public void setTypeInstrument(TypeInstrument typeInstrument){
        this.typeInstrument = typeInstrument;
    }
    public ChequeEffet getChequeEffet(){
        return this.chequeEffet;
    }
    public void setChequeEffet(ChequeEffet chequeEffet){
        this.chequeEffet = chequeEffet;
    }
    public LocalDateTime getDateEmission(){
        return this.dateEmission;
    }
    public void setDateEmission(LocalDateTime dateEmission){
        this.dateEmission = dateEmission;
    }
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instrument instrument = (Instrument) o;
        return id != null && id.equals(instrument.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

