package ma.zs.easystock.domain.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.domain.model.stock.InventaireItem;
import ma.zs.easystock.infra.dao.criteria.core.stock.InventaireItemCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface InventaireItemAdminService extends  IService<InventaireItem,InventaireItemCriteria>  {

    List<InventaireItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<InventaireItem> findByInventaireId(Long id);
    int deleteByInventaireId(Long id);
    long countByInventaireReference(String reference);



}
