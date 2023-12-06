package ma.zs.easystock.infra.dao.impl.core.stock;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.stock.StockRepository;
import ma.zs.easystock.infra.bean.core.stock.StockEntity;
import ma.zs.easystock.infra.converter.stock.StockInfraConverter;
import ma.zs.easystock.domain.dao.stock.StockDao;
import ma.zs.easystock.domain.model.stock.Stock;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StockDaoImpl extends AbstractDaoImpl<StockEntity, Stock, StockRepository, StockInfraConverter> implements StockDao  {


    @Override
    public List<Stock> findByProduitId(Long id){
        List<StockEntity> list = repository.findByProduitId(id);
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
    public List<Stock> findByDepotId(Long id){
        List<StockEntity> list = repository.findByDepotId(id);
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



    public StockDaoImpl(StockRepository  repository, StockInfraConverter converter){
        super(repository,converter);
    }
}
