package  ma.zs.easystock.infra.dao.specification.core.stock;

import ma.zs.easystock.infra.dao.criteria.core.stock.TaxeCriteria;
import ma.zs.easystock.infra.bean.core.stock.TaxeEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class TaxeSpecification extends  AbstractSpecification<TaxeCriteria, TaxeEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public TaxeSpecification(TaxeCriteria criteria) {
        super(criteria);
    }

    public TaxeSpecification(TaxeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
