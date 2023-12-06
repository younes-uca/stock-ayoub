package ma.zs.easystock.infra.bean.core.gestionchequeffet;

import java.util.Objects;





import ma.zs.easystock.infra.bean.core.commun.PersonneEntity;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;



import jakarta.persistence.*;

@Entity
@Table(name = "proprietaire")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProprietaireEntity   extends AuditBusinessObject     {

    private Long id;


    private PersonneEntity personne ;


    public ProprietaireEntity(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="proprietaire_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public PersonneEntity getPersonne(){
        return this.personne;
    }
    public void setPersonne(PersonneEntity personne){
        this.personne = personne;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProprietaireEntity proprietaire = (ProprietaireEntity) o;
        return id != null && id.equals(proprietaire.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

