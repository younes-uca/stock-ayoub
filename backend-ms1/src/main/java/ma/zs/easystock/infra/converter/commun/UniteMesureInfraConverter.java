package  ma.zs.easystock.infra.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;






import ma.zs.easystock.infra.bean.core.commun.UniteMesureEntity;
import ma.zs.easystock.domain.model.commun.UniteMesure;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class UniteMesureInfraConverter extends AbstractInfraConverter<UniteMesureEntity, UniteMesure> {


    public  UniteMesureInfraConverter(){
        super(UniteMesureEntity.class, UniteMesure.class);
    }

    @Override
    public UniteMesure toModel(UniteMesureEntity entity) {
        if (entity == null) {
            return null;
        } else {
        UniteMesure model = new UniteMesure();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getLibelle()))
                model.setLibelle(entity.getLibelle());



        return model;
        }
    }

    @Override
    public UniteMesureEntity toEntity(UniteMesure model) {
        if (model == null) {
            return null;
        } else {
            UniteMesureEntity entity = new UniteMesureEntity();
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
