package  ma.zs.easystock.infra.converter.chequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;



import ma.zs.easystock.infra.converter.gestionchequeffet.ChequeEffetInfraConverter;
import ma.zs.easystock.infra.converter.gestionchequeffet.TypeInstrumentInfraConverter;



import ma.zs.easystock.infra.bean.core.chequeffet.InstrumentEntity;
import ma.zs.easystock.domain.model.chequeffet.Instrument;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class InstrumentInfraConverter extends AbstractInfraConverter<InstrumentEntity, Instrument> {

    @Autowired
    private ChequeEffetInfraConverter chequeEffetConverter ;
    @Autowired
    private TypeInstrumentInfraConverter typeInstrumentConverter ;
    private boolean typeInstrument;
    private boolean chequeEffet;

    public  InstrumentInfraConverter(){
        super(InstrumentEntity.class, Instrument.class);
    }

    @Override
    public Instrument toModel(InstrumentEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Instrument model = new Instrument();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getDateEmission()))
                model.setDateEmission(DateUtil.stringEnToDate(entity.getDateEmission()));
            if(StringUtil.isNotEmpty(entity.getMontant()))
                model.setMontant(entity.getMontant());
            if(this.typeInstrument && entity.getTypeInstrument()!=null &&  entity.getTypeInstrument().getId() != null)
                model.setTypeInstrument(typeInstrumentConverter.toModel(entity.getTypeInstrument())) ;

            if(this.chequeEffet && entity.getChequeEffet()!=null &&  entity.getChequeEffet().getId() != null)
                model.setChequeEffet(chequeEffetConverter.toModel(entity.getChequeEffet())) ;




        return model;
        }
    }

    @Override
    public InstrumentEntity toEntity(Instrument model) {
        if (model == null) {
            return null;
        } else {
            InstrumentEntity entity = new InstrumentEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(model.getDateEmission()!=null)
             entity.setDateEmission(DateUtil.dateTimeToString(model.getDateEmission()));
            if(StringUtil.isNotEmpty(model.getMontant()))
             entity.setMontant(model.getMontant());
        if(this.typeInstrument && model.getTypeInstrument()!=null) {
            entity.setTypeInstrument(typeInstrumentConverter.toEntity(model.getTypeInstrument())) ;
        }
        if(this.chequeEffet && model.getChequeEffet()!=null) {
            entity.setChequeEffet(chequeEffetConverter.toEntity(model.getChequeEffet())) ;
        }


        return entity;
        }
    }


    public void initObject(boolean value) {
        this.typeInstrument = value;
        this.chequeEffet = value;
    }


    public ChequeEffetInfraConverter getChequeEffetConverter(){
        return this.chequeEffetConverter;
    }
    public void setChequeEffetInfraConverter(ChequeEffetInfraConverter chequeEffetConverter ){
        this.chequeEffetConverter = chequeEffetConverter;
    }
    public TypeInstrumentInfraConverter getTypeInstrumentConverter(){
        return this.typeInstrumentConverter;
    }
    public void setTypeInstrumentInfraConverter(TypeInstrumentInfraConverter typeInstrumentConverter ){
        this.typeInstrumentConverter = typeInstrumentConverter;
    }
    public boolean  isTypeInstrument(){
        return this.typeInstrument;
    }
    public void  setTypeInstrument(boolean typeInstrument){
        this.typeInstrument = typeInstrument;
    }
    public boolean  isChequeEffet(){
        return this.chequeEffet;
    }
    public void  setChequeEffet(boolean chequeEffet){
        this.chequeEffet = chequeEffet;
    }
}
