package ma.zs.easystock.domain.dao.gestionchequeffet;

import ma.zs.easystock.domain.model.gestionchequeffet.Compte;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface CompteDao extends IDao<Compte> {


    List<Compte> findByBanqueId(Long id);
    int deleteByBanqueId(Long id);
    long countByBanqueId(Long id);
    List<Compte> findByProprietaireId(Long id);
    int deleteByProprietaireId(Long id);
    long countByProprietaireId(Long id);

    List<Compte> findAllOptimized();


}
