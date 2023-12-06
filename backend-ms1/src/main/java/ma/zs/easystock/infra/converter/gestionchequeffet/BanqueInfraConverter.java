package  ma.zs.easystock.infra.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;






import ma.zs.easystock.infra.bean.core.gestionchequeffet.BanqueEntity;
import ma.zs.easystock.domain.model.gestionchequeffet.Banque;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class BanqueInfraConverter extends AbstractInfraConverter<BanqueEntity, Banque> {


    public  BanqueInfraConverter(){
        super(BanqueEntity.class, Banque.class);
    }

    @Override
    public Banque toModel(BanqueEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Banque model = new Banque();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getLibelle()))
                model.setLibelle(entity.getLibelle());



        return model;
        }
    }

    @Override
    public BanqueEntity toEntity(Banque model) {
        if (model == null) {
            return null;
        } else {
            BanqueEntity entity = new BanqueEntity();
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
