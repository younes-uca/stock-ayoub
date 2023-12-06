package  ma.zs.easystock.infra.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;






import ma.zs.easystock.infra.bean.core.commun.EntrepriseSocieteEntity;
import ma.zs.easystock.domain.model.commun.EntrepriseSociete;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class EntrepriseSocieteInfraConverter extends AbstractInfraConverter<EntrepriseSocieteEntity, EntrepriseSociete> {


    public  EntrepriseSocieteInfraConverter(){
        super(EntrepriseSocieteEntity.class, EntrepriseSociete.class);
    }

    @Override
    public EntrepriseSociete toModel(EntrepriseSocieteEntity entity) {
        if (entity == null) {
            return null;
        } else {
        EntrepriseSociete model = new EntrepriseSociete();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getNom()))
                model.setNom(entity.getNom());
            if(StringUtil.isNotEmpty(entity.getIce()))
                model.setIce(entity.getIce());
            if(StringUtil.isNotEmpty(entity.getCapital()))
                model.setCapital(entity.getCapital());



        return model;
        }
    }

    @Override
    public EntrepriseSocieteEntity toEntity(EntrepriseSociete model) {
        if (model == null) {
            return null;
        } else {
            EntrepriseSocieteEntity entity = new EntrepriseSocieteEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getNom()))
             entity.setNom(model.getNom());
            if(StringUtil.isNotEmpty(model.getIce()))
             entity.setIce(model.getIce());
            if(StringUtil.isNotEmpty(model.getCapital()))
             entity.setCapital(model.getCapital());


        return entity;
        }
    }


    public void initObject(boolean value) {
    }


}
