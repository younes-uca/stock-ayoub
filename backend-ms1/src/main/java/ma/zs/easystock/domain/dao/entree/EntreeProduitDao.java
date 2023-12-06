package ma.zs.easystock.domain.dao.entree;

import ma.zs.easystock.domain.model.entree.EntreeProduit;

import ma.zs.easystock.domain.model.entree.EntreeProduit;

import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface EntreeProduitDao extends IDao<EntreeProduit> {

    EntreeProduit findByReference(String reference);
    int deleteByReference(String reference);

    List<EntreeProduit> findByFournisseurId(Long id);
    int deleteByFournisseurId(Long id);
    long countByFournisseurIce(String ice);
    List<EntreeProduit> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);

    List<EntreeProduit> findAllOptimized();


}
