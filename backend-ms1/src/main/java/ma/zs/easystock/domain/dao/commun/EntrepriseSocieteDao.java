package ma.zs.easystock.domain.dao.commun;

import ma.zs.easystock.domain.model.commun.EntrepriseSociete;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface EntrepriseSocieteDao extends IDao<EntrepriseSociete> {



    List<EntrepriseSociete> findAllOptimized();


}
