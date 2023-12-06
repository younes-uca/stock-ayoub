package ma.zs.easystock.infra.dao.impl.core.depense;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.depense.DepenseRepository;
import ma.zs.easystock.infra.bean.core.depense.DepenseEntity;
import ma.zs.easystock.infra.converter.depense.DepenseInfraConverter;
import ma.zs.easystock.domain.dao.depense.DepenseDao;
import ma.zs.easystock.domain.model.depense.Depense;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DepenseDaoImpl extends AbstractDaoImpl<DepenseEntity, Depense, DepenseRepository, DepenseInfraConverter> implements DepenseDao  {





    public DepenseDaoImpl(DepenseRepository  repository, DepenseInfraConverter converter){
        super(repository,converter);
    }
}
