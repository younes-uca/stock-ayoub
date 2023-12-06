package ma.zs.easystock.infra.bean.core.gestionchequeffet;

import java.util.Objects;





import ma.zs.easystock.infra.bean.core.stock.ProduitEntity;
import ma.zs.easystock.infra.bean.core.commun.DepotEntity;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "transfert_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransfertItemEntity   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal quantite = BigDecimal.ZERO;

    private DepotEntity depot ;
    private ProduitEntity produit ;
    private TransfertEntity transfert ;


    public TransfertItemEntity(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="transfert_item_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public DepotEntity getDepot(){
        return this.depot;
    }
    public void setDepot(DepotEntity depot){
        this.depot = depot;
    }
    @ManyToOne(fetch = FetchType.LAZY)

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
    }    @ManyToOne(fetch = FetchType.LAZY)

    public TransfertEntity getTransfert(){
        return this.transfert;
    }
    public void setTransfert(TransfertEntity transfert){
        this.transfert = transfert;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransfertItemEntity transfertItem = (TransfertItemEntity) o;
        return id != null && id.equals(transfertItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

