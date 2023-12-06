package  ma.zs.easystock.infra.dao.specification.core.commun;

import ma.zs.easystock.infra.dao.criteria.core.commun.DepotCriteria;
import ma.zs.easystock.infra.bean.core.commun.DepotEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class DepotSpecification extends  AbstractSpecification<DepotCriteria, DepotEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("adresse", criteria.getAdresse(),criteria.getAdresseLike());
    }

    public DepotSpecification(DepotCriteria criteria) {
        super(criteria);
    }

    public DepotSpecification(DepotCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
