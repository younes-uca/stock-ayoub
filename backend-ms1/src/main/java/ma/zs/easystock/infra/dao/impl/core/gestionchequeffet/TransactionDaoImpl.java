package ma.zs.easystock.infra.dao.impl.core.gestionchequeffet;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.gestionchequeffet.TransactionRepository;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.TransactionEntity;
import ma.zs.easystock.infra.converter.gestionchequeffet.TransactionInfraConverter;
import ma.zs.easystock.domain.dao.gestionchequeffet.TransactionDao;
import ma.zs.easystock.domain.model.gestionchequeffet.Transaction;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TransactionDaoImpl extends AbstractDaoImpl<TransactionEntity, Transaction, TransactionRepository, TransactionInfraConverter> implements TransactionDao  {


    @Override
    public List<Transaction> findByTypeTransactionId(Long id){
        List<TransactionEntity> list = repository.findByTypeTransactionId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByTypeTransactionId(Long id){
        return repository.deleteByTypeTransactionId(id);
    }
    @Override
    public long countByTypeTransactionId(Long id){
        return repository.countByTypeTransactionId(id);
    }
    @Override
    public List<Transaction> findByInstrumentId(Long id){
        List<TransactionEntity> list = repository.findByInstrumentId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByInstrumentId(Long id){
        return repository.deleteByInstrumentId(id);
    }
    @Override
    public long countByInstrumentId(Long id){
        return repository.countByInstrumentId(id);
    }
    @Override
    public List<Transaction> findByCompteId(Long id){
        List<TransactionEntity> list = repository.findByCompteId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByCompteId(Long id){
        return repository.deleteByCompteId(id);
    }
    @Override
    public long countByCompteId(Long id){
        return repository.countByCompteId(id);
    }



    public TransactionDaoImpl(TransactionRepository  repository, TransactionInfraConverter converter){
        super(repository,converter);
    }
}
