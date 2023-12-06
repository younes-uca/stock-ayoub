package ma.zs.easystock.domain.dao.gestionchequeffet;

import ma.zs.easystock.domain.model.gestionchequeffet.PossedeCompte;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface PossedeCompteDao extends IDao<PossedeCompte> {


    List<PossedeCompte> findByProprietaireId(Long id);
    int deleteByProprietaireId(Long id);
    long countByProprietaireId(Long id);
    List<PossedeCompte> findByBanqueId(Long id);
    int deleteByBanqueId(Long id);
    long countByBanqueId(Long id);
    List<PossedeCompte> findByCompteId(Long id);
    int deleteByCompteId(Long id);
    long countByCompteId(Long id);



}
