package ma.zs.easystock.domain.dao.stock;

import ma.zs.easystock.domain.model.stock.AvoirVente;

import ma.zs.easystock.domain.model.stock.AvoirVente;

import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface AvoirVenteDao extends IDao<AvoirVente> {

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

    List<AvoirVente> findAllOptimized();


}
