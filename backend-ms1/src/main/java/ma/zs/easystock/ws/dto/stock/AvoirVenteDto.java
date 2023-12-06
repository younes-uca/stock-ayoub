package  ma.zs.easystock.ws.dto.stock;

import ma.zs.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


import ma.zs.easystock.ws.dto.commun.EtatAvoirVenteDto;
import ma.zs.easystock.ws.dto.commun.DepotDto;
import ma.zs.easystock.ws.dto.commun.EntrepriseSocieteDto;
import ma.zs.easystock.ws.dto.commun.ClientDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class AvoirVenteDto  extends AuditBaseDto {

    private String barCode  ;
    private String codeAvoirVente  ;
    private String numeroFactureAvoirVente  ;
    private String dateFactureAvoirVente ;
    private BigDecimal montantHt  ;
    private BigDecimal montantTva  ;
    private BigDecimal montantTtc  ;
    private String description  ;

    private EntrepriseSocieteDto entrepriseSociete ;
    private ClientDto client ;
    private EtatAvoirVenteDto etatAvoirVente ;
    private AchatDto achat ;

    private List<AvoirVenteItemDto> avoirVenteItems ;
    private List<AvoirVenteItemDto> avoirs ;


    public AvoirVenteDto(){
        super();
    }



    public String getBarCode(){
        return this.barCode;
    }
    public void setBarCode(String barCode){
        this.barCode = barCode;
    }

    public String getCodeAvoirVente(){
        return this.codeAvoirVente;
    }
    public void setCodeAvoirVente(String codeAvoirVente){
        this.codeAvoirVente = codeAvoirVente;
    }

    public String getNumeroFactureAvoirVente(){
        return this.numeroFactureAvoirVente;
    }
    public void setNumeroFactureAvoirVente(String numeroFactureAvoirVente){
        this.numeroFactureAvoirVente = numeroFactureAvoirVente;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateFactureAvoirVente(){
        return this.dateFactureAvoirVente;
    }
    public void setDateFactureAvoirVente(String dateFactureAvoirVente){
        this.dateFactureAvoirVente = dateFactureAvoirVente;
    }

    public BigDecimal getMontantHt(){
        return this.montantHt;
    }
    public void setMontantHt(BigDecimal montantHt){
        this.montantHt = montantHt;
    }

    public BigDecimal getMontantTva(){
        return this.montantTva;
    }
    public void setMontantTva(BigDecimal montantTva){
        this.montantTva = montantTva;
    }

    public BigDecimal getMontantTtc(){
        return this.montantTtc;
    }
    public void setMontantTtc(BigDecimal montantTtc){
        this.montantTtc = montantTtc;
    }

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public EntrepriseSocieteDto getEntrepriseSociete(){
        return this.entrepriseSociete;
    }

    public void setEntrepriseSociete(EntrepriseSocieteDto entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public ClientDto getClient(){
        return this.client;
    }

    public void setClient(ClientDto client){
        this.client = client;
    }
    public EtatAvoirVenteDto getEtatAvoirVente(){
        return this.etatAvoirVente;
    }

    public void setEtatAvoirVente(EtatAvoirVenteDto etatAvoirVente){
        this.etatAvoirVente = etatAvoirVente;
    }
    public AchatDto getAchat(){
        return this.achat;
    }

    public void setAchat(AchatDto achat){
        this.achat = achat;
    }



    public List<AvoirVenteItemDto> getAvoirVenteItems(){
        return this.avoirVenteItems;
    }

    public void setAvoirVenteItems(List<AvoirVenteItemDto> avoirVenteItems){
        this.avoirVenteItems = avoirVenteItems;
    }
    public List<AvoirVenteItemDto> getAvoirs(){
        return this.avoirs;
    }

    public void setAvoirs(List<AvoirVenteItemDto> avoirs){
        this.avoirs = avoirs;
    }



}
