package ma.zs.easystock.domain.service.facade.admin.gestionchequeffet;

import java.util.List;
import ma.zs.easystock.domain.model.gestionchequeffet.Compte;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.CompteCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface CompteAdminService extends  IService<Compte,CompteCriteria>  {

    List<Compte> findByBanqueId(Long id);
    int deleteByBanqueId(Long id);
    long countByBanqueId(Long id);
    List<Compte> findByProprietaireId(Long id);
    int deleteByProprietaireId(Long id);
    long countByProprietaireId(Long id);



}
