package ma.zs.easystock.domain.dao.stock;

import ma.zs.easystock.domain.model.stock.BonPourItem;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface BonPourItemDao extends IDao<BonPourItem> {


    List<BonPourItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<BonPourItem> findByTaxeId(Long id);
    int deleteByTaxeId(Long id);
    long countByTaxeId(Long id);
    List<BonPourItem> findByBonPourId(Long id);
    int deleteByBonPourId(Long id);
    long countByBonPourNumeroBonPour(String numeroBonPour);



}
