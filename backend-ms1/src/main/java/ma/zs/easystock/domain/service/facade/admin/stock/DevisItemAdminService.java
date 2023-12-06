package ma.zs.easystock.domain.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.domain.model.stock.DevisItem;
import ma.zs.easystock.infra.dao.criteria.core.stock.DevisItemCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface DevisItemAdminService extends  IService<DevisItem,DevisItemCriteria>  {

    List<DevisItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<DevisItem> findByTaxeId(Long id);
    int deleteByTaxeId(Long id);
    long countByTaxeId(Long id);
    List<DevisItem> findByDevisId(Long id);
    int deleteByDevisId(Long id);
    long countByDevisNumeroDevis(String numeroDevis);



}
