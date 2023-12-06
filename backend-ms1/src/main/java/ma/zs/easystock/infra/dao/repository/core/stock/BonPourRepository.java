package ma.zs.easystock.infra.dao.repository.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.stock.BonPourEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BonPourRepository extends AbstractRepository<BonPourEntity,Long>  {
    BonPourEntity findByNumeroBonPour(String numeroBonPour);
    int deleteByNumeroBonPour(String numeroBonPour);

    List<BonPourEntity> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientCin(String cin);

    @Query("SELECT NEW BonPourEntity(item.id,item.numeroBonPour) FROM BonPourEntity item")
    List<BonPourEntity> findAllOptimized();

}
