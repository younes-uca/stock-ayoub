package  ma.zs.easystock.infra.dao.specification.core.commun;

import ma.zs.easystock.infra.dao.criteria.core.commun.PersonneCriteria;
import ma.zs.easystock.infra.bean.core.commun.PersonneEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class PersonneSpecification extends  AbstractSpecification<PersonneCriteria, PersonneEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("nom", criteria.getNom(),criteria.getNomLike());
        addPredicate("telephone", criteria.getTelephone(),criteria.getTelephoneLike());
        addPredicateBigDecimal("creance", criteria.getCreance(), criteria.getCreanceMin(), criteria.getCreanceMax());
        addPredicateFk("ville","id", criteria.getVille()==null?null:criteria.getVille().getId());
        addPredicateFk("ville","id", criteria.getVilles());
    }

    public PersonneSpecification(PersonneCriteria criteria) {
        super(criteria);
    }

    public PersonneSpecification(PersonneCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
