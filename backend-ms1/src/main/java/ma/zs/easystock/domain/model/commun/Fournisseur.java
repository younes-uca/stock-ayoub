package ma.zs.easystock.domain.model.commun;

import java.util.Objects;



import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;




public class Fournisseur   extends AuditDomainObject     {

    private Long id;

    private String ice;



    public Fournisseur(){
        super();
    }

    public Fournisseur(Long id,String ice){
        this.id = id;
        this.ice = ice ;
    }
    public Fournisseur(String ice){
        this.ice = ice ;
    }
    public String getIce(){
        return this.ice;
    }
    public void setIce(String ice){
        this.ice = ice;
    }

    public String getLabel() {
        label = ice;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fournisseur fournisseur = (Fournisseur) o;
        return id != null && id.equals(fournisseur.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

