package  ma.zs.easystock.infra.dao.specification.core.gestionchequeffet;

import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.ProprietaireCriteria;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.ProprietaireEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class ProprietaireSpecification extends  AbstractSpecification<ProprietaireCriteria, ProprietaireEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateFk("personne","id", criteria.getPersonne()==null?null:criteria.getPersonne().getId());
        addPredicateFk("personne","id", criteria.getPersonnes());
        addPredicateFk("personne","telephone", criteria.getPersonne()==null?null:criteria.getPersonne().getTelephone());
    }

    public ProprietaireSpecification(ProprietaireCriteria criteria) {
        super(criteria);
    }

    public ProprietaireSpecification(ProprietaireCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
