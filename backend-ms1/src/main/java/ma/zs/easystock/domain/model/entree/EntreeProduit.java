package ma.zs.easystock.domain.model.entree;

import java.util.Objects;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Date;

import ma.zs.easystock.domain.model.stock.Produit;
import ma.zs.easystock.domain.model.stock.EntreeProduitItem;
import ma.zs.easystock.domain.model.commun.Depot;
import ma.zs.easystock.domain.model.commun.Fournisseur;


import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;




public class EntreeProduit   extends AuditDomainObject     {

    private Long id;

    private String reference;
    private LocalDateTime dateEntreeProduit ;
    private String description;

    private Fournisseur fournisseur ;
    private Depot depot ;

    private List<EntreeProduitItem> entreeProduitItems ;

    public EntreeProduit(){
        super();
    }

    public EntreeProduit(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }
    public EntreeProduit(String reference){
        this.reference = reference ;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public LocalDateTime getDateEntreeProduit(){
        return this.dateEntreeProduit;
    }
    public void setDateEntreeProduit(LocalDateTime dateEntreeProduit){
        this.dateEntreeProduit = dateEntreeProduit;
    }
    public Fournisseur getFournisseur(){
        return this.fournisseur;
    }
    public void setFournisseur(Fournisseur fournisseur){
        this.fournisseur = fournisseur;
    }
    public Depot getDepot(){
        return this.depot;
    }
    public void setDepot(Depot depot){
        this.depot = depot;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public List<EntreeProduitItem> getEntreeProduitItems(){
        return this.entreeProduitItems;
    }
    public void setEntreeProduitItems(List<EntreeProduitItem> entreeProduitItems){
        this.entreeProduitItems = entreeProduitItems;
    }

    public String getLabel() {
        label = reference;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntreeProduit entreeProduit = (EntreeProduit) o;
        return id != null && id.equals(entreeProduit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

