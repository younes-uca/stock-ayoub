package ma.zs.easystock.domain.model.commun;

import java.util.Objects;



import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;




public class UniteMesure   extends AuditDomainObject     {

    private Long id;

    private String libelle;



    public UniteMesure(){
        super();
    }

    public UniteMesure(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public UniteMesure(String libelle){
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
        UniteMesure uniteMesure = (UniteMesure) o;
        return id != null && id.equals(uniteMesure.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

