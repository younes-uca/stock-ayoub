package ma.zs.easystock.domain.model.stock;

import java.util.Objects;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Date;

import ma.zs.easystock.domain.model.commun.Client;
import ma.zs.easystock.domain.model.commun.EtatCommande;


import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;

import java.math.BigDecimal;



public class Commande   extends AuditDomainObject     {

    private Long id;

    private String barCode;
    private String numeroCommande;
    private LocalDateTime dateCommande ;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTva = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;
    private String description;

    private Client client ;
    private EtatCommande etatCommande ;

    private List<CommandeItem> commandeItems ;

    public Commande(){
        super();
    }

    public Commande(Long id,String numeroCommande){
        this.id = id;
        this.numeroCommande = numeroCommande ;
    }
    public Commande(String numeroCommande){
        this.numeroCommande = numeroCommande ;
    }
    public String getBarCode(){
        return this.barCode;
    }
    public void setBarCode(String barCode){
        this.barCode = barCode;
    }
    public String getNumeroCommande(){
        return this.numeroCommande;
    }
    public void setNumeroCommande(String numeroCommande){
        this.numeroCommande = numeroCommande;
    }
    public LocalDateTime getDateCommande(){
        return this.dateCommande;
    }
    public void setDateCommande(LocalDateTime dateCommande){
        this.dateCommande = dateCommande;
    }
    public Client getClient(){
        return this.client;
    }
    public void setClient(Client client){
        this.client = client;
    }
    public EtatCommande getEtatCommande(){
        return this.etatCommande;
    }
    public void setEtatCommande(EtatCommande etatCommande){
        this.etatCommande = etatCommande;
    }
    public BigDecimal getMontantHt(){
        return this.montantHt;
    }
    public void setMontantHt(BigDecimal montantHt){
        this.montantHt = montantHt;
    }
    public BigDecimal getMontantTva(){
        return this.montantTva;
    }
    public void setMontantTva(BigDecimal montantTva){
        this.montantTva = montantTva;
    }
    public BigDecimal getMontantTtc(){
        return this.montantTtc;
    }
    public void setMontantTtc(BigDecimal montantTtc){
        this.montantTtc = montantTtc;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public List<CommandeItem> getCommandeItems(){
        return this.commandeItems;
    }
    public void setCommandeItems(List<CommandeItem> commandeItems){
        this.commandeItems = commandeItems;
    }

    public String getLabel() {
        label = numeroCommande;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commande commande = (Commande) o;
        return id != null && id.equals(commande.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

