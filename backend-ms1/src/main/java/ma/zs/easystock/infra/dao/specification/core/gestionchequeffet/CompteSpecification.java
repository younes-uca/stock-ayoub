package  ma.zs.easystock.infra.dao.specification.core.gestionchequeffet;

import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.CompteCriteria;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.CompteEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class CompteSpecification extends  AbstractSpecification<CompteCriteria, CompteEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("numeroCompte", criteria.getNumeroCompte(),criteria.getNumeroCompteLike());
        addPredicateBigDecimal("solde", criteria.getSolde(), criteria.getSoldeMin(), criteria.getSoldeMax());
        addPredicateFk("banque","id", criteria.getBanque()==null?null:criteria.getBanque().getId());
        addPredicateFk("banque","id", criteria.getBanques());
        addPredicateFk("proprietaire","id", criteria.getProprietaire()==null?null:criteria.getProprietaire().getId());
        addPredicateFk("proprietaire","id", criteria.getProprietaires());
    }

    public CompteSpecification(CompteCriteria criteria) {
        super(criteria);
    }

    public CompteSpecification(CompteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
