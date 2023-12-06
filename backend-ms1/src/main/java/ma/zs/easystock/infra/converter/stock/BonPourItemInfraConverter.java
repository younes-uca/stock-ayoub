package  ma.zs.easystock.infra.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;



import ma.zs.easystock.infra.converter.stock.ProduitInfraConverter;
import ma.zs.easystock.infra.converter.stock.BonPourInfraConverter;
import ma.zs.easystock.infra.converter.stock.TaxeInfraConverter;

import ma.zs.easystock.infra.bean.core.stock.ProduitEntity;
import ma.zs.easystock.domain.model.stock.Produit;
import ma.zs.easystock.infra.bean.core.stock.BonPourEntity;
import ma.zs.easystock.domain.model.stock.BonPour;


import ma.zs.easystock.infra.bean.core.stock.BonPourItemEntity;
import ma.zs.easystock.domain.model.stock.BonPourItem;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class BonPourItemInfraConverter extends AbstractInfraConverter<BonPourItemEntity, BonPourItem> {

    @Autowired
    private ProduitInfraConverter produitConverter ;
    @Autowired
    private BonPourInfraConverter bonPourConverter ;
    @Autowired
    private TaxeInfraConverter taxeConverter ;
    private boolean produit;
    private boolean taxe;
    private boolean bonPour;

    public  BonPourItemInfraConverter(){
        super(BonPourItemEntity.class, BonPourItem.class);
    }

    @Override
    public BonPourItem toModel(BonPourItemEntity entity) {
        if (entity == null) {
            return null;
        } else {
        BonPourItem model = new BonPourItem();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getQuantite()))
                model.setQuantite(entity.getQuantite());
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

            if(entity.getBonPour() != null && entity.getBonPour().getId() != null){
                model.setBonPour(new BonPour());
                model.getBonPour().setId(entity.getBonPour().getId());
                model.getBonPour().setNumeroBonPour(entity.getBonPour().getNumeroBonPour());
            }




        return model;
        }
    }

    @Override
    public BonPourItemEntity toEntity(BonPourItem model) {
        if (model == null) {
            return null;
        } else {
            BonPourItemEntity entity = new BonPourItemEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getQuantite()))
             entity.setQuantite(model.getQuantite());
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
        if(this.bonPour && model.getBonPour()!=null) {
            entity.setBonPour(bonPourConverter.toEntity(model.getBonPour())) ;
        }


        return entity;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.taxe = value;
        this.bonPour = value;
    }


    public ProduitInfraConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitInfraConverter(ProduitInfraConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public BonPourInfraConverter getBonPourConverter(){
        return this.bonPourConverter;
    }
    public void setBonPourInfraConverter(BonPourInfraConverter bonPourConverter ){
        this.bonPourConverter = bonPourConverter;
    }
    public TaxeInfraConverter getTaxeConverter(){
        return this.taxeConverter;
    }
    public void setTaxeInfraConverter(TaxeInfraConverter taxeConverter ){
        this.taxeConverter = taxeConverter;
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
    public boolean  isBonPour(){
        return this.bonPour;
    }
    public void  setBonPour(boolean bonPour){
        this.bonPour = bonPour;
    }
}
