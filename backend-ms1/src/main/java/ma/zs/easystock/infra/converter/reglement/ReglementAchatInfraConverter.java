package  ma.zs.easystock.infra.converter.reglement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;



import ma.zs.easystock.infra.converter.stock.AchatInfraConverter;
import ma.zs.easystock.infra.converter.commun.ModeReglementInfraConverter;

import ma.zs.easystock.infra.bean.core.stock.AchatEntity;
import ma.zs.easystock.domain.model.stock.Achat;


import ma.zs.easystock.infra.bean.core.reglement.ReglementAchatEntity;
import ma.zs.easystock.domain.model.reglement.ReglementAchat;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class ReglementAchatInfraConverter extends AbstractInfraConverter<ReglementAchatEntity, ReglementAchat> {

    @Autowired
    private AchatInfraConverter achatConverter ;
    @Autowired
    private ModeReglementInfraConverter modeReglementConverter ;
    private boolean achat;
    private boolean modeReglement;

    public  ReglementAchatInfraConverter(){
        super(ReglementAchatEntity.class, ReglementAchat.class);
    }

    @Override
    public ReglementAchat toModel(ReglementAchatEntity entity) {
        if (entity == null) {
            return null;
        } else {
        ReglementAchat model = new ReglementAchat();
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




        return model;
        }
    }

    @Override
    public ReglementAchatEntity toEntity(ReglementAchat model) {
        if (model == null) {
            return null;
        } else {
            ReglementAchatEntity entity = new ReglementAchatEntity();
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


        return entity;
        }
    }


    public void initObject(boolean value) {
        this.achat = value;
        this.modeReglement = value;
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
}
