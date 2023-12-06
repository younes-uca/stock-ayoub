package ma.zs.easystock.domain.service.facade.admin.commun;

import java.util.List;
import ma.zs.easystock.domain.model.commun.Marque;
import ma.zs.easystock.infra.dao.criteria.core.commun.MarqueCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface MarqueAdminService extends  IService<Marque,MarqueCriteria>  {
    Marque findByLibelle(String libelle);
    int deleteByLibelle(String libelle);




}
