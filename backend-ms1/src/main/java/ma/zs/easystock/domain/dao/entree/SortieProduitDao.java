package ma.zs.easystock.domain.dao.entree;

import ma.zs.easystock.domain.model.entree.SortieProduit;

import ma.zs.easystock.domain.model.entree.SortieProduit;

import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface SortieProduitDao extends IDao<SortieProduit> {

    SortieProduit findByReference(String reference);
    int deleteByReference(String reference);

    List<SortieProduit> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);

    List<SortieProduit> findAllOptimized();


}
