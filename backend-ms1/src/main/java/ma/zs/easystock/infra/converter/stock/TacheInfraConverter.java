package  ma.zs.easystock.infra.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;



import ma.zs.easystock.infra.converter.commun.CollaborateurInfraConverter;



import ma.zs.easystock.infra.bean.core.stock.TacheEntity;
import ma.zs.easystock.domain.model.stock.Tache;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class TacheInfraConverter extends AbstractInfraConverter<TacheEntity, Tache> {

    @Autowired
    private CollaborateurInfraConverter collaborateurConverter ;
    private boolean lierA;

    public  TacheInfraConverter(){
        super(TacheEntity.class, Tache.class);
    }

    @Override
    public Tache toModel(TacheEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Tache model = new Tache();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getDateDebut()))
                model.setDateDebut(DateUtil.stringEnToDate(entity.getDateDebut()));
            if(StringUtil.isNotEmpty(entity.getDateFin()))
                model.setDateFin(DateUtil.stringEnToDate(entity.getDateFin()));
            if(StringUtil.isNotEmpty(entity.getDescription()))
                model.setDescription(entity.getDescription());
            if(this.lierA && entity.getLierA()!=null &&  entity.getLierA().getId() != null)
                model.setLierA(collaborateurConverter.toModel(entity.getLierA())) ;




        return model;
        }
    }

    @Override
    public TacheEntity toEntity(Tache model) {
        if (model == null) {
            return null;
        } else {
            TacheEntity entity = new TacheEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(model.getDateDebut()!=null)
             entity.setDateDebut(DateUtil.dateTimeToString(model.getDateDebut()));
            if(model.getDateFin()!=null)
             entity.setDateFin(DateUtil.dateTimeToString(model.getDateFin()));
            if(StringUtil.isNotEmpty(model.getDescription()))
             entity.setDescription(model.getDescription());
        if(this.lierA && model.getLierA()!=null) {
            entity.setLierA(collaborateurConverter.toEntity(model.getLierA())) ;
        }


        return entity;
        }
    }


    public void initObject(boolean value) {
        this.lierA = value;
    }


    public CollaborateurInfraConverter getCollaborateurConverter(){
        return this.collaborateurConverter;
    }
    public void setCollaborateurInfraConverter(CollaborateurInfraConverter collaborateurConverter ){
        this.collaborateurConverter = collaborateurConverter;
    }
    public boolean  isLierA(){
        return this.lierA;
    }
    public void  setLierA(boolean lierA){
        this.lierA = lierA;
    }
}
