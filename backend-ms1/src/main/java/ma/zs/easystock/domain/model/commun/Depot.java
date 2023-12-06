package ma.zs.easystock.domain.model.commun;

import java.util.Objects;



import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;




public class Depot   extends AuditDomainObject     {

    private Long id;

    private String libelle;
    private String adresse;



    public Depot(){
        super();
    }

    public Depot(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public Depot(String libelle){
        this.libelle = libelle ;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getAdresse(){
        return this.adresse;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }

    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Depot depot = (Depot) o;
        return id != null && id.equals(depot.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

