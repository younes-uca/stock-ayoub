package ma.zs.easystock.domain.dao.reglement;

import ma.zs.easystock.domain.model.reglement.ReglementAchat;

import ma.zs.easystock.domain.model.reglement.ReglementAchat;

import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface ReglementAchatDao extends IDao<ReglementAchat> {

    ReglementAchat findByReference(String reference);
    int deleteByReference(String reference);

    List<ReglementAchat> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    long countByAchatId(Long id);
    List<ReglementAchat> findByModeReglementId(Long id);
    int deleteByModeReglementId(Long id);
    long countByModeReglementId(Long id);

    List<ReglementAchat> findAllOptimized();


}
