package ma.zs.easystock.infra.dao.repository.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.commun.EtatVenteEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EtatVenteRepository extends AbstractRepository<EtatVenteEntity,Long>  {


    @Query("SELECT NEW EtatVenteEntity(item.id,item.libelle) FROM EtatVenteEntity item")
    List<EtatVenteEntity> findAllOptimized();

}
