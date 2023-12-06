package  ma.zs.easystock.infra.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;






import ma.zs.easystock.infra.bean.core.gestionchequeffet.TypeInstrumentEntity;
import ma.zs.easystock.domain.model.gestionchequeffet.TypeInstrument;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class TypeInstrumentInfraConverter extends AbstractInfraConverter<TypeInstrumentEntity, TypeInstrument> {


    public  TypeInstrumentInfraConverter(){
        super(TypeInstrumentEntity.class, TypeInstrument.class);
    }

    @Override
    public TypeInstrument toModel(TypeInstrumentEntity entity) {
        if (entity == null) {
            return null;
        } else {
        TypeInstrument model = new TypeInstrument();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getLibelle()))
                model.setLibelle(entity.getLibelle());



        return model;
        }
    }

    @Override
    public TypeInstrumentEntity toEntity(TypeInstrument model) {
        if (model == null) {
            return null;
        } else {
            TypeInstrumentEntity entity = new TypeInstrumentEntity();
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
