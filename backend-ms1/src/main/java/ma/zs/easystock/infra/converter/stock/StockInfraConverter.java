package  ma.zs.easystock.infra.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;



import ma.zs.easystock.infra.converter.stock.ProduitInfraConverter;
import ma.zs.easystock.infra.converter.commun.DepotInfraConverter;

import ma.zs.easystock.infra.bean.core.stock.ProduitEntity;
import ma.zs.easystock.domain.model.stock.Produit;


import ma.zs.easystock.infra.bean.core.stock.StockEntity;
import ma.zs.easystock.domain.model.stock.Stock;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class StockInfraConverter extends AbstractInfraConverter<StockEntity, Stock> {

    @Autowired
    private ProduitInfraConverter produitConverter ;
    @Autowired
    private DepotInfraConverter depotConverter ;
    private boolean produit;
    private boolean depot;

    public  StockInfraConverter(){
        super(StockEntity.class, Stock.class);
    }

    @Override
    public Stock toModel(StockEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Stock model = new Stock();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getQuantite()))
                model.setQuantite(entity.getQuantite());
            if(entity.getProduit() != null && entity.getProduit().getId() != null){
                model.setProduit(new Produit());
                model.getProduit().setId(entity.getProduit().getId());
                model.getProduit().setSeuilAlerte(entity.getProduit().getSeuilAlerte());
            }

            if(this.depot && entity.getDepot()!=null &&  entity.getDepot().getId() != null)
                model.setDepot(depotConverter.toModel(entity.getDepot())) ;




        return model;
        }
    }

    @Override
    public StockEntity toEntity(Stock model) {
        if (model == null) {
            return null;
        } else {
            StockEntity entity = new StockEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getQuantite()))
             entity.setQuantite(model.getQuantite());
        if(this.produit && model.getProduit()!=null) {
            entity.setProduit(produitConverter.toEntity(model.getProduit())) ;
        }
        if(this.depot && model.getDepot()!=null) {
            entity.setDepot(depotConverter.toEntity(model.getDepot())) ;
        }


        return entity;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.depot = value;
    }


    public ProduitInfraConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitInfraConverter(ProduitInfraConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public DepotInfraConverter getDepotConverter(){
        return this.depotConverter;
    }
    public void setDepotInfraConverter(DepotInfraConverter depotConverter ){
        this.depotConverter = depotConverter;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isDepot(){
        return this.depot;
    }
    public void  setDepot(boolean depot){
        this.depot = depot;
    }
}
