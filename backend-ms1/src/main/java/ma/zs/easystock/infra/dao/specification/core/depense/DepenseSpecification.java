package  ma.zs.easystock.infra.dao.specification.core.depense;

import ma.zs.easystock.infra.dao.criteria.core.depense.DepenseCriteria;
import ma.zs.easystock.infra.bean.core.depense.DepenseEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class DepenseSpecification extends  AbstractSpecification<DepenseCriteria, DepenseEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateDepense", criteria.getDateDepense(), criteria.getDateDepenseFrom(), criteria.getDateDepenseTo());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
    }

    public DepenseSpecification(DepenseCriteria criteria) {
        super(criteria);
    }

    public DepenseSpecification(DepenseCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
