package  ma.zs.easystock.infra.dao.specification.core.chequeffet;

import ma.zs.easystock.infra.dao.criteria.core.chequeffet.InstrumentCriteria;
import ma.zs.easystock.infra.bean.core.chequeffet.InstrumentEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class InstrumentSpecification extends  AbstractSpecification<InstrumentCriteria, InstrumentEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateEmission", criteria.getDateEmission(), criteria.getDateEmissionFrom(), criteria.getDateEmissionTo());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicateFk("typeInstrument","id", criteria.getTypeInstrument()==null?null:criteria.getTypeInstrument().getId());
        addPredicateFk("typeInstrument","id", criteria.getTypeInstruments());
        addPredicateFk("chequeEffet","id", criteria.getChequeEffet()==null?null:criteria.getChequeEffet().getId());
        addPredicateFk("chequeEffet","id", criteria.getChequeEffets());
        addPredicateFk("chequeEffet","numeroChequeEffet", criteria.getChequeEffet()==null?null:criteria.getChequeEffet().getNumeroChequeEffet());
    }

    public InstrumentSpecification(InstrumentCriteria criteria) {
        super(criteria);
    }

    public InstrumentSpecification(InstrumentCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
