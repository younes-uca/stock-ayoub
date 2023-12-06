package ma.zs.easystock.infra.dao.impl.core.stock;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.stock.VenteItemRepository;
import ma.zs.easystock.infra.bean.core.stock.VenteItemEntity;
import ma.zs.easystock.infra.converter.stock.VenteItemInfraConverter;
import ma.zs.easystock.domain.dao.stock.VenteItemDao;
import ma.zs.easystock.domain.model.stock.VenteItem;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class VenteItemDaoImpl extends AbstractDaoImpl<VenteItemEntity, VenteItem, VenteItemRepository, VenteItemInfraConverter> implements VenteItemDao  {

    @Override
    public VenteItem findByBarCode(String barCode){
        VenteItemEntity entity = repository.findByBarCode(barCode);
        return converter.toModel(entity);
    }

    @Override
    public int deleteByBarCode(String barCode){
        return repository.deleteByBarCode(barCode);
    }

    @Override
    public List<VenteItem> findAllOptimized(){
    List<VenteItemEntity> list =  repository.findAllOptimized();
        return converter.toModel(list);
    }

    @Override
    public List<VenteItem> findByDepotId(Long id){
        List<VenteItemEntity> list = repository.findByDepotId(id);
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
    public List<VenteItem> findByProduitId(Long id){
        List<VenteItemEntity> list = repository.findByProduitId(id);
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
    public List<VenteItem> findByTaxeId(Long id){
        List<VenteItemEntity> list = repository.findByTaxeId(id);
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
    public List<VenteItem> findByVenteId(Long id){
        List<VenteItemEntity> list = repository.findByVenteId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByVenteId(Long id){
        return repository.deleteByVenteId(id);
    }
    @Override
    public long countByVenteNumeroFacture(String numeroFacture){
        return repository.countByVenteNumeroFacture(numeroFacture);
    }



    public VenteItemDaoImpl(VenteItemRepository  repository, VenteItemInfraConverter converter){
        super(repository,converter);
    }
}
