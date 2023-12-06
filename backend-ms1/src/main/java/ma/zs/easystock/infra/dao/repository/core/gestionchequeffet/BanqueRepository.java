package ma.zs.easystock.infra.dao.repository.core.gestionchequeffet;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.BanqueEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BanqueRepository extends AbstractRepository<BanqueEntity,Long>  {


    @Query("SELECT NEW BanqueEntity(item.id,item.libelle) FROM BanqueEntity item")
    List<BanqueEntity> findAllOptimized();

}
