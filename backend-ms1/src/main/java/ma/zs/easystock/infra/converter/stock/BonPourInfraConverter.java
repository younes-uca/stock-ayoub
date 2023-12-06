package  ma.zs.easystock.infra.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;

import ma.zs.easystock.zynerator.helper.ListUtil;


import ma.zs.easystock.infra.converter.stock.ProduitInfraConverter;
import ma.zs.easystock.infra.converter.stock.BonPourItemInfraConverter;
import ma.zs.easystock.infra.converter.commun.ClientInfraConverter;
import ma.zs.easystock.infra.converter.stock.TaxeInfraConverter;



import ma.zs.easystock.infra.bean.core.stock.BonPourEntity;
import ma.zs.easystock.domain.model.stock.BonPour;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class BonPourInfraConverter extends AbstractInfraConverter<BonPourEntity, BonPour> {

    @Autowired
    private ProduitInfraConverter produitConverter ;
    @Autowired
    private BonPourItemInfraConverter bonPourItemConverter ;
    @Autowired
    private ClientInfraConverter clientConverter ;
    @Autowired
    private TaxeInfraConverter taxeConverter ;
    private boolean client;
    private boolean bonPourItems;

    public  BonPourInfraConverter(){
        super(BonPourEntity.class, BonPour.class);
        init(true);
    }

    @Override
    public BonPour toModel(BonPourEntity entity) {
        if (entity == null) {
            return null;
        } else {
        BonPour model = new BonPour();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getNumeroBonPour()))
                model.setNumeroBonPour(entity.getNumeroBonPour());
            if(StringUtil.isNotEmpty(entity.getDateBonPour()))
                model.setDateBonPour(DateUtil.stringEnToDate(entity.getDateBonPour()));
            if(StringUtil.isNotEmpty(entity.getMontantHt()))
                model.setMontantHt(entity.getMontantHt());
            if(StringUtil.isNotEmpty(entity.getMontantTva()))
                model.setMontantTva(entity.getMontantTva());
            if(StringUtil.isNotEmpty(entity.getMontantTtc()))
                model.setMontantTtc(entity.getMontantTtc());
            if(StringUtil.isNotEmpty(entity.getDescription()))
                model.setDescription(entity.getDescription());
            if(this.client && entity.getClient()!=null &&  entity.getClient().getId() != null)
                model.setClient(clientConverter.toModel(entity.getClient())) ;


            if(this.bonPourItems && ListUtil.isNotEmpty(entity.getBonPourItems()))
                model.setBonPourItems(bonPourItemConverter.toModel(entity.getBonPourItems()));


        return model;
        }
    }

    @Override
    public BonPourEntity toEntity(BonPour model) {
        if (model == null) {
            return null;
        } else {
            BonPourEntity entity = new BonPourEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getNumeroBonPour()))
             entity.setNumeroBonPour(model.getNumeroBonPour());
            if(model.getDateBonPour()!=null)
             entity.setDateBonPour(DateUtil.dateTimeToString(model.getDateBonPour()));
            if(StringUtil.isNotEmpty(model.getMontantHt()))
             entity.setMontantHt(model.getMontantHt());
            if(StringUtil.isNotEmpty(model.getMontantTva()))
             entity.setMontantTva(model.getMontantTva());
            if(StringUtil.isNotEmpty(model.getMontantTtc()))
             entity.setMontantTtc(model.getMontantTtc());
            if(StringUtil.isNotEmpty(model.getDescription()))
             entity.setDescription(model.getDescription());
        if(this.client && model.getClient()!=null) {
            entity.setClient(clientConverter.toEntity(model.getClient())) ;
        }
        if(this.bonPourItems && ListUtil.isNotEmpty(model.getBonPourItems())){
            bonPourItemConverter.init(true);
            bonPourItemConverter.setBonPour(false);
            entity.setBonPourItems(bonPourItemConverter.toEntity(model.getBonPourItems()));
            bonPourItemConverter.setBonPour(true);

        }


        return entity;
        }
    }

    public void initList(boolean value) {
        this.bonPourItems = value;
    }

    public void initObject(boolean value) {
        this.client = value;
    }


    public ProduitInfraConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitInfraConverter(ProduitInfraConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public BonPourItemInfraConverter getBonPourItemConverter(){
        return this.bonPourItemConverter;
    }
    public void setBonPourItemInfraConverter(BonPourItemInfraConverter bonPourItemConverter ){
        this.bonPourItemConverter = bonPourItemConverter;
    }
    public ClientInfraConverter getClientConverter(){
        return this.clientConverter;
    }
    public void setClientInfraConverter(ClientInfraConverter clientConverter ){
        this.clientConverter = clientConverter;
    }
    public TaxeInfraConverter getTaxeConverter(){
        return this.taxeConverter;
    }
    public void setTaxeInfraConverter(TaxeInfraConverter taxeConverter ){
        this.taxeConverter = taxeConverter;
    }
    public boolean  isClient(){
        return this.client;
    }
    public void  setClient(boolean client){
        this.client = client;
    }
    public boolean  isBonPourItems(){
        return this.bonPourItems ;
    }
    public void  setBonPourItems(boolean bonPourItems ){
        this.bonPourItems  = bonPourItems ;
    }
}
