package ma.zs.easystock.infra.dao.impl.core.commun;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.commun.MarqueRepository;
import ma.zs.easystock.infra.bean.core.commun.MarqueEntity;
import ma.zs.easystock.infra.converter.commun.MarqueInfraConverter;
import ma.zs.easystock.domain.dao.commun.MarqueDao;
import ma.zs.easystock.domain.model.commun.Marque;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MarqueDaoImpl extends AbstractDaoImpl<MarqueEntity, Marque, MarqueRepository, MarqueInfraConverter> implements MarqueDao  {

    @Override
    public Marque findByLibelle(String libelle){
        MarqueEntity entity = repository.findByLibelle(libelle);
        return converter.toModel(entity);
    }

    @Override
    public int deleteByLibelle(String libelle){
        return repository.deleteByLibelle(libelle);
    }

    @Override
    public List<Marque> findAllOptimized(){
    List<MarqueEntity> list =  repository.findAllOptimized();
        return converter.toModel(list);
    }




    public MarqueDaoImpl(MarqueRepository  repository, MarqueInfraConverter converter){
        super(repository,converter);
    }
}
