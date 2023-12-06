package  ma.zs.easystock.infra.dao.specification.core.gestionchequeffet;

import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.TypeInstrumentCriteria;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.TypeInstrumentEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class TypeInstrumentSpecification extends  AbstractSpecification<TypeInstrumentCriteria, TypeInstrumentEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public TypeInstrumentSpecification(TypeInstrumentCriteria criteria) {
        super(criteria);
    }

    public TypeInstrumentSpecification(TypeInstrumentCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
