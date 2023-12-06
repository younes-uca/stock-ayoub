package ma.zs.easystock.infra.bean.core.commun;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;



import jakarta.persistence.*;

@Entity
@Table(name = "collaborateur")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CollaborateurEntity   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String prenom;



    public CollaborateurEntity(){
        super();
    }

    public CollaborateurEntity(Long id,String prenom){
        this.id = id;
        this.prenom = prenom ;
    }
    public CollaborateurEntity(String prenom){
        this.prenom = prenom ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="collaborateur_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    @Transient
    public String getLabel() {
        label = prenom;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollaborateurEntity collaborateur = (CollaborateurEntity) o;
        return id != null && id.equals(collaborateur.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

