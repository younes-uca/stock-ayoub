package ma.zs.easystock.domain.dao.stock;

import ma.zs.easystock.domain.model.stock.Devis;

import ma.zs.easystock.domain.model.stock.Devis;

import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface DevisDao extends IDao<Devis> {

    Devis findByNumeroDevis(String numeroDevis);
    int deleteByNumeroDevis(String numeroDevis);

    List<Devis> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientCin(String cin);

    List<Devis> findAllOptimized();


}
