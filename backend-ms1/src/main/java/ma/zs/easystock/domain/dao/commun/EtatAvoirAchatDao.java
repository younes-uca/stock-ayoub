package ma.zs.easystock.domain.dao.commun;

import ma.zs.easystock.domain.model.commun.EtatAvoirAchat;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface EtatAvoirAchatDao extends IDao<EtatAvoirAchat> {



    List<EtatAvoirAchat> findAllOptimized();


}
