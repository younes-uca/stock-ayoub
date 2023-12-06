package ma.zs.easystock.domain.dao.stock;

import ma.zs.easystock.domain.model.stock.EntreeProduitItem;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface EntreeProduitItemDao extends IDao<EntreeProduitItem> {


    List<EntreeProduitItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<EntreeProduitItem> findByEntreeProduitId(Long id);
    int deleteByEntreeProduitId(Long id);
    long countByEntreeProduitReference(String reference);



}
