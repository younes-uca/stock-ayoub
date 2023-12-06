package  ma.zs.easystock.infra.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;






import ma.zs.easystock.infra.bean.core.commun.EtatAvoirVenteEntity;
import ma.zs.easystock.domain.model.commun.EtatAvoirVente;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class EtatAvoirVenteInfraConverter extends AbstractInfraConverter<EtatAvoirVenteEntity, EtatAvoirVente> {


    public  EtatAvoirVenteInfraConverter(){
        super(EtatAvoirVenteEntity.class, EtatAvoirVente.class);
    }

    @Override
    public EtatAvoirVente toModel(EtatAvoirVenteEntity entity) {
        if (entity == null) {
            return null;
        } else {
        EtatAvoirVente model = new EtatAvoirVente();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getLibelle()))
                model.setLibelle(entity.getLibelle());



        return model;
        }
    }

    @Override
    public EtatAvoirVenteEntity toEntity(EtatAvoirVente model) {
        if (model == null) {
            return null;
        } else {
            EtatAvoirVenteEntity entity = new EtatAvoirVenteEntity();
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
