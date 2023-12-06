package  ma.zs.easystock.infra.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;






import ma.zs.easystock.infra.bean.core.commun.ModeReglementEntity;
import ma.zs.easystock.domain.model.commun.ModeReglement;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class ModeReglementInfraConverter extends AbstractInfraConverter<ModeReglementEntity, ModeReglement> {


    public  ModeReglementInfraConverter(){
        super(ModeReglementEntity.class, ModeReglement.class);
    }

    @Override
    public ModeReglement toModel(ModeReglementEntity entity) {
        if (entity == null) {
            return null;
        } else {
        ModeReglement model = new ModeReglement();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getLibelle()))
                model.setLibelle(entity.getLibelle());



        return model;
        }
    }

    @Override
    public ModeReglementEntity toEntity(ModeReglement model) {
        if (model == null) {
            return null;
        } else {
            ModeReglementEntity entity = new ModeReglementEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getLibelle()))
             entity.setLibelle(model.getLibelle());


        return entity;
        }
    }


    public void initObject(boolean value) {
    }


}
