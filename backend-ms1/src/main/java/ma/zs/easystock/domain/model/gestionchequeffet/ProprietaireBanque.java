package ma.zs.easystock.domain.model.gestionchequeffet;

import java.util.Objects;



import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;




public class ProprietaireBanque   extends AuditDomainObject     {

    private Long id;


    private Proprietaire proprietaire ;
    private Banque banque ;
    private Compte compte ;


    public ProprietaireBanque(){
        super();
    }

    public Proprietaire getProprietaire(){
        return this.proprietaire;
    }
    public void setProprietaire(Proprietaire proprietaire){
        this.proprietaire = proprietaire;
    }
    public Banque getBanque(){
        return this.banque;
    }
    public void setBanque(Banque banque){
        this.banque = banque;
    }
    public Compte getCompte(){
        return this.compte;
    }
    public void setCompte(Compte compte){
        this.compte = compte;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProprietaireBanque proprietaireBanque = (ProprietaireBanque) o;
        return id != null && id.equals(proprietaireBanque.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

