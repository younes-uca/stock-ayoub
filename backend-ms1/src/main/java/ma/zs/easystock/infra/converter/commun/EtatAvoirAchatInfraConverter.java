package  ma.zs.easystock.infra.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;






import ma.zs.easystock.infra.bean.core.commun.EtatAvoirAchatEntity;
import ma.zs.easystock.domain.model.commun.EtatAvoirAchat;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class EtatAvoirAchatInfraConverter extends AbstractInfraConverter<EtatAvoirAchatEntity, EtatAvoirAchat> {


    public  EtatAvoirAchatInfraConverter(){
        super(EtatAvoirAchatEntity.class, EtatAvoirAchat.class);
    }

    @Override
    public EtatAvoirAchat toModel(EtatAvoirAchatEntity entity) {
        if (entity == null) {
            return null;
        } else {
        EtatAvoirAchat model = new EtatAvoirAchat();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getLibelle()))
                model.setLibelle(entity.getLibelle());



        return model;
        }
    }

    @Override
    public EtatAvoirAchatEntity toEntity(EtatAvoirAchat model) {
        if (model == null) {
            return null;
        } else {
            EtatAvoirAchatEntity entity = new EtatAvoirAchatEntity();
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
