package ma.zs.easystock.infra.bean.core.stock;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.infra.bean.core.commun.CollaborateurEntity;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;



import jakarta.persistence.*;

@Entity
@Table(name = "tache")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TacheEntity   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateDebut ;
    private LocalDateTime dateFin ;
    @Column(length = 500)
    private String description;

    private CollaborateurEntity lierA ;


    public TacheEntity(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="tache_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }    public LocalDateTime getDateDebut(){
        return this.dateDebut;
    }
    public void setDateDebut(LocalDateTime dateDebut){
        this.dateDebut = dateDebut;
    }    public LocalDateTime getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(LocalDateTime dateFin){
        this.dateFin = dateFin;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public CollaborateurEntity getLierA(){
        return this.lierA;
    }
    public void setLierA(CollaborateurEntity lierA){
        this.lierA = lierA;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TacheEntity tache = (TacheEntity) o;
        return id != null && id.equals(tache.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

