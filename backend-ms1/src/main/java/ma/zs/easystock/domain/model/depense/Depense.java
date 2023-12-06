package ma.zs.easystock.domain.model.depense;

import java.util.Objects;
import java.time.LocalDateTime;
import java.util.Date;



import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;

import java.math.BigDecimal;



public class Depense   extends AuditDomainObject     {

    private Long id;

    private LocalDateTime dateDepense ;
    private String libelle;
    private BigDecimal montant = BigDecimal.ZERO;
    private String description;



    public Depense(){
        super();
    }

    public LocalDateTime getDateDepense(){
        return this.dateDepense;
    }
    public void setDateDepense(LocalDateTime dateDepense){
        this.dateDepense = dateDepense;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Depense depense = (Depense) o;
        return id != null && id.equals(depense.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

