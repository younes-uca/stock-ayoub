package ma.zs.easystock.domain.service.impl.admin.entree;


import ma.zs.easystock.domain.model.entree.EntreeProduit;
import ma.zs.easystock.infra.dao.criteria.core.entree.EntreeProduitCriteria;
import ma.zs.easystock.domain.dao.entree.EntreeProduitDao;
import ma.zs.easystock.infra.dao.specification.core.entree.EntreeProduitSpecification;
import ma.zs.easystock.domain.service.facade.admin.entree.EntreeProduitAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.easystock.domain.service.facade.admin.stock.EntreeProduitItemAdminService ;
import ma.zs.easystock.domain.model.stock.EntreeProduitItem ;
import ma.zs.easystock.domain.service.facade.admin.commun.DepotAdminService ;
import ma.zs.easystock.domain.model.commun.Depot ;
import ma.zs.easystock.domain.service.facade.admin.commun.FournisseurAdminService ;
import ma.zs.easystock.domain.model.commun.Fournisseur ;

import java.util.List;
@Service
public class EntreeProduitAdminServiceImpl extends AbstractServiceImpl<EntreeProduit, EntreeProduitCriteria, EntreeProduitDao> implements EntreeProduitAdminService {


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public EntreeProduit save(EntreeProduit t) {
    
        super.save(t);
        if (t.getEntreeProduitItems() != null) {
                t.getEntreeProduitItems().forEach(element-> {
                    element.setEntreeProduit(t);
                    entreeProduitItemService.save(element);
            });
        }
        return t;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public int deleteById(Long id) {
        int result=0;
        result += entreeProduitItemService.deleteByEntreeProduitId(id);
        result += dao.deleteById(id);
        return result;
    }

    public EntreeProduit findByReference(String reference){
        return dao.findByReference(reference);
    }
    public int deleteByReference(String reference){
        return dao.deleteByReference(reference);
    }

    public List<EntreeProduit> findByFournisseurId(Long id){
        return dao.findByFournisseurId(id);
    }
    public int deleteByFournisseurId(Long id){
        return dao.deleteByFournisseurId(id);
    }
    public long countByFournisseurIce(String ice){
        return dao.countByFournisseurIce(ice);
    }
    public List<EntreeProduit> findByDepotId(Long id){
        return dao.findByDepotId(id);
    }
    public int deleteByDepotId(Long id){
        return dao.deleteByDepotId(id);
    }
    public long countByDepotId(Long id){
        return dao.countByDepotId(id);
    }

    public List<EntreeProduit> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(EntreeProduit.class);
    }

    @Autowired
    private EntreeProduitItemAdminService entreeProduitItemService ;
    @Autowired
    private DepotAdminService depotService ;
    @Autowired
    private FournisseurAdminService fournisseurService ;

    public EntreeProduitAdminServiceImpl(EntreeProduitDao dao) {
        super(dao);
    }

}
