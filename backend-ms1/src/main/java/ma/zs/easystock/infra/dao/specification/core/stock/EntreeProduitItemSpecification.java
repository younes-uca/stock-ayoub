package  ma.zs.easystock.infra.dao.specification.core.stock;

import ma.zs.easystock.infra.dao.criteria.core.stock.EntreeProduitItemCriteria;
import ma.zs.easystock.infra.bean.core.stock.EntreeProduitItemEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class EntreeProduitItemSpecification extends  AbstractSpecification<EntreeProduitItemCriteria, EntreeProduitItemEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("quantite", criteria.getQuantite(), criteria.getQuantiteMin(), criteria.getQuantiteMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("produit","barCode", criteria.getProduit()==null?null:criteria.getProduit().getBarCode());
        addPredicateFk("entreeProduit","id", criteria.getEntreeProduit()==null?null:criteria.getEntreeProduit().getId());
        addPredicateFk("entreeProduit","id", criteria.getEntreeProduits());
        addPredicateFk("entreeProduit","reference", criteria.getEntreeProduit()==null?null:criteria.getEntreeProduit().getReference());
    }

    public EntreeProduitItemSpecification(EntreeProduitItemCriteria criteria) {
        super(criteria);
    }

    public EntreeProduitItemSpecification(EntreeProduitItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
