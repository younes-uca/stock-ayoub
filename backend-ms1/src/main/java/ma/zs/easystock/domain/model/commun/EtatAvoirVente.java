package ma.zs.easystock.domain.model.commun;

import java.util.Objects;



import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;




public class EtatAvoirVente   extends AuditDomainObject     {

    private Long id;

    private String libelle;



    public EtatAvoirVente(){
        super();
    }

    public EtatAvoirVente(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public EtatAvoirVente(String libelle){
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
        EtatAvoirVente etatAvoirVente = (EtatAvoirVente) o;
        return id != null && id.equals(etatAvoirVente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

