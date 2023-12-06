package ma.zs.easystock.domain.service.impl.admin.entree;


import ma.zs.easystock.domain.model.entree.SortieProduit;
import ma.zs.easystock.infra.dao.criteria.core.entree.SortieProduitCriteria;
import ma.zs.easystock.domain.dao.entree.SortieProduitDao;
import ma.zs.easystock.infra.dao.specification.core.entree.SortieProduitSpecification;
import ma.zs.easystock.domain.service.facade.admin.entree.SortieProduitAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.easystock.domain.service.facade.admin.stock.SortieProduitItemAdminService ;
import ma.zs.easystock.domain.model.stock.SortieProduitItem ;
import ma.zs.easystock.domain.service.facade.admin.commun.DepotAdminService ;
import ma.zs.easystock.domain.model.commun.Depot ;

import java.util.List;
@Service
public class SortieProduitAdminServiceImpl extends AbstractServiceImpl<SortieProduit, SortieProduitCriteria, SortieProduitDao> implements SortieProduitAdminService {


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public SortieProduit save(SortieProduit t) {
    
        super.save(t);
        if (t.getSortieProduitItems() != null) {
                t.getSortieProduitItems().forEach(element-> {
                    element.setSortieProduit(t);
                    sortieProduitItemService.save(element);
            });
        }
        return t;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public int deleteById(Long id) {
        int result=0;
        result += sortieProduitItemService.deleteBySortieProduitId(id);
        result += dao.deleteById(id);
        return result;
    }

    public SortieProduit findByReference(String reference){
        return dao.findByReference(reference);
    }
    public int deleteByReference(String reference){
        return dao.deleteByReference(reference);
    }

    public List<SortieProduit> findByDepotId(Long id){
        return dao.findByDepotId(id);
    }
    public int deleteByDepotId(Long id){
        return dao.deleteByDepotId(id);
    }
    public long countByDepotId(Long id){
        return dao.countByDepotId(id);
    }

    public List<SortieProduit> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(SortieProduit.class);
    }

    @Autowired
    private SortieProduitItemAdminService sortieProduitItemService ;
    @Autowired
    private DepotAdminService depotService ;

    public SortieProduitAdminServiceImpl(SortieProduitDao dao) {
        super(dao);
    }

}
