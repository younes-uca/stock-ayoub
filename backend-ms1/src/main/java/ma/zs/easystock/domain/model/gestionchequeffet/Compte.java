package ma.zs.easystock.domain.model.gestionchequeffet;

import java.util.Objects;



import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;

import java.math.BigDecimal;



public class Compte   extends AuditDomainObject     {

    private Long id;

    private String numeroCompte;
    private BigDecimal solde = BigDecimal.ZERO;

    private Banque banque ;
    private Proprietaire proprietaire ;


    public Compte(){
        super();
    }

    public Compte(Long id,String numeroCompte){
        this.id = id;
        this.numeroCompte = numeroCompte ;
    }
    public Compte(String numeroCompte){
        this.numeroCompte = numeroCompte ;
    }
    public String getNumeroCompte(){
        return this.numeroCompte;
    }
    public void setNumeroCompte(String numeroCompte){
        this.numeroCompte = numeroCompte;
    }
    public Banque getBanque(){
        return this.banque;
    }
    public void setBanque(Banque banque){
        this.banque = banque;
    }
    public Proprietaire getProprietaire(){
        return this.proprietaire;
    }
    public void setProprietaire(Proprietaire proprietaire){
        this.proprietaire = proprietaire;
    }
    public BigDecimal getSolde(){
        return this.solde;
    }
    public void setSolde(BigDecimal solde){
        this.solde = solde;
    }

    public String getLabel() {
        label = numeroCompte;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compte compte = (Compte) o;
        return id != null && id.equals(compte.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

