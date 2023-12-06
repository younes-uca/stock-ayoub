package  ma.zs.easystock.infra.dao.specification.core.commun;

import ma.zs.easystock.infra.dao.criteria.core.commun.UniteMesureCriteria;
import ma.zs.easystock.infra.bean.core.commun.UniteMesureEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class UniteMesureSpecification extends  AbstractSpecification<UniteMesureCriteria, UniteMesureEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public UniteMesureSpecification(UniteMesureCriteria criteria) {
        super(criteria);
    }

    public UniteMesureSpecification(UniteMesureCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
