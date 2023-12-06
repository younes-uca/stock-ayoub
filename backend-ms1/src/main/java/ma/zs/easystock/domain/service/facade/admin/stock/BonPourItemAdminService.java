package ma.zs.easystock.domain.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.domain.model.stock.BonPourItem;
import ma.zs.easystock.infra.dao.criteria.core.stock.BonPourItemCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface BonPourItemAdminService extends  IService<BonPourItem,BonPourItemCriteria>  {

    List<BonPourItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<BonPourItem> findByTaxeId(Long id);
    int deleteByTaxeId(Long id);
    long countByTaxeId(Long id);
    List<BonPourItem> findByBonPourId(Long id);
    int deleteByBonPourId(Long id);
    long countByBonPourNumeroBonPour(String numeroBonPour);



}
