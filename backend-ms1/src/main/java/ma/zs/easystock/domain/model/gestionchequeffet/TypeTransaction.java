package ma.zs.easystock.domain.model.gestionchequeffet;

import java.util.Objects;



import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;




public class TypeTransaction   extends AuditDomainObject     {

    private Long id;

    private String libelle;



    public TypeTransaction(){
        super();
    }

    public TypeTransaction(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public TypeTransaction(String libelle){
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
        TypeTransaction typeTransaction = (TypeTransaction) o;
        return id != null && id.equals(typeTransaction.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

