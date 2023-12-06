package  ma.zs.easystock.ws.dto.stock;

import ma.zs.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


import ma.zs.easystock.ws.dto.commun.EntrepriseSocieteDto;
import ma.zs.easystock.ws.dto.commun.EtatAvoirVenteDto;
import ma.zs.easystock.ws.dto.commun.DepotDto;
import ma.zs.easystock.ws.dto.commun.EtatVenteDto;
import ma.zs.easystock.ws.dto.commun.ClientDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class VenteDto  extends AuditBaseDto {

    private String barCode  ;
    private String codeVente  ;
    private String dateFacture ;
    private String numeroFacture  ;
    private BigDecimal montantHt  ;
    private BigDecimal montantTva  ;
    private BigDecimal montantTtc  ;
    private String description  ;

    private EntrepriseSocieteDto entrepriseSociete ;
    private ClientDto client ;
    private EtatVenteDto etatVente ;

    private List<VenteItemDto> venteItems ;
    private List<AvoirVenteDto> avoirs ;


    public VenteDto(){
        super();
    }



    public String getBarCode(){
        return this.barCode;
    }
    public void setBarCode(String barCode){
        this.barCode = barCode;
    }

    public String getCodeVente(){
        return this.codeVente;
    }
    public void setCodeVente(String codeVente){
        this.codeVente = codeVente;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateFacture(){
        return this.dateFacture;
    }
    public void setDateFacture(String dateFacture){
        this.dateFacture = dateFacture;
    }

    public String getNumeroFacture(){
        return this.numeroFacture;
    }
    public void setNumeroFacture(String numeroFacture){
        this.numeroFacture = numeroFacture;
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
    public EtatVenteDto getEtatVente(){
        return this.etatVente;
    }

    public void setEtatVente(EtatVenteDto etatVente){
        this.etatVente = etatVente;
    }



    public List<VenteItemDto> getVenteItems(){
        return this.venteItems;
    }

    public void setVenteItems(List<VenteItemDto> venteItems){
        this.venteItems = venteItems;
    }
    public List<AvoirVenteDto> getAvoirs(){
        return this.avoirs;
    }

    public void setAvoirs(List<AvoirVenteDto> avoirs){
        this.avoirs = avoirs;
    }



}
