package ma.zs.easystock.domain.service.impl.admin.stock;


import ma.zs.easystock.domain.model.stock.AchatItem;
import ma.zs.easystock.infra.dao.criteria.core.stock.AchatItemCriteria;
import ma.zs.easystock.domain.dao.stock.AchatItemDao;
import ma.zs.easystock.infra.dao.specification.core.stock.AchatItemSpecification;
import ma.zs.easystock.domain.service.facade.admin.stock.AchatItemAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.domain.service.facade.admin.stock.ProduitAdminService ;
import ma.zs.easystock.domain.model.stock.Produit ;
import ma.zs.easystock.domain.service.facade.admin.stock.AchatAdminService ;
import ma.zs.easystock.domain.model.stock.Achat ;
import ma.zs.easystock.domain.service.facade.admin.stock.TaxeAdminService ;
import ma.zs.easystock.domain.model.stock.Taxe ;
import ma.zs.easystock.domain.service.facade.admin.commun.DepotAdminService ;
import ma.zs.easystock.domain.model.commun.Depot ;

import java.util.List;
@Service
public class AchatItemAdminServiceImpl extends AbstractServiceImpl<AchatItem, AchatItemCriteria, AchatItemDao> implements AchatItemAdminService {






    public List<AchatItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitBarCode(String barCode){
        return dao.countByProduitBarCode(barCode);
    }
    public List<AchatItem> findByTaxeId(Long id){
        return dao.findByTaxeId(id);
    }
    public int deleteByTaxeId(Long id){
        return dao.deleteByTaxeId(id);
    }
    public long countByTaxeId(Long id){
        return dao.countByTaxeId(id);
    }
    public List<AchatItem> findByAchatId(Long id){
        return dao.findByAchatId(id);
    }
    public int deleteByAchatId(Long id){
        return dao.deleteByAchatId(id);
    }
    public long countByAchatId(Long id){
        return dao.countByAchatId(id);
    }
    public List<AchatItem> findByDepotId(Long id){
        return dao.findByDepotId(id);
    }
    public int deleteByDepotId(Long id){
        return dao.deleteByDepotId(id);
    }
    public long countByDepotId(Long id){
        return dao.countByDepotId(id);
    }





    public void configure() {
        super.configure(AchatItem.class);
    }

    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private AchatAdminService achatService ;
    @Autowired
    private TaxeAdminService taxeService ;
    @Autowired
    private DepotAdminService depotService ;

    public AchatItemAdminServiceImpl(AchatItemDao dao) {
        super(dao);
    }

}
