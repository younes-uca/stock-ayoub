package ma.zs.easystock.domain.dao.commun;

import ma.zs.easystock.domain.model.commun.Collaborateur;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface CollaborateurDao extends IDao<Collaborateur> {



    List<Collaborateur> findAllOptimized();


}
