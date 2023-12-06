package ma.zs.easystock.domain.dao.commun;

import ma.zs.easystock.domain.model.commun.Depot;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface DepotDao extends IDao<Depot> {



    List<Depot> findAllOptimized();


}
