package ma.zs.easystock.infra.bean.core.gestionchequeffet;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;



import jakarta.persistence.*;

@Entity
@Table(name = "banque")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BanqueEntity   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;



    public BanqueEntity(){
        super();
    }

    public BanqueEntity(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public BanqueEntity(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="banque_seq")
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
        BanqueEntity banque = (BanqueEntity) o;
        return id != null && id.equals(banque.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

