package ma.zs.easystock.infra.dao.repository.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.stock.AvoirVenteItemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AvoirVenteItemRepository extends AbstractRepository<AvoirVenteItemEntity,Long>  {
    AvoirVenteItemEntity findByBarCode(String barCode);
    int deleteByBarCode(String barCode);

    List<AvoirVenteItemEntity> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);
    List<AvoirVenteItemEntity> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<AvoirVenteItemEntity> findByTaxeId(Long id);
    int deleteByTaxeId(Long id);
    long countByTaxeId(Long id);
    List<AvoirVenteItemEntity> findByAvoirVenteId(Long id);
    int deleteByAvoirVenteId(Long id);
    long countByAvoirVenteNumeroFactureAvoirVente(String numeroFactureAvoirVente);

    @Query("SELECT NEW AvoirVenteItemEntity(item.id,item.barCode) FROM AvoirVenteItemEntity item")
    List<AvoirVenteItemEntity> findAllOptimized();

}
