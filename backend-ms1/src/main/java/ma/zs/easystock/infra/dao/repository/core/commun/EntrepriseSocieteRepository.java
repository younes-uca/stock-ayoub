package ma.zs.easystock.infra.dao.repository.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.commun.EntrepriseSocieteEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EntrepriseSocieteRepository extends AbstractRepository<EntrepriseSocieteEntity,Long>  {


    @Query("SELECT NEW EntrepriseSocieteEntity(item.id,item.nom) FROM EntrepriseSocieteEntity item")
    List<EntrepriseSocieteEntity> findAllOptimized();

}
