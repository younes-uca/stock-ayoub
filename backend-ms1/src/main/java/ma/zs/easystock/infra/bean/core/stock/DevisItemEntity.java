package ma.zs.easystock.infra.bean.core.stock;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "devis_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DevisItemEntity   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal quantite = BigDecimal.ZERO;
    private BigDecimal prixUnitaireHt = BigDecimal.ZERO;
    private BigDecimal prixUnitaireTtc = BigDecimal.ZERO;
    private BigDecimal remise = BigDecimal.ZERO;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;

    private ProduitEntity produit ;
    private TaxeEntity taxe ;
    private DevisEntity devis ;


    public DevisItemEntity(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="devis_item_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
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

    public DevisEntity getDevis(){
        return this.devis;
    }
    public void setDevis(DevisEntity devis){
        this.devis = devis;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DevisItemEntity devisItem = (DevisItemEntity) o;
        return id != null && id.equals(devisItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

