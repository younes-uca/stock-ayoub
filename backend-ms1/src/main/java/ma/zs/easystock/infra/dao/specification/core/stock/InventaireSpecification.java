package  ma.zs.easystock.infra.dao.specification.core.stock;

import ma.zs.easystock.infra.dao.criteria.core.stock.InventaireCriteria;
import ma.zs.easystock.infra.bean.core.stock.InventaireEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class InventaireSpecification extends  AbstractSpecification<InventaireCriteria, InventaireEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("dateInventaire", criteria.getDateInventaire(), criteria.getDateInventaireFrom(), criteria.getDateInventaireTo());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSociete()==null?null:criteria.getEntrepriseSociete().getId());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSocietes());
        addPredicateFk("depot","id", criteria.getDepot()==null?null:criteria.getDepot().getId());
        addPredicateFk("depot","id", criteria.getDepots());
    }

    public InventaireSpecification(InventaireCriteria criteria) {
        super(criteria);
    }

    public InventaireSpecification(InventaireCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
