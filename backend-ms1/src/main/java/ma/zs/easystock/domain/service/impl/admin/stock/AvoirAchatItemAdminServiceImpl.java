package ma.zs.easystock.domain.service.impl.admin.stock;


import ma.zs.easystock.domain.model.stock.AvoirAchatItem;
import ma.zs.easystock.infra.dao.criteria.core.stock.AvoirAchatItemCriteria;
import ma.zs.easystock.domain.dao.stock.AvoirAchatItemDao;
import ma.zs.easystock.infra.dao.specification.core.stock.AvoirAchatItemSpecification;
import ma.zs.easystock.domain.service.facade.admin.stock.AvoirAchatItemAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.domain.service.facade.admin.stock.ProduitAdminService ;
import ma.zs.easystock.domain.model.stock.Produit ;
import ma.zs.easystock.domain.service.facade.admin.stock.AvoirAchatAdminService ;
import ma.zs.easystock.domain.model.stock.AvoirAchat ;
import ma.zs.easystock.domain.service.facade.admin.commun.DepotAdminService ;
import ma.zs.easystock.domain.model.commun.Depot ;
import ma.zs.easystock.domain.service.facade.admin.stock.TaxeAdminService ;
import ma.zs.easystock.domain.model.stock.Taxe ;

import java.util.List;
@Service
public class AvoirAchatItemAdminServiceImpl extends AbstractServiceImpl<AvoirAchatItem, AvoirAchatItemCriteria, AvoirAchatItemDao> implements AvoirAchatItemAdminService {





    public AvoirAchatItem findByBarCode(String barCode){
        return dao.findByBarCode(barCode);
    }
    public int deleteByBarCode(String barCode){
        return dao.deleteByBarCode(barCode);
    }

    public List<AvoirAchatItem> findByDepotId(Long id){
        return dao.findByDepotId(id);
    }
    public int deleteByDepotId(Long id){
        return dao.deleteByDepotId(id);
    }
    public long countByDepotId(Long id){
        return dao.countByDepotId(id);
    }
    public List<AvoirAchatItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitBarCode(String barCode){
        return dao.countByProduitBarCode(barCode);
    }
    public List<AvoirAchatItem> findByTaxeId(Long id){
        return dao.findByTaxeId(id);
    }
    public int deleteByTaxeId(Long id){
        return dao.deleteByTaxeId(id);
    }
    public long countByTaxeId(Long id){
        return dao.countByTaxeId(id);
    }
    public List<AvoirAchatItem> findByAvoirAchatId(Long id){
        return dao.findByAvoirAchatId(id);
    }
    public int deleteByAvoirAchatId(Long id){
        return dao.deleteByAvoirAchatId(id);
    }
    public long countByAvoirAchatNumeroFactureAvoirAchat(String numeroFactureAvoirAchat){
        return dao.countByAvoirAchatNumeroFactureAvoirAchat(numeroFactureAvoirAchat);
    }

    public List<AvoirAchatItem> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(AvoirAchatItem.class);
    }

    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private AvoirAchatAdminService avoirAchatService ;
    @Autowired
    private DepotAdminService depotService ;
    @Autowired
    private TaxeAdminService taxeService ;

    public AvoirAchatItemAdminServiceImpl(AvoirAchatItemDao dao) {
        super(dao);
    }

}
