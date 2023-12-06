package ma.zs.easystock.infra.dao.repository.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.stock.InventaireEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InventaireRepository extends AbstractRepository<InventaireEntity,Long>  {
    InventaireEntity findByReference(String reference);
    int deleteByReference(String reference);

    List<InventaireEntity> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<InventaireEntity> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);

    @Query("SELECT NEW InventaireEntity(item.id,item.reference) FROM InventaireEntity item")
    List<InventaireEntity> findAllOptimized();

}
