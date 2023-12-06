package ma.zs.easystock.infra.dao.repository.core.stock;

import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.stock.BonPourItemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BonPourItemRepository extends AbstractRepository<BonPourItemEntity,Long>  {

    List<BonPourItemEntity> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<BonPourItemEntity> findByTaxeId(Long id);
    int deleteByTaxeId(Long id);
    long countByTaxeId(Long id);
    List<BonPourItemEntity> findByBonPourId(Long id);
    int deleteByBonPourId(Long id);
    long countByBonPourNumeroBonPour(String numeroBonPour);


}
