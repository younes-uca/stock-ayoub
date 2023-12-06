package ma.zs.easystock.infra.dao.repository.core.stock;

import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.stock.DevisItemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DevisItemRepository extends AbstractRepository<DevisItemEntity,Long>  {

    List<DevisItemEntity> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<DevisItemEntity> findByTaxeId(Long id);
    int deleteByTaxeId(Long id);
    long countByTaxeId(Long id);
    List<DevisItemEntity> findByDevisId(Long id);
    int deleteByDevisId(Long id);
    long countByDevisNumeroDevis(String numeroDevis);


}
