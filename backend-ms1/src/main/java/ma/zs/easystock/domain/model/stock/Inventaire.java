package ma.zs.easystock.domain.model.stock;

import java.util.Objects;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Date;

import ma.zs.easystock.domain.model.commun.EntrepriseSociete;
import ma.zs.easystock.domain.model.commun.Depot;


import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;




public class Inventaire   extends AuditDomainObject     {

    private Long id;

    private String reference;
    private LocalDateTime dateInventaire ;
    private String description;

    private EntrepriseSociete entrepriseSociete ;
    private Depot depot ;

    private List<InventaireItem> inventaireItems ;

    public Inventaire(){
        super();
    }

    public Inventaire(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }
    public Inventaire(String reference){
        this.reference = reference ;
    }
    public EntrepriseSociete getEntrepriseSociete(){
        return this.entrepriseSociete;
    }
    public void setEntrepriseSociete(EntrepriseSociete entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public Depot getDepot(){
        return this.depot;
    }
    public void setDepot(Depot depot){
        this.depot = depot;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public LocalDateTime getDateInventaire(){
        return this.dateInventaire;
    }
    public void setDateInventaire(LocalDateTime dateInventaire){
        this.dateInventaire = dateInventaire;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public List<InventaireItem> getInventaireItems(){
        return this.inventaireItems;
    }
    public void setInventaireItems(List<InventaireItem> inventaireItems){
        this.inventaireItems = inventaireItems;
    }

    public String getLabel() {
        label = reference;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventaire inventaire = (Inventaire) o;
        return id != null && id.equals(inventaire.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

