package ma.zs.easystock.infra.dao.impl.core.stock;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.stock.InventaireRepository;
import ma.zs.easystock.infra.bean.core.stock.InventaireEntity;
import ma.zs.easystock.infra.converter.stock.InventaireInfraConverter;
import ma.zs.easystock.domain.dao.stock.InventaireDao;
import ma.zs.easystock.domain.model.stock.Inventaire;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class InventaireDaoImpl extends AbstractDaoImpl<InventaireEntity, Inventaire, InventaireRepository, InventaireInfraConverter> implements InventaireDao  {

    @Override
    public Inventaire findByReference(String reference){
        InventaireEntity entity = repository.findByReference(reference);
        return converter.toModel(entity);
    }

    @Override
    public int deleteByReference(String reference){
        return repository.deleteByReference(reference);
    }

    @Override
    public List<Inventaire> findAllOptimized(){
    List<InventaireEntity> list =  repository.findAllOptimized();
        return converter.toModel(list);
    }

    @Override
    public List<Inventaire> findByEntrepriseSocieteId(Long id){
        List<InventaireEntity> list = repository.findByEntrepriseSocieteId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByEntrepriseSocieteId(Long id){
        return repository.deleteByEntrepriseSocieteId(id);
    }
    @Override
    public long countByEntrepriseSocieteId(Long id){
        return repository.countByEntrepriseSocieteId(id);
    }
    @Override
    public List<Inventaire> findByDepotId(Long id){
        List<InventaireEntity> list = repository.findByDepotId(id);
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



    public InventaireDaoImpl(InventaireRepository  repository, InventaireInfraConverter converter){
        super(repository,converter);
    }
}
