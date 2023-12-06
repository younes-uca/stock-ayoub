package ma.zs.easystock.infra.dao.repository.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.commun.CollaborateurEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CollaborateurRepository extends AbstractRepository<CollaborateurEntity,Long>  {


    @Query("SELECT NEW CollaborateurEntity(item.id,item.prenom) FROM CollaborateurEntity item")
    List<CollaborateurEntity> findAllOptimized();

}
