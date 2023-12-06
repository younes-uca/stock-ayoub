package ma.zs.easystock.domain.dao.commun;

import ma.zs.easystock.domain.model.commun.Marque;

import ma.zs.easystock.domain.model.commun.Marque;

import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface MarqueDao extends IDao<Marque> {

    Marque findByLibelle(String libelle);
    int deleteByLibelle(String libelle);


    List<Marque> findAllOptimized();


}
