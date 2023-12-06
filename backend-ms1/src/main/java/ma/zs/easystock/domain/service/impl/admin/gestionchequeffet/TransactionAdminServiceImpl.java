package ma.zs.easystock.domain.service.impl.admin.gestionchequeffet;


import ma.zs.easystock.domain.model.gestionchequeffet.Transaction;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.TransactionCriteria;
import ma.zs.easystock.domain.dao.gestionchequeffet.TransactionDao;
import ma.zs.easystock.infra.dao.specification.core.gestionchequeffet.TransactionSpecification;
import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.TransactionAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.TypeTransactionAdminService ;
import ma.zs.easystock.domain.model.gestionchequeffet.TypeTransaction ;
import ma.zs.easystock.domain.service.facade.admin.chequeffet.InstrumentAdminService ;
import ma.zs.easystock.domain.model.chequeffet.Instrument ;
import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.CompteAdminService ;
import ma.zs.easystock.domain.model.gestionchequeffet.Compte ;

import java.util.List;
@Service
public class TransactionAdminServiceImpl extends AbstractServiceImpl<Transaction, TransactionCriteria, TransactionDao> implements TransactionAdminService {






    public List<Transaction> findByTypeTransactionId(Long id){
        return dao.findByTypeTransactionId(id);
    }
    public int deleteByTypeTransactionId(Long id){
        return dao.deleteByTypeTransactionId(id);
    }
    public long countByTypeTransactionId(Long id){
        return dao.countByTypeTransactionId(id);
    }
    public List<Transaction> findByInstrumentId(Long id){
        return dao.findByInstrumentId(id);
    }
    public int deleteByInstrumentId(Long id){
        return dao.deleteByInstrumentId(id);
    }
    public long countByInstrumentId(Long id){
        return dao.countByInstrumentId(id);
    }
    public List<Transaction> findByCompteId(Long id){
        return dao.findByCompteId(id);
    }
    public int deleteByCompteId(Long id){
        return dao.deleteByCompteId(id);
    }
    public long countByCompteId(Long id){
        return dao.countByCompteId(id);
    }





    public void configure() {
        super.configure(Transaction.class);
    }

    @Autowired
    private TypeTransactionAdminService typeTransactionService ;
    @Autowired
    private InstrumentAdminService instrumentService ;
    @Autowired
    private CompteAdminService compteService ;

    public TransactionAdminServiceImpl(TransactionDao dao) {
        super(dao);
    }

}
