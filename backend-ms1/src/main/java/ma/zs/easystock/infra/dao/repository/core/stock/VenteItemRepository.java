package ma.zs.easystock.infra.dao.repository.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.stock.VenteItemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VenteItemRepository extends AbstractRepository<VenteItemEntity,Long>  {
    VenteItemEntity findByBarCode(String barCode);
    int deleteByBarCode(String barCode);

    List<VenteItemEntity> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);
    List<VenteItemEntity> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<VenteItemEntity> findByTaxeId(Long id);
    int deleteByTaxeId(Long id);
    long countByTaxeId(Long id);
    List<VenteItemEntity> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    long countByVenteNumeroFacture(String numeroFacture);

    @Query("SELECT NEW VenteItemEntity(item.id,item.barCode) FROM VenteItemEntity item")
    List<VenteItemEntity> findAllOptimized();

}
