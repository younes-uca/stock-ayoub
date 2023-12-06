package ma.zs.easystock.domain.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.domain.model.stock.Vente;
import ma.zs.easystock.infra.dao.criteria.core.stock.VenteCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface VenteAdminService extends  IService<Vente,VenteCriteria>  {
    Vente findByNumeroFacture(String numeroFacture);
    int deleteByNumeroFacture(String numeroFacture);

    List<Vente> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<Vente> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientCin(String cin);
    List<Vente> findByEtatVenteId(Long id);
    int deleteByEtatVenteId(Long id);
    long countByEtatVenteId(Long id);



}
