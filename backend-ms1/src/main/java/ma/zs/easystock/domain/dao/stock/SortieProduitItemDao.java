package ma.zs.easystock.domain.dao.stock;

import ma.zs.easystock.domain.model.stock.SortieProduitItem;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface SortieProduitItemDao extends IDao<SortieProduitItem> {


    List<SortieProduitItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<SortieProduitItem> findBySortieProduitId(Long id);
    int deleteBySortieProduitId(Long id);
    long countBySortieProduitReference(String reference);



}
