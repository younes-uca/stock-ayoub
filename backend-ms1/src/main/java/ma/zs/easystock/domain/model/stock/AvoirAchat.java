package ma.zs.easystock.domain.model.stock;

import java.util.Objects;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Date;

import ma.zs.easystock.domain.model.commun.EtatAvoirAchat;
import ma.zs.easystock.domain.model.commun.Depot;
import ma.zs.easystock.domain.model.commun.Fournisseur;
import ma.zs.easystock.domain.model.commun.EntrepriseSociete;


import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;

import java.math.BigDecimal;



public class AvoirAchat   extends AuditDomainObject     {

    private Long id;

    private String barCode;
    private String codeAvoirAchat;
    private String numeroFactureAvoirAchat;
    private LocalDateTime dateFactureAvoirAchat ;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTva = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;
    private String description;

    private EntrepriseSociete entrepriseSociete ;
    private Fournisseur fournisseur ;
    private EtatAvoirAchat etatAvoirAchat ;

    private List<AvoirAchatItem> avoirAchatItems ;

    public AvoirAchat(){
        super();
    }

    public AvoirAchat(Long id,String numeroFactureAvoirAchat){
        this.id = id;
        this.numeroFactureAvoirAchat = numeroFactureAvoirAchat ;
    }
    public AvoirAchat(String numeroFactureAvoirAchat){
        this.numeroFactureAvoirAchat = numeroFactureAvoirAchat ;
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
    public String getCodeAvoirAchat(){
        return this.codeAvoirAchat;
    }
    public void setCodeAvoirAchat(String codeAvoirAchat){
        this.codeAvoirAchat = codeAvoirAchat;
    }
    public String getNumeroFactureAvoirAchat(){
        return this.numeroFactureAvoirAchat;
    }
    public void setNumeroFactureAvoirAchat(String numeroFactureAvoirAchat){
        this.numeroFactureAvoirAchat = numeroFactureAvoirAchat;
    }
    public LocalDateTime getDateFactureAvoirAchat(){
        return this.dateFactureAvoirAchat;
    }
    public void setDateFactureAvoirAchat(LocalDateTime dateFactureAvoirAchat){
        this.dateFactureAvoirAchat = dateFactureAvoirAchat;
    }
    public Fournisseur getFournisseur(){
        return this.fournisseur;
    }
    public void setFournisseur(Fournisseur fournisseur){
        this.fournisseur = fournisseur;
    }
    public EtatAvoirAchat getEtatAvoirAchat(){
        return this.etatAvoirAchat;
    }
    public void setEtatAvoirAchat(EtatAvoirAchat etatAvoirAchat){
        this.etatAvoirAchat = etatAvoirAchat;
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
    public List<AvoirAchatItem> getAvoirAchatItems(){
        return this.avoirAchatItems;
    }
    public void setAvoirAchatItems(List<AvoirAchatItem> avoirAchatItems){
        this.avoirAchatItems = avoirAchatItems;
    }

    public String getLabel() {
        label = numeroFactureAvoirAchat;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvoirAchat avoirAchat = (AvoirAchat) o;
        return id != null && id.equals(avoirAchat.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

