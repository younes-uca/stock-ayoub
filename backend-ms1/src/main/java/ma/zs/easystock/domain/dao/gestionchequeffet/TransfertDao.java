package ma.zs.easystock.domain.dao.gestionchequeffet;

import ma.zs.easystock.domain.model.gestionchequeffet.Transfert;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface TransfertDao extends IDao<Transfert> {


    List<Transfert> findByRaisonId(Long id);
    int deleteByRaisonId(Long id);
    long countByRaisonId(Long id);



}
