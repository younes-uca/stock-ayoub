package  ma.zs.easystock.infra.converter.reglement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;



import ma.zs.easystock.infra.converter.stock.AchatInfraConverter;
import ma.zs.easystock.infra.converter.commun.ModeReglementInfraConverter;
import ma.zs.easystock.infra.converter.stock.AvoirAchatInfraConverter;

import ma.zs.easystock.infra.bean.core.stock.AchatEntity;
import ma.zs.easystock.domain.model.stock.Achat;
import ma.zs.easystock.infra.bean.core.stock.AvoirAchatEntity;
import ma.zs.easystock.domain.model.stock.AvoirAchat;


import ma.zs.easystock.infra.bean.core.reglement.ReglementAvoirAchatEntity;
import ma.zs.easystock.domain.model.reglement.ReglementAvoirAchat;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class ReglementAvoirAchatInfraConverter extends AbstractInfraConverter<ReglementAvoirAchatEntity, ReglementAvoirAchat> {

    @Autowired
    private AchatInfraConverter achatConverter ;
    @Autowired
    private ModeReglementInfraConverter modeReglementConverter ;
    @Autowired
    private AvoirAchatInfraConverter avoirAchatConverter ;
    private boolean achat;
    private boolean modeReglement;
    private boolean avoirAchat;

    public  ReglementAvoirAchatInfraConverter(){
        super(ReglementAvoirAchatEntity.class, ReglementAvoirAchat.class);
    }

    @Override
    public ReglementAvoirAchat toModel(ReglementAvoirAchatEntity entity) {
        if (entity == null) {
            return null;
        } else {
        ReglementAvoirAchat model = new ReglementAvoirAchat();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getReference()))
                model.setReference(entity.getReference());
            if(StringUtil.isNotEmpty(entity.getDateReglement()))
                model.setDateReglement(DateUtil.stringEnToDate(entity.getDateReglement()));
            if(StringUtil.isNotEmpty(entity.getMontant()))
                model.setMontant(entity.getMontant());
            if(StringUtil.isNotEmpty(entity.getDescription()))
                model.setDescription(entity.getDescription());
            if(entity.getAchat() != null && entity.getAchat().getId() != null){
                model.setAchat(new Achat());
                model.getAchat().setId(entity.getAchat().getId());
                model.getAchat().setId(entity.getAchat().getId());
            }

            if(this.modeReglement && entity.getModeReglement()!=null &&  entity.getModeReglement().getId() != null)
                model.setModeReglement(modeReglementConverter.toModel(entity.getModeReglement())) ;

            if(entity.getAvoirAchat() != null && entity.getAvoirAchat().getId() != null){
                model.setAvoirAchat(new AvoirAchat());
                model.getAvoirAchat().setId(entity.getAvoirAchat().getId());
                model.getAvoirAchat().setNumeroFactureAvoirAchat(entity.getAvoirAchat().getNumeroFactureAvoirAchat());
            }




        return model;
        }
    }

    @Override
    public ReglementAvoirAchatEntity toEntity(ReglementAvoirAchat model) {
        if (model == null) {
            return null;
        } else {
            ReglementAvoirAchatEntity entity = new ReglementAvoirAchatEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getReference()))
             entity.setReference(model.getReference());
            if(model.getDateReglement()!=null)
             entity.setDateReglement(DateUtil.dateTimeToString(model.getDateReglement()));
            if(StringUtil.isNotEmpty(model.getMontant()))
             entity.setMontant(model.getMontant());
            if(StringUtil.isNotEmpty(model.getDescription()))
             entity.setDescription(model.getDescription());
        if(this.achat && model.getAchat()!=null) {
            entity.setAchat(achatConverter.toEntity(model.getAchat())) ;
        }
        if(this.modeReglement && model.getModeReglement()!=null) {
            entity.setModeReglement(modeReglementConverter.toEntity(model.getModeReglement())) ;
        }
        if(this.avoirAchat && model.getAvoirAchat()!=null) {
            entity.setAvoirAchat(avoirAchatConverter.toEntity(model.getAvoirAchat())) ;
        }


        return entity;
        }
    }


    public void initObject(boolean value) {
        this.achat = value;
        this.modeReglement = value;
        this.avoirAchat = value;
    }


    public AchatInfraConverter getAchatConverter(){
        return this.achatConverter;
    }
    public void setAchatInfraConverter(AchatInfraConverter achatConverter ){
        this.achatConverter = achatConverter;
    }
    public ModeReglementInfraConverter getModeReglementConverter(){
        return this.modeReglementConverter;
    }
    public void setModeReglementInfraConverter(ModeReglementInfraConverter modeReglementConverter ){
        this.modeReglementConverter = modeReglementConverter;
    }
    public AvoirAchatInfraConverter getAvoirAchatConverter(){
        return this.avoirAchatConverter;
    }
    public void setAvoirAchatInfraConverter(AvoirAchatInfraConverter avoirAchatConverter ){
        this.avoirAchatConverter = avoirAchatConverter;
    }
    public boolean  isAchat(){
        return this.achat;
    }
    public void  setAchat(boolean achat){
        this.achat = achat;
    }
    public boolean  isModeReglement(){
        return this.modeReglement;
    }
    public void  setModeReglement(boolean modeReglement){
        this.modeReglement = modeReglement;
    }
    public boolean  isAvoirAchat(){
        return this.avoirAchat;
    }
    public void  setAvoirAchat(boolean avoirAchat){
        this.avoirAchat = avoirAchat;
    }
}
