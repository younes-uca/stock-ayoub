package  ma.zs.easystock.infra.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;






import ma.zs.easystock.infra.bean.core.commun.CategorieEntity;
import ma.zs.easystock.domain.model.commun.Categorie;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class CategorieInfraConverter extends AbstractInfraConverter<CategorieEntity, Categorie> {


    public  CategorieInfraConverter(){
        super(CategorieEntity.class, Categorie.class);
    }

    @Override
    public Categorie toModel(CategorieEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Categorie model = new Categorie();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getLibelle()))
                model.setLibelle(entity.getLibelle());



        return model;
        }
    }

    @Override
    public CategorieEntity toEntity(Categorie model) {
        if (model == null) {
            return null;
        } else {
            CategorieEntity entity = new CategorieEntity();
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
