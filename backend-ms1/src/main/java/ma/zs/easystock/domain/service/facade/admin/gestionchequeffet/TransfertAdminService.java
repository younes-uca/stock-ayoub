package ma.zs.easystock.domain.service.facade.admin.gestionchequeffet;

import java.util.List;
import ma.zs.easystock.domain.model.gestionchequeffet.Transfert;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.TransfertCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface TransfertAdminService extends  IService<Transfert,TransfertCriteria>  {

    List<Transfert> findByRaisonId(Long id);
    int deleteByRaisonId(Long id);
    long countByRaisonId(Long id);



}
