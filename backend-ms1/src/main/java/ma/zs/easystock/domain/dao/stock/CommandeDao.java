package ma.zs.easystock.domain.dao.stock;

import ma.zs.easystock.domain.model.stock.Commande;

import ma.zs.easystock.domain.model.stock.Commande;

import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface CommandeDao extends IDao<Commande> {

    Commande findByNumeroCommande(String numeroCommande);
    int deleteByNumeroCommande(String numeroCommande);

    List<Commande> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientCin(String cin);
    List<Commande> findByEtatCommandeId(Long id);
    int deleteByEtatCommandeId(Long id);
    long countByEtatCommandeId(Long id);

    List<Commande> findAllOptimized();


}
