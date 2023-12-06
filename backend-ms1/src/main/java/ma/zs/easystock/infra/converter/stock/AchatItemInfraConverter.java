package  ma.zs.easystock.infra.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;



import ma.zs.easystock.infra.converter.stock.ProduitInfraConverter;
import ma.zs.easystock.infra.converter.stock.AchatInfraConverter;
import ma.zs.easystock.infra.converter.stock.TaxeInfraConverter;
import ma.zs.easystock.infra.converter.commun.DepotInfraConverter;

import ma.zs.easystock.infra.bean.core.stock.ProduitEntity;
import ma.zs.easystock.domain.model.stock.Produit;
import ma.zs.easystock.infra.bean.core.stock.AchatEntity;
import ma.zs.easystock.domain.model.stock.Achat;


import ma.zs.easystock.infra.bean.core.stock.AchatItemEntity;
import ma.zs.easystock.domain.model.stock.AchatItem;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class AchatItemInfraConverter extends AbstractInfraConverter<AchatItemEntity, AchatItem> {

    @Autowired
    private ProduitInfraConverter produitConverter ;
    @Autowired
    private AchatInfraConverter achatConverter ;
    @Autowired
    private TaxeInfraConverter taxeConverter ;
    @Autowired
    private DepotInfraConverter depotConverter ;
    private boolean produit;
    private boolean taxe;
    private boolean achat;
    private boolean depot;

    public  AchatItemInfraConverter(){
        super(AchatItemEntity.class, AchatItem.class);
    }

    @Override
    public AchatItem toModel(AchatItemEntity entity) {
        if (entity == null) {
            return null;
        } else {
        AchatItem model = new AchatItem();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getBarCode()))
                model.setBarCode(entity.getBarCode());
            if(StringUtil.isNotEmpty(entity.getFooterBarCode()))
                model.setFooterBarCode(entity.getFooterBarCode());
            if(StringUtil.isNotEmpty(entity.getQuantite()))
                model.setQuantite(entity.getQuantite());
            if(StringUtil.isNotEmpty(entity.getQuantiteAvoir()))
                model.setQuantiteAvoir(entity.getQuantiteAvoir());
            if(StringUtil.isNotEmpty(entity.getQuantiteDisponible()))
                model.setQuantiteDisponible(entity.getQuantiteDisponible());
            if(StringUtil.isNotEmpty(entity.getPrixUnitaireHt()))
                model.setPrixUnitaireHt(entity.getPrixUnitaireHt());
            if(StringUtil.isNotEmpty(entity.getPrixUnitaireTtc()))
                model.setPrixUnitaireTtc(entity.getPrixUnitaireTtc());
            if(StringUtil.isNotEmpty(entity.getRemise()))
                model.setRemise(entity.getRemise());
            if(StringUtil.isNotEmpty(entity.getMontantHt()))
                model.setMontantHt(entity.getMontantHt());
            if(StringUtil.isNotEmpty(entity.getMontantTtc()))
                model.setMontantTtc(entity.getMontantTtc());
            if(entity.getProduit() != null && entity.getProduit().getId() != null){
                model.setProduit(new Produit());
                model.getProduit().setId(entity.getProduit().getId());
                model.getProduit().setSeuilAlerte(entity.getProduit().getSeuilAlerte());
            }

            if(this.taxe && entity.getTaxe()!=null &&  entity.getTaxe().getId() != null)
                model.setTaxe(taxeConverter.toModel(entity.getTaxe())) ;

            if(entity.getAchat() != null && entity.getAchat().getId() != null){
                model.setAchat(new Achat());
                model.getAchat().setId(entity.getAchat().getId());
                model.getAchat().setId(entity.getAchat().getId());
            }

            if(this.depot && entity.getDepot()!=null &&  entity.getDepot().getId() != null)
                model.setDepot(depotConverter.toModel(entity.getDepot())) ;




        return model;
        }
    }

    @Override
    public AchatItemEntity toEntity(AchatItem model) {
        if (model == null) {
            return null;
        } else {
            AchatItemEntity entity = new AchatItemEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getBarCode()))
             entity.setBarCode(model.getBarCode());
            if(StringUtil.isNotEmpty(model.getFooterBarCode()))
             entity.setFooterBarCode(model.getFooterBarCode());
            if(StringUtil.isNotEmpty(model.getQuantite()))
             entity.setQuantite(model.getQuantite());
            if(StringUtil.isNotEmpty(model.getQuantiteAvoir()))
             entity.setQuantiteAvoir(model.getQuantiteAvoir());
            if(StringUtil.isNotEmpty(model.getQuantiteDisponible()))
             entity.setQuantiteDisponible(model.getQuantiteDisponible());
            if(StringUtil.isNotEmpty(model.getPrixUnitaireHt()))
             entity.setPrixUnitaireHt(model.getPrixUnitaireHt());
            if(StringUtil.isNotEmpty(model.getPrixUnitaireTtc()))
             entity.setPrixUnitaireTtc(model.getPrixUnitaireTtc());
            if(StringUtil.isNotEmpty(model.getRemise()))
             entity.setRemise(model.getRemise());
            if(StringUtil.isNotEmpty(model.getMontantHt()))
             entity.setMontantHt(model.getMontantHt());
            if(StringUtil.isNotEmpty(model.getMontantTtc()))
             entity.setMontantTtc(model.getMontantTtc());
        if(this.produit && model.getProduit()!=null) {
            entity.setProduit(produitConverter.toEntity(model.getProduit())) ;
        }
        if(this.taxe && model.getTaxe()!=null) {
            entity.setTaxe(taxeConverter.toEntity(model.getTaxe())) ;
        }
        if(this.achat && model.getAchat()!=null) {
            entity.setAchat(achatConverter.toEntity(model.getAchat())) ;
        }
        if(this.depot && model.getDepot()!=null) {
            entity.setDepot(depotConverter.toEntity(model.getDepot())) ;
        }


        return entity;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.taxe = value;
        this.achat = value;
        this.depot = value;
    }


    public ProduitInfraConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitInfraConverter(ProduitInfraConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public AchatInfraConverter getAchatConverter(){
        return this.achatConverter;
    }
    public void setAchatInfraConverter(AchatInfraConverter achatConverter ){
        this.achatConverter = achatConverter;
    }
    public TaxeInfraConverter getTaxeConverter(){
        return this.taxeConverter;
    }
    public void setTaxeInfraConverter(TaxeInfraConverter taxeConverter ){
        this.taxeConverter = taxeConverter;
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
    public boolean  isTaxe(){
        return this.taxe;
    }
    public void  setTaxe(boolean taxe){
        this.taxe = taxe;
    }
    public boolean  isAchat(){
        return this.achat;
    }
    public void  setAchat(boolean achat){
        this.achat = achat;
    }
    public boolean  isDepot(){
        return this.depot;
    }
    public void  setDepot(boolean depot){
        this.depot = depot;
    }
}
