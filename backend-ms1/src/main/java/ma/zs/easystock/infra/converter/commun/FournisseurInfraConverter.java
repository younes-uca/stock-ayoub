package  ma.zs.easystock.infra.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;






import ma.zs.easystock.infra.bean.core.commun.FournisseurEntity;
import ma.zs.easystock.domain.model.commun.Fournisseur;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class FournisseurInfraConverter extends AbstractInfraConverter<FournisseurEntity, Fournisseur> {


    public  FournisseurInfraConverter(){
        super(FournisseurEntity.class, Fournisseur.class);
    }

    @Override
    public Fournisseur toModel(FournisseurEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Fournisseur model = new Fournisseur();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getIce()))
                model.setIce(entity.getIce());



        return model;
        }
    }

    @Override
    public FournisseurEntity toEntity(Fournisseur model) {
        if (model == null) {
            return null;
        } else {
            FournisseurEntity entity = new FournisseurEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getIce()))
             entity.setIce(model.getIce());


        return entity;
        }
    }


    public void initObject(boolean value) {
    }


}
