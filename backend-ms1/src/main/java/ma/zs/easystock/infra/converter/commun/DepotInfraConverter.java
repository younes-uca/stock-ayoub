package  ma.zs.easystock.infra.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;






import ma.zs.easystock.infra.bean.core.commun.DepotEntity;
import ma.zs.easystock.domain.model.commun.Depot;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class DepotInfraConverter extends AbstractInfraConverter<DepotEntity, Depot> {


    public  DepotInfraConverter(){
        super(DepotEntity.class, Depot.class);
    }

    @Override
    public Depot toModel(DepotEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Depot model = new Depot();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getLibelle()))
                model.setLibelle(entity.getLibelle());
            if(StringUtil.isNotEmpty(entity.getAdresse()))
                model.setAdresse(entity.getAdresse());



        return model;
        }
    }

    @Override
    public DepotEntity toEntity(Depot model) {
        if (model == null) {
            return null;
        } else {
            DepotEntity entity = new DepotEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getLibelle()))
             entity.setLibelle(model.getLibelle());
            if(StringUtil.isNotEmpty(model.getAdresse()))
             entity.setAdresse(model.getAdresse());


        return entity;
        }
    }


    public void initObject(boolean value) {
    }


}
