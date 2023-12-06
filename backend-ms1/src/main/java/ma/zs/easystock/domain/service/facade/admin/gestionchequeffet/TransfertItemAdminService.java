package ma.zs.easystock.domain.service.facade.admin.gestionchequeffet;

import java.util.List;
import ma.zs.easystock.domain.model.gestionchequeffet.TransfertItem;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.TransfertItemCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface TransfertItemAdminService extends  IService<TransfertItem,TransfertItemCriteria>  {

    List<TransfertItem> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);
    List<TransfertItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<TransfertItem> findByTransfertId(Long id);
    int deleteByTransfertId(Long id);
    long countByTransfertId(Long id);



}
