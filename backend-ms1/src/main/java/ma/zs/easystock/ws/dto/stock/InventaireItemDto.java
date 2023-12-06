package  ma.zs.easystock.ws.dto.stock;

import ma.zs.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;




@JsonInclude(JsonInclude.Include.NON_NULL)
public class InventaireItemDto  extends AuditBaseDto {

    private BigDecimal quantiteEstime  ;
    private BigDecimal quantiteReelle  ;

    private ProduitDto produit ;
    private InventaireDto inventaire ;



    public InventaireItemDto(){
        super();
    }



    public BigDecimal getQuantiteEstime(){
        return this.quantiteEstime;
    }
    public void setQuantiteEstime(BigDecimal quantiteEstime){
        this.quantiteEstime = quantiteEstime;
    }

    public BigDecimal getQuantiteReelle(){
        return this.quantiteReelle;
    }
    public void setQuantiteReelle(BigDecimal quantiteReelle){
        this.quantiteReelle = quantiteReelle;
    }


    public ProduitDto getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitDto produit){
        this.produit = produit;
    }
    public InventaireDto getInventaire(){
        return this.inventaire;
    }

    public void setInventaire(InventaireDto inventaire){
        this.inventaire = inventaire;
    }






}
