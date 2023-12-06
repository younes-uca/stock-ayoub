package  ma.zs.easystock.infra.dao.specification.core.stock;

import ma.zs.easystock.infra.dao.criteria.core.stock.TacheCriteria;
import ma.zs.easystock.infra.bean.core.stock.TacheEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class TacheSpecification extends  AbstractSpecification<TacheCriteria, TacheEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateDebut", criteria.getDateDebut(), criteria.getDateDebutFrom(), criteria.getDateDebutTo());
        addPredicate("dateFin", criteria.getDateFin(), criteria.getDateFinFrom(), criteria.getDateFinTo());
        addPredicateFk("lierA","id", criteria.getLierA()==null?null:criteria.getLierA().getId());
        addPredicateFk("lierA","id", criteria.getLierAs());
    }

    public TacheSpecification(TacheCriteria criteria) {
        super(criteria);
    }

    public TacheSpecification(TacheCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
