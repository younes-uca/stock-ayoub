package ma.zs.easystock.domain.dao.reglement;

import ma.zs.easystock.domain.model.reglement.ReglementVente;

import ma.zs.easystock.domain.model.reglement.ReglementVente;

import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface ReglementVenteDao extends IDao<ReglementVente> {

    ReglementVente findByReference(String reference);
    int deleteByReference(String reference);

    List<ReglementVente> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    long countByVenteNumeroFacture(String numeroFacture);
    List<ReglementVente> findByModeReglementId(Long id);
    int deleteByModeReglementId(Long id);
    long countByModeReglementId(Long id);

    List<ReglementVente> findAllOptimized();


}
