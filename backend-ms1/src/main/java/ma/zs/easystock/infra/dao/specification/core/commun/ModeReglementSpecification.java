package  ma.zs.easystock.infra.dao.specification.core.commun;

import ma.zs.easystock.infra.dao.criteria.core.commun.ModeReglementCriteria;
import ma.zs.easystock.infra.bean.core.commun.ModeReglementEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class ModeReglementSpecification extends  AbstractSpecification<ModeReglementCriteria, ModeReglementEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public ModeReglementSpecification(ModeReglementCriteria criteria) {
        super(criteria);
    }

    public ModeReglementSpecification(ModeReglementCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
