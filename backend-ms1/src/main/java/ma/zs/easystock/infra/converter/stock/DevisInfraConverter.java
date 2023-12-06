package  ma.zs.easystock.infra.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;

import ma.zs.easystock.zynerator.helper.ListUtil;


import ma.zs.easystock.infra.converter.stock.DevisItemInfraConverter;
import ma.zs.easystock.infra.converter.stock.ProduitInfraConverter;
import ma.zs.easystock.infra.converter.commun.ClientInfraConverter;
import ma.zs.easystock.infra.converter.stock.TaxeInfraConverter;



import ma.zs.easystock.infra.bean.core.stock.DevisEntity;
import ma.zs.easystock.domain.model.stock.Devis;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class DevisInfraConverter extends AbstractInfraConverter<DevisEntity, Devis> {

    @Autowired
    private DevisItemInfraConverter devisItemConverter ;
    @Autowired
    private ProduitInfraConverter produitConverter ;
    @Autowired
    private ClientInfraConverter clientConverter ;
    @Autowired
    private TaxeInfraConverter taxeConverter ;
    private boolean client;
    private boolean devisItems;

    public  DevisInfraConverter(){
        super(DevisEntity.class, Devis.class);
        init(true);
    }

    @Override
    public Devis toModel(DevisEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Devis model = new Devis();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getNumeroDevis()))
                model.setNumeroDevis(entity.getNumeroDevis());
            if(StringUtil.isNotEmpty(entity.getDateDevis()))
                model.setDateDevis(DateUtil.stringEnToDate(entity.getDateDevis()));
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


            if(this.devisItems && ListUtil.isNotEmpty(entity.getDevisItems()))
                model.setDevisItems(devisItemConverter.toModel(entity.getDevisItems()));


        return model;
        }
    }

    @Override
    public DevisEntity toEntity(Devis model) {
        if (model == null) {
            return null;
        } else {
            DevisEntity entity = new DevisEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getNumeroDevis()))
             entity.setNumeroDevis(model.getNumeroDevis());
            if(model.getDateDevis()!=null)
             entity.setDateDevis(DateUtil.dateTimeToString(model.getDateDevis()));
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
        if(this.devisItems && ListUtil.isNotEmpty(model.getDevisItems())){
            devisItemConverter.init(true);
            devisItemConverter.setDevis(false);
            entity.setDevisItems(devisItemConverter.toEntity(model.getDevisItems()));
            devisItemConverter.setDevis(true);

        }


        return entity;
        }
    }

    public void initList(boolean value) {
        this.devisItems = value;
    }

    public void initObject(boolean value) {
        this.client = value;
    }


    public DevisItemInfraConverter getDevisItemConverter(){
        return this.devisItemConverter;
    }
    public void setDevisItemInfraConverter(DevisItemInfraConverter devisItemConverter ){
        this.devisItemConverter = devisItemConverter;
    }
    public ProduitInfraConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitInfraConverter(ProduitInfraConverter produitConverter ){
        this.produitConverter = produitConverter;
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
    public boolean  isDevisItems(){
        return this.devisItems ;
    }
    public void  setDevisItems(boolean devisItems ){
        this.devisItems  = devisItems ;
    }
}
