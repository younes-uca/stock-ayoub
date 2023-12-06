package ma.zs.easystock.domain.dao.reglement;

import ma.zs.easystock.domain.model.reglement.ReglementAvoirVente;

import ma.zs.easystock.domain.model.reglement.ReglementAvoirVente;

import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface ReglementAvoirVenteDao extends IDao<ReglementAvoirVente> {

    ReglementAvoirVente findByReference(String reference);
    int deleteByReference(String reference);

    List<ReglementAvoirVente> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    long countByVenteNumeroFacture(String numeroFacture);
    List<ReglementAvoirVente> findByModeReglementId(Long id);
    int deleteByModeReglementId(Long id);
    long countByModeReglementId(Long id);
    List<ReglementAvoirVente> findByAvoirVenteId(Long id);
    int deleteByAvoirVenteId(Long id);
    long countByAvoirVenteNumeroFactureAvoirVente(String numeroFactureAvoirVente);

    List<ReglementAvoirVente> findAllOptimized();


}
