package ma.zs.easystock.infra.dao.impl.core.stock;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.stock.AchatItemRepository;
import ma.zs.easystock.infra.bean.core.stock.AchatItemEntity;
import ma.zs.easystock.infra.converter.stock.AchatItemInfraConverter;
import ma.zs.easystock.domain.dao.stock.AchatItemDao;
import ma.zs.easystock.domain.model.stock.AchatItem;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AchatItemDaoImpl extends AbstractDaoImpl<AchatItemEntity, AchatItem, AchatItemRepository, AchatItemInfraConverter> implements AchatItemDao  {


    @Override
    public List<AchatItem> findByProduitId(Long id){
        List<AchatItemEntity> list = repository.findByProduitId(id);
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
    public List<AchatItem> findByTaxeId(Long id){
        List<AchatItemEntity> list = repository.findByTaxeId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByTaxeId(Long id){
        return repository.deleteByTaxeId(id);
    }
    @Override
    public long countByTaxeId(Long id){
        return repository.countByTaxeId(id);
    }
    @Override
    public List<AchatItem> findByAchatId(Long id){
        List<AchatItemEntity> list = repository.findByAchatId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByAchatId(Long id){
        return repository.deleteByAchatId(id);
    }
    @Override
    public long countByAchatId(Long id){
        return repository.countByAchatId(id);
    }
    @Override
    public List<AchatItem> findByDepotId(Long id){
        List<AchatItemEntity> list = repository.findByDepotId(id);
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



    public AchatItemDaoImpl(AchatItemRepository  repository, AchatItemInfraConverter converter){
        super(repository,converter);
    }
}
