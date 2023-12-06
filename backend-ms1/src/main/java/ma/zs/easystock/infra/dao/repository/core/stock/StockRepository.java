package ma.zs.easystock.infra.dao.repository.core.stock;

import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.stock.StockEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StockRepository extends AbstractRepository<StockEntity,Long>  {

    List<StockEntity> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<StockEntity> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);


}
