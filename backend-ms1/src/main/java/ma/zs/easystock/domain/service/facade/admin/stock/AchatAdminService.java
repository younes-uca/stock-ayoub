package ma.zs.easystock.domain.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.domain.model.stock.Achat;
import ma.zs.easystock.infra.dao.criteria.core.stock.AchatCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface AchatAdminService extends  IService<Achat,AchatCriteria>  {

    List<Achat> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<Achat> findByFournisseurId(Long id);
    int deleteByFournisseurId(Long id);
    long countByFournisseurIce(String ice);
    List<Achat> findByEtatAchatId(Long id);
    int deleteByEtatAchatId(Long id);
    long countByEtatAchatId(Long id);



}
