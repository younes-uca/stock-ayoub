package ma.zs.easystock.domain.model.gestionchequeffet;

import java.util.Objects;



import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;




public class TypeInstrument   extends AuditDomainObject     {

    private Long id;

    private String libelle;



    public TypeInstrument(){
        super();
    }

    public TypeInstrument(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public TypeInstrument(String libelle){
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
        TypeInstrument typeInstrument = (TypeInstrument) o;
        return id != null && id.equals(typeInstrument.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

