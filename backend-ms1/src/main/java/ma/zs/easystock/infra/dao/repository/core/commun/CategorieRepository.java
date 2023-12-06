package ma.zs.easystock.infra.dao.repository.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.commun.CategorieEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategorieRepository extends AbstractRepository<CategorieEntity,Long>  {
    CategorieEntity findByLibelle(String libelle);
    int deleteByLibelle(String libelle);


    @Query("SELECT NEW CategorieEntity(item.id,item.libelle) FROM CategorieEntity item")
    List<CategorieEntity> findAllOptimized();

}
