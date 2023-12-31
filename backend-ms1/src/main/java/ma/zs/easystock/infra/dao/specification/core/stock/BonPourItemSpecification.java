package  ma.zs.easystock.infra.dao.specification.core.stock;

import ma.zs.easystock.infra.dao.criteria.core.stock.BonPourItemCriteria;
import ma.zs.easystock.infra.bean.core.stock.BonPourItemEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class BonPourItemSpecification extends  AbstractSpecification<BonPourItemCriteria, BonPourItemEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("quantite", criteria.getQuantite(), criteria.getQuantiteMin(), criteria.getQuantiteMax());
        addPredicateBigDecimal("prixUnitaireHt", criteria.getPrixUnitaireHt(), criteria.getPrixUnitaireHtMin(), criteria.getPrixUnitaireHtMax());
        addPredicateBigDecimal("prixUnitaireTtc", criteria.getPrixUnitaireTtc(), criteria.getPrixUnitaireTtcMin(), criteria.getPrixUnitaireTtcMax());
        addPredicateBigDecimal("remise", criteria.getRemise(), criteria.getRemiseMin(), criteria.getRemiseMax());
        addPredicateBigDecimal("montantHt", criteria.getMontantHt(), criteria.getMontantHtMin(), criteria.getMontantHtMax());
        addPredicateBigDecimal("montantTtc", criteria.getMontantTtc(), criteria.getMontantTtcMin(), criteria.getMontantTtcMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("produit","barCode", criteria.getProduit()==null?null:criteria.getProduit().getBarCode());
        addPredicateFk("taxe","id", criteria.getTaxe()==null?null:criteria.getTaxe().getId());
        addPredicateFk("taxe","id", criteria.getTaxes());
        addPredicateFk("bonPour","id", criteria.getBonPour()==null?null:criteria.getBonPour().getId());
        addPredicateFk("bonPour","id", criteria.getBonPours());
        addPredicateFk("bonPour","numeroBonPour", criteria.getBonPour()==null?null:criteria.getBonPour().getNumeroBonPour());
    }

    public BonPourItemSpecification(BonPourItemCriteria criteria) {
        super(criteria);
    }

    public BonPourItemSpecification(BonPourItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
