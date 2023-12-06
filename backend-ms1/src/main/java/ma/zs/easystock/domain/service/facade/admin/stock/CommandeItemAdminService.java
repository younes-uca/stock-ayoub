package ma.zs.easystock.domain.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.domain.model.stock.CommandeItem;
import ma.zs.easystock.infra.dao.criteria.core.stock.CommandeItemCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface CommandeItemAdminService extends  IService<CommandeItem,CommandeItemCriteria>  {

    List<CommandeItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<CommandeItem> findByTaxeId(Long id);
    int deleteByTaxeId(Long id);
    long countByTaxeId(Long id);
    List<CommandeItem> findByCommandeId(Long id);
    int deleteByCommandeId(Long id);
    long countByCommandeNumeroCommande(String numeroCommande);



}
