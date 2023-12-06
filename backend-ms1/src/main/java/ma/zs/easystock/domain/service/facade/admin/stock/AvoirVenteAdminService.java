package ma.zs.easystock.domain.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.domain.model.stock.AvoirVente;
import ma.zs.easystock.infra.dao.criteria.core.stock.AvoirVenteCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface AvoirVenteAdminService extends  IService<AvoirVente,AvoirVenteCriteria>  {
    AvoirVente findByNumeroFactureAvoirVente(String numeroFactureAvoirVente);
    int deleteByNumeroFactureAvoirVente(String numeroFactureAvoirVente);

    List<AvoirVente> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<AvoirVente> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientCin(String cin);
    List<AvoirVente> findByEtatAvoirVenteId(Long id);
    int deleteByEtatAvoirVenteId(Long id);
    long countByEtatAvoirVenteId(Long id);
    List<AvoirVente> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    long countByAchatId(Long id);



}
