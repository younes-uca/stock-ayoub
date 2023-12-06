package ma.zs.easystock.infra.dao.impl.core.commun;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.commun.DepotRepository;
import ma.zs.easystock.infra.bean.core.commun.DepotEntity;
import ma.zs.easystock.infra.converter.commun.DepotInfraConverter;
import ma.zs.easystock.domain.dao.commun.DepotDao;
import ma.zs.easystock.domain.model.commun.Depot;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DepotDaoImpl extends AbstractDaoImpl<DepotEntity, Depot, DepotRepository, DepotInfraConverter> implements DepotDao  {





    public DepotDaoImpl(DepotRepository  repository, DepotInfraConverter converter){
        super(repository,converter);
    }
}
