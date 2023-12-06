package ma.zs.easystock.infra.dao.repository.core.stock;

import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.stock.AchatItemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AchatItemRepository extends AbstractRepository<AchatItemEntity,Long>  {

    List<AchatItemEntity> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<AchatItemEntity> findByTaxeId(Long id);
    int deleteByTaxeId(Long id);
    long countByTaxeId(Long id);
    List<AchatItemEntity> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    long countByAchatId(Long id);
    List<AchatItemEntity> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);


}
