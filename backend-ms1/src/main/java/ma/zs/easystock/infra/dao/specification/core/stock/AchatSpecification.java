package  ma.zs.easystock.infra.dao.specification.core.stock;

import ma.zs.easystock.infra.dao.criteria.core.stock.AchatCriteria;
import ma.zs.easystock.infra.bean.core.stock.AchatEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class AchatSpecification extends  AbstractSpecification<AchatCriteria, AchatEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateFacture", criteria.getDateFacture(), criteria.getDateFactureFrom(), criteria.getDateFactureTo());
        addPredicate("referenceFacture", criteria.getReferenceFacture(),criteria.getReferenceFactureLike());
        addPredicateBigDecimal("montantHt", criteria.getMontantHt(), criteria.getMontantHtMin(), criteria.getMontantHtMax());
        addPredicateBigDecimal("montantTva", criteria.getMontantTva(), criteria.getMontantTvaMin(), criteria.getMontantTvaMax());
        addPredicateBigDecimal("montantTtc", criteria.getMontantTtc(), criteria.getMontantTtcMin(), criteria.getMontantTtcMax());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSociete()==null?null:criteria.getEntrepriseSociete().getId());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSocietes());
        addPredicateFk("fournisseur","id", criteria.getFournisseur()==null?null:criteria.getFournisseur().getId());
        addPredicateFk("fournisseur","id", criteria.getFournisseurs());
        addPredicateFk("fournisseur","ice", criteria.getFournisseur()==null?null:criteria.getFournisseur().getIce());
        addPredicateFk("etatAchat","id", criteria.getEtatAchat()==null?null:criteria.getEtatAchat().getId());
        addPredicateFk("etatAchat","id", criteria.getEtatAchats());
    }

    public AchatSpecification(AchatCriteria criteria) {
        super(criteria);
    }

    public AchatSpecification(AchatCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
