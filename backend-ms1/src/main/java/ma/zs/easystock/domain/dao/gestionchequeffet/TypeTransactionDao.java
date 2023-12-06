package ma.zs.easystock.domain.dao.gestionchequeffet;

import ma.zs.easystock.domain.model.gestionchequeffet.TypeTransaction;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface TypeTransactionDao extends IDao<TypeTransaction> {



    List<TypeTransaction> findAllOptimized();


}
