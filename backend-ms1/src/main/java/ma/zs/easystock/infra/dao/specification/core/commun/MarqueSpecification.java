package  ma.zs.easystock.infra.dao.specification.core.commun;

import ma.zs.easystock.infra.dao.criteria.core.commun.MarqueCriteria;
import ma.zs.easystock.infra.bean.core.commun.MarqueEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class MarqueSpecification extends  AbstractSpecification<MarqueCriteria, MarqueEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public MarqueSpecification(MarqueCriteria criteria) {
        super(criteria);
    }

    public MarqueSpecification(MarqueCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
