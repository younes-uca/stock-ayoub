package ma.zs.easystock.domain.model.stock;

import java.util.Objects;



import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;

import java.math.BigDecimal;



public class InventaireItem   extends AuditDomainObject     {

    private Long id;

    private BigDecimal quantiteEstime = BigDecimal.ZERO;
    private BigDecimal quantiteReelle = BigDecimal.ZERO;

    private Produit produit ;
    private Inventaire inventaire ;


    public InventaireItem(){
        super();
    }

    public Produit getProduit(){
        return this.produit;
    }
    public void setProduit(Produit produit){
        this.produit = produit;
    }
    public BigDecimal getQuantiteEstime(){
        return this.quantiteEstime;
    }
    public void setQuantiteEstime(BigDecimal quantiteEstime){
        this.quantiteEstime = quantiteEstime;
    }
    public BigDecimal getQuantiteReelle(){
        return this.quantiteReelle;
    }
    public void setQuantiteReelle(BigDecimal quantiteReelle){
        this.quantiteReelle = quantiteReelle;
    }
    public Inventaire getInventaire(){
        return this.inventaire;
    }
    public void setInventaire(Inventaire inventaire){
        this.inventaire = inventaire;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventaireItem inventaireItem = (InventaireItem) o;
        return id != null && id.equals(inventaireItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

