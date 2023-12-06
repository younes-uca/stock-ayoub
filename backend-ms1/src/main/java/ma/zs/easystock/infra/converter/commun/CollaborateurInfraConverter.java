package  ma.zs.easystock.infra.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;






import ma.zs.easystock.infra.bean.core.commun.CollaborateurEntity;
import ma.zs.easystock.domain.model.commun.Collaborateur;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class CollaborateurInfraConverter extends AbstractInfraConverter<CollaborateurEntity, Collaborateur> {


    public  CollaborateurInfraConverter(){
        super(CollaborateurEntity.class, Collaborateur.class);
    }

    @Override
    public Collaborateur toModel(CollaborateurEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Collaborateur model = new Collaborateur();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getPrenom()))
                model.setPrenom(entity.getPrenom());



        return model;
        }
    }

    @Override
    public CollaborateurEntity toEntity(Collaborateur model) {
        if (model == null) {
            return null;
        } else {
            CollaborateurEntity entity = new CollaborateurEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getPrenom()))
             entity.setPrenom(model.getPrenom());


        return entity;
        }
    }


    public void initObject(boolean value) {
    }


}
