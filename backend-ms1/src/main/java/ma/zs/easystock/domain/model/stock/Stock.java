package ma.zs.easystock.domain.model.stock;

import java.util.Objects;

import ma.zs.easystock.domain.model.commun.Depot;


import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;

import java.math.BigDecimal;



public class Stock   extends AuditDomainObject     {

    private Long id;

    private BigDecimal quantite = BigDecimal.ZERO;

    private Produit produit ;
    private Depot depot ;


    public Stock(){
        super();
    }

    public Produit getProduit(){
        return this.produit;
    }
    public void setProduit(Produit produit){
        this.produit = produit;
    }
    public Depot getDepot(){
        return this.depot;
    }
    public void setDepot(Depot depot){
        this.depot = depot;
    }
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return id != null && id.equals(stock.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

