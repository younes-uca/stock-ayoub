package  ma.zs.easystock.infra.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;



import ma.zs.easystock.infra.converter.stock.ProduitInfraConverter;
import ma.zs.easystock.infra.converter.entree.EntreeProduitInfraConverter;

import ma.zs.easystock.infra.bean.core.stock.ProduitEntity;
import ma.zs.easystock.domain.model.stock.Produit;
import ma.zs.easystock.infra.bean.core.entree.EntreeProduitEntity;
import ma.zs.easystock.domain.model.entree.EntreeProduit;


import ma.zs.easystock.infra.bean.core.stock.EntreeProduitItemEntity;
import ma.zs.easystock.domain.model.stock.EntreeProduitItem;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class EntreeProduitItemInfraConverter extends AbstractInfraConverter<EntreeProduitItemEntity, EntreeProduitItem> {

    @Autowired
    private ProduitInfraConverter produitConverter ;
    @Autowired
    private EntreeProduitInfraConverter entreeProduitConverter ;
    private boolean produit;
    private boolean entreeProduit;

    public  EntreeProduitItemInfraConverter(){
        super(EntreeProduitItemEntity.class, EntreeProduitItem.class);
    }

    @Override
    public EntreeProduitItem toModel(EntreeProduitItemEntity entity) {
        if (entity == null) {
            return null;
        } else {
        EntreeProduitItem model = new EntreeProduitItem();
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

            if(entity.getEntreeProduit() != null && entity.getEntreeProduit().getId() != null){
                model.setEntreeProduit(new EntreeProduit());
                model.getEntreeProduit().setId(entity.getEntreeProduit().getId());
                model.getEntreeProduit().setReference(entity.getEntreeProduit().getReference());
            }




        return model;
        }
    }

    @Override
    public EntreeProduitItemEntity toEntity(EntreeProduitItem model) {
        if (model == null) {
            return null;
        } else {
            EntreeProduitItemEntity entity = new EntreeProduitItemEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getQuantite()))
             entity.setQuantite(model.getQuantite());
            if(StringUtil.isNotEmpty(model.getDescription()))
             entity.setDescription(model.getDescription());
        if(this.produit && model.getProduit()!=null) {
            entity.setProduit(produitConverter.toEntity(model.getProduit())) ;
        }
        if(this.entreeProduit && model.getEntreeProduit()!=null) {
            entity.setEntreeProduit(entreeProduitConverter.toEntity(model.getEntreeProduit())) ;
        }


        return entity;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.entreeProduit = value;
    }


    public ProduitInfraConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitInfraConverter(ProduitInfraConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public EntreeProduitInfraConverter getEntreeProduitConverter(){
        return this.entreeProduitConverter;
    }
    public void setEntreeProduitInfraConverter(EntreeProduitInfraConverter entreeProduitConverter ){
        this.entreeProduitConverter = entreeProduitConverter;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isEntreeProduit(){
        return this.entreeProduit;
    }
    public void  setEntreeProduit(boolean entreeProduit){
        this.entreeProduit = entreeProduit;
    }
}
