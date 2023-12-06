package ma.zs.easystock.domain.dao.commun;

import ma.zs.easystock.domain.model.commun.EtatVente;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface EtatVenteDao extends IDao<EtatVente> {



    List<EtatVente> findAllOptimized();


}
