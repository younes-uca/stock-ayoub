package  ma.zs.easystock.infra.dao.specification.core.commun;

import ma.zs.easystock.infra.dao.criteria.core.commun.EtatVenteCriteria;
import ma.zs.easystock.infra.bean.core.commun.EtatVenteEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class EtatVenteSpecification extends  AbstractSpecification<EtatVenteCriteria, EtatVenteEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public EtatVenteSpecification(EtatVenteCriteria criteria) {
        super(criteria);
    }

    public EtatVenteSpecification(EtatVenteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
