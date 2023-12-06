package ma.zs.easystock.domain.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.domain.model.stock.AvoirAchatItem;
import ma.zs.easystock.infra.dao.criteria.core.stock.AvoirAchatItemCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface AvoirAchatItemAdminService extends  IService<AvoirAchatItem,AvoirAchatItemCriteria>  {
    AvoirAchatItem findByBarCode(String barCode);
    int deleteByBarCode(String barCode);

    List<AvoirAchatItem> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);
    List<AvoirAchatItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<AvoirAchatItem> findByTaxeId(Long id);
    int deleteByTaxeId(Long id);
    long countByTaxeId(Long id);
    List<AvoirAchatItem> findByAvoirAchatId(Long id);
    int deleteByAvoirAchatId(Long id);
    long countByAvoirAchatNumeroFactureAvoirAchat(String numeroFactureAvoirAchat);



}
