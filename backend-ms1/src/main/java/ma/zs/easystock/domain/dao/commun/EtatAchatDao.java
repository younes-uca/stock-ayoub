package ma.zs.easystock.domain.dao.commun;

import ma.zs.easystock.domain.model.commun.EtatAchat;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface EtatAchatDao extends IDao<EtatAchat> {



    List<EtatAchat> findAllOptimized();


}
