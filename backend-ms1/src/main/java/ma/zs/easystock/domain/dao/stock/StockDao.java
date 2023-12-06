package ma.zs.easystock.domain.dao.stock;

import ma.zs.easystock.domain.model.stock.Stock;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface StockDao extends IDao<Stock> {


    List<Stock> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<Stock> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);



}
