package ma.zs.easystock.domain.service.impl.admin.stock;


import ma.zs.easystock.domain.model.stock.Achat;
import ma.zs.easystock.infra.dao.criteria.core.stock.AchatCriteria;
import ma.zs.easystock.domain.dao.stock.AchatDao;
import ma.zs.easystock.infra.dao.specification.core.stock.AchatSpecification;
import ma.zs.easystock.domain.service.facade.admin.stock.AchatAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.easystock.domain.service.facade.admin.commun.EtatAchatAdminService ;
import ma.zs.easystock.domain.model.commun.EtatAchat ;
import ma.zs.easystock.domain.service.facade.admin.commun.EntrepriseSocieteAdminService ;
import ma.zs.easystock.domain.model.commun.EntrepriseSociete ;
import ma.zs.easystock.domain.service.facade.admin.stock.AvoirAchatAdminService ;
import ma.zs.easystock.domain.model.stock.AvoirAchat ;
import ma.zs.easystock.domain.service.facade.admin.stock.AchatItemAdminService ;
import ma.zs.easystock.domain.model.stock.AchatItem ;
import ma.zs.easystock.domain.service.facade.admin.commun.FournisseurAdminService ;
import ma.zs.easystock.domain.model.commun.Fournisseur ;

import java.util.List;
@Service
public class AchatAdminServiceImpl extends AbstractServiceImpl<Achat, AchatCriteria, AchatDao> implements AchatAdminService {


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Achat save(Achat t) {
    
        super.save(t);
        if (t.getAchatItems() != null) {
                t.getAchatItems().forEach(element-> {
                    element.setAchat(t);
                    achatItemService.save(element);
            });
        }
        if (t.getAvoirs() != null) {
                t.getAvoirs().forEach(element-> {
                    element.setAchat(t);
                    avoirAchatService.save(element);
            });
        }
        return t;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public int deleteById(Long id) {
        int result=0;
        result += achatItemService.deleteByAchatId(id);
        result += avoirAchatService.deleteByAchatId(id);
        result += dao.deleteById(id);
        return result;
    }


    public List<Achat> findByEntrepriseSocieteId(Long id){
        return dao.findByEntrepriseSocieteId(id);
    }
    public int deleteByEntrepriseSocieteId(Long id){
        return dao.deleteByEntrepriseSocieteId(id);
    }
    public long countByEntrepriseSocieteId(Long id){
        return dao.countByEntrepriseSocieteId(id);
    }
    public List<Achat> findByFournisseurId(Long id){
        return dao.findByFournisseurId(id);
    }
    public int deleteByFournisseurId(Long id){
        return dao.deleteByFournisseurId(id);
    }
    public long countByFournisseurIce(String ice){
        return dao.countByFournisseurIce(ice);
    }
    public List<Achat> findByEtatAchatId(Long id){
        return dao.findByEtatAchatId(id);
    }
    public int deleteByEtatAchatId(Long id){
        return dao.deleteByEtatAchatId(id);
    }
    public long countByEtatAchatId(Long id){
        return dao.countByEtatAchatId(id);
    }





    public void configure() {
        super.configure(Achat.class);
    }

    @Autowired
    private EtatAchatAdminService etatAchatService ;
    @Autowired
    private EntrepriseSocieteAdminService entrepriseSocieteService ;
    @Autowired
    private AvoirAchatAdminService avoirAchatService ;
    @Autowired
    private AchatItemAdminService achatItemService ;
    @Autowired
    private FournisseurAdminService fournisseurService ;

    public AchatAdminServiceImpl(AchatDao dao) {
        super(dao);
    }

}
