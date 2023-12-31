package ma.zs.easystock.domain.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.domain.model.stock.VenteItem;
import ma.zs.easystock.infra.dao.criteria.core.stock.VenteItemCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface VenteItemAdminService extends  IService<VenteItem,VenteItemCriteria>  {
    VenteItem findByBarCode(String barCode);
    int deleteByBarCode(String barCode);

    List<VenteItem> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);
    List<VenteItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<VenteItem> findByTaxeId(Long id);
    int deleteByTaxeId(Long id);
    long countByTaxeId(Long id);
    List<VenteItem> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    long countByVenteNumeroFacture(String numeroFacture);



}
