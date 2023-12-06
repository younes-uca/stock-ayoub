package  ma.zs.easystock.ws.dto.stock;

import ma.zs.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.zs.easystock.ws.dto.entree.SortieProduitDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SortieProduitItemDto  extends AuditBaseDto {

    private BigDecimal quantite  ;
    private String description  ;

    private ProduitDto produit ;
    private SortieProduitDto sortieProduit ;



    public SortieProduitItemDto(){
        super();
    }



    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public ProduitDto getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitDto produit){
        this.produit = produit;
    }
    public SortieProduitDto getSortieProduit(){
        return this.sortieProduit;
    }

    public void setSortieProduit(SortieProduitDto sortieProduit){
        this.sortieProduit = sortieProduit;
    }






}
