package ma.zs.easystock.infra.dao.repository.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.stock.AvoirAchatItemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AvoirAchatItemRepository extends AbstractRepository<AvoirAchatItemEntity,Long>  {
    AvoirAchatItemEntity findByBarCode(String barCode);
    int deleteByBarCode(String barCode);

    List<AvoirAchatItemEntity> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);
    List<AvoirAchatItemEntity> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<AvoirAchatItemEntity> findByTaxeId(Long id);
    int deleteByTaxeId(Long id);
    long countByTaxeId(Long id);
    List<AvoirAchatItemEntity> findByAvoirAchatId(Long id);
    int deleteByAvoirAchatId(Long id);
    long countByAvoirAchatNumeroFactureAvoirAchat(String numeroFactureAvoirAchat);

    @Query("SELECT NEW AvoirAchatItemEntity(item.id,item.barCode) FROM AvoirAchatItemEntity item")
    List<AvoirAchatItemEntity> findAllOptimized();

}
