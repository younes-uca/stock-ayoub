package  ma.zs.easystock.infra.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;



import ma.zs.easystock.infra.converter.stock.ProduitInfraConverter;
import ma.zs.easystock.infra.converter.entree.SortieProduitInfraConverter;

import ma.zs.easystock.infra.bean.core.stock.ProduitEntity;
import ma.zs.easystock.domain.model.stock.Produit;
import ma.zs.easystock.infra.bean.core.entree.SortieProduitEntity;
import ma.zs.easystock.domain.model.entree.SortieProduit;


import ma.zs.easystock.infra.bean.core.stock.SortieProduitItemEntity;
import ma.zs.easystock.domain.model.stock.SortieProduitItem;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class SortieProduitItemInfraConverter extends AbstractInfraConverter<SortieProduitItemEntity, SortieProduitItem> {

    @Autowired
    private ProduitInfraConverter produitConverter ;
    @Autowired
    private SortieProduitInfraConverter sortieProduitConverter ;
    private boolean produit;
    private boolean sortieProduit;

    public  SortieProduitItemInfraConverter(){
        super(SortieProduitItemEntity.class, SortieProduitItem.class);
    }

    @Override
    public SortieProduitItem toModel(SortieProduitItemEntity entity) {
        if (entity == null) {
            return null;
        } else {
        SortieProduitItem model = new SortieProduitItem();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getQuantite()))
                model.setQuantite(entity.getQuantite());
            if(StringUtil.isNotEmpty(entity.getDescription()))
                model.setDescription(entity.getDescription());
            if(entity.getProduit() != null && entity.getProduit().getId() != null){
                model.setProduit(new Produit());
                model.getProduit().setId(entity.getProduit().getId());
                model.getProduit().setSeuilAlerte(entity.getProduit().getSeuilAlerte());
            }

            if(entity.getSortieProduit() != null && entity.getSortieProduit().getId() != null){
                model.setSortieProduit(new SortieProduit());
                model.getSortieProduit().setId(entity.getSortieProduit().getId());
                model.getSortieProduit().setReference(entity.getSortieProduit().getReference());
            }




        return model;
        }
    }

    @Override
    public SortieProduitItemEntity toEntity(SortieProduitItem model) {
        if (model == null) {
            return null;
        } else {
            SortieProduitItemEntity entity = new SortieProduitItemEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getQuantite()))
             entity.setQuantite(model.getQuantite());
            if(StringUtil.isNotEmpty(model.getDescription()))
             entity.setDescription(model.getDescription());
        if(this.produit && model.getProduit()!=null) {
            entity.setProduit(produitConverter.toEntity(model.getProduit())) ;
        }
        if(this.sortieProduit && model.getSortieProduit()!=null) {
            entity.setSortieProduit(sortieProduitConverter.toEntity(model.getSortieProduit())) ;
        }


        return entity;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.sortieProduit = value;
    }


    public ProduitInfraConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitInfraConverter(ProduitInfraConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public SortieProduitInfraConverter getSortieProduitConverter(){
        return this.sortieProduitConverter;
    }
    public void setSortieProduitInfraConverter(SortieProduitInfraConverter sortieProduitConverter ){
        this.sortieProduitConverter = sortieProduitConverter;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isSortieProduit(){
        return this.sortieProduit;
    }
    public void  setSortieProduit(boolean sortieProduit){
        this.sortieProduit = sortieProduit;
    }
}
