package ma.zs.easystock.domain.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.domain.model.stock.AchatItem;
import ma.zs.easystock.infra.dao.criteria.core.stock.AchatItemCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface AchatItemAdminService extends  IService<AchatItem,AchatItemCriteria>  {

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
