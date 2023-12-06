package ma.zs.easystock.domain.service.impl.admin.stock;


import ma.zs.easystock.domain.model.stock.Inventaire;
import ma.zs.easystock.infra.dao.criteria.core.stock.InventaireCriteria;
import ma.zs.easystock.domain.dao.stock.InventaireDao;
import ma.zs.easystock.infra.dao.specification.core.stock.InventaireSpecification;
import ma.zs.easystock.domain.service.facade.admin.stock.InventaireAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.easystock.domain.service.facade.admin.stock.InventaireItemAdminService ;
import ma.zs.easystock.domain.model.stock.InventaireItem ;
import ma.zs.easystock.domain.service.facade.admin.commun.EntrepriseSocieteAdminService ;
import ma.zs.easystock.domain.model.commun.EntrepriseSociete ;
import ma.zs.easystock.domain.service.facade.admin.commun.DepotAdminService ;
import ma.zs.easystock.domain.model.commun.Depot ;

import java.util.List;
@Service
public class InventaireAdminServiceImpl extends AbstractServiceImpl<Inventaire, InventaireCriteria, InventaireDao> implements InventaireAdminService {


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Inventaire save(Inventaire t) {
    
        super.save(t);
        if (t.getInventaireItems() != null) {
                t.getInventaireItems().forEach(element-> {
                    element.setInventaire(t);
                    inventaireItemService.save(element);
            });
        }
        return t;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public int deleteById(Long id) {
        int result=0;
        result += inventaireItemService.deleteByInventaireId(id);
        result += dao.deleteById(id);
        return result;
    }

    public Inventaire findByReference(String reference){
        return dao.findByReference(reference);
    }
    public int deleteByReference(String reference){
        return dao.deleteByReference(reference);
    }

    public List<Inventaire> findByEntrepriseSocieteId(Long id){
        return dao.findByEntrepriseSocieteId(id);
    }
    public int deleteByEntrepriseSocieteId(Long id){
        return dao.deleteByEntrepriseSocieteId(id);
    }
    public long countByEntrepriseSocieteId(Long id){
        return dao.countByEntrepriseSocieteId(id);
    }
    public List<Inventaire> findByDepotId(Long id){
        return dao.findByDepotId(id);
    }
    public int deleteByDepotId(Long id){
        return dao.deleteByDepotId(id);
    }
    public long countByDepotId(Long id){
        return dao.countByDepotId(id);
    }

    public List<Inventaire> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(Inventaire.class);
    }

    @Autowired
    private InventaireItemAdminService inventaireItemService ;
    @Autowired
    private EntrepriseSocieteAdminService entrepriseSocieteService ;
    @Autowired
    private DepotAdminService depotService ;

    public InventaireAdminServiceImpl(InventaireDao dao) {
        super(dao);
    }

}
