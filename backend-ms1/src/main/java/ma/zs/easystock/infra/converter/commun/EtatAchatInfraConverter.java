package  ma.zs.easystock.infra.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;






import ma.zs.easystock.infra.bean.core.commun.EtatAchatEntity;
import ma.zs.easystock.domain.model.commun.EtatAchat;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class EtatAchatInfraConverter extends AbstractInfraConverter<EtatAchatEntity, EtatAchat> {


    public  EtatAchatInfraConverter(){
        super(EtatAchatEntity.class, EtatAchat.class);
    }

    @Override
    public EtatAchat toModel(EtatAchatEntity entity) {
        if (entity == null) {
            return null;
        } else {
        EtatAchat model = new EtatAchat();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getLibelle()))
                model.setLibelle(entity.getLibelle());



        return model;
        }
    }

    @Override
    public EtatAchatEntity toEntity(EtatAchat model) {
        if (model == null) {
            return null;
        } else {
            EtatAchatEntity entity = new EtatAchatEntity();
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
