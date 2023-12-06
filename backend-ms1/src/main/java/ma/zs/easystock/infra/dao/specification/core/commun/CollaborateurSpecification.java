package  ma.zs.easystock.infra.dao.specification.core.commun;

import ma.zs.easystock.infra.dao.criteria.core.commun.CollaborateurCriteria;
import ma.zs.easystock.infra.bean.core.commun.CollaborateurEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class CollaborateurSpecification extends  AbstractSpecification<CollaborateurCriteria, CollaborateurEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("prenom", criteria.getPrenom(),criteria.getPrenomLike());
    }

    public CollaborateurSpecification(CollaborateurCriteria criteria) {
        super(criteria);
    }

    public CollaborateurSpecification(CollaborateurCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
