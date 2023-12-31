package ma.zs.easystock.infra.bean.core.commun;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "entreprise_societe")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntrepriseSocieteEntity   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String nom;
    @Column(length = 500)
    private String ice;
    private BigDecimal capital = BigDecimal.ZERO;



    public EntrepriseSocieteEntity(){
        super();
    }

    public EntrepriseSocieteEntity(Long id,String nom){
        this.id = id;
        this.nom = nom ;
    }
    public EntrepriseSocieteEntity(String nom){
        this.nom = nom ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="entreprise_societe_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }    public String getIce(){
        return this.ice;
    }
    public void setIce(String ice){
        this.ice = ice;
    }    public BigDecimal getCapital(){
        return this.capital;
    }
    public void setCapital(BigDecimal capital){
        this.capital = capital;
    }
    @Transient
    public String getLabel() {
        label = nom;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntrepriseSocieteEntity entrepriseSociete = (EntrepriseSocieteEntity) o;
        return id != null && id.equals(entrepriseSociete.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

