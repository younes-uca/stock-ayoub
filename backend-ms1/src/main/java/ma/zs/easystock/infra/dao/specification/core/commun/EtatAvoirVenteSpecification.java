package  ma.zs.easystock.infra.dao.specification.core.commun;

import ma.zs.easystock.infra.dao.criteria.core.commun.EtatAvoirVenteCriteria;
import ma.zs.easystock.infra.bean.core.commun.EtatAvoirVenteEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class EtatAvoirVenteSpecification extends  AbstractSpecification<EtatAvoirVenteCriteria, EtatAvoirVenteEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public EtatAvoirVenteSpecification(EtatAvoirVenteCriteria criteria) {
        super(criteria);
    }

    public EtatAvoirVenteSpecification(EtatAvoirVenteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
