package ma.zs.easystock.domain.service.facade.admin.gestionchequeffet;

import java.util.List;
import ma.zs.easystock.domain.model.gestionchequeffet.Proprietaire;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.ProprietaireCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface ProprietaireAdminService extends  IService<Proprietaire,ProprietaireCriteria>  {

    List<Proprietaire> findByPersonneId(Long id);
    int deleteByPersonneId(Long id);
    long countByPersonneTelephone(String telephone);



}
