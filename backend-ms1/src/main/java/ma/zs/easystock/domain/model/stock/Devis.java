package ma.zs.easystock.domain.model.stock;

import java.util.Objects;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Date;

import ma.zs.easystock.domain.model.commun.Client;


import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;

import java.math.BigDecimal;



public class Devis   extends AuditDomainObject     {

    private Long id;

    private String numeroDevis;
    private LocalDateTime dateDevis ;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTva = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;
    private String description;

    private Client client ;

    private List<DevisItem> devisItems ;

    public Devis(){
        super();
    }

    public Devis(Long id,String numeroDevis){
        this.id = id;
        this.numeroDevis = numeroDevis ;
    }
    public Devis(String numeroDevis){
        this.numeroDevis = numeroDevis ;
    }
    public String getNumeroDevis(){
        return this.numeroDevis;
    }
    public void setNumeroDevis(String numeroDevis){
        this.numeroDevis = numeroDevis;
    }
    public LocalDateTime getDateDevis(){
        return this.dateDevis;
    }
    public void setDateDevis(LocalDateTime dateDevis){
        this.dateDevis = dateDevis;
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
    public List<DevisItem> getDevisItems(){
        return this.devisItems;
    }
    public void setDevisItems(List<DevisItem> devisItems){
        this.devisItems = devisItems;
    }

    public String getLabel() {
        label = numeroDevis;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Devis devis = (Devis) o;
        return id != null && id.equals(devis.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

