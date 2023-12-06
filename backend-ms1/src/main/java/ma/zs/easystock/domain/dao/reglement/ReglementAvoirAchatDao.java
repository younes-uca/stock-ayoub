package ma.zs.easystock.domain.dao.reglement;

import ma.zs.easystock.domain.model.reglement.ReglementAvoirAchat;

import ma.zs.easystock.domain.model.reglement.ReglementAvoirAchat;

import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface ReglementAvoirAchatDao extends IDao<ReglementAvoirAchat> {

    ReglementAvoirAchat findByReference(String reference);
    int deleteByReference(String reference);

    List<ReglementAvoirAchat> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    long countByAchatId(Long id);
    List<ReglementAvoirAchat> findByModeReglementId(Long id);
    int deleteByModeReglementId(Long id);
    long countByModeReglementId(Long id);
    List<ReglementAvoirAchat> findByAvoirAchatId(Long id);
    int deleteByAvoirAchatId(Long id);
    long countByAvoirAchatNumeroFactureAvoirAchat(String numeroFactureAvoirAchat);

    List<ReglementAvoirAchat> findAllOptimized();


}
