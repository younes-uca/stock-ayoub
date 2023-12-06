package  ma.zs.easystock.infra.converter.entree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;

import ma.zs.easystock.zynerator.helper.ListUtil;


import ma.zs.easystock.infra.converter.stock.ProduitInfraConverter;
import ma.zs.easystock.infra.converter.stock.EntreeProduitItemInfraConverter;
import ma.zs.easystock.infra.converter.commun.DepotInfraConverter;
import ma.zs.easystock.infra.converter.commun.FournisseurInfraConverter;



import ma.zs.easystock.infra.bean.core.entree.EntreeProduitEntity;
import ma.zs.easystock.domain.model.entree.EntreeProduit;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class EntreeProduitInfraConverter extends AbstractInfraConverter<EntreeProduitEntity, EntreeProduit> {

    @Autowired
    private ProduitInfraConverter produitConverter ;
    @Autowired
    private EntreeProduitItemInfraConverter entreeProduitItemConverter ;
    @Autowired
    private DepotInfraConverter depotConverter ;
    @Autowired
    private FournisseurInfraConverter fournisseurConverter ;
    private boolean fournisseur;
    private boolean depot;
    private boolean entreeProduitItems;

    public  EntreeProduitInfraConverter(){
        super(EntreeProduitEntity.class, EntreeProduit.class);
        init(true);
    }

    @Override
    public EntreeProduit toModel(EntreeProduitEntity entity) {
        if (entity == null) {
            return null;
        } else {
        EntreeProduit model = new EntreeProduit();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getReference()))
                model.setReference(entity.getReference());
            if(StringUtil.isNotEmpty(entity.getDateEntreeProduit()))
                model.setDateEntreeProduit(DateUtil.stringEnToDate(entity.getDateEntreeProduit()));
            if(StringUtil.isNotEmpty(entity.getDescription()))
                model.setDescription(entity.getDescription());
            if(this.fournisseur && entity.getFournisseur()!=null &&  entity.getFournisseur().getId() != null)
                model.setFournisseur(fournisseurConverter.toModel(entity.getFournisseur())) ;

            if(this.depot && entity.getDepot()!=null &&  entity.getDepot().getId() != null)
                model.setDepot(depotConverter.toModel(entity.getDepot())) ;


            if(this.entreeProduitItems && ListUtil.isNotEmpty(entity.getEntreeProduitItems()))
                model.setEntreeProduitItems(entreeProduitItemConverter.toModel(entity.getEntreeProduitItems()));


        return model;
        }
    }

    @Override
    public EntreeProduitEntity toEntity(EntreeProduit model) {
        if (model == null) {
            return null;
        } else {
            EntreeProduitEntity entity = new EntreeProduitEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getReference()))
             entity.setReference(model.getReference());
            if(model.getDateEntreeProduit()!=null)
             entity.setDateEntreeProduit(DateUtil.dateTimeToString(model.getDateEntreeProduit()));
            if(StringUtil.isNotEmpty(model.getDescription()))
             entity.setDescription(model.getDescription());
        if(this.fournisseur && model.getFournisseur()!=null) {
            entity.setFournisseur(fournisseurConverter.toEntity(model.getFournisseur())) ;
        }
        if(this.depot && model.getDepot()!=null) {
            entity.setDepot(depotConverter.toEntity(model.getDepot())) ;
        }
        if(this.entreeProduitItems && ListUtil.isNotEmpty(model.getEntreeProduitItems())){
            entreeProduitItemConverter.init(true);
            entreeProduitItemConverter.setEntreeProduit(false);
            entity.setEntreeProduitItems(entreeProduitItemConverter.toEntity(model.getEntreeProduitItems()));
            entreeProduitItemConverter.setEntreeProduit(true);

        }


        return entity;
        }
    }

    public void initList(boolean value) {
        this.entreeProduitItems = value;
    }

    public void initObject(boolean value) {
        this.fournisseur = value;
        this.depot = value;
    }


    public ProduitInfraConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitInfraConverter(ProduitInfraConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public EntreeProduitItemInfraConverter getEntreeProduitItemConverter(){
        return this.entreeProduitItemConverter;
    }
    public void setEntreeProduitItemInfraConverter(EntreeProduitItemInfraConverter entreeProduitItemConverter ){
        this.entreeProduitItemConverter = entreeProduitItemConverter;
    }
    public DepotInfraConverter getDepotConverter(){
        return this.depotConverter;
    }
    public void setDepotInfraConverter(DepotInfraConverter depotConverter ){
        this.depotConverter = depotConverter;
    }
    public FournisseurInfraConverter getFournisseurConverter(){
        return this.fournisseurConverter;
    }
    public void setFournisseurInfraConverter(FournisseurInfraConverter fournisseurConverter ){
        this.fournisseurConverter = fournisseurConverter;
    }
    public boolean  isFournisseur(){
        return this.fournisseur;
    }
    public void  setFournisseur(boolean fournisseur){
        this.fournisseur = fournisseur;
    }
    public boolean  isDepot(){
        return this.depot;
    }
    public void  setDepot(boolean depot){
        this.depot = depot;
    }
    public boolean  isEntreeProduitItems(){
        return this.entreeProduitItems ;
    }
    public void  setEntreeProduitItems(boolean entreeProduitItems ){
        this.entreeProduitItems  = entreeProduitItems ;
    }
}
