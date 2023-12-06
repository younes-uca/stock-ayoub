package ma.zs.easystock.infra.dao.impl.core.stock;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.stock.EntreeProduitItemRepository;
import ma.zs.easystock.infra.bean.core.stock.EntreeProduitItemEntity;
import ma.zs.easystock.infra.converter.stock.EntreeProduitItemInfraConverter;
import ma.zs.easystock.domain.dao.stock.EntreeProduitItemDao;
import ma.zs.easystock.domain.model.stock.EntreeProduitItem;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EntreeProduitItemDaoImpl extends AbstractDaoImpl<EntreeProduitItemEntity, EntreeProduitItem, EntreeProduitItemRepository, EntreeProduitItemInfraConverter> implements EntreeProduitItemDao  {


    @Override
    public List<EntreeProduitItem> findByProduitId(Long id){
        List<EntreeProduitItemEntity> list = repository.findByProduitId(id);
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
    public List<EntreeProduitItem> findByEntreeProduitId(Long id){
        List<EntreeProduitItemEntity> list = repository.findByEntreeProduitId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByEntreeProduitId(Long id){
        return repository.deleteByEntreeProduitId(id);
    }
    @Override
    public long countByEntreeProduitReference(String reference){
        return repository.countByEntreeProduitReference(reference);
    }



    public EntreeProduitItemDaoImpl(EntreeProduitItemRepository  repository, EntreeProduitItemInfraConverter converter){
        super(repository,converter);
    }
}
