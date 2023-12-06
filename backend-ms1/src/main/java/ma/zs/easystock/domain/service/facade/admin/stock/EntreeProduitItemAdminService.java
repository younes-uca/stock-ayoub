package ma.zs.easystock.domain.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.domain.model.stock.EntreeProduitItem;
import ma.zs.easystock.infra.dao.criteria.core.stock.EntreeProduitItemCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface EntreeProduitItemAdminService extends  IService<EntreeProduitItem,EntreeProduitItemCriteria>  {

    List<EntreeProduitItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<EntreeProduitItem> findByEntreeProduitId(Long id);
    int deleteByEntreeProduitId(Long id);
    long countByEntreeProduitReference(String reference);



}
