package  ma.zs.easystock.infra.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;






import ma.zs.easystock.infra.bean.core.commun.MarqueEntity;
import ma.zs.easystock.domain.model.commun.Marque;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class MarqueInfraConverter extends AbstractInfraConverter<MarqueEntity, Marque> {


    public  MarqueInfraConverter(){
        super(MarqueEntity.class, Marque.class);
    }

    @Override
    public Marque toModel(MarqueEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Marque model = new Marque();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getLibelle()))
                model.setLibelle(entity.getLibelle());



        return model;
        }
    }

    @Override
    public MarqueEntity toEntity(Marque model) {
        if (model == null) {
            return null;
        } else {
            MarqueEntity entity = new MarqueEntity();
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
