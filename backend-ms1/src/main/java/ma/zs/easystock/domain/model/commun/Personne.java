package ma.zs.easystock.domain.model.commun;

import java.util.Objects;



import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;

import java.math.BigDecimal;



public class Personne   extends AuditDomainObject     {

    private Long id;

    private String nom;
    private String telephone;
    private String adresse;
    private BigDecimal creance = BigDecimal.ZERO;
    private String description;

    private Ville ville ;


    public Personne(){
        super();
    }

    public Personne(Long id,String telephone){
        this.id = id;
        this.telephone = telephone ;
    }
    public Personne(String telephone){
        this.telephone = telephone ;
    }
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getTelephone(){
        return this.telephone;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }
    public Ville getVille(){
        return this.ville;
    }
    public void setVille(Ville ville){
        this.ville = ville;
    }
    public String getAdresse(){
        return this.adresse;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }
    public BigDecimal getCreance(){
        return this.creance;
    }
    public void setCreance(BigDecimal creance){
        this.creance = creance;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public String getLabel() {
        label = telephone;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return id != null && id.equals(personne.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

