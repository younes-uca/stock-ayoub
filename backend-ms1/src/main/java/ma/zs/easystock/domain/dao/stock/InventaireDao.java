package ma.zs.easystock.domain.dao.stock;

import ma.zs.easystock.domain.model.stock.Inventaire;

import ma.zs.easystock.domain.model.stock.Inventaire;

import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface InventaireDao extends IDao<Inventaire> {

    Inventaire findByReference(String reference);
    int deleteByReference(String reference);

    List<Inventaire> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<Inventaire> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);

    List<Inventaire> findAllOptimized();


}
