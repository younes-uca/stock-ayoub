package  ma.zs.easystock.infra.dao.specification.core.stock;

import ma.zs.easystock.infra.dao.criteria.core.stock.AvoirAchatCriteria;
import ma.zs.easystock.infra.bean.core.stock.AvoirAchatEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class AvoirAchatSpecification extends  AbstractSpecification<AvoirAchatCriteria, AvoirAchatEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("barCode", criteria.getBarCode(),criteria.getBarCodeLike());
        addPredicate("codeAvoirAchat", criteria.getCodeAvoirAchat(),criteria.getCodeAvoirAchatLike());
        addPredicate("numeroFactureAvoirAchat", criteria.getNumeroFactureAvoirAchat(),criteria.getNumeroFactureAvoirAchatLike());
        addPredicate("dateFactureAvoirAchat", criteria.getDateFactureAvoirAchat(), criteria.getDateFactureAvoirAchatFrom(), criteria.getDateFactureAvoirAchatTo());
        addPredicateBigDecimal("montantHt", criteria.getMontantHt(), criteria.getMontantHtMin(), criteria.getMontantHtMax());
        addPredicateBigDecimal("montantTva", criteria.getMontantTva(), criteria.getMontantTvaMin(), criteria.getMontantTvaMax());
        addPredicateBigDecimal("montantTtc", criteria.getMontantTtc(), criteria.getMontantTtcMin(), criteria.getMontantTtcMax());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSociete()==null?null:criteria.getEntrepriseSociete().getId());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSocietes());
        addPredicateFk("fournisseur","id", criteria.getFournisseur()==null?null:criteria.getFournisseur().getId());
        addPredicateFk("fournisseur","id", criteria.getFournisseurs());
        addPredicateFk("fournisseur","ice", criteria.getFournisseur()==null?null:criteria.getFournisseur().getIce());
        addPredicateFk("etatAvoirAchat","id", criteria.getEtatAvoirAchat()==null?null:criteria.getEtatAvoirAchat().getId());
        addPredicateFk("etatAvoirAchat","id", criteria.getEtatAvoirAchats());
    }

    public AvoirAchatSpecification(AvoirAchatCriteria criteria) {
        super(criteria);
    }

    public AvoirAchatSpecification(AvoirAchatCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
