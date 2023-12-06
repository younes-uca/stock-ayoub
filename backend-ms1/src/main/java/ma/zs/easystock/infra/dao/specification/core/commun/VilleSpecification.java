package  ma.zs.easystock.infra.dao.specification.core.commun;

import ma.zs.easystock.infra.dao.criteria.core.commun.VilleCriteria;
import ma.zs.easystock.infra.bean.core.commun.VilleEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class VilleSpecification extends  AbstractSpecification<VilleCriteria, VilleEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public VilleSpecification(VilleCriteria criteria) {
        super(criteria);
    }

    public VilleSpecification(VilleCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
