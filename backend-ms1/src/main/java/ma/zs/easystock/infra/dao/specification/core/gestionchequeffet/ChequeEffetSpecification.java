package  ma.zs.easystock.infra.dao.specification.core.gestionchequeffet;

import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.ChequeEffetCriteria;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.ChequeEffetEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class ChequeEffetSpecification extends  AbstractSpecification<ChequeEffetCriteria, ChequeEffetEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("numeroChequeEffet", criteria.getNumeroChequeEffet(),criteria.getNumeroChequeEffetLike());
        addPredicate("dateEmission", criteria.getDateEmission(), criteria.getDateEmissionFrom(), criteria.getDateEmissionTo());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicateFk("beneficiaire","id", criteria.getBeneficiaire()==null?null:criteria.getBeneficiaire().getId());
        addPredicateFk("beneficiaire","id", criteria.getBeneficiaires());
        addPredicateFk("beneficiaire","ice", criteria.getBeneficiaire()==null?null:criteria.getBeneficiaire().getIce());
    }

    public ChequeEffetSpecification(ChequeEffetCriteria criteria) {
        super(criteria);
    }

    public ChequeEffetSpecification(ChequeEffetCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
