package  ma.zs.easystock.ws.dto.stock;

import ma.zs.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;




@JsonInclude(JsonInclude.Include.NON_NULL)
public class DevisItemDto  extends AuditBaseDto {

    private BigDecimal quantite  ;
    private BigDecimal prixUnitaireHt  ;
    private BigDecimal prixUnitaireTtc  ;
    private BigDecimal remise  ;
    private BigDecimal montantHt  ;
    private BigDecimal montantTtc  ;

    private ProduitDto produit ;
    private TaxeDto taxe ;
    private DevisDto devis ;



    public DevisItemDto(){
        super();
    }



    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }

    public BigDecimal getPrixUnitaireHt(){
        return this.prixUnitaireHt;
    }
    public void setPrixUnitaireHt(BigDecimal prixUnitaireHt){
        this.prixUnitaireHt = prixUnitaireHt;
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


    public ProduitDto getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitDto produit){
        this.produit = produit;
    }
    public TaxeDto getTaxe(){
        return this.taxe;
    }

    public void setTaxe(TaxeDto taxe){
        this.taxe = taxe;
    }
    public DevisDto getDevis(){
        return this.devis;
    }

    public void setDevis(DevisDto devis){
        this.devis = devis;
    }






}
