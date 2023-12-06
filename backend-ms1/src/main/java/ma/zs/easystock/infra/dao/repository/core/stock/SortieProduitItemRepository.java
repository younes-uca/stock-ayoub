package ma.zs.easystock.infra.dao.repository.core.stock;

import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.stock.SortieProduitItemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SortieProduitItemRepository extends AbstractRepository<SortieProduitItemEntity,Long>  {

    List<SortieProduitItemEntity> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<SortieProduitItemEntity> findBySortieProduitId(Long id);
    int deleteBySortieProduitId(Long id);
    long countBySortieProduitReference(String reference);


}
