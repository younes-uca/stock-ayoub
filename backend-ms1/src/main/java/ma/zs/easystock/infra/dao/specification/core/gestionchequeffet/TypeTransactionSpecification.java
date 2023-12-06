package  ma.zs.easystock.infra.dao.specification.core.gestionchequeffet;

import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.TypeTransactionCriteria;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.TypeTransactionEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class TypeTransactionSpecification extends  AbstractSpecification<TypeTransactionCriteria, TypeTransactionEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public TypeTransactionSpecification(TypeTransactionCriteria criteria) {
        super(criteria);
    }

    public TypeTransactionSpecification(TypeTransactionCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
