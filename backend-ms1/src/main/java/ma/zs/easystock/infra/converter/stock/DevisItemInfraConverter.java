package  ma.zs.easystock.infra.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;



import ma.zs.easystock.infra.converter.stock.ProduitInfraConverter;
import ma.zs.easystock.infra.converter.stock.DevisInfraConverter;
import ma.zs.easystock.infra.converter.stock.TaxeInfraConverter;

import ma.zs.easystock.infra.bean.core.stock.ProduitEntity;
import ma.zs.easystock.domain.model.stock.Produit;
import ma.zs.easystock.infra.bean.core.stock.DevisEntity;
import ma.zs.easystock.domain.model.stock.Devis;


import ma.zs.easystock.infra.bean.core.stock.DevisItemEntity;
import ma.zs.easystock.domain.model.stock.DevisItem;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class DevisItemInfraConverter extends AbstractInfraConverter<DevisItemEntity, DevisItem> {

    @Autowired
    private ProduitInfraConverter produitConverter ;
    @Autowired
    private DevisInfraConverter devisConverter ;
    @Autowired
    private TaxeInfraConverter taxeConverter ;
    private boolean produit;
    private boolean taxe;
    private boolean devis;

    public  DevisItemInfraConverter(){
        super(DevisItemEntity.class, DevisItem.class);
    }

    @Override
    public DevisItem toModel(DevisItemEntity entity) {
        if (entity == null) {
            return null;
        } else {
        DevisItem model = new DevisItem();
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

            if(entity.getDevis() != null && entity.getDevis().getId() != null){
                model.setDevis(new Devis());
                model.getDevis().setId(entity.getDevis().getId());
                model.getDevis().setNumeroDevis(entity.getDevis().getNumeroDevis());
            }




        return model;
        }
    }

    @Override
    public DevisItemEntity toEntity(DevisItem model) {
        if (model == null) {
            return null;
        } else {
            DevisItemEntity entity = new DevisItemEntity();
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
        if(this.devis && model.getDevis()!=null) {
            entity.setDevis(devisConverter.toEntity(model.getDevis())) ;
        }


        return entity;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.taxe = value;
        this.devis = value;
    }


    public ProduitInfraConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitInfraConverter(ProduitInfraConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public DevisInfraConverter getDevisConverter(){
        return this.devisConverter;
    }
    public void setDevisInfraConverter(DevisInfraConverter devisConverter ){
        this.devisConverter = devisConverter;
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
    public boolean  isDevis(){
        return this.devis;
    }
    public void  setDevis(boolean devis){
        this.devis = devis;
    }
}
