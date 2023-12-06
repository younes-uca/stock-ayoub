package ma.zs.easystock.domain.service.facade.admin.gestionchequeffet;

import java.util.List;
import ma.zs.easystock.domain.model.gestionchequeffet.ProprietaireBanque;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.ProprietaireBanqueCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface ProprietaireBanqueAdminService extends  IService<ProprietaireBanque,ProprietaireBanqueCriteria>  {

    List<ProprietaireBanque> findByProprietaireId(Long id);
    int deleteByProprietaireId(Long id);
    long countByProprietaireId(Long id);
    List<ProprietaireBanque> findByBanqueId(Long id);
    int deleteByBanqueId(Long id);
    long countByBanqueId(Long id);
    List<ProprietaireBanque> findByCompteId(Long id);
    int deleteByCompteId(Long id);
    long countByCompteId(Long id);



}
