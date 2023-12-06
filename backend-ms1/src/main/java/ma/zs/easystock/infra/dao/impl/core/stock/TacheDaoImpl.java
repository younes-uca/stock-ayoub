package ma.zs.easystock.infra.dao.impl.core.stock;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.stock.TacheRepository;
import ma.zs.easystock.infra.bean.core.stock.TacheEntity;
import ma.zs.easystock.infra.converter.stock.TacheInfraConverter;
import ma.zs.easystock.domain.dao.stock.TacheDao;
import ma.zs.easystock.domain.model.stock.Tache;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TacheDaoImpl extends AbstractDaoImpl<TacheEntity, Tache, TacheRepository, TacheInfraConverter> implements TacheDao  {


    @Override
    public List<Tache> findByLierAId(Long id){
        List<TacheEntity> list = repository.findByLierAId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByLierAId(Long id){
        return repository.deleteByLierAId(id);
    }
    @Override
    public long countByLierAId(Long id){
        return repository.countByLierAId(id);
    }



    public TacheDaoImpl(TacheRepository  repository, TacheInfraConverter converter){
        super(repository,converter);
    }
}
