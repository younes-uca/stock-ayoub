package  ma.zs.easystock.infra.dao.criteria.core.stock;


import ma.zs.easystock.infra.dao.criteria.core.commun.EtatAvoirAchatCriteria;
import ma.zs.easystock.infra.dao.criteria.core.commun.EntrepriseSocieteCriteria;
import ma.zs.easystock.infra.dao.criteria.core.commun.FournisseurCriteria;

import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class AvoirAchatCriteria extends  BaseCriteria  {

    private String barCode;
    private String barCodeLike;
    private String codeAvoirAchat;
    private String codeAvoirAchatLike;
    private String numeroFactureAvoirAchat;
    private String numeroFactureAvoirAchatLike;
    private LocalDateTime dateFactureAvoirAchat;
    private LocalDateTime dateFactureAvoirAchatFrom;
    private LocalDateTime dateFactureAvoirAchatTo;
    private String montantHt;
    private String montantHtMin;
    private String montantHtMax;
    private String montantTva;
    private String montantTvaMin;
    private String montantTvaMax;
    private String montantTtc;
    private String montantTtcMin;
    private String montantTtcMax;
    private String description;
    private String descriptionLike;

    private EntrepriseSocieteCriteria entrepriseSociete ;
    private List<EntrepriseSocieteCriteria> entrepriseSocietes ;
    private FournisseurCriteria fournisseur ;
    private List<FournisseurCriteria> fournisseurs ;
    private EtatAvoirAchatCriteria etatAvoirAchat ;
    private List<EtatAvoirAchatCriteria> etatAvoirAchats ;


    public AvoirAchatCriteria(){}

    public String getBarCode(){
        return this.barCode;
    }
    public void setBarCode(String barCode){
        this.barCode = barCode;
    }
    public String getBarCodeLike(){
        return this.barCodeLike;
    }
    public void setBarCodeLike(String barCodeLike){
        this.barCodeLike = barCodeLike;
    }

    public String getCodeAvoirAchat(){
        return this.codeAvoirAchat;
    }
    public void setCodeAvoirAchat(String codeAvoirAchat){
        this.codeAvoirAchat = codeAvoirAchat;
    }
    public String getCodeAvoirAchatLike(){
        return this.codeAvoirAchatLike;
    }
    public void setCodeAvoirAchatLike(String codeAvoirAchatLike){
        this.codeAvoirAchatLike = codeAvoirAchatLike;
    }

    public String getNumeroFactureAvoirAchat(){
        return this.numeroFactureAvoirAchat;
    }
    public void setNumeroFactureAvoirAchat(String numeroFactureAvoirAchat){
        this.numeroFactureAvoirAchat = numeroFactureAvoirAchat;
    }
    public String getNumeroFactureAvoirAchatLike(){
        return this.numeroFactureAvoirAchatLike;
    }
    public void setNumeroFactureAvoirAchatLike(String numeroFactureAvoirAchatLike){
        this.numeroFactureAvoirAchatLike = numeroFactureAvoirAchatLike;
    }

    public LocalDateTime getDateFactureAvoirAchat(){
        return this.dateFactureAvoirAchat;
    }
    public void setDateFactureAvoirAchat(LocalDateTime dateFactureAvoirAchat){
        this.dateFactureAvoirAchat = dateFactureAvoirAchat;
    }
    public LocalDateTime getDateFactureAvoirAchatFrom(){
        return this.dateFactureAvoirAchatFrom;
    }
    public void setDateFactureAvoirAchatFrom(LocalDateTime dateFactureAvoirAchatFrom){
        this.dateFactureAvoirAchatFrom = dateFactureAvoirAchatFrom;
    }
    public LocalDateTime getDateFactureAvoirAchatTo(){
        return this.dateFactureAvoirAchatTo;
    }
    public void setDateFactureAvoirAchatTo(LocalDateTime dateFactureAvoirAchatTo){
        this.dateFactureAvoirAchatTo = dateFactureAvoirAchatTo;
    }
    public String getMontantHt(){
        return this.montantHt;
    }
    public void setMontantHt(String montantHt){
        this.montantHt = montantHt;
    }   
    public String getMontantHtMin(){
        return this.montantHtMin;
    }
    public void setMontantHtMin(String montantHtMin){
        this.montantHtMin = montantHtMin;
    }
    public String getMontantHtMax(){
        return this.montantHtMax;
    }
    public void setMontantHtMax(String montantHtMax){
        this.montantHtMax = montantHtMax;
    }
      
    public String getMontantTva(){
        return this.montantTva;
    }
    public void setMontantTva(String montantTva){
        this.montantTva = montantTva;
    }   
    public String getMontantTvaMin(){
        return this.montantTvaMin;
    }
    public void setMontantTvaMin(String montantTvaMin){
        this.montantTvaMin = montantTvaMin;
    }
    public String getMontantTvaMax(){
        return this.montantTvaMax;
    }
    public void setMontantTvaMax(String montantTvaMax){
        this.montantTvaMax = montantTvaMax;
    }
      
    public String getMontantTtc(){
        return this.montantTtc;
    }
    public void setMontantTtc(String montantTtc){
        this.montantTtc = montantTtc;
    }   
    public String getMontantTtcMin(){
        return this.montantTtcMin;
    }
    public void setMontantTtcMin(String montantTtcMin){
        this.montantTtcMin = montantTtcMin;
    }
    public String getMontantTtcMax(){
        return this.montantTtcMax;
    }
    public void setMontantTtcMax(String montantTtcMax){
        this.montantTtcMax = montantTtcMax;
    }
      
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }


    public EntrepriseSocieteCriteria getEntrepriseSociete(){
        return this.entrepriseSociete;
    }

    public void setEntrepriseSociete(EntrepriseSocieteCriteria entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public List<EntrepriseSocieteCriteria> getEntrepriseSocietes(){
        return this.entrepriseSocietes;
    }

    public void setEntrepriseSocietes(List<EntrepriseSocieteCriteria> entrepriseSocietes){
        this.entrepriseSocietes = entrepriseSocietes;
    }
    public FournisseurCriteria getFournisseur(){
        return this.fournisseur;
    }

    public void setFournisseur(FournisseurCriteria fournisseur){
        this.fournisseur = fournisseur;
    }
    public List<FournisseurCriteria> getFournisseurs(){
        return this.fournisseurs;
    }

    public void setFournisseurs(List<FournisseurCriteria> fournisseurs){
        this.fournisseurs = fournisseurs;
    }
    public EtatAvoirAchatCriteria getEtatAvoirAchat(){
        return this.etatAvoirAchat;
    }

    public void setEtatAvoirAchat(EtatAvoirAchatCriteria etatAvoirAchat){
        this.etatAvoirAchat = etatAvoirAchat;
    }
    public List<EtatAvoirAchatCriteria> getEtatAvoirAchats(){
        return this.etatAvoirAchats;
    }

    public void setEtatAvoirAchats(List<EtatAvoirAchatCriteria> etatAvoirAchats){
        this.etatAvoirAchats = etatAvoirAchats;
    }
}
