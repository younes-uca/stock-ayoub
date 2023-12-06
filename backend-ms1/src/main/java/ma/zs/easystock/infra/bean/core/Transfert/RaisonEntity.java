package ma.zs.easystock.infra.bean.core.Transfert;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;



import jakarta.persistence.*;

@Entity
@Table(name = "raison")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RaisonEntity   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;



    public RaisonEntity(){
        super();
    }

    public RaisonEntity(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public RaisonEntity(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="raison_seq")
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
        RaisonEntity raison = (RaisonEntity) o;
        return id != null && id.equals(raison.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

