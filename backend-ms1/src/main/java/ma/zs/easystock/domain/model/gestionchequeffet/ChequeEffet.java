package ma.zs.easystock.domain.model.gestionchequeffet;

import java.util.Objects;
import java.time.LocalDateTime;
import java.util.Date;

import ma.zs.easystock.domain.model.commun.Fournisseur;


import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;

import java.math.BigDecimal;



public class ChequeEffet   extends AuditDomainObject     {

    private Long id;

    private String numeroChequeEffet;
    private LocalDateTime dateEmission ;
    private BigDecimal montant = BigDecimal.ZERO;

    private Fournisseur beneficiaire ;


    public ChequeEffet(){
        super();
    }

    public ChequeEffet(Long id,String numeroChequeEffet){
        this.id = id;
        this.numeroChequeEffet = numeroChequeEffet ;
    }
    public ChequeEffet(String numeroChequeEffet){
        this.numeroChequeEffet = numeroChequeEffet ;
    }
    public String getNumeroChequeEffet(){
        return this.numeroChequeEffet;
    }
    public void setNumeroChequeEffet(String numeroChequeEffet){
        this.numeroChequeEffet = numeroChequeEffet;
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
    public Fournisseur getBeneficiaire(){
        return this.beneficiaire;
    }
    public void setBeneficiaire(Fournisseur beneficiaire){
        this.beneficiaire = beneficiaire;
    }

    public String getLabel() {
        label = numeroChequeEffet;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChequeEffet chequeEffet = (ChequeEffet) o;
        return id != null && id.equals(chequeEffet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

