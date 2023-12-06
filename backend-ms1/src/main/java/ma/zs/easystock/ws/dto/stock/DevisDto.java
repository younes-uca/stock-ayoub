package  ma.zs.easystock.ws.dto.stock;

import ma.zs.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


import ma.zs.easystock.ws.dto.commun.ClientDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class DevisDto  extends AuditBaseDto {

    private String numeroDevis  ;
    private String dateDevis ;
    private BigDecimal montantHt  ;
    private BigDecimal montantTva  ;
    private BigDecimal montantTtc  ;
    private String description  ;

    private ClientDto client ;

    private List<DevisItemDto> devisItems ;


    public DevisDto(){
        super();
    }



    public String getNumeroDevis(){
        return this.numeroDevis;
    }
    public void setNumeroDevis(String numeroDevis){
        this.numeroDevis = numeroDevis;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateDevis(){
        return this.dateDevis;
    }
    public void setDateDevis(String dateDevis){
        this.dateDevis = dateDevis;
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


    public ClientDto getClient(){
        return this.client;
    }

    public void setClient(ClientDto client){
        this.client = client;
    }



    public List<DevisItemDto> getDevisItems(){
        return this.devisItems;
    }

    public void setDevisItems(List<DevisItemDto> devisItems){
        this.devisItems = devisItems;
    }



}
