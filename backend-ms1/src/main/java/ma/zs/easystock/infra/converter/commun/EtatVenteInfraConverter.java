package  ma.zs.easystock.infra.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;






import ma.zs.easystock.infra.bean.core.commun.EtatVenteEntity;
import ma.zs.easystock.domain.model.commun.EtatVente;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class EtatVenteInfraConverter extends AbstractInfraConverter<EtatVenteEntity, EtatVente> {


    public  EtatVenteInfraConverter(){
        super(EtatVenteEntity.class, EtatVente.class);
    }

    @Override
    public EtatVente toModel(EtatVenteEntity entity) {
        if (entity == null) {
            return null;
        } else {
        EtatVente model = new EtatVente();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getLibelle()))
                model.setLibelle(entity.getLibelle());



        return model;
        }
    }

    @Override
    public EtatVenteEntity toEntity(EtatVente model) {
        if (model == null) {
            return null;
        } else {
            EtatVenteEntity entity = new EtatVenteEntity();
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
