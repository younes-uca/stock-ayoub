package ma.zs.easystock.infra.dao.impl.core.gestionchequeffet;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.gestionchequeffet.TransfertItemRepository;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.TransfertItemEntity;
import ma.zs.easystock.infra.converter.gestionchequeffet.TransfertItemInfraConverter;
import ma.zs.easystock.domain.dao.gestionchequeffet.TransfertItemDao;
import ma.zs.easystock.domain.model.gestionchequeffet.TransfertItem;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TransfertItemDaoImpl extends AbstractDaoImpl<TransfertItemEntity, TransfertItem, TransfertItemRepository, TransfertItemInfraConverter> implements TransfertItemDao  {


    @Override
    public List<TransfertItem> findByDepotId(Long id){
        List<TransfertItemEntity> list = repository.findByDepotId(id);
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
    @Override
    public List<TransfertItem> findByProduitId(Long id){
        List<TransfertItemEntity> list = repository.findByProduitId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByProduitId(Long id){
        return repository.deleteByProduitId(id);
    }
    @Override
    public long countByProduitBarCode(String barCode){
        return repository.countByProduitBarCode(barCode);
    }
    @Override
    public List<TransfertItem> findByTransfertId(Long id){
        List<TransfertItemEntity> list = repository.findByTransfertId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByTransfertId(Long id){
        return repository.deleteByTransfertId(id);
    }
    @Override
    public long countByTransfertId(Long id){
        return repository.countByTransfertId(id);
    }



    public TransfertItemDaoImpl(TransfertItemRepository  repository, TransfertItemInfraConverter converter){
        super(repository,converter);
    }
}
