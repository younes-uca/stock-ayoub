package ma.zs.easystock.infra.dao.repository.core.gestionchequeffet;

import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.TransfertItemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransfertItemRepository extends AbstractRepository<TransfertItemEntity,Long>  {

    List<TransfertItemEntity> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);
    List<TransfertItemEntity> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<TransfertItemEntity> findByTransfertId(Long id);
    int deleteByTransfertId(Long id);
    long countByTransfertId(Long id);


}
