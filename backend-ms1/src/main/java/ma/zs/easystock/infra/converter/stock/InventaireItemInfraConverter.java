package  ma.zs.easystock.infra.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;



import ma.zs.easystock.infra.converter.stock.ProduitInfraConverter;
import ma.zs.easystock.infra.converter.stock.InventaireInfraConverter;

import ma.zs.easystock.infra.bean.core.stock.ProduitEntity;
import ma.zs.easystock.domain.model.stock.Produit;
import ma.zs.easystock.infra.bean.core.stock.InventaireEntity;
import ma.zs.easystock.domain.model.stock.Inventaire;


import ma.zs.easystock.infra.bean.core.stock.InventaireItemEntity;
import ma.zs.easystock.domain.model.stock.InventaireItem;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class InventaireItemInfraConverter extends AbstractInfraConverter<InventaireItemEntity, InventaireItem> {

    @Autowired
    private ProduitInfraConverter produitConverter ;
    @Autowired
    private InventaireInfraConverter inventaireConverter ;
    private boolean produit;
    private boolean inventaire;

    public  InventaireItemInfraConverter(){
        super(InventaireItemEntity.class, InventaireItem.class);
    }

    @Override
    public InventaireItem toModel(InventaireItemEntity entity) {
        if (entity == null) {
            return null;
        } else {
        InventaireItem model = new InventaireItem();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getQuantiteEstime()))
                model.setQuantiteEstime(entity.getQuantiteEstime());
            if(StringUtil.isNotEmpty(entity.getQuantiteReelle()))
                model.setQuantiteReelle(entity.getQuantiteReelle());
            if(entity.getProduit() != null && entity.getProduit().getId() != null){
                model.setProduit(new Produit());
                model.getProduit().setId(entity.getProduit().getId());
                model.getProduit().setSeuilAlerte(entity.getProduit().getSeuilAlerte());
            }

            if(entity.getInventaire() != null && entity.getInventaire().getId() != null){
                model.setInventaire(new Inventaire());
                model.getInventaire().setId(entity.getInventaire().getId());
                model.getInventaire().setReference(entity.getInventaire().getReference());
            }




        return model;
        }
    }

    @Override
    public InventaireItemEntity toEntity(InventaireItem model) {
        if (model == null) {
            return null;
        } else {
            InventaireItemEntity entity = new InventaireItemEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getQuantiteEstime()))
             entity.setQuantiteEstime(model.getQuantiteEstime());
            if(StringUtil.isNotEmpty(model.getQuantiteReelle()))
             entity.setQuantiteReelle(model.getQuantiteReelle());
        if(this.produit && model.getProduit()!=null) {
            entity.setProduit(produitConverter.toEntity(model.getProduit())) ;
        }
        if(this.inventaire && model.getInventaire()!=null) {
            entity.setInventaire(inventaireConverter.toEntity(model.getInventaire())) ;
        }


        return entity;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.inventaire = value;
    }


    public ProduitInfraConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitInfraConverter(ProduitInfraConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public InventaireInfraConverter getInventaireConverter(){
        return this.inventaireConverter;
    }
    public void setInventaireInfraConverter(InventaireInfraConverter inventaireConverter ){
        this.inventaireConverter = inventaireConverter;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isInventaire(){
        return this.inventaire;
    }
    public void  setInventaire(boolean inventaire){
        this.inventaire = inventaire;
    }
}
