package ma.zs.easystock.infra.bean.core.commun;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;



import jakarta.persistence.*;

@Entity
@Table(name = "depot")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepotEntity   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String adresse;



    public DepotEntity(){
        super();
    }

    public DepotEntity(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public DepotEntity(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="depot_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }    public String getAdresse(){
        return this.adresse;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }
    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepotEntity depot = (DepotEntity) o;
        return id != null && id.equals(depot.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

