package ma.zs.easystock.domain.dao.commun;

import ma.zs.easystock.domain.model.commun.Fournisseur;

import ma.zs.easystock.domain.model.commun.Fournisseur;

import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface FournisseurDao extends IDao<Fournisseur> {

    Fournisseur findByIce(String ice);
    int deleteByIce(String ice);


    List<Fournisseur> findAllOptimized();


}
