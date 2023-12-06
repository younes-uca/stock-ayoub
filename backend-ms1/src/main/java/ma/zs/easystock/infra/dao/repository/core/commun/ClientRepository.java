package ma.zs.easystock.infra.dao.repository.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.commun.ClientEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClientRepository extends AbstractRepository<ClientEntity,Long>  {
    ClientEntity findByCin(String cin);
    int deleteByCin(String cin);


    @Query("SELECT NEW ClientEntity(item.id,item.cin) FROM ClientEntity item")
    List<ClientEntity> findAllOptimized();

}
