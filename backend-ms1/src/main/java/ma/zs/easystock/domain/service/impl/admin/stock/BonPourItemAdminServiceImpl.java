package ma.zs.easystock.domain.service.impl.admin.stock;


import ma.zs.easystock.domain.model.stock.BonPourItem;
import ma.zs.easystock.infra.dao.criteria.core.stock.BonPourItemCriteria;
import ma.zs.easystock.domain.dao.stock.BonPourItemDao;
import ma.zs.easystock.infra.dao.specification.core.stock.BonPourItemSpecification;
import ma.zs.easystock.domain.service.facade.admin.stock.BonPourItemAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.domain.service.facade.admin.stock.ProduitAdminService ;
import ma.zs.easystock.domain.model.stock.Produit ;
import ma.zs.easystock.domain.service.facade.admin.stock.BonPourAdminService ;
import ma.zs.easystock.domain.model.stock.BonPour ;
import ma.zs.easystock.domain.service.facade.admin.stock.TaxeAdminService ;
import ma.zs.easystock.domain.model.stock.Taxe ;

import java.util.List;
@Service
public class BonPourItemAdminServiceImpl extends AbstractServiceImpl<BonPourItem, BonPourItemCriteria, BonPourItemDao> implements BonPourItemAdminService {






    public List<BonPourItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitBarCode(String barCode){
        return dao.countByProduitBarCode(barCode);
    }
    public List<BonPourItem> findByTaxeId(Long id){
        return dao.findByTaxeId(id);
    }
    public int deleteByTaxeId(Long id){
        return dao.deleteByTaxeId(id);
    }
    public long countByTaxeId(Long id){
        return dao.countByTaxeId(id);
    }
    public List<BonPourItem> findByBonPourId(Long id){
        return dao.findByBonPourId(id);
    }
    public int deleteByBonPourId(Long id){
        return dao.deleteByBonPourId(id);
    }
    public long countByBonPourNumeroBonPour(String numeroBonPour){
        return dao.countByBonPourNumeroBonPour(numeroBonPour);
    }





    public void configure() {
        super.configure(BonPourItem.class);
    }

    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private BonPourAdminService bonPourService ;
    @Autowired
    private TaxeAdminService taxeService ;

    public BonPourItemAdminServiceImpl(BonPourItemDao dao) {
        super(dao);
    }

}
