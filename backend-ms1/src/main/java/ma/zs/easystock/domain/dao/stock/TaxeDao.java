package ma.zs.easystock.domain.dao.stock;

import ma.zs.easystock.domain.model.stock.Taxe;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface TaxeDao extends IDao<Taxe> {



    List<Taxe> findAllOptimized();


}
