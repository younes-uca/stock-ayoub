package ma.zs.easystock.infra.dao.impl.core.stock;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.stock.BonPourItemRepository;
import ma.zs.easystock.infra.bean.core.stock.BonPourItemEntity;
import ma.zs.easystock.infra.converter.stock.BonPourItemInfraConverter;
import ma.zs.easystock.domain.dao.stock.BonPourItemDao;
import ma.zs.easystock.domain.model.stock.BonPourItem;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BonPourItemDaoImpl extends AbstractDaoImpl<BonPourItemEntity, BonPourItem, BonPourItemRepository, BonPourItemInfraConverter> implements BonPourItemDao  {


    @Override
    public List<BonPourItem> findByProduitId(Long id){
        List<BonPourItemEntity> list = repository.findByProduitId(id);
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
    public List<BonPourItem> findByTaxeId(Long id){
        List<BonPourItemEntity> list = repository.findByTaxeId(id);
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
    public List<BonPourItem> findByBonPourId(Long id){
        List<BonPourItemEntity> list = repository.findByBonPourId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByBonPourId(Long id){
        return repository.deleteByBonPourId(id);
    }
    @Override
    public long countByBonPourNumeroBonPour(String numeroBonPour){
        return repository.countByBonPourNumeroBonPour(numeroBonPour);
    }



    public BonPourItemDaoImpl(BonPourItemRepository  repository, BonPourItemInfraConverter converter){
        super(repository,converter);
    }
}
