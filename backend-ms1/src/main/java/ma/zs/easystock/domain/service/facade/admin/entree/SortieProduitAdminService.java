package ma.zs.easystock.domain.service.facade.admin.entree;

import java.util.List;
import ma.zs.easystock.domain.model.entree.SortieProduit;
import ma.zs.easystock.infra.dao.criteria.core.entree.SortieProduitCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface SortieProduitAdminService extends  IService<SortieProduit,SortieProduitCriteria>  {
    SortieProduit findByReference(String reference);
    int deleteByReference(String reference);

    List<SortieProduit> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);



}
