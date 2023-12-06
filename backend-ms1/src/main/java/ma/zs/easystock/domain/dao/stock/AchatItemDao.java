package ma.zs.easystock.domain.dao.stock;

import ma.zs.easystock.domain.model.stock.AchatItem;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface AchatItemDao extends IDao<AchatItem> {


    List<AchatItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<AchatItem> findByTaxeId(Long id);
    int deleteByTaxeId(Long id);
    long countByTaxeId(Long id);
    List<AchatItem> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    long countByAchatId(Long id);
    List<AchatItem> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);



}
