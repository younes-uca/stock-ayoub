package ma.zs.easystock.domain.dao.commun;

import ma.zs.easystock.domain.model.commun.ModeReglement;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface ModeReglementDao extends IDao<ModeReglement> {



    List<ModeReglement> findAllOptimized();


}
