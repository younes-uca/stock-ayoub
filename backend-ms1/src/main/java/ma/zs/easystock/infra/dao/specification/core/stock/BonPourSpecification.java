package  ma.zs.easystock.infra.dao.specification.core.stock;

import ma.zs.easystock.infra.dao.criteria.core.stock.BonPourCriteria;
import ma.zs.easystock.infra.bean.core.stock.BonPourEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class BonPourSpecification extends  AbstractSpecification<BonPourCriteria, BonPourEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("numeroBonPour", criteria.getNumeroBonPour(),criteria.getNumeroBonPourLike());
        addPredicate("dateBonPour", criteria.getDateBonPour(), criteria.getDateBonPourFrom(), criteria.getDateBonPourTo());
        addPredicateBigDecimal("montantHt", criteria.getMontantHt(), criteria.getMontantHtMin(), criteria.getMontantHtMax());
        addPredicateBigDecimal("montantTva", criteria.getMontantTva(), criteria.getMontantTvaMin(), criteria.getMontantTvaMax());
        addPredicateBigDecimal("montantTtc", criteria.getMontantTtc(), criteria.getMontantTtcMin(), criteria.getMontantTtcMax());
        addPredicateFk("client","id", criteria.getClient()==null?null:criteria.getClient().getId());
        addPredicateFk("client","id", criteria.getClients());
        addPredicateFk("client","cin", criteria.getClient()==null?null:criteria.getClient().getCin());
    }

    public BonPourSpecification(BonPourCriteria criteria) {
        super(criteria);
    }

    public BonPourSpecification(BonPourCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
