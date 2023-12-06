package  ma.zs.easystock.infra.converter.Transfert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;






import ma.zs.easystock.infra.bean.core.Transfert.RaisonEntity;
import ma.zs.easystock.domain.model.Transfert.Raison;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class RaisonInfraConverter extends AbstractInfraConverter<RaisonEntity, Raison> {


    public  RaisonInfraConverter(){
        super(RaisonEntity.class, Raison.class);
    }

    @Override
    public Raison toModel(RaisonEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Raison model = new Raison();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getLibelle()))
                model.setLibelle(entity.getLibelle());



        return model;
        }
    }

    @Override
    public RaisonEntity toEntity(Raison model) {
        if (model == null) {
            return null;
        } else {
            RaisonEntity entity = new RaisonEntity();
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
