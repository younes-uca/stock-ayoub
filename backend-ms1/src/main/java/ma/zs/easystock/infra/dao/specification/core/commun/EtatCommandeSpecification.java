package  ma.zs.easystock.infra.dao.specification.core.commun;

import ma.zs.easystock.infra.dao.criteria.core.commun.EtatCommandeCriteria;
import ma.zs.easystock.infra.bean.core.commun.EtatCommandeEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class EtatCommandeSpecification extends  AbstractSpecification<EtatCommandeCriteria, EtatCommandeEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public EtatCommandeSpecification(EtatCommandeCriteria criteria) {
        super(criteria);
    }

    public EtatCommandeSpecification(EtatCommandeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
