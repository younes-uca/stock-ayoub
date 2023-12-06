package  ma.zs.easystock.ws.dto.gestionchequeffet;

import ma.zs.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


import ma.zs.easystock.ws.dto.commun.FournisseurDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChequeEffetDto  extends AuditBaseDto {

    private String numeroChequeEffet  ;
    private String dateEmission ;
    private BigDecimal montant  ;

    private FournisseurDto beneficiaire ;



    public ChequeEffetDto(){
        super();
    }



    public String getNumeroChequeEffet(){
        return this.numeroChequeEffet;
    }
    public void setNumeroChequeEffet(String numeroChequeEffet){
        this.numeroChequeEffet = numeroChequeEffet;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateEmission(){
        return this.dateEmission;
    }
    public void setDateEmission(String dateEmission){
        this.dateEmission = dateEmission;
    }

    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }


    public FournisseurDto getBeneficiaire(){
        return this.beneficiaire;
    }

    public void setBeneficiaire(FournisseurDto beneficiaire){
        this.beneficiaire = beneficiaire;
    }






}
