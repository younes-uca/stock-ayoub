package ma.zs.easystock.infra.dao.impl.core.gestionchequeffet;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.gestionchequeffet.TypeInstrumentRepository;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.TypeInstrumentEntity;
import ma.zs.easystock.infra.converter.gestionchequeffet.TypeInstrumentInfraConverter;
import ma.zs.easystock.domain.dao.gestionchequeffet.TypeInstrumentDao;
import ma.zs.easystock.domain.model.gestionchequeffet.TypeInstrument;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TypeInstrumentDaoImpl extends AbstractDaoImpl<TypeInstrumentEntity, TypeInstrument, TypeInstrumentRepository, TypeInstrumentInfraConverter> implements TypeInstrumentDao  {





    public TypeInstrumentDaoImpl(TypeInstrumentRepository  repository, TypeInstrumentInfraConverter converter){
        super(repository,converter);
    }
}
