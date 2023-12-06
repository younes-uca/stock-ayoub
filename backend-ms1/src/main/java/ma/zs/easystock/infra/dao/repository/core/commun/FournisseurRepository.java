package ma.zs.easystock.infra.dao.repository.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.commun.FournisseurEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FournisseurRepository extends AbstractRepository<FournisseurEntity,Long>  {
    FournisseurEntity findByIce(String ice);
    int deleteByIce(String ice);


    @Query("SELECT NEW FournisseurEntity(item.id,item.ice) FROM FournisseurEntity item")
    List<FournisseurEntity> findAllOptimized();

}
