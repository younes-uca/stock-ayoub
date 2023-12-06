package ma.zs.easystock.infra.dao.repository.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.commun.EtatCommandeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EtatCommandeRepository extends AbstractRepository<EtatCommandeEntity,Long>  {


    @Query("SELECT NEW EtatCommandeEntity(item.id,item.libelle) FROM EtatCommandeEntity item")
    List<EtatCommandeEntity> findAllOptimized();

}
