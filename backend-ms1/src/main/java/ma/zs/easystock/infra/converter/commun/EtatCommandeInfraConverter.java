package  ma.zs.easystock.infra.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;






import ma.zs.easystock.infra.bean.core.commun.EtatCommandeEntity;
import ma.zs.easystock.domain.model.commun.EtatCommande;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class EtatCommandeInfraConverter extends AbstractInfraConverter<EtatCommandeEntity, EtatCommande> {


    public  EtatCommandeInfraConverter(){
        super(EtatCommandeEntity.class, EtatCommande.class);
    }

    @Override
    public EtatCommande toModel(EtatCommandeEntity entity) {
        if (entity == null) {
            return null;
        } else {
        EtatCommande model = new EtatCommande();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getLibelle()))
                model.setLibelle(entity.getLibelle());



        return model;
        }
    }

    @Override
    public EtatCommandeEntity toEntity(EtatCommande model) {
        if (model == null) {
            return null;
        } else {
            EtatCommandeEntity entity = new EtatCommandeEntity();
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
