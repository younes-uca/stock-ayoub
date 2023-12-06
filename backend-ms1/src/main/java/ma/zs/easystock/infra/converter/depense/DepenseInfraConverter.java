package  ma.zs.easystock.infra.converter.depense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;






import ma.zs.easystock.infra.bean.core.depense.DepenseEntity;
import ma.zs.easystock.domain.model.depense.Depense;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class DepenseInfraConverter extends AbstractInfraConverter<DepenseEntity, Depense> {


    public  DepenseInfraConverter(){
        super(DepenseEntity.class, Depense.class);
    }

    @Override
    public Depense toModel(DepenseEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Depense model = new Depense();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getDateDepense()))
                model.setDateDepense(DateUtil.stringEnToDate(entity.getDateDepense()));
            if(StringUtil.isNotEmpty(entity.getLibelle()))
                model.setLibelle(entity.getLibelle());
            if(StringUtil.isNotEmpty(entity.getMontant()))
                model.setMontant(entity.getMontant());
            if(StringUtil.isNotEmpty(entity.getDescription()))
                model.setDescription(entity.getDescription());



        return model;
        }
    }

    @Override
    public DepenseEntity toEntity(Depense model) {
        if (model == null) {
            return null;
        } else {
            DepenseEntity entity = new DepenseEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(model.getDateDepense()!=null)
             entity.setDateDepense(DateUtil.dateTimeToString(model.getDateDepense()));
            if(StringUtil.isNotEmpty(model.getLibelle()))
             entity.setLibelle(model.getLibelle());
            if(StringUtil.isNotEmpty(model.getMontant()))
             entity.setMontant(model.getMontant());
            if(StringUtil.isNotEmpty(model.getDescription()))
             entity.setDescription(model.getDescription());


        return entity;
        }
    }


    public void initObject(boolean value) {
    }


}
