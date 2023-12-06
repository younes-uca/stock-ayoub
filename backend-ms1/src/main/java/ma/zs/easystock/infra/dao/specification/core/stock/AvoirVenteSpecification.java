package  ma.zs.easystock.infra.dao.specification.core.stock;

import ma.zs.easystock.infra.dao.criteria.core.stock.AvoirVenteCriteria;
import ma.zs.easystock.infra.bean.core.stock.AvoirVenteEntity;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class AvoirVenteSpecification extends  AbstractSpecification<AvoirVenteCriteria, AvoirVenteEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("barCode", criteria.getBarCode(),criteria.getBarCodeLike());
        addPredicate("codeAvoirVente", criteria.getCodeAvoirVente(),criteria.getCodeAvoirVenteLike());
        addPredicate("numeroFactureAvoirVente", criteria.getNumeroFactureAvoirVente(),criteria.getNumeroFactureAvoirVenteLike());
        addPredicate("dateFactureAvoirVente", criteria.getDateFactureAvoirVente(), criteria.getDateFactureAvoirVenteFrom(), criteria.getDateFactureAvoirVenteTo());
        addPredicateBigDecimal("montantHt", criteria.getMontantHt(), criteria.getMontantHtMin(), criteria.getMontantHtMax());
        addPredicateBigDecimal("montantTva", criteria.getMontantTva(), criteria.getMontantTvaMin(), criteria.getMontantTvaMax());
        addPredicateBigDecimal("montantTtc", criteria.getMontantTtc(), criteria.getMontantTtcMin(), criteria.getMontantTtcMax());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSociete()==null?null:criteria.getEntrepriseSociete().getId());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSocietes());
        addPredicateFk("client","id", criteria.getClient()==null?null:criteria.getClient().getId());
        addPredicateFk("client","id", criteria.getClients());
        addPredicateFk("client","cin", criteria.getClient()==null?null:criteria.getClient().getCin());
        addPredicateFk("etatAvoirVente","id", criteria.getEtatAvoirVente()==null?null:criteria.getEtatAvoirVente().getId());
        addPredicateFk("etatAvoirVente","id", criteria.getEtatAvoirVentes());
        addPredicateFk("achat","id", criteria.getAchat()==null?null:criteria.getAchat().getId());
        addPredicateFk("achat","id", criteria.getAchats());
    }

    public AvoirVenteSpecification(AvoirVenteCriteria criteria) {
        super(criteria);
    }

    public AvoirVenteSpecification(AvoirVenteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
