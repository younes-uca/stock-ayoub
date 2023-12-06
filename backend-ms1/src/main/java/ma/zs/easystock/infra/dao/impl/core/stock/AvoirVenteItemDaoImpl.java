package ma.zs.easystock.infra.dao.impl.core.stock;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.stock.AvoirVenteItemRepository;
import ma.zs.easystock.infra.bean.core.stock.AvoirVenteItemEntity;
import ma.zs.easystock.infra.converter.stock.AvoirVenteItemInfraConverter;
import ma.zs.easystock.domain.dao.stock.AvoirVenteItemDao;
import ma.zs.easystock.domain.model.stock.AvoirVenteItem;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AvoirVenteItemDaoImpl extends AbstractDaoImpl<AvoirVenteItemEntity, AvoirVenteItem, AvoirVenteItemRepository, AvoirVenteItemInfraConverter> implements AvoirVenteItemDao  {

    @Override
    public AvoirVenteItem findByBarCode(String barCode){
        AvoirVenteItemEntity entity = repository.findByBarCode(barCode);
        return converter.toModel(entity);
    }

    @Override
    public int deleteByBarCode(String barCode){
        return repository.deleteByBarCode(barCode);
    }

    @Override
    public List<AvoirVenteItem> findAllOptimized(){
    List<AvoirVenteItemEntity> list =  repository.findAllOptimized();
        return converter.toModel(list);
    }

    @Override
    public List<AvoirVenteItem> findByDepotId(Long id){
        List<AvoirVenteItemEntity> list = repository.findByDepotId(id);
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
    public List<AvoirVenteItem> findByProduitId(Long id){
        List<AvoirVenteItemEntity> list = repository.findByProduitId(id);
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
    public List<AvoirVenteItem> findByTaxeId(Long id){
        List<AvoirVenteItemEntity> list = repository.findByTaxeId(id);
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
    public List<AvoirVenteItem> findByAvoirVenteId(Long id){
        List<AvoirVenteItemEntity> list = repository.findByAvoirVenteId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByAvoirVenteId(Long id){
        return repository.deleteByAvoirVenteId(id);
    }
    @Override
    public long countByAvoirVenteNumeroFactureAvoirVente(String numeroFactureAvoirVente){
        return repository.countByAvoirVenteNumeroFactureAvoirVente(numeroFactureAvoirVente);
    }



    public AvoirVenteItemDaoImpl(AvoirVenteItemRepository  repository, AvoirVenteItemInfraConverter converter){
        super(repository,converter);
    }
}
