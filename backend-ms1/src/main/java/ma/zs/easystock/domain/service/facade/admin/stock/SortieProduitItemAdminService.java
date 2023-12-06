package ma.zs.easystock.domain.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.domain.model.stock.SortieProduitItem;
import ma.zs.easystock.infra.dao.criteria.core.stock.SortieProduitItemCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface SortieProduitItemAdminService extends  IService<SortieProduitItem,SortieProduitItemCriteria>  {

    List<SortieProduitItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<SortieProduitItem> findBySortieProduitId(Long id);
    int deleteBySortieProduitId(Long id);
    long countBySortieProduitReference(String reference);



}
