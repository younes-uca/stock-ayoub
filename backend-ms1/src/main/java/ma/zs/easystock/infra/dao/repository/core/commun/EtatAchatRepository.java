package ma.zs.easystock.infra.dao.repository.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.commun.EtatAchatEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EtatAchatRepository extends AbstractRepository<EtatAchatEntity,Long>  {


    @Query("SELECT NEW EtatAchatEntity(item.id,item.libelle) FROM EtatAchatEntity item")
    List<EtatAchatEntity> findAllOptimized();

}
