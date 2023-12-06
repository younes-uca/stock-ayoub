package ma.zs.easystock.domain.dao.commun;

import ma.zs.easystock.domain.model.commun.Personne;

import ma.zs.easystock.domain.model.commun.Personne;

import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface PersonneDao extends IDao<Personne> {

    Personne findByTelephone(String telephone);
    int deleteByTelephone(String telephone);

    List<Personne> findByVilleId(Long id);
    int deleteByVilleId(Long id);
    long countByVilleId(Long id);

    List<Personne> findAllOptimized();


}
