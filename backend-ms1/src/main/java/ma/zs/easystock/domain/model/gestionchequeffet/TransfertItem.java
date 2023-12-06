package ma.zs.easystock.domain.model.gestionchequeffet;

import java.util.Objects;

import ma.zs.easystock.domain.model.stock.Produit;
import ma.zs.easystock.domain.model.commun.Depot;


import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;

import java.math.BigDecimal;



public class TransfertItem   extends AuditDomainObject     {

    private Long id;

    private BigDecimal quantite = BigDecimal.ZERO;

    private Depot depot ;
    private Produit produit ;
    private Transfert transfert ;


    public TransfertItem(){
        super();
    }

    public Depot getDepot(){
        return this.depot;
    }
    public void setDepot(Depot depot){
        this.depot = depot;
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
    public Transfert getTransfert(){
        return this.transfert;
    }
    public void setTransfert(Transfert transfert){
        this.transfert = transfert;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransfertItem transfertItem = (TransfertItem) o;
        return id != null && id.equals(transfertItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

