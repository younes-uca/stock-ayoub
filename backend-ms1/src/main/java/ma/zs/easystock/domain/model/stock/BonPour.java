package ma.zs.easystock.domain.model.stock;

import java.util.Objects;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Date;

import ma.zs.easystock.domain.model.commun.Client;


import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;

import java.math.BigDecimal;



public class BonPour   extends AuditDomainObject     {

    private Long id;

    private String numeroBonPour;
    private LocalDateTime dateBonPour ;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTva = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;
    private String description;

    private Client client ;

    private List<BonPourItem> bonPourItems ;

    public BonPour(){
        super();
    }

    public BonPour(Long id,String numeroBonPour){
        this.id = id;
        this.numeroBonPour = numeroBonPour ;
    }
    public BonPour(String numeroBonPour){
        this.numeroBonPour = numeroBonPour ;
    }
    public String getNumeroBonPour(){
        return this.numeroBonPour;
    }
    public void setNumeroBonPour(String numeroBonPour){
        this.numeroBonPour = numeroBonPour;
    }
    public LocalDateTime getDateBonPour(){
        return this.dateBonPour;
    }
    public void setDateBonPour(LocalDateTime dateBonPour){
        this.dateBonPour = dateBonPour;
    }
    public Client getClient(){
        return this.client;
    }
    public void setClient(Client client){
        this.client = client;
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
    public List<BonPourItem> getBonPourItems(){
        return this.bonPourItems;
    }
    public void setBonPourItems(List<BonPourItem> bonPourItems){
        this.bonPourItems = bonPourItems;
    }

    public String getLabel() {
        label = numeroBonPour;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonPour bonPour = (BonPour) o;
        return id != null && id.equals(bonPour.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

