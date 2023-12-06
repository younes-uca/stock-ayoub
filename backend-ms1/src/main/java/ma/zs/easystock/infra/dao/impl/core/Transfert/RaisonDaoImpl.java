package ma.zs.easystock.infra.dao.impl.core.Transfert;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.Transfert.RaisonRepository;
import ma.zs.easystock.infra.bean.core.Transfert.RaisonEntity;
import ma.zs.easystock.infra.converter.Transfert.RaisonInfraConverter;
import ma.zs.easystock.domain.dao.Transfert.RaisonDao;
import ma.zs.easystock.domain.model.Transfert.Raison;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RaisonDaoImpl extends AbstractDaoImpl<RaisonEntity, Raison, RaisonRepository, RaisonInfraConverter> implements RaisonDao  {





    public RaisonDaoImpl(RaisonRepository  repository, RaisonInfraConverter converter){
        super(repository,converter);
    }
}
