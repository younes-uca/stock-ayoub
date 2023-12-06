package ma.zs.easystock.domain.dao.stock;

import ma.zs.easystock.domain.model.stock.BonPour;

import ma.zs.easystock.domain.model.stock.BonPour;

import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface BonPourDao extends IDao<BonPour> {

    BonPour findByNumeroBonPour(String numeroBonPour);
    int deleteByNumeroBonPour(String numeroBonPour);

    List<BonPour> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientCin(String cin);

    List<BonPour> findAllOptimized();


}
