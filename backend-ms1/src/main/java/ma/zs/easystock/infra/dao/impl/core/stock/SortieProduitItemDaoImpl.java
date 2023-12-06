package ma.zs.easystock.infra.dao.impl.core.stock;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.stock.SortieProduitItemRepository;
import ma.zs.easystock.infra.bean.core.stock.SortieProduitItemEntity;
import ma.zs.easystock.infra.converter.stock.SortieProduitItemInfraConverter;
import ma.zs.easystock.domain.dao.stock.SortieProduitItemDao;
import ma.zs.easystock.domain.model.stock.SortieProduitItem;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SortieProduitItemDaoImpl extends AbstractDaoImpl<SortieProduitItemEntity, SortieProduitItem, SortieProduitItemRepository, SortieProduitItemInfraConverter> implements SortieProduitItemDao  {


    @Override
    public List<SortieProduitItem> findByProduitId(Long id){
        List<SortieProduitItemEntity> list = repository.findByProduitId(id);
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
    public List<SortieProduitItem> findBySortieProduitId(Long id){
        List<SortieProduitItemEntity> list = repository.findBySortieProduitId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteBySortieProduitId(Long id){
        return repository.deleteBySortieProduitId(id);
    }
    @Override
    public long countBySortieProduitReference(String reference){
        return repository.countBySortieProduitReference(reference);
    }



    public SortieProduitItemDaoImpl(SortieProduitItemRepository  repository, SortieProduitItemInfraConverter converter){
        super(repository,converter);
    }
}
