package ma.zs.easystock.domain.dao.gestionchequeffet;

import ma.zs.easystock.domain.model.gestionchequeffet.Transaction;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface TransactionDao extends IDao<Transaction> {


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
