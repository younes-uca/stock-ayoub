package ma.zs.easystock.domain.model.commun;

import java.util.Objects;



import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;




public class EtatVente   extends AuditDomainObject     {

    private Long id;

    private String libelle;



    public EtatVente(){
        super();
    }

    public EtatVente(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public EtatVente(String libelle){
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
        EtatVente etatVente = (EtatVente) o;
        return id != null && id.equals(etatVente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

