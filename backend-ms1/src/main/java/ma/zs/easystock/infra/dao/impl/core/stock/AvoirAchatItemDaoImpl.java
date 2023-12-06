package ma.zs.easystock.infra.dao.impl.core.stock;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.stock.AvoirAchatItemRepository;
import ma.zs.easystock.infra.bean.core.stock.AvoirAchatItemEntity;
import ma.zs.easystock.infra.converter.stock.AvoirAchatItemInfraConverter;
import ma.zs.easystock.domain.dao.stock.AvoirAchatItemDao;
import ma.zs.easystock.domain.model.stock.AvoirAchatItem;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AvoirAchatItemDaoImpl extends AbstractDaoImpl<AvoirAchatItemEntity, AvoirAchatItem, AvoirAchatItemRepository, AvoirAchatItemInfraConverter> implements AvoirAchatItemDao  {

    @Override
    public AvoirAchatItem findByBarCode(String barCode){
        AvoirAchatItemEntity entity = repository.findByBarCode(barCode);
        return converter.toModel(entity);
    }

    @Override
    public int deleteByBarCode(String barCode){
        return repository.deleteByBarCode(barCode);
    }

    @Override
    public List<AvoirAchatItem> findAllOptimized(){
    List<AvoirAchatItemEntity> list =  repository.findAllOptimized();
        return converter.toModel(list);
    }

    @Override
    public List<AvoirAchatItem> findByDepotId(Long id){
        List<AvoirAchatItemEntity> list = repository.findByDepotId(id);
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
    public List<AvoirAchatItem> findByProduitId(Long id){
        List<AvoirAchatItemEntity> list = repository.findByProduitId(id);
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
    public List<AvoirAchatItem> findByTaxeId(Long id){
        List<AvoirAchatItemEntity> list = repository.findByTaxeId(id);
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
    public List<AvoirAchatItem> findByAvoirAchatId(Long id){
        List<AvoirAchatItemEntity> list = repository.findByAvoirAchatId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByAvoirAchatId(Long id){
        return repository.deleteByAvoirAchatId(id);
    }
    @Override
    public long countByAvoirAchatNumeroFactureAvoirAchat(String numeroFactureAvoirAchat){
        return repository.countByAvoirAchatNumeroFactureAvoirAchat(numeroFactureAvoirAchat);
    }



    public AvoirAchatItemDaoImpl(AvoirAchatItemRepository  repository, AvoirAchatItemInfraConverter converter){
        super(repository,converter);
    }
}
