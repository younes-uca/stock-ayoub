package ma.zs.easystock.domain.dao.stock;

import ma.zs.easystock.domain.model.stock.DevisItem;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface DevisItemDao extends IDao<DevisItem> {


    List<DevisItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<DevisItem> findByTaxeId(Long id);
    int deleteByTaxeId(Long id);
    long countByTaxeId(Long id);
    List<DevisItem> findByDevisId(Long id);
    int deleteByDevisId(Long id);
    long countByDevisNumeroDevis(String numeroDevis);



}
