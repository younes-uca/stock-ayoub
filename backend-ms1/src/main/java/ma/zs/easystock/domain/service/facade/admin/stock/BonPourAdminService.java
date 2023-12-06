package ma.zs.easystock.domain.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.domain.model.stock.BonPour;
import ma.zs.easystock.infra.dao.criteria.core.stock.BonPourCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface BonPourAdminService extends  IService<BonPour,BonPourCriteria>  {
    BonPour findByNumeroBonPour(String numeroBonPour);
    int deleteByNumeroBonPour(String numeroBonPour);

    List<BonPour> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientCin(String cin);



}
