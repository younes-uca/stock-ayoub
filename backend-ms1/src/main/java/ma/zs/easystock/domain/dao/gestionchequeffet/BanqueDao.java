package ma.zs.easystock.domain.dao.gestionchequeffet;

import ma.zs.easystock.domain.model.gestionchequeffet.Banque;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface BanqueDao extends IDao<Banque> {



    List<Banque> findAllOptimized();


}
