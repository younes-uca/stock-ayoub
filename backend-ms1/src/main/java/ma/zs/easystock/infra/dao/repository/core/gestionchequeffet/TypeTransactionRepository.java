package ma.zs.easystock.infra.dao.repository.core.gestionchequeffet;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.TypeTransactionEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TypeTransactionRepository extends AbstractRepository<TypeTransactionEntity,Long>  {


    @Query("SELECT NEW TypeTransactionEntity(item.id,item.libelle) FROM TypeTransactionEntity item")
    List<TypeTransactionEntity> findAllOptimized();

}
