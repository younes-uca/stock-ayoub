package  ma.zs.easystock.infra.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;

import ma.zs.easystock.zynerator.helper.ListUtil;


import ma.zs.easystock.infra.converter.stock.ProduitInfraConverter;
import ma.zs.easystock.infra.converter.stock.InventaireItemInfraConverter;
import ma.zs.easystock.infra.converter.commun.EntrepriseSocieteInfraConverter;
import ma.zs.easystock.infra.converter.commun.DepotInfraConverter;



import ma.zs.easystock.infra.bean.core.stock.InventaireEntity;
import ma.zs.easystock.domain.model.stock.Inventaire;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class InventaireInfraConverter extends AbstractInfraConverter<InventaireEntity, Inventaire> {

    @Autowired
    private ProduitInfraConverter produitConverter ;
    @Autowired
    private InventaireItemInfraConverter inventaireItemConverter ;
    @Autowired
    private EntrepriseSocieteInfraConverter entrepriseSocieteConverter ;
    @Autowired
    private DepotInfraConverter depotConverter ;
    private boolean entrepriseSociete;
    private boolean depot;
    private boolean inventaireItems;

    public  InventaireInfraConverter(){
        super(InventaireEntity.class, Inventaire.class);
        init(true);
    }

    @Override
    public Inventaire toModel(InventaireEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Inventaire model = new Inventaire();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getReference()))
                model.setReference(entity.getReference());
            if(StringUtil.isNotEmpty(entity.getDateInventaire()))
                model.setDateInventaire(DateUtil.stringEnToDate(entity.getDateInventaire()));
            if(StringUtil.isNotEmpty(entity.getDescription()))
                model.setDescription(entity.getDescription());
            if(this.entrepriseSociete && entity.getEntrepriseSociete()!=null &&  entity.getEntrepriseSociete().getId() != null)
                model.setEntrepriseSociete(entrepriseSocieteConverter.toModel(entity.getEntrepriseSociete())) ;

            if(this.depot && entity.getDepot()!=null &&  entity.getDepot().getId() != null)
                model.setDepot(depotConverter.toModel(entity.getDepot())) ;


            if(this.inventaireItems && ListUtil.isNotEmpty(entity.getInventaireItems()))
                model.setInventaireItems(inventaireItemConverter.toModel(entity.getInventaireItems()));


        return model;
        }
    }

    @Override
    public InventaireEntity toEntity(Inventaire model) {
        if (model == null) {
            return null;
        } else {
            InventaireEntity entity = new InventaireEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getReference()))
             entity.setReference(model.getReference());
            if(model.getDateInventaire()!=null)
             entity.setDateInventaire(DateUtil.dateTimeToString(model.getDateInventaire()));
            if(StringUtil.isNotEmpty(model.getDescription()))
             entity.setDescription(model.getDescription());
        if(this.entrepriseSociete && model.getEntrepriseSociete()!=null) {
            entity.setEntrepriseSociete(entrepriseSocieteConverter.toEntity(model.getEntrepriseSociete())) ;
        }
        if(this.depot && model.getDepot()!=null) {
            entity.setDepot(depotConverter.toEntity(model.getDepot())) ;
        }
        if(this.inventaireItems && ListUtil.isNotEmpty(model.getInventaireItems())){
            inventaireItemConverter.init(true);
            inventaireItemConverter.setInventaire(false);
            entity.setInventaireItems(inventaireItemConverter.toEntity(model.getInventaireItems()));
            inventaireItemConverter.setInventaire(true);

        }


        return entity;
        }
    }

    public void initList(boolean value) {
        this.inventaireItems = value;
    }

    public void initObject(boolean value) {
        this.entrepriseSociete = value;
        this.depot = value;
    }


    public ProduitInfraConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitInfraConverter(ProduitInfraConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public InventaireItemInfraConverter getInventaireItemConverter(){
        return this.inventaireItemConverter;
    }
    public void setInventaireItemInfraConverter(InventaireItemInfraConverter inventaireItemConverter ){
        this.inventaireItemConverter = inventaireItemConverter;
    }
    public EntrepriseSocieteInfraConverter getEntrepriseSocieteConverter(){
        return this.entrepriseSocieteConverter;
    }
    public void setEntrepriseSocieteInfraConverter(EntrepriseSocieteInfraConverter entrepriseSocieteConverter ){
        this.entrepriseSocieteConverter = entrepriseSocieteConverter;
    }
    public DepotInfraConverter getDepotConverter(){
        return this.depotConverter;
    }
    public void setDepotInfraConverter(DepotInfraConverter depotConverter ){
        this.depotConverter = depotConverter;
    }
    public boolean  isEntrepriseSociete(){
        return this.entrepriseSociete;
    }
    public void  setEntrepriseSociete(boolean entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public boolean  isDepot(){
        return this.depot;
    }
    public void  setDepot(boolean depot){
        this.depot = depot;
    }
    public boolean  isInventaireItems(){
        return this.inventaireItems ;
    }
    public void  setInventaireItems(boolean inventaireItems ){
        this.inventaireItems  = inventaireItems ;
    }
}
