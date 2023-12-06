package ma.zs.easystock.domain.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.domain.model.stock.Commande;
import ma.zs.easystock.infra.dao.criteria.core.stock.CommandeCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface CommandeAdminService extends  IService<Commande,CommandeCriteria>  {
    Commande findByNumeroCommande(String numeroCommande);
    int deleteByNumeroCommande(String numeroCommande);

    List<Commande> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientCin(String cin);
    List<Commande> findByEtatCommandeId(Long id);
    int deleteByEtatCommandeId(Long id);
    long countByEtatCommandeId(Long id);



}
