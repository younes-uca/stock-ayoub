package ma.zs.easystock.domain.dao.gestionchequeffet;

import ma.zs.easystock.domain.model.gestionchequeffet.TransfertItem;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface TransfertItemDao extends IDao<TransfertItem> {


    List<TransfertItem> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);
    List<TransfertItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<TransfertItem> findByTransfertId(Long id);
    int deleteByTransfertId(Long id);
    long countByTransfertId(Long id);



}
