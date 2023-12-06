package ma.zs.easystock.domain.model.stock;

import java.util.Objects;

import ma.zs.easystock.domain.model.entree.SortieProduit;


import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;

import java.math.BigDecimal;



public class SortieProduitItem   extends AuditDomainObject     {

    private Long id;

    private BigDecimal quantite = BigDecimal.ZERO;
    private String description;

    private Produit produit ;
    private SortieProduit sortieProduit ;


    public SortieProduitItem(){
        super();
    }

    public Produit getProduit(){
        return this.produit;
    }
    public void setProduit(Produit produit){
        this.produit = produit;
    }
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public SortieProduit getSortieProduit(){
        return this.sortieProduit;
    }
    public void setSortieProduit(SortieProduit sortieProduit){
        this.sortieProduit = sortieProduit;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SortieProduitItem sortieProduitItem = (SortieProduitItem) o;
        return id != null && id.equals(sortieProduitItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

