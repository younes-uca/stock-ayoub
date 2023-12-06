package ma.zs.easystock.domain.dao.stock;

import ma.zs.easystock.domain.model.stock.InventaireItem;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface InventaireItemDao extends IDao<InventaireItem> {


    List<InventaireItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<InventaireItem> findByInventaireId(Long id);
    int deleteByInventaireId(Long id);
    long countByInventaireReference(String reference);



}
