package ma.zs.easystock.domain.model.stock;

import java.util.Objects;
import java.util.List;

import ma.zs.easystock.domain.model.commun.Marque;
import ma.zs.easystock.domain.model.commun.UniteMesure;
import ma.zs.easystock.domain.model.commun.EntrepriseSociete;
import ma.zs.easystock.domain.model.commun.Categorie;
import ma.zs.easystock.domain.model.commun.Depot;


import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;

import java.math.BigDecimal;



public class Produit   extends AuditDomainObject     {

    private Long id;

    private String reference;
    private String barCode;
    private String designation;
    private BigDecimal quantite = BigDecimal.ZERO;
    private BigDecimal prixAchatMoyen = BigDecimal.ZERO;
    private BigDecimal prixVente = BigDecimal.ZERO;
    private String pathPhoto;
    private BigDecimal seuilAlerte = BigDecimal.ZERO;
    private String description;

    private EntrepriseSociete entrepriseSociete ;
    private Categorie categorie ;
    private Marque marque ;
    private UniteMesure uniteMesure ;

    private List<Stock> stocks ;

    public Produit(){
        super();
    }

    public Produit(Long id,BigDecimal seuilAlerte){
        this.id = id;
        this.seuilAlerte = seuilAlerte ;
    }
    public Produit(BigDecimal seuilAlerte){
        this.seuilAlerte = seuilAlerte ;
    }
    public EntrepriseSociete getEntrepriseSociete(){
        return this.entrepriseSociete;
    }
    public void setEntrepriseSociete(EntrepriseSociete entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getBarCode(){
        return this.barCode;
    }
    public void setBarCode(String barCode){
        this.barCode = barCode;
    }
    public Categorie getCategorie(){
        return this.categorie;
    }
    public void setCategorie(Categorie categorie){
        this.categorie = categorie;
    }
    public String getDesignation(){
        return this.designation;
    }
    public void setDesignation(String designation){
        this.designation = designation;
    }
    public Marque getMarque(){
        return this.marque;
    }
    public void setMarque(Marque marque){
        this.marque = marque;
    }
    public UniteMesure getUniteMesure(){
        return this.uniteMesure;
    }
    public void setUniteMesure(UniteMesure uniteMesure){
        this.uniteMesure = uniteMesure;
    }
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }
    public BigDecimal getPrixAchatMoyen(){
        return this.prixAchatMoyen;
    }
    public void setPrixAchatMoyen(BigDecimal prixAchatMoyen){
        this.prixAchatMoyen = prixAchatMoyen;
    }
    public BigDecimal getPrixVente(){
        return this.prixVente;
    }
    public void setPrixVente(BigDecimal prixVente){
        this.prixVente = prixVente;
    }
    public List<Stock> getStocks(){
        return this.stocks;
    }
    public void setStocks(List<Stock> stocks){
        this.stocks = stocks;
    }
    public String getPathPhoto(){
        return this.pathPhoto;
    }
    public void setPathPhoto(String pathPhoto){
        this.pathPhoto = pathPhoto;
    }
    public BigDecimal getSeuilAlerte(){
        return this.seuilAlerte;
    }
    public void setSeuilAlerte(BigDecimal seuilAlerte){
        this.seuilAlerte = seuilAlerte;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public String getLabel() {
        label = seuilAlerte;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return id != null && id.equals(produit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

