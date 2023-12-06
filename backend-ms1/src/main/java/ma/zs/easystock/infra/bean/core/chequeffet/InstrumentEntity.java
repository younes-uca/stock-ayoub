package ma.zs.easystock.infra.bean.core.chequeffet;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.infra.bean.core.gestionchequeffet.ChequeEffetEntity;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.TypeInstrumentEntity;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "instrument")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InstrumentEntity   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateEmission ;
    private BigDecimal montant = BigDecimal.ZERO;

    private TypeInstrumentEntity typeInstrument ;
    private ChequeEffetEntity chequeEffet ;


    public InstrumentEntity(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="instrument_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public TypeInstrumentEntity getTypeInstrument(){
        return this.typeInstrument;
    }
    public void setTypeInstrument(TypeInstrumentEntity typeInstrument){
        this.typeInstrument = typeInstrument;
    }
    @ManyToOne(fetch = FetchType.LAZY)

    public ChequeEffetEntity getChequeEffet(){
        return this.chequeEffet;
    }
    public void setChequeEffet(ChequeEffetEntity chequeEffet){
        this.chequeEffet = chequeEffet;
    }
    public LocalDateTime getDateEmission(){
        return this.dateEmission;
    }
    public void setDateEmission(LocalDateTime dateEmission){
        this.dateEmission = dateEmission;
    }    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstrumentEntity instrument = (InstrumentEntity) o;
        return id != null && id.equals(instrument.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

