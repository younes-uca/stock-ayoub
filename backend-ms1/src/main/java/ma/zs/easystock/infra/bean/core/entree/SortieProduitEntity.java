package ma.zs.easystock.infra.bean.core.entree;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.infra.bean.core.stock.SortieProduitItemEntity;
import ma.zs.easystock.infra.bean.core.stock.ProduitEntity;
import ma.zs.easystock.infra.bean.core.commun.DepotEntity;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;



import jakarta.persistence.*;

@Entity
@Table(name = "sortie_produit")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SortieProduitEntity   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime dateSortieProduit ;
    @Column(length = 500)
    private String description;

    private DepotEntity depot ;

    private List<SortieProduitItemEntity> sortieProduitItems ;

    public SortieProduitEntity(){
        super();
    }

    public SortieProduitEntity(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }
    public SortieProduitEntity(String reference){
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="sortie_produit_seq")
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
    }    public LocalDateTime getDateSortieProduit(){
        return this.dateSortieProduit;
    }
    public void setDateSortieProduit(LocalDateTime dateSortieProduit){
        this.dateSortieProduit = dateSortieProduit;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public DepotEntity getDepot(){
        return this.depot;
    }
    public void setDepot(DepotEntity depot){
        this.depot = depot;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }    @OneToMany(mappedBy = "sortieProduit")

    public List<SortieProduitItemEntity> getSortieProduitItems(){
        return this.sortieProduitItems;
    }
    public void setSortieProduitItems(List<SortieProduitItemEntity> sortieProduitItems){
        this.sortieProduitItems = sortieProduitItems;
    }

    @Transient
    public String getLabel() {
        label = reference;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SortieProduitEntity sortieProduit = (SortieProduitEntity) o;
        return id != null && id.equals(sortieProduit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

