package  ma.zs.easystock.infra.dao.specification.core.gestionchequeffet;

import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.BanqueCriteria;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.BanqueEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class BanqueSpecification extends  AbstractSpecification<BanqueCriteria, BanqueEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public BanqueSpecification(BanqueCriteria criteria) {
        super(criteria);
    }

    public BanqueSpecification(BanqueCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
