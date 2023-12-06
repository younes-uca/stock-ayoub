package ma.zs.easystock.infra.dao.impl.core.entree;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.entree.EntreeProduitRepository;
import ma.zs.easystock.infra.bean.core.entree.EntreeProduitEntity;
import ma.zs.easystock.infra.converter.entree.EntreeProduitInfraConverter;
import ma.zs.easystock.domain.dao.entree.EntreeProduitDao;
import ma.zs.easystock.domain.model.entree.EntreeProduit;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EntreeProduitDaoImpl extends AbstractDaoImpl<EntreeProduitEntity, EntreeProduit, EntreeProduitRepository, EntreeProduitInfraConverter> implements EntreeProduitDao  {

    @Override
    public EntreeProduit findByReference(String reference){
        EntreeProduitEntity entity = repository.findByReference(reference);
        return converter.toModel(entity);
    }

    @Override
    public int deleteByReference(String reference){
        return repository.deleteByReference(reference);
    }

    @Override
    public List<EntreeProduit> findAllOptimized(){
    List<EntreeProduitEntity> list =  repository.findAllOptimized();
        return converter.toModel(list);
    }

    @Override
    public List<EntreeProduit> findByFournisseurId(Long id){
        List<EntreeProduitEntity> list = repository.findByFournisseurId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByFournisseurId(Long id){
        return repository.deleteByFournisseurId(id);
    }
    @Override
    public long countByFournisseurIce(String ice){
        return repository.countByFournisseurIce(ice);
    }
    @Override
    public List<EntreeProduit> findByDepotId(Long id){
        List<EntreeProduitEntity> list = repository.findByDepotId(id);
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



    public EntreeProduitDaoImpl(EntreeProduitRepository  repository, EntreeProduitInfraConverter converter){
        super(repository,converter);
    }
}
