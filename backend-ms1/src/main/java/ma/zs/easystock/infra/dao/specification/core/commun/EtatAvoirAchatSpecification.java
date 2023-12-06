package  ma.zs.easystock.infra.dao.specification.core.commun;

import ma.zs.easystock.infra.dao.criteria.core.commun.EtatAvoirAchatCriteria;
import ma.zs.easystock.infra.bean.core.commun.EtatAvoirAchatEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class EtatAvoirAchatSpecification extends  AbstractSpecification<EtatAvoirAchatCriteria, EtatAvoirAchatEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public EtatAvoirAchatSpecification(EtatAvoirAchatCriteria criteria) {
        super(criteria);
    }

    public EtatAvoirAchatSpecification(EtatAvoirAchatCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
