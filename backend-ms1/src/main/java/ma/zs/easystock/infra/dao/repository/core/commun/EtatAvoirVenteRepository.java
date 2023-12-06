package ma.zs.easystock.infra.dao.repository.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.commun.EtatAvoirVenteEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EtatAvoirVenteRepository extends AbstractRepository<EtatAvoirVenteEntity,Long>  {


    @Query("SELECT NEW EtatAvoirVenteEntity(item.id,item.libelle) FROM EtatAvoirVenteEntity item")
    List<EtatAvoirVenteEntity> findAllOptimized();

}
