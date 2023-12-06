package ma.zs.easystock.domain.service.facade.admin.gestionchequeffet;

import java.util.List;
import ma.zs.easystock.domain.model.gestionchequeffet.PossedeCompte;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.PossedeCompteCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface PossedeCompteAdminService extends  IService<PossedeCompte,PossedeCompteCriteria>  {

    List<PossedeCompte> findByProprietaireId(Long id);
    int deleteByProprietaireId(Long id);
    long countByProprietaireId(Long id);
    List<PossedeCompte> findByBanqueId(Long id);
    int deleteByBanqueId(Long id);
    long countByBanqueId(Long id);
    List<PossedeCompte> findByCompteId(Long id);
    int deleteByCompteId(Long id);
    long countByCompteId(Long id);



}
