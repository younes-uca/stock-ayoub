package ma.zs.easystock.infra.dao.repository.core.entree;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.entree.SortieProduitEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SortieProduitRepository extends AbstractRepository<SortieProduitEntity,Long>  {
    SortieProduitEntity findByReference(String reference);
    int deleteByReference(String reference);

    List<SortieProduitEntity> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);

    @Query("SELECT NEW SortieProduitEntity(item.id,item.reference) FROM SortieProduitEntity item")
    List<SortieProduitEntity> findAllOptimized();

}
