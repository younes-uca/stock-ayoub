package ma.zs.easystock.domain.model.stock;

import java.util.Objects;
import java.time.LocalDateTime;
import java.util.Date;

import ma.zs.easystock.domain.model.commun.Collaborateur;


import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;




public class Tache   extends AuditDomainObject     {

    private Long id;

    private LocalDateTime dateDebut ;
    private LocalDateTime dateFin ;
    private String description;

    private Collaborateur lierA ;


    public Tache(){
        super();
    }

    public LocalDateTime getDateDebut(){
        return this.dateDebut;
    }
    public void setDateDebut(LocalDateTime dateDebut){
        this.dateDebut = dateDebut;
    }
    public LocalDateTime getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(LocalDateTime dateFin){
        this.dateFin = dateFin;
    }
    public Collaborateur getLierA(){
        return this.lierA;
    }
    public void setLierA(Collaborateur lierA){
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
        Tache tache = (Tache) o;
        return id != null && id.equals(tache.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

