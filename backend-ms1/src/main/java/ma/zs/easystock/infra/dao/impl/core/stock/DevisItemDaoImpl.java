package ma.zs.easystock.infra.dao.impl.core.stock;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.stock.DevisItemRepository;
import ma.zs.easystock.infra.bean.core.stock.DevisItemEntity;
import ma.zs.easystock.infra.converter.stock.DevisItemInfraConverter;
import ma.zs.easystock.domain.dao.stock.DevisItemDao;
import ma.zs.easystock.domain.model.stock.DevisItem;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DevisItemDaoImpl extends AbstractDaoImpl<DevisItemEntity, DevisItem, DevisItemRepository, DevisItemInfraConverter> implements DevisItemDao  {


    @Override
    public List<DevisItem> findByProduitId(Long id){
        List<DevisItemEntity> list = repository.findByProduitId(id);
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
    public List<DevisItem> findByTaxeId(Long id){
        List<DevisItemEntity> list = repository.findByTaxeId(id);
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
    public List<DevisItem> findByDevisId(Long id){
        List<DevisItemEntity> list = repository.findByDevisId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByDevisId(Long id){
        return repository.deleteByDevisId(id);
    }
    @Override
    public long countByDevisNumeroDevis(String numeroDevis){
        return repository.countByDevisNumeroDevis(numeroDevis);
    }



    public DevisItemDaoImpl(DevisItemRepository  repository, DevisItemInfraConverter converter){
        super(repository,converter);
    }
}
