package ma.zs.easystock.domain.dao.stock;

import ma.zs.easystock.domain.model.stock.AvoirVenteItem;

import ma.zs.easystock.domain.model.stock.AvoirVenteItem;

import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface AvoirVenteItemDao extends IDao<AvoirVenteItem> {

    AvoirVenteItem findByBarCode(String barCode);
    int deleteByBarCode(String barCode);

    List<AvoirVenteItem> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);
    List<AvoirVenteItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<AvoirVenteItem> findByTaxeId(Long id);
    int deleteByTaxeId(Long id);
    long countByTaxeId(Long id);
    List<AvoirVenteItem> findByAvoirVenteId(Long id);
    int deleteByAvoirVenteId(Long id);
    long countByAvoirVenteNumeroFactureAvoirVente(String numeroFactureAvoirVente);

    List<AvoirVenteItem> findAllOptimized();


}
