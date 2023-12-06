package ma.zs.easystock.infra.bean.core.entree;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.infra.bean.core.stock.ProduitEntity;
import ma.zs.easystock.infra.bean.core.stock.EntreeProduitItemEntity;
import ma.zs.easystock.infra.bean.core.commun.DepotEntity;
import ma.zs.easystock.infra.bean.core.commun.FournisseurEntity;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;



import jakarta.persistence.*;

@Entity
@Table(name = "entree_produit")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntreeProduitEntity   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime dateEntreeProduit ;
    @Column(length = 500)
    private String description;

    private FournisseurEntity fournisseur ;
    private DepotEntity depot ;

    private List<EntreeProduitItemEntity> entreeProduitItems ;

    public EntreeProduitEntity(){
        super();
    }

    public EntreeProduitEntity(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }
    public EntreeProduitEntity(String reference){
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="entree_produit_seq")
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
    }    public LocalDateTime getDateEntreeProduit(){
        return this.dateEntreeProduit;
    }
    public void setDateEntreeProduit(LocalDateTime dateEntreeProduit){
        this.dateEntreeProduit = dateEntreeProduit;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public FournisseurEntity getFournisseur(){
        return this.fournisseur;
    }
    public void setFournisseur(FournisseurEntity fournisseur){
        this.fournisseur = fournisseur;
    }
    @ManyToOne(fetch = FetchType.LAZY)

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
    }    @OneToMany(mappedBy = "entreeProduit")

    public List<EntreeProduitItemEntity> getEntreeProduitItems(){
        return this.entreeProduitItems;
    }
    public void setEntreeProduitItems(List<EntreeProduitItemEntity> entreeProduitItems){
        this.entreeProduitItems = entreeProduitItems;
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
        EntreeProduitEntity entreeProduit = (EntreeProduitEntity) o;
        return id != null && id.equals(entreeProduit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

