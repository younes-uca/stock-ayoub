package ma.zs.easystock.domain.dao.stock;

import ma.zs.easystock.domain.model.stock.AvoirAchat;

import ma.zs.easystock.domain.model.stock.AvoirAchat;

import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface AvoirAchatDao extends IDao<AvoirAchat> {

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

    List<AvoirAchat> findAllOptimized();


}
