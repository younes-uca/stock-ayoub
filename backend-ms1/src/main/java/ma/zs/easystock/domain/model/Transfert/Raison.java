package ma.zs.easystock.domain.model.Transfert;

import java.util.Objects;



import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;




public class Raison   extends AuditDomainObject     {

    private Long id;

    private String libelle;



    public Raison(){
        super();
    }

    public Raison(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public Raison(String libelle){
        this.libelle = libelle ;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Raison raison = (Raison) o;
        return id != null && id.equals(raison.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

