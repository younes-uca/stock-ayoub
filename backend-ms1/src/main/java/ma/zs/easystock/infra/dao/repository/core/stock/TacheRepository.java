package ma.zs.easystock.infra.dao.repository.core.stock;

import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.stock.TacheEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TacheRepository extends AbstractRepository<TacheEntity,Long>  {

    List<TacheEntity> findByLierAId(Long id);
    int deleteByLierAId(Long id);
    long countByLierAId(Long id);


}
