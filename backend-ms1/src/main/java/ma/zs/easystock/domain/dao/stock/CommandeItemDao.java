package ma.zs.easystock.domain.dao.stock;

import ma.zs.easystock.domain.model.stock.CommandeItem;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface CommandeItemDao extends IDao<CommandeItem> {


    List<CommandeItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<CommandeItem> findByTaxeId(Long id);
    int deleteByTaxeId(Long id);
    long countByTaxeId(Long id);
    List<CommandeItem> findByCommandeId(Long id);
    int deleteByCommandeId(Long id);
    long countByCommandeNumeroCommande(String numeroCommande);



}
