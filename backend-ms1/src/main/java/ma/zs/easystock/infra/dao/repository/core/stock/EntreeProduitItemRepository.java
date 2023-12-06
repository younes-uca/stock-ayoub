package ma.zs.easystock.infra.dao.repository.core.stock;

import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.stock.EntreeProduitItemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EntreeProduitItemRepository extends AbstractRepository<EntreeProduitItemEntity,Long>  {

    List<EntreeProduitItemEntity> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<EntreeProduitItemEntity> findByEntreeProduitId(Long id);
    int deleteByEntreeProduitId(Long id);
    long countByEntreeProduitReference(String reference);


}
