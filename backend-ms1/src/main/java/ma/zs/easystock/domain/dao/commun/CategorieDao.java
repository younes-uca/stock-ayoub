package ma.zs.easystock.domain.dao.commun;

import ma.zs.easystock.domain.model.commun.Categorie;

import ma.zs.easystock.domain.model.commun.Categorie;

import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface CategorieDao extends IDao<Categorie> {

    Categorie findByLibelle(String libelle);
    int deleteByLibelle(String libelle);


    List<Categorie> findAllOptimized();


}
