package ma.zs.easystock.domain.dao.commun;

import ma.zs.easystock.domain.model.commun.UniteMesure;

import ma.zs.easystock.domain.model.commun.UniteMesure;

import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface UniteMesureDao extends IDao<UniteMesure> {

    UniteMesure findByLibelle(String libelle);
    int deleteByLibelle(String libelle);


    List<UniteMesure> findAllOptimized();


}
