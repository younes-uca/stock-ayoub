package ma.zs.easystock.infra.dao.impl.core.commun;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.commun.EntrepriseSocieteRepository;
import ma.zs.easystock.infra.bean.core.commun.EntrepriseSocieteEntity;
import ma.zs.easystock.infra.converter.commun.EntrepriseSocieteInfraConverter;
import ma.zs.easystock.domain.dao.commun.EntrepriseSocieteDao;
import ma.zs.easystock.domain.model.commun.EntrepriseSociete;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EntrepriseSocieteDaoImpl extends AbstractDaoImpl<EntrepriseSocieteEntity, EntrepriseSociete, EntrepriseSocieteRepository, EntrepriseSocieteInfraConverter> implements EntrepriseSocieteDao  {





    public EntrepriseSocieteDaoImpl(EntrepriseSocieteRepository  repository, EntrepriseSocieteInfraConverter converter){
        super(repository,converter);
    }
}
