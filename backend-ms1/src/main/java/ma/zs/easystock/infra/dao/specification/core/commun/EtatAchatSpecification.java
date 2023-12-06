package  ma.zs.easystock.infra.dao.specification.core.commun;

import ma.zs.easystock.infra.dao.criteria.core.commun.EtatAchatCriteria;
import ma.zs.easystock.infra.bean.core.commun.EtatAchatEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class EtatAchatSpecification extends  AbstractSpecification<EtatAchatCriteria, EtatAchatEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public EtatAchatSpecification(EtatAchatCriteria criteria) {
        super(criteria);
    }

    public EtatAchatSpecification(EtatAchatCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
