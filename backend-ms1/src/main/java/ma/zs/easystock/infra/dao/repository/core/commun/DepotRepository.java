package ma.zs.easystock.infra.dao.repository.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.commun.DepotEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DepotRepository extends AbstractRepository<DepotEntity,Long>  {


    @Query("SELECT NEW DepotEntity(item.id,item.libelle) FROM DepotEntity item")
    List<DepotEntity> findAllOptimized();

}
