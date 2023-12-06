package ma.zs.easystock.infra.bean.core.gestionchequeffet;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;



import jakarta.persistence.*;

@Entity
@Table(name = "proprietaire_banque")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProprietaireBanqueEntity   extends AuditBusinessObject     {

    private Long id;


    private ProprietaireEntity proprietaire ;
    private BanqueEntity banque ;
    private CompteEntity compte ;


    public ProprietaireBanqueEntity(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="proprietaire_banque_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public ProprietaireEntity getProprietaire(){
        return this.proprietaire;
    }
    public void setProprietaire(ProprietaireEntity proprietaire){
        this.proprietaire = proprietaire;
    }
    @ManyToOne(fetch = FetchType.LAZY)

    public BanqueEntity getBanque(){
        return this.banque;
    }
    public void setBanque(BanqueEntity banque){
        this.banque = banque;
    }
    @ManyToOne(fetch = FetchType.LAZY)

    public CompteEntity getCompte(){
        return this.compte;
    }
    public void setCompte(CompteEntity compte){
        this.compte = compte;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProprietaireBanqueEntity proprietaireBanque = (ProprietaireBanqueEntity) o;
        return id != null && id.equals(proprietaireBanque.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

