package ma.zs.easystock.domain.service.impl.admin.stock;


import ma.zs.easystock.domain.model.stock.InventaireItem;
import ma.zs.easystock.infra.dao.criteria.core.stock.InventaireItemCriteria;
import ma.zs.easystock.domain.dao.stock.InventaireItemDao;
import ma.zs.easystock.infra.dao.specification.core.stock.InventaireItemSpecification;
import ma.zs.easystock.domain.service.facade.admin.stock.InventaireItemAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.domain.service.facade.admin.stock.ProduitAdminService ;
import ma.zs.easystock.domain.model.stock.Produit ;
import ma.zs.easystock.domain.service.facade.admin.stock.InventaireAdminService ;
import ma.zs.easystock.domain.model.stock.Inventaire ;

import java.util.List;
@Service
public class InventaireItemAdminServiceImpl extends AbstractServiceImpl<InventaireItem, InventaireItemCriteria, InventaireItemDao> implements InventaireItemAdminService {






    public List<InventaireItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitBarCode(String barCode){
        return dao.countByProduitBarCode(barCode);
    }
    public List<InventaireItem> findByInventaireId(Long id){
        return dao.findByInventaireId(id);
    }
    public int deleteByInventaireId(Long id){
        return dao.deleteByInventaireId(id);
    }
    public long countByInventaireReference(String reference){
        return dao.countByInventaireReference(reference);
    }





    public void configure() {
        super.configure(InventaireItem.class);
    }

    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private InventaireAdminService inventaireService ;

    public InventaireItemAdminServiceImpl(InventaireItemDao dao) {
        super(dao);
    }

}
