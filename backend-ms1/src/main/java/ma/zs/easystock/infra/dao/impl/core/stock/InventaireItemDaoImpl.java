package ma.zs.easystock.infra.dao.impl.core.stock;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.stock.InventaireItemRepository;
import ma.zs.easystock.infra.bean.core.stock.InventaireItemEntity;
import ma.zs.easystock.infra.converter.stock.InventaireItemInfraConverter;
import ma.zs.easystock.domain.dao.stock.InventaireItemDao;
import ma.zs.easystock.domain.model.stock.InventaireItem;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class InventaireItemDaoImpl extends AbstractDaoImpl<InventaireItemEntity, InventaireItem, InventaireItemRepository, InventaireItemInfraConverter> implements InventaireItemDao  {


    @Override
    public List<InventaireItem> findByProduitId(Long id){
        List<InventaireItemEntity> list = repository.findByProduitId(id);
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
    public List<InventaireItem> findByInventaireId(Long id){
        List<InventaireItemEntity> list = repository.findByInventaireId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByInventaireId(Long id){
        return repository.deleteByInventaireId(id);
    }
    @Override
    public long countByInventaireReference(String reference){
        return repository.countByInventaireReference(reference);
    }



    public InventaireItemDaoImpl(InventaireItemRepository  repository, InventaireItemInfraConverter converter){
        super(repository,converter);
    }
}
