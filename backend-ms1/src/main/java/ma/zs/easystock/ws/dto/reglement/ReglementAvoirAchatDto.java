package  ma.zs.easystock.ws.dto.reglement;

import ma.zs.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


import ma.zs.easystock.ws.dto.stock.AchatDto;
import ma.zs.easystock.ws.dto.commun.ModeReglementDto;
import ma.zs.easystock.ws.dto.stock.AvoirAchatDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReglementAvoirAchatDto  extends AuditBaseDto {

    private String reference  ;
    private String dateReglement ;
    private BigDecimal montant  ;
    private String description  ;

    private AchatDto achat ;
    private ModeReglementDto modeReglement ;
    private AvoirAchatDto avoirAchat ;



    public ReglementAvoirAchatDto(){
        super();
    }



    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateReglement(){
        return this.dateReglement;
    }
    public void setDateReglement(String dateReglement){
        this.dateReglement = dateReglement;
    }

    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public AchatDto getAchat(){
        return this.achat;
    }

    public void setAchat(AchatDto achat){
        this.achat = achat;
    }
    public ModeReglementDto getModeReglement(){
        return this.modeReglement;
    }

    public void setModeReglement(ModeReglementDto modeReglement){
        this.modeReglement = modeReglement;
    }
    public AvoirAchatDto getAvoirAchat(){
        return this.avoirAchat;
    }

    public void setAvoirAchat(AvoirAchatDto avoirAchat){
        this.avoirAchat = avoirAchat;
    }






}
