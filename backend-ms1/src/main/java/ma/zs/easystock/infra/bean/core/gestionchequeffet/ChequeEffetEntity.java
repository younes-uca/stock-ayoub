package ma.zs.easystock.infra.bean.core.gestionchequeffet;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.infra.bean.core.commun.FournisseurEntity;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "cheque_effet")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChequeEffetEntity   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String numeroChequeEffet;
    private LocalDateTime dateEmission ;
    private BigDecimal montant = BigDecimal.ZERO;

    private FournisseurEntity beneficiaire ;


    public ChequeEffetEntity(){
        super();
    }

    public ChequeEffetEntity(Long id,String numeroChequeEffet){
        this.id = id;
        this.numeroChequeEffet = numeroChequeEffet ;
    }
    public ChequeEffetEntity(String numeroChequeEffet){
        this.numeroChequeEffet = numeroChequeEffet ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="cheque_effet_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }    public String getNumeroChequeEffet(){
        return this.numeroChequeEffet;
    }
    public void setNumeroChequeEffet(String numeroChequeEffet){
        this.numeroChequeEffet = numeroChequeEffet;
    }    public LocalDateTime getDateEmission(){
        return this.dateEmission;
    }
    public void setDateEmission(LocalDateTime dateEmission){
        this.dateEmission = dateEmission;
    }    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public FournisseurEntity getBeneficiaire(){
        return this.beneficiaire;
    }
    public void setBeneficiaire(FournisseurEntity beneficiaire){
        this.beneficiaire = beneficiaire;
    }

    @Transient
    public String getLabel() {
        label = numeroChequeEffet;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChequeEffetEntity chequeEffet = (ChequeEffetEntity) o;
        return id != null && id.equals(chequeEffet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

