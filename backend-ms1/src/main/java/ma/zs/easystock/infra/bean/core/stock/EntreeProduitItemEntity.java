package ma.zs.easystock.infra.bean.core.stock;

import java.util.Objects;





import ma.zs.easystock.infra.bean.core.entree.EntreeProduitEntity;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "entree_produit_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntreeProduitItemEntity   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal quantite = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private ProduitEntity produit ;
    private EntreeProduitEntity entreeProduit ;


    public EntreeProduitItemEntity(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="entree_produit_item_seq")
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
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public EntreeProduitEntity getEntreeProduit(){
        return this.entreeProduit;
    }
    public void setEntreeProduit(EntreeProduitEntity entreeProduit){
        this.entreeProduit = entreeProduit;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntreeProduitItemEntity entreeProduitItem = (EntreeProduitItemEntity) o;
        return id != null && id.equals(entreeProduitItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

