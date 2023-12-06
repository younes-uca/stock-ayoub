package ma.zs.easystock.infra.dao.repository.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.commun.MarqueEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MarqueRepository extends AbstractRepository<MarqueEntity,Long>  {
    MarqueEntity findByLibelle(String libelle);
    int deleteByLibelle(String libelle);


    @Query("SELECT NEW MarqueEntity(item.id,item.libelle) FROM MarqueEntity item")
    List<MarqueEntity> findAllOptimized();

}
