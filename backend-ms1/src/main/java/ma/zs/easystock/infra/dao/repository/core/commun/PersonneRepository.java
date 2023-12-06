package ma.zs.easystock.infra.dao.repository.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.commun.PersonneEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonneRepository extends AbstractRepository<PersonneEntity,Long>  {
    PersonneEntity findByTelephone(String telephone);
    int deleteByTelephone(String telephone);

    List<PersonneEntity> findByVilleId(Long id);
    int deleteByVilleId(Long id);
    long countByVilleId(Long id);

    @Query("SELECT NEW PersonneEntity(item.id,item.telephone) FROM PersonneEntity item")
    List<PersonneEntity> findAllOptimized();

}
