package  ma.zs.easystock.infra.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;






import ma.zs.easystock.infra.bean.core.stock.TaxeEntity;
import ma.zs.easystock.domain.model.stock.Taxe;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class TaxeInfraConverter extends AbstractInfraConverter<TaxeEntity, Taxe> {


    public  TaxeInfraConverter(){
        super(TaxeEntity.class, Taxe.class);
    }

    @Override
    public Taxe toModel(TaxeEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Taxe model = new Taxe();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getLibelle()))
                model.setLibelle(entity.getLibelle());



        return model;
        }
    }

    @Override
    public TaxeEntity toEntity(Taxe model) {
        if (model == null) {
            return null;
        } else {
            TaxeEntity entity = new TaxeEntity();
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
