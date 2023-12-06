package ma.zs.easystock.domain.dao.gestionchequeffet;

import ma.zs.easystock.domain.model.gestionchequeffet.TypeInstrument;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface TypeInstrumentDao extends IDao<TypeInstrument> {



    List<TypeInstrument> findAllOptimized();


}
