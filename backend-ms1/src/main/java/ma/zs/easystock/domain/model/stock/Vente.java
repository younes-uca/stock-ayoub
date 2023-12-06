package ma.zs.easystock.domain.model.stock;

import java.util.Objects;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Date;

import ma.zs.easystock.domain.model.commun.EntrepriseSociete;
import ma.zs.easystock.domain.model.commun.EtatAvoirVente;
import ma.zs.easystock.domain.model.commun.Depot;
import ma.zs.easystock.domain.model.commun.EtatVente;
import ma.zs.easystock.domain.model.commun.Client;


import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;

import java.math.BigDecimal;



public class Vente   extends AuditDomainObject     {

    private Long id;

    private String barCode;
    private String codeVente;
    private LocalDateTime dateFacture ;
    private String numeroFacture;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTva = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;
    private String description;

    private EntrepriseSociete entrepriseSociete ;
    private Client client ;
    private EtatVente etatVente ;

    private List<VenteItem> venteItems ;
    private List<AvoirVente> avoirs ;

    public Vente(){
        super();
    }

    public Vente(Long id,String numeroFacture){
        this.id = id;
        this.numeroFacture = numeroFacture ;
    }
    public Vente(String numeroFacture){
        this.numeroFacture = numeroFacture ;
    }
    public String getBarCode(){
        return this.barCode;
    }
    public void setBarCode(String barCode){
        this.barCode = barCode;
    }
    public EntrepriseSociete getEntrepriseSociete(){
        return this.entrepriseSociete;
    }
    public void setEntrepriseSociete(EntrepriseSociete entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public String getCodeVente(){
        return this.codeVente;
    }
    public void setCodeVente(String codeVente){
        this.codeVente = codeVente;
    }
    public LocalDateTime getDateFacture(){
        return this.dateFacture;
    }
    public void setDateFacture(LocalDateTime dateFacture){
        this.dateFacture = dateFacture;
    }
    public String getNumeroFacture(){
        return this.numeroFacture;
    }
    public void setNumeroFacture(String numeroFacture){
        this.numeroFacture = numeroFacture;
    }
    public Client getClient(){
        return this.client;
    }
    public void setClient(Client client){
        this.client = client;
    }
    public EtatVente getEtatVente(){
        return this.etatVente;
    }
    public void setEtatVente(EtatVente etatVente){
        this.etatVente = etatVente;
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
    public List<VenteItem> getVenteItems(){
        return this.venteItems;
    }
    public void setVenteItems(List<VenteItem> venteItems){
        this.venteItems = venteItems;
    }
    public List<AvoirVente> getAvoirs(){
        return this.avoirs;
    }
    public void setAvoirs(List<AvoirVente> avoirs){
        this.avoirs = avoirs;
    }

    public String getLabel() {
        label = numeroFacture;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vente vente = (Vente) o;
        return id != null && id.equals(vente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

