package  ma.zs.easystock.infra.dao.specification.core.Transfert;

import ma.zs.easystock.infra.dao.criteria.core.Transfert.RaisonCriteria;
import ma.zs.easystock.infra.bean.core.Transfert.RaisonEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class RaisonSpecification extends  AbstractSpecification<RaisonCriteria, RaisonEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public RaisonSpecification(RaisonCriteria criteria) {
        super(criteria);
    }

    public RaisonSpecification(RaisonCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
