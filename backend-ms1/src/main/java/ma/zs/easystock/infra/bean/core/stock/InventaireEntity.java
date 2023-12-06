package ma.zs.easystock.infra.bean.core.stock;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.infra.bean.core.commun.EntrepriseSocieteEntity;
import ma.zs.easystock.infra.bean.core.commun.DepotEntity;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;



import jakarta.persistence.*;

@Entity
@Table(name = "inventaire")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InventaireEntity   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime dateInventaire ;
    @Column(length = 500)
    private String description;

    private EntrepriseSocieteEntity entrepriseSociete ;
    private DepotEntity depot ;

    private List<InventaireItemEntity> inventaireItems ;

    public InventaireEntity(){
        super();
    }

    public InventaireEntity(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }
    public InventaireEntity(String reference){
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="inventaire_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public EntrepriseSocieteEntity getEntrepriseSociete(){
        return this.entrepriseSociete;
    }
    public void setEntrepriseSociete(EntrepriseSocieteEntity entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    @ManyToOne(fetch = FetchType.LAZY)

    public DepotEntity getDepot(){
        return this.depot;
    }
    public void setDepot(DepotEntity depot){
        this.depot = depot;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }    public LocalDateTime getDateInventaire(){
        return this.dateInventaire;
    }
    public void setDateInventaire(LocalDateTime dateInventaire){
        this.dateInventaire = dateInventaire;
    }    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }    @OneToMany(mappedBy = "inventaire")

    public List<InventaireItemEntity> getInventaireItems(){
        return this.inventaireItems;
    }
    public void setInventaireItems(List<InventaireItemEntity> inventaireItems){
        this.inventaireItems = inventaireItems;
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
        InventaireEntity inventaire = (InventaireEntity) o;
        return id != null && id.equals(inventaire.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

