package ma.zs.easystock.domain.dao.commun;

import ma.zs.easystock.domain.model.commun.EtatCommande;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface EtatCommandeDao extends IDao<EtatCommande> {



    List<EtatCommande> findAllOptimized();


}
