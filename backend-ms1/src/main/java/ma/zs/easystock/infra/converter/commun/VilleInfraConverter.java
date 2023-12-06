package  ma.zs.easystock.infra.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;






import ma.zs.easystock.infra.bean.core.commun.VilleEntity;
import ma.zs.easystock.domain.model.commun.Ville;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class VilleInfraConverter extends AbstractInfraConverter<VilleEntity, Ville> {


    public  VilleInfraConverter(){
        super(VilleEntity.class, Ville.class);
    }

    @Override
    public Ville toModel(VilleEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Ville model = new Ville();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getLibelle()))
                model.setLibelle(entity.getLibelle());



        return model;
        }
    }

    @Override
    public VilleEntity toEntity(Ville model) {
        if (model == null) {
            return null;
        } else {
            VilleEntity entity = new VilleEntity();
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
