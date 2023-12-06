package ma.zs.easystock.domain.model.stock;

import java.util.Objects;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Date;

import ma.zs.easystock.domain.model.commun.EtatAchat;
import ma.zs.easystock.domain.model.commun.EntrepriseSociete;
import ma.zs.easystock.domain.model.commun.EtatAvoirAchat;
import ma.zs.easystock.domain.model.commun.Depot;
import ma.zs.easystock.domain.model.commun.Fournisseur;


import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;

import java.math.BigDecimal;



public class Achat   extends AuditDomainObject     {

    private Long id;

    private LocalDateTime dateFacture ;
    private String referenceFacture;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTva = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;
    private String description;

    private EntrepriseSociete entrepriseSociete ;
    private Fournisseur fournisseur ;
    private EtatAchat etatAchat ;

    private List<AchatItem> achatItems ;
    private List<AvoirAchat> avoirs ;

    public Achat(){
        super();
    }

    public EntrepriseSociete getEntrepriseSociete(){
        return this.entrepriseSociete;
    }
    public void setEntrepriseSociete(EntrepriseSociete entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public LocalDateTime getDateFacture(){
        return this.dateFacture;
    }
    public void setDateFacture(LocalDateTime dateFacture){
        this.dateFacture = dateFacture;
    }
    public String getReferenceFacture(){
        return this.referenceFacture;
    }
    public void setReferenceFacture(String referenceFacture){
        this.referenceFacture = referenceFacture;
    }
    public Fournisseur getFournisseur(){
        return this.fournisseur;
    }
    public void setFournisseur(Fournisseur fournisseur){
        this.fournisseur = fournisseur;
    }
    public EtatAchat getEtatAchat(){
        return this.etatAchat;
    }
    public void setEtatAchat(EtatAchat etatAchat){
        this.etatAchat = etatAchat;
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
    public List<AchatItem> getAchatItems(){
        return this.achatItems;
    }
    public void setAchatItems(List<AchatItem> achatItems){
        this.achatItems = achatItems;
    }
    public List<AvoirAchat> getAvoirs(){
        return this.avoirs;
    }
    public void setAvoirs(List<AvoirAchat> avoirs){
        this.avoirs = avoirs;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Achat achat = (Achat) o;
        return id != null && id.equals(achat.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

