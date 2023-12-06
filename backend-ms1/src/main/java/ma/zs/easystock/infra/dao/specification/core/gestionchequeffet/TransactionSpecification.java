package  ma.zs.easystock.infra.dao.specification.core.gestionchequeffet;

import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.TransactionCriteria;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.TransactionEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class TransactionSpecification extends  AbstractSpecification<TransactionCriteria, TransactionEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateTransaction", criteria.getDateTransaction(), criteria.getDateTransactionFrom(), criteria.getDateTransactionTo());
        addPredicate("dateEncaissement", criteria.getDateEncaissement(), criteria.getDateEncaissementFrom(), criteria.getDateEncaissementTo());
        addPredicate("pathCheque", criteria.getPathCheque(),criteria.getPathChequeLike());
        addPredicateFk("typeTransaction","id", criteria.getTypeTransaction()==null?null:criteria.getTypeTransaction().getId());
        addPredicateFk("typeTransaction","id", criteria.getTypeTransactions());
        addPredicateFk("instrument","id", criteria.getInstrument()==null?null:criteria.getInstrument().getId());
        addPredicateFk("instrument","id", criteria.getInstruments());
        addPredicateFk("compte","id", criteria.getCompte()==null?null:criteria.getCompte().getId());
        addPredicateFk("compte","id", criteria.getComptes());
    }

    public TransactionSpecification(TransactionCriteria criteria) {
        super(criteria);
    }

    public TransactionSpecification(TransactionCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
