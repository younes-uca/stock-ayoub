package ma.zs.easystock.domain.dao.stock;

import ma.zs.easystock.domain.model.stock.Tache;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface TacheDao extends IDao<Tache> {


    List<Tache> findByLierAId(Long id);
    int deleteByLierAId(Long id);
    long countByLierAId(Long id);



}
