package ma.zs.easystock.infra.dao.repository.core.gestionchequeffet;

import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.TransfertEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransfertRepository extends AbstractRepository<TransfertEntity,Long>  {

    List<TransfertEntity> findByRaisonId(Long id);
    int deleteByRaisonId(Long id);
    long countByRaisonId(Long id);


}
