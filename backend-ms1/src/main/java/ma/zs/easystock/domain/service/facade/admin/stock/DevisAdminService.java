package ma.zs.easystock.domain.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.domain.model.stock.Devis;
import ma.zs.easystock.infra.dao.criteria.core.stock.DevisCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface DevisAdminService extends  IService<Devis,DevisCriteria>  {
    Devis findByNumeroDevis(String numeroDevis);
    int deleteByNumeroDevis(String numeroDevis);

    List<Devis> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientCin(String cin);



}
