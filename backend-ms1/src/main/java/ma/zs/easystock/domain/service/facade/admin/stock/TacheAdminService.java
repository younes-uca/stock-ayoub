package ma.zs.easystock.domain.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.domain.model.stock.Tache;
import ma.zs.easystock.infra.dao.criteria.core.stock.TacheCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface TacheAdminService extends  IService<Tache,TacheCriteria>  {

    List<Tache> findByLierAId(Long id);
    int deleteByLierAId(Long id);
    long countByLierAId(Long id);



}
