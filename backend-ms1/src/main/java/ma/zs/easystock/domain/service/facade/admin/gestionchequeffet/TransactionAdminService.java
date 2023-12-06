package ma.zs.easystock.domain.service.facade.admin.gestionchequeffet;

import java.util.List;
import ma.zs.easystock.domain.model.gestionchequeffet.Transaction;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.TransactionCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface TransactionAdminService extends  IService<Transaction,TransactionCriteria>  {

    List<Transaction> findByTypeTransactionId(Long id);
    int deleteByTypeTransactionId(Long id);
    long countByTypeTransactionId(Long id);
    List<Transaction> findByInstrumentId(Long id);
    int deleteByInstrumentId(Long id);
    long countByInstrumentId(Long id);
    List<Transaction> findByCompteId(Long id);
    int deleteByCompteId(Long id);
    long countByCompteId(Long id);



}
