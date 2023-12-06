package  ma.zs.easystock.infra.dao.specification.core.commun;

import ma.zs.easystock.infra.dao.criteria.core.commun.CategorieCriteria;
import ma.zs.easystock.infra.bean.core.commun.CategorieEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class CategorieSpecification extends  AbstractSpecification<CategorieCriteria, CategorieEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public CategorieSpecification(CategorieCriteria criteria) {
        super(criteria);
    }

    public CategorieSpecification(CategorieCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
