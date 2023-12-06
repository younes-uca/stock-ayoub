package  ma.zs.easystock.infra.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;






import ma.zs.easystock.infra.bean.core.gestionchequeffet.TypeTransactionEntity;
import ma.zs.easystock.domain.model.gestionchequeffet.TypeTransaction;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class TypeTransactionInfraConverter extends AbstractInfraConverter<TypeTransactionEntity, TypeTransaction> {


    public  TypeTransactionInfraConverter(){
        super(TypeTransactionEntity.class, TypeTransaction.class);
    }

    @Override
    public TypeTransaction toModel(TypeTransactionEntity entity) {
        if (entity == null) {
            return null;
        } else {
        TypeTransaction model = new TypeTransaction();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getLibelle()))
                model.setLibelle(entity.getLibelle());



        return model;
        }
    }

    @Override
    public TypeTransactionEntity toEntity(TypeTransaction model) {
        if (model == null) {
            return null;
        } else {
            TypeTransactionEntity entity = new TypeTransactionEntity();
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
