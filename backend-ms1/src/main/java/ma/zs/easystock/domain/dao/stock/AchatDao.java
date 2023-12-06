package ma.zs.easystock.domain.dao.stock;

import ma.zs.easystock.domain.model.stock.Achat;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface AchatDao extends IDao<Achat> {


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
