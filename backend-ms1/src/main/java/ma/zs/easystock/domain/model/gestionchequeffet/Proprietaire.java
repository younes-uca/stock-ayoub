package ma.zs.easystock.domain.model.gestionchequeffet;

import java.util.Objects;

import ma.zs.easystock.domain.model.commun.Personne;


import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;




public class Proprietaire   extends AuditDomainObject     {

    private Long id;


    private Personne personne ;


    public Proprietaire(){
        super();
    }

    public Personne getPersonne(){
        return this.personne;
    }
    public void setPersonne(Personne personne){
        this.personne = personne;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proprietaire proprietaire = (Proprietaire) o;
        return id != null && id.equals(proprietaire.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

