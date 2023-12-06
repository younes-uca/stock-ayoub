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
public class BonPourDto  extends AuditBaseDto {

    private String numeroBonPour  ;
    private String dateBonPour ;
    private BigDecimal montantHt  ;
    private BigDecimal montantTva  ;
    private BigDecimal montantTtc  ;
    private String description  ;

    private ClientDto client ;

    private List<BonPourItemDto> bonPourItems ;


    public BonPourDto(){
        super();
    }



    public String getNumeroBonPour(){
        return this.numeroBonPour;
    }
    public void setNumeroBonPour(String numeroBonPour){
        this.numeroBonPour = numeroBonPour;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateBonPour(){
        return this.dateBonPour;
    }
    public void setDateBonPour(String dateBonPour){
        this.dateBonPour = dateBonPour;
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



    public List<BonPourItemDto> getBonPourItems(){
        return this.bonPourItems;
    }

    public void setBonPourItems(List<BonPourItemDto> bonPourItems){
        this.bonPourItems = bonPourItems;
    }



}
