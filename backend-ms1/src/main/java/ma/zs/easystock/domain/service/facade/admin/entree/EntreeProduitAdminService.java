package ma.zs.easystock.domain.service.facade.admin.entree;

import java.util.List;
import ma.zs.easystock.domain.model.entree.EntreeProduit;
import ma.zs.easystock.infra.dao.criteria.core.entree.EntreeProduitCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface EntreeProduitAdminService extends  IService<EntreeProduit,EntreeProduitCriteria>  {
    EntreeProduit findByReference(String reference);
    int deleteByReference(String reference);

    List<EntreeProduit> findByFournisseurId(Long id);
    int deleteByFournisseurId(Long id);
    long countByFournisseurIce(String ice);
    List<EntreeProduit> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);



}
