package  ma.zs.easystock.infra.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;

import ma.zs.easystock.zynerator.helper.ListUtil;


import ma.zs.easystock.infra.converter.stock.ProduitInfraConverter;
import ma.zs.easystock.infra.converter.gestionchequeffet.TransfertItemInfraConverter;
import ma.zs.easystock.infra.converter.Transfert.RaisonInfraConverter;
import ma.zs.easystock.infra.converter.commun.DepotInfraConverter;



import ma.zs.easystock.infra.bean.core.gestionchequeffet.TransfertEntity;
import ma.zs.easystock.domain.model.gestionchequeffet.Transfert;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class TransfertInfraConverter extends AbstractInfraConverter<TransfertEntity, Transfert> {

    @Autowired
    private ProduitInfraConverter produitConverter ;
    @Autowired
    private TransfertItemInfraConverter transfertItemConverter ;
    @Autowired
    private RaisonInfraConverter raisonConverter ;
    @Autowired
    private DepotInfraConverter depotConverter ;
    private boolean raison;
    private boolean transfertItems;

    public  TransfertInfraConverter(){
        super(TransfertEntity.class, Transfert.class);
        init(true);
    }

    @Override
    public Transfert toModel(TransfertEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Transfert model = new Transfert();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getReference()))
                model.setReference(entity.getReference());
            if(StringUtil.isNotEmpty(entity.getDateTransfert()))
                model.setDateTransfert(DateUtil.stringEnToDate(entity.getDateTransfert()));
            if(StringUtil.isNotEmpty(entity.getDescription()))
                model.setDescription(entity.getDescription());
            if(this.raison && entity.getRaison()!=null &&  entity.getRaison().getId() != null)
                model.setRaison(raisonConverter.toModel(entity.getRaison())) ;


            if(this.transfertItems && ListUtil.isNotEmpty(entity.getTransfertItems()))
                model.setTransfertItems(transfertItemConverter.toModel(entity.getTransfertItems()));


        return model;
        }
    }

    @Override
    public TransfertEntity toEntity(Transfert model) {
        if (model == null) {
            return null;
        } else {
            TransfertEntity entity = new TransfertEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getReference()))
             entity.setReference(model.getReference());
            if(model.getDateTransfert()!=null)
             entity.setDateTransfert(DateUtil.dateTimeToString(model.getDateTransfert()));
            if(StringUtil.isNotEmpty(model.getDescription()))
             entity.setDescription(model.getDescription());
        if(this.raison && model.getRaison()!=null) {
            entity.setRaison(raisonConverter.toEntity(model.getRaison())) ;
        }
        if(this.transfertItems && ListUtil.isNotEmpty(model.getTransfertItems())){
            transfertItemConverter.init(true);
            transfertItemConverter.setTransfert(false);
            entity.setTransfertItems(transfertItemConverter.toEntity(model.getTransfertItems()));
            transfertItemConverter.setTransfert(true);

        }


        return entity;
        }
    }

    public void initList(boolean value) {
        this.transfertItems = value;
    }

    public void initObject(boolean value) {
        this.raison = value;
    }


    public ProduitInfraConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitInfraConverter(ProduitInfraConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public TransfertItemInfraConverter getTransfertItemConverter(){
        return this.transfertItemConverter;
    }
    public void setTransfertItemInfraConverter(TransfertItemInfraConverter transfertItemConverter ){
        this.transfertItemConverter = transfertItemConverter;
    }
    public RaisonInfraConverter getRaisonConverter(){
        return this.raisonConverter;
    }
    public void setRaisonInfraConverter(RaisonInfraConverter raisonConverter ){
        this.raisonConverter = raisonConverter;
    }
    public DepotInfraConverter getDepotConverter(){
        return this.depotConverter;
    }
    public void setDepotInfraConverter(DepotInfraConverter depotConverter ){
        this.depotConverter = depotConverter;
    }
    public boolean  isRaison(){
        return this.raison;
    }
    public void  setRaison(boolean raison){
        this.raison = raison;
    }
    public boolean  isTransfertItems(){
        return this.transfertItems ;
    }
    public void  setTransfertItems(boolean transfertItems ){
        this.transfertItems  = transfertItems ;
    }
}
