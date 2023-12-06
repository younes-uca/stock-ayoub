package  ma.zs.easystock.infra.dao.specification.core.stock;

import ma.zs.easystock.infra.dao.criteria.core.stock.DevisCriteria;
import ma.zs.easystock.infra.bean.core.stock.DevisEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class DevisSpecification extends  AbstractSpecification<DevisCriteria, DevisEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("numeroDevis", criteria.getNumeroDevis(),criteria.getNumeroDevisLike());
        addPredicate("dateDevis", criteria.getDateDevis(), criteria.getDateDevisFrom(), criteria.getDateDevisTo());
        addPredicateBigDecimal("montantHt", criteria.getMontantHt(), criteria.getMontantHtMin(), criteria.getMontantHtMax());
        addPredicateBigDecimal("montantTva", criteria.getMontantTva(), criteria.getMontantTvaMin(), criteria.getMontantTvaMax());
        addPredicateBigDecimal("montantTtc", criteria.getMontantTtc(), criteria.getMontantTtcMin(), criteria.getMontantTtcMax());
        addPredicateFk("client","id", criteria.getClient()==null?null:criteria.getClient().getId());
        addPredicateFk("client","id", criteria.getClients());
        addPredicateFk("client","cin", criteria.getClient()==null?null:criteria.getClient().getCin());
    }

    public DevisSpecification(DevisCriteria criteria) {
        super(criteria);
    }

    public DevisSpecification(DevisCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
