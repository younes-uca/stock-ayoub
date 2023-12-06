package ma.zs.easystock.domain.model.commun;

import java.util.Objects;



import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;

import java.math.BigDecimal;



public class EntrepriseSociete   extends AuditDomainObject     {

    private Long id;

    private String nom;
    private String ice;
    private BigDecimal capital = BigDecimal.ZERO;



    public EntrepriseSociete(){
        super();
    }

    public EntrepriseSociete(Long id,String nom){
        this.id = id;
        this.nom = nom ;
    }
    public EntrepriseSociete(String nom){
        this.nom = nom ;
    }
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getIce(){
        return this.ice;
    }
    public void setIce(String ice){
        this.ice = ice;
    }
    public BigDecimal getCapital(){
        return this.capital;
    }
    public void setCapital(BigDecimal capital){
        this.capital = capital;
    }

    public String getLabel() {
        label = nom;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntrepriseSociete entrepriseSociete = (EntrepriseSociete) o;
        return id != null && id.equals(entrepriseSociete.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

