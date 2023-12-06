package ma.zs.easystock.domain.service.impl.admin.stock;


import ma.zs.easystock.domain.model.stock.Stock;
import ma.zs.easystock.infra.dao.criteria.core.stock.StockCriteria;
import ma.zs.easystock.domain.dao.stock.StockDao;
import ma.zs.easystock.infra.dao.specification.core.stock.StockSpecification;
import ma.zs.easystock.domain.service.facade.admin.stock.StockAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.stock.StockDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.domain.service.facade.admin.stock.ProduitAdminService ;
import ma.zs.easystock.domain.model.stock.Produit ;
import ma.zs.easystock.domain.service.facade.admin.commun.DepotAdminService ;
import ma.zs.easystock.domain.model.commun.Depot ;

import java.util.List;
@Service
public class StockAdminServiceImpl extends AbstractServiceImpl<Stock, StockCriteria, StockDao> implements StockAdminService {






    public List<Stock> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitBarCode(String barCode){
        return dao.countByProduitBarCode(barCode);
    }
    public List<Stock> findByDepotId(Long id){
        return dao.findByDepotId(id);
    }
    public int deleteByDepotId(Long id){
        return dao.deleteByDepotId(id);
    }
    public long countByDepotId(Long id){
        return dao.countByDepotId(id);
    }





    public void configure() {
        super.configure(Stock.class);
    }

    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private DepotAdminService depotService ;

    public StockAdminServiceImpl(StockDao dao) {
        super(dao);
    }

}
