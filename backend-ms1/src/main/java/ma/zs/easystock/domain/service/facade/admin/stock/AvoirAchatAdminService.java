package ma.zs.easystock.domain.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.domain.model.stock.AvoirAchat;
import ma.zs.easystock.infra.dao.criteria.core.stock.AvoirAchatCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface AvoirAchatAdminService extends  IService<AvoirAchat,AvoirAchatCriteria>  {
    AvoirAchat findByNumeroFactureAvoirAchat(String numeroFactureAvoirAchat);
    int deleteByNumeroFactureAvoirAchat(String numeroFactureAvoirAchat);

    List<AvoirAchat> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<AvoirAchat> findByFournisseurId(Long id);
    int deleteByFournisseurId(Long id);
    long countByFournisseurIce(String ice);
    List<AvoirAchat> findByEtatAvoirAchatId(Long id);
    int deleteByEtatAvoirAchatId(Long id);
    long countByEtatAvoirAchatId(Long id);



}
