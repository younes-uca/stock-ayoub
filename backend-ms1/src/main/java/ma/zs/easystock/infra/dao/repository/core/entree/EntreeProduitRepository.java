package ma.zs.easystock.infra.dao.repository.core.entree;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.entree.EntreeProduitEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EntreeProduitRepository extends AbstractRepository<EntreeProduitEntity,Long>  {
    EntreeProduitEntity findByReference(String reference);
    int deleteByReference(String reference);

    List<EntreeProduitEntity> findByFournisseurId(Long id);
    int deleteByFournisseurId(Long id);
    long countByFournisseurIce(String ice);
    List<EntreeProduitEntity> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);

    @Query("SELECT NEW EntreeProduitEntity(item.id,item.reference) FROM EntreeProduitEntity item")
    List<EntreeProduitEntity> findAllOptimized();

}
