package ma.zs.easystock.infra.bean.core.gestionchequeffet;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "compte")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompteEntity   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String numeroCompte;
    private BigDecimal solde = BigDecimal.ZERO;

    private BanqueEntity banque ;
    private ProprietaireEntity proprietaire ;


    public CompteEntity(){
        super();
    }

    public CompteEntity(Long id,String numeroCompte){
        this.id = id;
        this.numeroCompte = numeroCompte ;
    }
    public CompteEntity(String numeroCompte){
        this.numeroCompte = numeroCompte ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="compte_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }    public String getNumeroCompte(){
        return this.numeroCompte;
    }
    public void setNumeroCompte(String numeroCompte){
        this.numeroCompte = numeroCompte;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public BanqueEntity getBanque(){
        return this.banque;
    }
    public void setBanque(BanqueEntity banque){
        this.banque = banque;
    }
    @ManyToOne(fetch = FetchType.LAZY)

    public ProprietaireEntity getProprietaire(){
        return this.proprietaire;
    }
    public void setProprietaire(ProprietaireEntity proprietaire){
        this.proprietaire = proprietaire;
    }
    public BigDecimal getSolde(){
        return this.solde;
    }
    public void setSolde(BigDecimal solde){
        this.solde = solde;
    }
    @Transient
    public String getLabel() {
        label = numeroCompte;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompteEntity compte = (CompteEntity) o;
        return id != null && id.equals(compte.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

