package ma.zs.easystock.infra.bean.core.commun;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "personne")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonneEntity   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String nom;
    @Column(length = 500)
    private String telephone;
    @Column(length = 500)
    private String adresse;
    private BigDecimal creance = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private VilleEntity ville ;


    public PersonneEntity(){
        super();
    }

    public PersonneEntity(Long id,String telephone){
        this.id = id;
        this.telephone = telephone ;
    }
    public PersonneEntity(String telephone){
        this.telephone = telephone ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="personne_seq")
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
    }    public String getTelephone(){
        return this.telephone;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public VilleEntity getVille(){
        return this.ville;
    }
    public void setVille(VilleEntity ville){
        this.ville = ville;
    }
    public String getAdresse(){
        return this.adresse;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }    public BigDecimal getCreance(){
        return this.creance;
    }
    public void setCreance(BigDecimal creance){
        this.creance = creance;
    }    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @Transient
    public String getLabel() {
        label = telephone;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonneEntity personne = (PersonneEntity) o;
        return id != null && id.equals(personne.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

