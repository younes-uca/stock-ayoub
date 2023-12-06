package ma.zs.easystock.domain.dao.Transfert;

import ma.zs.easystock.domain.model.Transfert.Raison;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface RaisonDao extends IDao<Raison> {



    List<Raison> findAllOptimized();


}
