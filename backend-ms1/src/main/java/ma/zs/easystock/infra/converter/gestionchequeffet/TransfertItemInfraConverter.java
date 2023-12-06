package  ma.zs.easystock.infra.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;



import ma.zs.easystock.infra.converter.stock.ProduitInfraConverter;
import ma.zs.easystock.infra.converter.gestionchequeffet.TransfertInfraConverter;
import ma.zs.easystock.infra.converter.commun.DepotInfraConverter;

import ma.zs.easystock.infra.bean.core.stock.ProduitEntity;
import ma.zs.easystock.domain.model.stock.Produit;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.TransfertEntity;
import ma.zs.easystock.domain.model.gestionchequeffet.Transfert;


import ma.zs.easystock.infra.bean.core.gestionchequeffet.TransfertItemEntity;
import ma.zs.easystock.domain.model.gestionchequeffet.TransfertItem;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class TransfertItemInfraConverter extends AbstractInfraConverter<TransfertItemEntity, TransfertItem> {

    @Autowired
    private ProduitInfraConverter produitConverter ;
    @Autowired
    private TransfertInfraConverter transfertConverter ;
    @Autowired
    private DepotInfraConverter depotConverter ;
    private boolean depot;
    private boolean produit;
    private boolean transfert;

    public  TransfertItemInfraConverter(){
        super(TransfertItemEntity.class, TransfertItem.class);
    }

    @Override
    public TransfertItem toModel(TransfertItemEntity entity) {
        if (entity == null) {
            return null;
        } else {
        TransfertItem model = new TransfertItem();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getQuantite()))
                model.setQuantite(entity.getQuantite());
            if(this.depot && entity.getDepot()!=null &&  entity.getDepot().getId() != null)
                model.setDepot(depotConverter.toModel(entity.getDepot())) ;

            if(entity.getProduit() != null && entity.getProduit().getId() != null){
                model.setProduit(new Produit());
                model.getProduit().setId(entity.getProduit().getId());
                model.getProduit().setSeuilAlerte(entity.getProduit().getSeuilAlerte());
            }

            if(entity.getTransfert() != null && entity.getTransfert().getId() != null){
                model.setTransfert(new Transfert());
                model.getTransfert().setId(entity.getTransfert().getId());
                model.getTransfert().setId(entity.getTransfert().getId());
            }




        return model;
        }
    }

    @Override
    public TransfertItemEntity toEntity(TransfertItem model) {
        if (model == null) {
            return null;
        } else {
            TransfertItemEntity entity = new TransfertItemEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getQuantite()))
             entity.setQuantite(model.getQuantite());
        if(this.depot && model.getDepot()!=null) {
            entity.setDepot(depotConverter.toEntity(model.getDepot())) ;
        }
        if(this.produit && model.getProduit()!=null) {
            entity.setProduit(produitConverter.toEntity(model.getProduit())) ;
        }
        if(this.transfert && model.getTransfert()!=null) {
            entity.setTransfert(transfertConverter.toEntity(model.getTransfert())) ;
        }


        return entity;
        }
    }


    public void initObject(boolean value) {
        this.depot = value;
        this.produit = value;
        this.transfert = value;
    }


    public ProduitInfraConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitInfraConverter(ProduitInfraConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public TransfertInfraConverter getTransfertConverter(){
        return this.transfertConverter;
    }
    public void setTransfertInfraConverter(TransfertInfraConverter transfertConverter ){
        this.transfertConverter = transfertConverter;
    }
    public DepotInfraConverter getDepotConverter(){
        return this.depotConverter;
    }
    public void setDepotInfraConverter(DepotInfraConverter depotConverter ){
        this.depotConverter = depotConverter;
    }
    public boolean  isDepot(){
        return this.depot;
    }
    public void  setDepot(boolean depot){
        this.depot = depot;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isTransfert(){
        return this.transfert;
    }
    public void  setTransfert(boolean transfert){
        this.transfert = transfert;
    }
}
