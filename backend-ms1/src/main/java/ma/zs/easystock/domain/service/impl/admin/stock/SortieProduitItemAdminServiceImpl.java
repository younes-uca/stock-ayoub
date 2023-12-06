package ma.zs.easystock.domain.service.impl.admin.stock;


import ma.zs.easystock.domain.model.stock.SortieProduitItem;
import ma.zs.easystock.infra.dao.criteria.core.stock.SortieProduitItemCriteria;
import ma.zs.easystock.domain.dao.stock.SortieProduitItemDao;
import ma.zs.easystock.infra.dao.specification.core.stock.SortieProduitItemSpecification;
import ma.zs.easystock.domain.service.facade.admin.stock.SortieProduitItemAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.domain.service.facade.admin.stock.ProduitAdminService ;
import ma.zs.easystock.domain.model.stock.Produit ;
import ma.zs.easystock.domain.service.facade.admin.entree.SortieProduitAdminService ;
import ma.zs.easystock.domain.model.entree.SortieProduit ;

import java.util.List;
@Service
public class SortieProduitItemAdminServiceImpl extends AbstractServiceImpl<SortieProduitItem, SortieProduitItemCriteria, SortieProduitItemDao> implements SortieProduitItemAdminService {






    public List<SortieProduitItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitBarCode(String barCode){
        return dao.countByProduitBarCode(barCode);
    }
    public List<SortieProduitItem> findBySortieProduitId(Long id){
        return dao.findBySortieProduitId(id);
    }
    public int deleteBySortieProduitId(Long id){
        return dao.deleteBySortieProduitId(id);
    }
    public long countBySortieProduitReference(String reference){
        return dao.countBySortieProduitReference(reference);
    }





    public void configure() {
        super.configure(SortieProduitItem.class);
    }

    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private SortieProduitAdminService sortieProduitService ;

    public SortieProduitItemAdminServiceImpl(SortieProduitItemDao dao) {
        super(dao);
    }

}
