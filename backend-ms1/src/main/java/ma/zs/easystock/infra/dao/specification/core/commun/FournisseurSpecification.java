package  ma.zs.easystock.infra.dao.specification.core.commun;

import ma.zs.easystock.infra.dao.criteria.core.commun.FournisseurCriteria;
import ma.zs.easystock.infra.bean.core.commun.FournisseurEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class FournisseurSpecification extends  AbstractSpecification<FournisseurCriteria, FournisseurEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ice", criteria.getIce(),criteria.getIceLike());
    }

    public FournisseurSpecification(FournisseurCriteria criteria) {
        super(criteria);
    }

    public FournisseurSpecification(FournisseurCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
