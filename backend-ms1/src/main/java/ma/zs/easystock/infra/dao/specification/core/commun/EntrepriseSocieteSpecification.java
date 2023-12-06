package  ma.zs.easystock.infra.dao.specification.core.commun;

import ma.zs.easystock.infra.dao.criteria.core.commun.EntrepriseSocieteCriteria;
import ma.zs.easystock.infra.bean.core.commun.EntrepriseSocieteEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class EntrepriseSocieteSpecification extends  AbstractSpecification<EntrepriseSocieteCriteria, EntrepriseSocieteEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("nom", criteria.getNom(),criteria.getNomLike());
        addPredicate("ice", criteria.getIce(),criteria.getIceLike());
        addPredicateBigDecimal("capital", criteria.getCapital(), criteria.getCapitalMin(), criteria.getCapitalMax());
    }

    public EntrepriseSocieteSpecification(EntrepriseSocieteCriteria criteria) {
        super(criteria);
    }

    public EntrepriseSocieteSpecification(EntrepriseSocieteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
