package ma.zs.easystock.infra.bean.core.stock;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "inventaire_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InventaireItemEntity   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal quantiteEstime = BigDecimal.ZERO;
    private BigDecimal quantiteReelle = BigDecimal.ZERO;

    private ProduitEntity produit ;
    private InventaireEntity inventaire ;


    public InventaireItemEntity(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="inventaire_item_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public ProduitEntity getProduit(){
        return this.produit;
    }
    public void setProduit(ProduitEntity produit){
        this.produit = produit;
    }
    public BigDecimal getQuantiteEstime(){
        return this.quantiteEstime;
    }
    public void setQuantiteEstime(BigDecimal quantiteEstime){
        this.quantiteEstime = quantiteEstime;
    }    public BigDecimal getQuantiteReelle(){
        return this.quantiteReelle;
    }
    public void setQuantiteReelle(BigDecimal quantiteReelle){
        this.quantiteReelle = quantiteReelle;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public InventaireEntity getInventaire(){
        return this.inventaire;
    }
    public void setInventaire(InventaireEntity inventaire){
        this.inventaire = inventaire;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventaireItemEntity inventaireItem = (InventaireItemEntity) o;
        return id != null && id.equals(inventaireItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

