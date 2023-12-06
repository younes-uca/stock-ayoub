package ma.zs.easystock.domain.model.stock;

import java.util.Objects;

import ma.zs.easystock.domain.model.commun.Depot;


import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;

import java.math.BigDecimal;



public class AvoirVenteItem   extends AuditDomainObject     {

    private Long id;

    private String barCode;
    private BigDecimal quantite = BigDecimal.ZERO;
    private BigDecimal quantiteAvoir = BigDecimal.ZERO;
    private BigDecimal quantiteVendue = BigDecimal.ZERO;
    private BigDecimal prixUnitaireHt = BigDecimal.ZERO;
    private BigDecimal prixUnitaireTtc = BigDecimal.ZERO;
    private BigDecimal remise = BigDecimal.ZERO;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;

    private Depot depot ;
    private Produit produit ;
    private Taxe taxe ;
    private AvoirVente avoirVente ;


    public AvoirVenteItem(){
        super();
    }

    public AvoirVenteItem(Long id,String barCode){
        this.id = id;
        this.barCode = barCode ;
    }
    public AvoirVenteItem(String barCode){
        this.barCode = barCode ;
    }
    public String getBarCode(){
        return this.barCode;
    }
    public void setBarCode(String barCode){
        this.barCode = barCode;
    }
    public Depot getDepot(){
        return this.depot;
    }
    public void setDepot(Depot depot){
        this.depot = depot;
    }
    public Produit getProduit(){
        return this.produit;
    }
    public void setProduit(Produit produit){
        this.produit = produit;
    }
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }
    public BigDecimal getQuantiteAvoir(){
        return this.quantiteAvoir;
    }
    public void setQuantiteAvoir(BigDecimal quantiteAvoir){
        this.quantiteAvoir = quantiteAvoir;
    }
    public BigDecimal getQuantiteVendue(){
        return this.quantiteVendue;
    }
    public void setQuantiteVendue(BigDecimal quantiteVendue){
        this.quantiteVendue = quantiteVendue;
    }
    public BigDecimal getPrixUnitaireHt(){
        return this.prixUnitaireHt;
    }
    public void setPrixUnitaireHt(BigDecimal prixUnitaireHt){
        this.prixUnitaireHt = prixUnitaireHt;
    }
    public Taxe getTaxe(){
        return this.taxe;
    }
    public void setTaxe(Taxe taxe){
        this.taxe = taxe;
    }
    public BigDecimal getPrixUnitaireTtc(){
        return this.prixUnitaireTtc;
    }
    public void setPrixUnitaireTtc(BigDecimal prixUnitaireTtc){
        this.prixUnitaireTtc = prixUnitaireTtc;
    }
    public BigDecimal getRemise(){
        return this.remise;
    }
    public void setRemise(BigDecimal remise){
        this.remise = remise;
    }
    public BigDecimal getMontantHt(){
        return this.montantHt;
    }
    public void setMontantHt(BigDecimal montantHt){
        this.montantHt = montantHt;
    }
    public BigDecimal getMontantTtc(){
        return this.montantTtc;
    }
    public void setMontantTtc(BigDecimal montantTtc){
        this.montantTtc = montantTtc;
    }
    public AvoirVente getAvoirVente(){
        return this.avoirVente;
    }
    public void setAvoirVente(AvoirVente avoirVente){
        this.avoirVente = avoirVente;
    }

    public String getLabel() {
        label = barCode;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvoirVenteItem avoirVenteItem = (AvoirVenteItem) o;
        return id != null && id.equals(avoirVenteItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

