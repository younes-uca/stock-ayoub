package ma.zs.easystock.infra.dao.repository.core.stock;

import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.stock.CommandeItemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommandeItemRepository extends AbstractRepository<CommandeItemEntity,Long>  {

    List<CommandeItemEntity> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<CommandeItemEntity> findByTaxeId(Long id);
    int deleteByTaxeId(Long id);
    long countByTaxeId(Long id);
    List<CommandeItemEntity> findByCommandeId(Long id);
    int deleteByCommandeId(Long id);
    long countByCommandeNumeroCommande(String numeroCommande);


}
