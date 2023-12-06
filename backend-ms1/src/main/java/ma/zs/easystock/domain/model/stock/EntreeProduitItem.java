package ma.zs.easystock.domain.model.stock;

import java.util.Objects;

import ma.zs.easystock.domain.model.entree.EntreeProduit;


import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;

import java.math.BigDecimal;



public class EntreeProduitItem   extends AuditDomainObject     {

    private Long id;

    private BigDecimal quantite = BigDecimal.ZERO;
    private String description;

    private Produit produit ;
    private EntreeProduit entreeProduit ;


    public EntreeProduitItem(){
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
    public EntreeProduit getEntreeProduit(){
        return this.entreeProduit;
    }
    public void setEntreeProduit(EntreeProduit entreeProduit){
        this.entreeProduit = entreeProduit;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntreeProduitItem entreeProduitItem = (EntreeProduitItem) o;
        return id != null && id.equals(entreeProduitItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

