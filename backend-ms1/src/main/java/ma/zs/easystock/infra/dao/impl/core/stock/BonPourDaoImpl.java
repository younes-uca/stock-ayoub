package ma.zs.easystock.infra.dao.impl.core.stock;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.stock.BonPourRepository;
import ma.zs.easystock.infra.bean.core.stock.BonPourEntity;
import ma.zs.easystock.infra.converter.stock.BonPourInfraConverter;
import ma.zs.easystock.domain.dao.stock.BonPourDao;
import ma.zs.easystock.domain.model.stock.BonPour;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BonPourDaoImpl extends AbstractDaoImpl<BonPourEntity, BonPour, BonPourRepository, BonPourInfraConverter> implements BonPourDao  {

    @Override
    public BonPour findByNumeroBonPour(String numeroBonPour){
        BonPourEntity entity = repository.findByNumeroBonPour(numeroBonPour);
        return converter.toModel(entity);
    }

    @Override
    public int deleteByNumeroBonPour(String numeroBonPour){
        return repository.deleteByNumeroBonPour(numeroBonPour);
    }

    @Override
    public List<BonPour> findAllOptimized(){
    List<BonPourEntity> list =  repository.findAllOptimized();
        return converter.toModel(list);
    }

    @Override
    public List<BonPour> findByClientId(Long id){
        List<BonPourEntity> list = repository.findByClientId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByClientId(Long id){
        return repository.deleteByClientId(id);
    }
    @Override
    public long countByClientCin(String cin){
        return repository.countByClientCin(cin);
    }



    public BonPourDaoImpl(BonPourRepository  repository, BonPourInfraConverter converter){
        super(repository,converter);
    }
}
