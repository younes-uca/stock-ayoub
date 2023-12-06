package  ma.zs.easystock.infra.dao.specification.core.stock;

import ma.zs.easystock.infra.dao.criteria.core.stock.StockCriteria;
import ma.zs.easystock.infra.bean.core.stock.StockEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class StockSpecification extends  AbstractSpecification<StockCriteria, StockEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("quantite", criteria.getQuantite(), criteria.getQuantiteMin(), criteria.getQuantiteMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("produit","barCode", criteria.getProduit()==null?null:criteria.getProduit().getBarCode());
        addPredicateFk("depot","id", criteria.getDepot()==null?null:criteria.getDepot().getId());
        addPredicateFk("depot","id", criteria.getDepots());
    }

    public StockSpecification(StockCriteria criteria) {
        super(criteria);
    }

    public StockSpecification(StockCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
