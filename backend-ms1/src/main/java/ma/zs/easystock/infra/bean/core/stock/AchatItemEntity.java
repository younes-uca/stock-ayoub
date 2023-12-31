package ma.zs.easystock.infra.bean.core.stock;

import java.util.Objects;





import ma.zs.easystock.infra.bean.core.commun.DepotEntity;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "achat_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AchatItemEntity   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String barCode;
    @Column(length = 500)
    private String footerBarCode;
    private BigDecimal quantite = BigDecimal.ZERO;
    private BigDecimal quantiteAvoir = BigDecimal.ZERO;
    private BigDecimal quantiteDisponible = BigDecimal.ZERO;
    private BigDecimal prixUnitaireHt = BigDecimal.ZERO;
    private BigDecimal prixUnitaireTtc = BigDecimal.ZERO;
    private BigDecimal remise = BigDecimal.ZERO;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;

    private ProduitEntity produit ;
    private TaxeEntity taxe ;
    private AchatEntity achat ;
    private DepotEntity depot ;


    public AchatItemEntity(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="achat_item_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }    public String getBarCode(){
        return this.barCode;
    }
    public void setBarCode(String barCode){
        this.barCode = barCode;
    }    public String getFooterBarCode(){
        return this.footerBarCode;
    }
    public void setFooterBarCode(String footerBarCode){
        this.footerBarCode = footerBarCode;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public ProduitEntity getProduit(){
        return this.produit;
    }
    public void setProduit(ProduitEntity produit){
        this.produit = produit;
    }
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }    public BigDecimal getQuantiteAvoir(){
        return this.quantiteAvoir;
    }
    public void setQuantiteAvoir(BigDecimal quantiteAvoir){
        this.quantiteAvoir = quantiteAvoir;
    }    public BigDecimal getQuantiteDisponible(){
        return this.quantiteDisponible;
    }
    public void setQuantiteDisponible(BigDecimal quantiteDisponible){
        this.quantiteDisponible = quantiteDisponible;
    }    public BigDecimal getPrixUnitaireHt(){
        return this.prixUnitaireHt;
    }
    public void setPrixUnitaireHt(BigDecimal prixUnitaireHt){
        this.prixUnitaireHt = prixUnitaireHt;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public TaxeEntity getTaxe(){
        return this.taxe;
    }
    public void setTaxe(TaxeEntity taxe){
        this.taxe = taxe;
    }
    public BigDecimal getPrixUnitaireTtc(){
        return this.prixUnitaireTtc;
    }
    public void setPrixUnitaireTtc(BigDecimal prixUnitaireTtc){
        this.prixUnitaireTtc = prixUnitaireTtc;
    }    public BigDecimal getRemise(){
        return this.remise;
    }
    public void setRemise(BigDecimal remise){
        this.remise = remise;
    }    public BigDecimal getMontantHt(){
        return this.montantHt;
    }
    public void setMontantHt(BigDecimal montantHt){
        this.montantHt = montantHt;
    }    public BigDecimal getMontantTtc(){
        return this.montantTtc;
    }
    public void setMontantTtc(BigDecimal montantTtc){
        this.montantTtc = montantTtc;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public AchatEntity getAchat(){
        return this.achat;
    }
    public void setAchat(AchatEntity achat){
        this.achat = achat;
    }
    @ManyToOne(fetch = FetchType.LAZY)

    public DepotEntity getDepot(){
        return this.depot;
    }
    public void setDepot(DepotEntity depot){
        this.depot = depot;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AchatItemEntity achatItem = (AchatItemEntity) o;
        return id != null && id.equals(achatItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

