package ma.zs.easystock.infra.dao.impl.core.entree;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.entree.SortieProduitRepository;
import ma.zs.easystock.infra.bean.core.entree.SortieProduitEntity;
import ma.zs.easystock.infra.converter.entree.SortieProduitInfraConverter;
import ma.zs.easystock.domain.dao.entree.SortieProduitDao;
import ma.zs.easystock.domain.model.entree.SortieProduit;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SortieProduitDaoImpl extends AbstractDaoImpl<SortieProduitEntity, SortieProduit, SortieProduitRepository, SortieProduitInfraConverter> implements SortieProduitDao  {

    @Override
    public SortieProduit findByReference(String reference){
        SortieProduitEntity entity = repository.findByReference(reference);
        return converter.toModel(entity);
    }

    @Override
    public int deleteByReference(String reference){
        return repository.deleteByReference(reference);
    }

    @Override
    public List<SortieProduit> findAllOptimized(){
    List<SortieProduitEntity> list =  repository.findAllOptimized();
        return converter.toModel(list);
    }

    @Override
    public List<SortieProduit> findByDepotId(Long id){
        List<SortieProduitEntity> list = repository.findByDepotId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByDepotId(Long id){
        return repository.deleteByDepotId(id);
    }
    @Override
    public long countByDepotId(Long id){
        return repository.countByDepotId(id);
    }



    public SortieProduitDaoImpl(SortieProduitRepository  repository, SortieProduitInfraConverter converter){
        super(repository,converter);
    }
}
