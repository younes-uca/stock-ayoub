package ma.zs.easystock.domain.service.impl.admin.gestionchequeffet;


import ma.zs.easystock.domain.model.gestionchequeffet.TransfertItem;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.TransfertItemCriteria;
import ma.zs.easystock.domain.dao.gestionchequeffet.TransfertItemDao;
import ma.zs.easystock.infra.dao.specification.core.gestionchequeffet.TransfertItemSpecification;
import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.TransfertItemAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.domain.service.facade.admin.stock.ProduitAdminService ;
import ma.zs.easystock.domain.model.stock.Produit ;
import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.TransfertAdminService ;
import ma.zs.easystock.domain.model.gestionchequeffet.Transfert ;
import ma.zs.easystock.domain.service.facade.admin.commun.DepotAdminService ;
import ma.zs.easystock.domain.model.commun.Depot ;

import java.util.List;
@Service
public class TransfertItemAdminServiceImpl extends AbstractServiceImpl<TransfertItem, TransfertItemCriteria, TransfertItemDao> implements TransfertItemAdminService {






    public List<TransfertItem> findByDepotId(Long id){
        return dao.findByDepotId(id);
    }
    public int deleteByDepotId(Long id){
        return dao.deleteByDepotId(id);
    }
    public long countByDepotId(Long id){
        return dao.countByDepotId(id);
    }
    public List<TransfertItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitBarCode(String barCode){
        return dao.countByProduitBarCode(barCode);
    }
    public List<TransfertItem> findByTransfertId(Long id){
        return dao.findByTransfertId(id);
    }
    public int deleteByTransfertId(Long id){
        return dao.deleteByTransfertId(id);
    }
    public long countByTransfertId(Long id){
        return dao.countByTransfertId(id);
    }





    public void configure() {
        super.configure(TransfertItem.class);
    }

    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private TransfertAdminService transfertService ;
    @Autowired
    private DepotAdminService depotService ;

    public TransfertItemAdminServiceImpl(TransfertItemDao dao) {
        super(dao);
    }

}
