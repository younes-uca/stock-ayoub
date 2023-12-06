package ma.zs.easystock.infra.dao.repository.core.Transfert;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.Transfert.RaisonEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RaisonRepository extends AbstractRepository<RaisonEntity,Long>  {


    @Query("SELECT NEW RaisonEntity(item.id,item.libelle) FROM RaisonEntity item")
    List<RaisonEntity> findAllOptimized();

}
