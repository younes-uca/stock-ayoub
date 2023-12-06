package ma.zs.easystock.infra.dao.repository.core.gestionchequeffet;

import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.TransactionEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransactionRepository extends AbstractRepository<TransactionEntity,Long>  {

    List<TransactionEntity> findByTypeTransactionId(Long id);
    int deleteByTypeTransactionId(Long id);
    long countByTypeTransactionId(Long id);
    List<TransactionEntity> findByInstrumentId(Long id);
    int deleteByInstrumentId(Long id);
    long countByInstrumentId(Long id);
    List<TransactionEntity> findByCompteId(Long id);
    int deleteByCompteId(Long id);
    long countByCompteId(Long id);


}
