package ma.zs.easystock.domain.model.stock;

import java.util.Objects;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Date;

import ma.zs.easystock.domain.model.commun.EtatAvoirVente;
import ma.zs.easystock.domain.model.commun.Depot;
import ma.zs.easystock.domain.model.commun.EntrepriseSociete;
import ma.zs.easystock.domain.model.commun.Client;


import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;

import java.math.BigDecimal;



public class AvoirVente   extends AuditDomainObject     {

    private Long id;

    private String barCode;
    private String codeAvoirVente;
    private String numeroFactureAvoirVente;
    private LocalDateTime dateFactureAvoirVente ;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTva = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;
    private String description;

    private EntrepriseSociete entrepriseSociete ;
    private Client client ;
    private EtatAvoirVente etatAvoirVente ;
    private Achat achat ;

    private List<AvoirVenteItem> avoirVenteItems ;
    private List<AvoirVenteItem> avoirs ;

    public AvoirVente(){
        super();
    }

    public AvoirVente(Long id,String numeroFactureAvoirVente){
        this.id = id;
        this.numeroFactureAvoirVente = numeroFactureAvoirVente ;
    }
    public AvoirVente(String numeroFactureAvoirVente){
        this.numeroFactureAvoirVente = numeroFactureAvoirVente ;
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
    public String getCodeAvoirVente(){
        return this.codeAvoirVente;
    }
    public void setCodeAvoirVente(String codeAvoirVente){
        this.codeAvoirVente = codeAvoirVente;
    }
    public String getNumeroFactureAvoirVente(){
        return this.numeroFactureAvoirVente;
    }
    public void setNumeroFactureAvoirVente(String numeroFactureAvoirVente){
        this.numeroFactureAvoirVente = numeroFactureAvoirVente;
    }
    public LocalDateTime getDateFactureAvoirVente(){
        return this.dateFactureAvoirVente;
    }
    public void setDateFactureAvoirVente(LocalDateTime dateFactureAvoirVente){
        this.dateFactureAvoirVente = dateFactureAvoirVente;
    }
    public Client getClient(){
        return this.client;
    }
    public void setClient(Client client){
        this.client = client;
    }
    public EtatAvoirVente getEtatAvoirVente(){
        return this.etatAvoirVente;
    }
    public void setEtatAvoirVente(EtatAvoirVente etatAvoirVente){
        this.etatAvoirVente = etatAvoirVente;
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
    public List<AvoirVenteItem> getAvoirVenteItems(){
        return this.avoirVenteItems;
    }
    public void setAvoirVenteItems(List<AvoirVenteItem> avoirVenteItems){
        this.avoirVenteItems = avoirVenteItems;
    }
    public List<AvoirVenteItem> getAvoirs(){
        return this.avoirs;
    }
    public void setAvoirs(List<AvoirVenteItem> avoirs){
        this.avoirs = avoirs;
    }
    public Achat getAchat(){
        return this.achat;
    }
    public void setAchat(Achat achat){
        this.achat = achat;
    }

    public String getLabel() {
        label = numeroFactureAvoirVente;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvoirVente avoirVente = (AvoirVente) o;
        return id != null && id.equals(avoirVente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

