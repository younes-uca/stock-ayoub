package ma.zs.easystock.domain.model.entree;

import java.util.Objects;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Date;

import ma.zs.easystock.domain.model.stock.SortieProduitItem;
import ma.zs.easystock.domain.model.stock.Produit;
import ma.zs.easystock.domain.model.commun.Depot;


import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;




public class SortieProduit   extends AuditDomainObject     {

    private Long id;

    private String reference;
    private LocalDateTime dateSortieProduit ;
    private String description;

    private Depot depot ;

    private List<SortieProduitItem> sortieProduitItems ;

    public SortieProduit(){
        super();
    }

    public SortieProduit(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }
    public SortieProduit(String reference){
        this.reference = reference ;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public LocalDateTime getDateSortieProduit(){
        return this.dateSortieProduit;
    }
    public void setDateSortieProduit(LocalDateTime dateSortieProduit){
        this.dateSortieProduit = dateSortieProduit;
    }
    public Depot getDepot(){
        return this.depot;
    }
    public void setDepot(Depot depot){
        this.depot = depot;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public List<SortieProduitItem> getSortieProduitItems(){
        return this.sortieProduitItems;
    }
    public void setSortieProduitItems(List<SortieProduitItem> sortieProduitItems){
        this.sortieProduitItems = sortieProduitItems;
    }

    public String getLabel() {
        label = reference;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SortieProduit sortieProduit = (SortieProduit) o;
        return id != null && id.equals(sortieProduit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

