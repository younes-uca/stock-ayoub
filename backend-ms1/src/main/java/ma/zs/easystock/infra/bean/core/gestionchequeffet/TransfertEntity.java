package ma.zs.easystock.infra.bean.core.gestionchequeffet;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.infra.bean.core.stock.ProduitEntity;
import ma.zs.easystock.infra.bean.core.Transfert.RaisonEntity;
import ma.zs.easystock.infra.bean.core.commun.DepotEntity;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;



import jakarta.persistence.*;

@Entity
@Table(name = "transfert")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransfertEntity   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime dateTransfert ;
    @Column(length = 500)
    private String description;

    private RaisonEntity raison ;

    private List<TransfertItemEntity> transfertItems ;

    public TransfertEntity(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="transfert_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public RaisonEntity getRaison(){
        return this.raison;
    }
    public void setRaison(RaisonEntity raison){
        this.raison = raison;
    }
    public LocalDateTime getDateTransfert(){
        return this.dateTransfert;
    }
    public void setDateTransfert(LocalDateTime dateTransfert){
        this.dateTransfert = dateTransfert;
    }    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }    @OneToMany(mappedBy = "transfert")

    public List<TransfertItemEntity> getTransfertItems(){
        return this.transfertItems;
    }
    public void setTransfertItems(List<TransfertItemEntity> transfertItems){
        this.transfertItems = transfertItems;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransfertEntity transfert = (TransfertEntity) o;
        return id != null && id.equals(transfert.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

