package ma.zs.easystock.infra.dao.repository.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.commun.ModeReglementEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ModeReglementRepository extends AbstractRepository<ModeReglementEntity,Long>  {


    @Query("SELECT NEW ModeReglementEntity(item.id,item.libelle) FROM ModeReglementEntity item")
    List<ModeReglementEntity> findAllOptimized();

}
