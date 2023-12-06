package  ma.zs.easystock.infra.converter.entree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;

import ma.zs.easystock.zynerator.helper.ListUtil;


import ma.zs.easystock.infra.converter.stock.SortieProduitItemInfraConverter;
import ma.zs.easystock.infra.converter.stock.ProduitInfraConverter;
import ma.zs.easystock.infra.converter.commun.DepotInfraConverter;



import ma.zs.easystock.infra.bean.core.entree.SortieProduitEntity;
import ma.zs.easystock.domain.model.entree.SortieProduit;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class SortieProduitInfraConverter extends AbstractInfraConverter<SortieProduitEntity, SortieProduit> {

    @Autowired
    private SortieProduitItemInfraConverter sortieProduitItemConverter ;
    @Autowired
    private ProduitInfraConverter produitConverter ;
    @Autowired
    private DepotInfraConverter depotConverter ;
    private boolean depot;
    private boolean sortieProduitItems;

    public  SortieProduitInfraConverter(){
        super(SortieProduitEntity.class, SortieProduit.class);
        init(true);
    }

    @Override
    public SortieProduit toModel(SortieProduitEntity entity) {
        if (entity == null) {
            return null;
        } else {
        SortieProduit model = new SortieProduit();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getReference()))
                model.setReference(entity.getReference());
            if(StringUtil.isNotEmpty(entity.getDateSortieProduit()))
                model.setDateSortieProduit(DateUtil.stringEnToDate(entity.getDateSortieProduit()));
            if(StringUtil.isNotEmpty(entity.getDescription()))
                model.setDescription(entity.getDescription());
            if(this.depot && entity.getDepot()!=null &&  entity.getDepot().getId() != null)
                model.setDepot(depotConverter.toModel(entity.getDepot())) ;


            if(this.sortieProduitItems && ListUtil.isNotEmpty(entity.getSortieProduitItems()))
                model.setSortieProduitItems(sortieProduitItemConverter.toModel(entity.getSortieProduitItems()));


        return model;
        }
    }

    @Override
    public SortieProduitEntity toEntity(SortieProduit model) {
        if (model == null) {
            return null;
        } else {
            SortieProduitEntity entity = new SortieProduitEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getReference()))
             entity.setReference(model.getReference());
            if(model.getDateSortieProduit()!=null)
             entity.setDateSortieProduit(DateUtil.dateTimeToString(model.getDateSortieProduit()));
            if(StringUtil.isNotEmpty(model.getDescription()))
             entity.setDescription(model.getDescription());
        if(this.depot && model.getDepot()!=null) {
            entity.setDepot(depotConverter.toEntity(model.getDepot())) ;
        }
        if(this.sortieProduitItems && ListUtil.isNotEmpty(model.getSortieProduitItems())){
            sortieProduitItemConverter.init(true);
            sortieProduitItemConverter.setSortieProduit(false);
            entity.setSortieProduitItems(sortieProduitItemConverter.toEntity(model.getSortieProduitItems()));
            sortieProduitItemConverter.setSortieProduit(true);

        }


        return entity;
        }
    }

    public void initList(boolean value) {
        this.sortieProduitItems = value;
    }

    public void initObject(boolean value) {
        this.depot = value;
    }


    public SortieProduitItemInfraConverter getSortieProduitItemConverter(){
        return this.sortieProduitItemConverter;
    }
    public void setSortieProduitItemInfraConverter(SortieProduitItemInfraConverter sortieProduitItemConverter ){
        this.sortieProduitItemConverter = sortieProduitItemConverter;
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
    public boolean  isDepot(){
        return this.depot;
    }
    public void  setDepot(boolean depot){
        this.depot = depot;
    }
    public boolean  isSortieProduitItems(){
        return this.sortieProduitItems ;
    }
    public void  setSortieProduitItems(boolean sortieProduitItems ){
        this.sortieProduitItems  = sortieProduitItems ;
    }
}
