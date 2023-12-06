package ma.zs.easystock.domain.dao.commun;

import ma.zs.easystock.domain.model.commun.EtatAvoirVente;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface EtatAvoirVenteDao extends IDao<EtatAvoirVente> {



    List<EtatAvoirVente> findAllOptimized();


}
