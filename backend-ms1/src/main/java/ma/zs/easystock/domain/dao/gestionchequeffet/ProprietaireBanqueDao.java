package ma.zs.easystock.domain.dao.gestionchequeffet;

import ma.zs.easystock.domain.model.gestionchequeffet.ProprietaireBanque;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface ProprietaireBanqueDao extends IDao<ProprietaireBanque> {


    List<ProprietaireBanque> findByProprietaireId(Long id);
    int deleteByProprietaireId(Long id);
    long countByProprietaireId(Long id);
    List<ProprietaireBanque> findByBanqueId(Long id);
    int deleteByBanqueId(Long id);
    long countByBanqueId(Long id);
    List<ProprietaireBanque> findByCompteId(Long id);
    int deleteByCompteId(Long id);
    long countByCompteId(Long id);



}
