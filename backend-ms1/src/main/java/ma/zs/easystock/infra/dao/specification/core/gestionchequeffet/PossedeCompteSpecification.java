package  ma.zs.easystock.infra.dao.specification.core.gestionchequeffet;

import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.PossedeCompteCriteria;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.PossedeCompteEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class PossedeCompteSpecification extends  AbstractSpecification<PossedeCompteCriteria, PossedeCompteEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateFk("proprietaire","id", criteria.getProprietaire()==null?null:criteria.getProprietaire().getId());
        addPredicateFk("proprietaire","id", criteria.getProprietaires());
        addPredicateFk("banque","id", criteria.getBanque()==null?null:criteria.getBanque().getId());
        addPredicateFk("banque","id", criteria.getBanques());
        addPredicateFk("compte","id", criteria.getCompte()==null?null:criteria.getCompte().getId());
        addPredicateFk("compte","id", criteria.getComptes());
    }

    public PossedeCompteSpecification(PossedeCompteCriteria criteria) {
        super(criteria);
    }

    public PossedeCompteSpecification(PossedeCompteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
