package ma.zs.easystock.infra.bean.core.stock;

import java.util.Objects;
import java.util.List;





import ma.zs.easystock.infra.bean.core.commun.MarqueEntity;
import ma.zs.easystock.infra.bean.core.commun.UniteMesureEntity;
import ma.zs.easystock.infra.bean.core.commun.EntrepriseSocieteEntity;
import ma.zs.easystock.infra.bean.core.commun.CategorieEntity;
import ma.zs.easystock.infra.bean.core.commun.DepotEntity;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "produit")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProduitEntity   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    @Column(length = 500)
    private String barCode;
    @Column(length = 500)
    private String designation;
    private BigDecimal quantite = BigDecimal.ZERO;
    private BigDecimal prixAchatMoyen = BigDecimal.ZERO;
    private BigDecimal prixVente = BigDecimal.ZERO;
    @Column(length = 500)
    private String pathPhoto;
    private BigDecimal seuilAlerte = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private EntrepriseSocieteEntity entrepriseSociete ;
    private CategorieEntity categorie ;
    private MarqueEntity marque ;
    private UniteMesureEntity uniteMesure ;

    private List<StockEntity> stocks ;

    public ProduitEntity(){
        super();
    }

    public ProduitEntity(Long id,BigDecimal seuilAlerte){
        this.id = id;
        this.seuilAlerte = seuilAlerte ;
    }
    public ProduitEntity(BigDecimal seuilAlerte){
        this.seuilAlerte = seuilAlerte ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="produit_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public EntrepriseSocieteEntity getEntrepriseSociete(){
        return this.entrepriseSociete;
    }
    public void setEntrepriseSociete(EntrepriseSocieteEntity entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }    public String getBarCode(){
        return this.barCode;
    }
    public void setBarCode(String barCode){
        this.barCode = barCode;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public CategorieEntity getCategorie(){
        return this.categorie;
    }
    public void setCategorie(CategorieEntity categorie){
        this.categorie = categorie;
    }
    public String getDesignation(){
        return this.designation;
    }
    public void setDesignation(String designation){
        this.designation = designation;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public MarqueEntity getMarque(){
        return this.marque;
    }
    public void setMarque(MarqueEntity marque){
        this.marque = marque;
    }
    @ManyToOne(fetch = FetchType.LAZY)

    public UniteMesureEntity getUniteMesure(){
        return this.uniteMesure;
    }
    public void setUniteMesure(UniteMesureEntity uniteMesure){
        this.uniteMesure = uniteMesure;
    }
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }    public BigDecimal getPrixAchatMoyen(){
        return this.prixAchatMoyen;
    }
    public void setPrixAchatMoyen(BigDecimal prixAchatMoyen){
        this.prixAchatMoyen = prixAchatMoyen;
    }    public BigDecimal getPrixVente(){
        return this.prixVente;
    }
    public void setPrixVente(BigDecimal prixVente){
        this.prixVente = prixVente;
    }    @OneToMany(mappedBy = "produit")

    public List<StockEntity> getStocks(){
        return this.stocks;
    }
    public void setStocks(List<StockEntity> stocks){
        this.stocks = stocks;
    }
    public String getPathPhoto(){
        return this.pathPhoto;
    }
    public void setPathPhoto(String pathPhoto){
        this.pathPhoto = pathPhoto;
    }    public BigDecimal getSeuilAlerte(){
        return this.seuilAlerte;
    }
    public void setSeuilAlerte(BigDecimal seuilAlerte){
        this.seuilAlerte = seuilAlerte;
    }    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @Transient
    public String getLabel() {
        label = seuilAlerte;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProduitEntity produit = (ProduitEntity) o;
        return id != null && id.equals(produit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
