package ma.zs.easystock.infra.dao.repository.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.commun.UniteMesureEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UniteMesureRepository extends AbstractRepository<UniteMesureEntity,Long>  {
    UniteMesureEntity findByLibelle(String libelle);
    int deleteByLibelle(String libelle);


    @Query("SELECT NEW UniteMesureEntity(item.id,item.libelle) FROM UniteMesureEntity item")
    List<UniteMesureEntity> findAllOptimized();

}
