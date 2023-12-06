package ma.zs.easystock.domain.model.stock;

import java.util.Objects;



import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;




public class Taxe   extends AuditDomainObject     {

    private Long id;

    private String libelle;



    public Taxe(){
        super();
    }

    public Taxe(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public Taxe(String libelle){
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
        Taxe taxe = (Taxe) o;
        return id != null && id.equals(taxe.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

