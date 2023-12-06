package ma.zs.easystock.domain.service.impl.admin.stock;


import ma.zs.easystock.domain.model.stock.VenteItem;
import ma.zs.easystock.infra.dao.criteria.core.stock.VenteItemCriteria;
import ma.zs.easystock.domain.dao.stock.VenteItemDao;
import ma.zs.easystock.infra.dao.specification.core.stock.VenteItemSpecification;
import ma.zs.easystock.domain.service.facade.admin.stock.VenteItemAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.domain.service.facade.admin.stock.ProduitAdminService ;
import ma.zs.easystock.domain.model.stock.Produit ;
import ma.zs.easystock.domain.service.facade.admin.stock.VenteAdminService ;
import ma.zs.easystock.domain.model.stock.Vente ;
import ma.zs.easystock.domain.service.facade.admin.commun.DepotAdminService ;
import ma.zs.easystock.domain.model.commun.Depot ;
import ma.zs.easystock.domain.service.facade.admin.stock.TaxeAdminService ;
import ma.zs.easystock.domain.model.stock.Taxe ;

import java.util.List;
@Service
public class VenteItemAdminServiceImpl extends AbstractServiceImpl<VenteItem, VenteItemCriteria, VenteItemDao> implements VenteItemAdminService {





    public VenteItem findByBarCode(String barCode){
        return dao.findByBarCode(barCode);
    }
    public int deleteByBarCode(String barCode){
        return dao.deleteByBarCode(barCode);
    }

    public List<VenteItem> findByDepotId(Long id){
        return dao.findByDepotId(id);
    }
    public int deleteByDepotId(Long id){
        return dao.deleteByDepotId(id);
    }
    public long countByDepotId(Long id){
        return dao.countByDepotId(id);
    }
    public List<VenteItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitBarCode(String barCode){
        return dao.countByProduitBarCode(barCode);
    }
    public List<VenteItem> findByTaxeId(Long id){
        return dao.findByTaxeId(id);
    }
    public int deleteByTaxeId(Long id){
        return dao.deleteByTaxeId(id);
    }
    public long countByTaxeId(Long id){
        return dao.countByTaxeId(id);
    }
    public List<VenteItem> findByVenteId(Long id){
        return dao.findByVenteId(id);
    }
    public int deleteByVenteId(Long id){
        return dao.deleteByVenteId(id);
    }
    public long countByVenteNumeroFacture(String numeroFacture){
        return dao.countByVenteNumeroFacture(numeroFacture);
    }

    public List<VenteItem> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(VenteItem.class);
    }

    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private VenteAdminService venteService ;
    @Autowired
    private DepotAdminService depotService ;
    @Autowired
    private TaxeAdminService taxeService ;

    public VenteItemAdminServiceImpl(VenteItemDao dao) {
        super(dao);
    }

}
