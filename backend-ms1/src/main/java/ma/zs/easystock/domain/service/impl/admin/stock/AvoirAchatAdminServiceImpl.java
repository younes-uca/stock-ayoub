package ma.zs.easystock.domain.service.impl.admin.stock;


import ma.zs.easystock.domain.model.stock.AvoirAchat;
import ma.zs.easystock.infra.dao.criteria.core.stock.AvoirAchatCriteria;
import ma.zs.easystock.domain.dao.stock.AvoirAchatDao;
import ma.zs.easystock.infra.dao.specification.core.stock.AvoirAchatSpecification;
import ma.zs.easystock.domain.service.facade.admin.stock.AvoirAchatAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.easystock.domain.service.facade.admin.commun.EtatAvoirAchatAdminService ;
import ma.zs.easystock.domain.model.commun.EtatAvoirAchat ;
import ma.zs.easystock.domain.service.facade.admin.commun.EntrepriseSocieteAdminService ;
import ma.zs.easystock.domain.model.commun.EntrepriseSociete ;
import ma.zs.easystock.domain.service.facade.admin.commun.FournisseurAdminService ;
import ma.zs.easystock.domain.model.commun.Fournisseur ;
import ma.zs.easystock.domain.service.facade.admin.stock.AvoirAchatItemAdminService ;
import ma.zs.easystock.domain.model.stock.AvoirAchatItem ;

import java.util.List;
@Service
public class AvoirAchatAdminServiceImpl extends AbstractServiceImpl<AvoirAchat, AvoirAchatCriteria, AvoirAchatDao> implements AvoirAchatAdminService {


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public AvoirAchat save(AvoirAchat t) {
    
        super.save(t);
        if (t.getAvoirAchatItems() != null) {
                t.getAvoirAchatItems().forEach(element-> {
                    element.setAvoirAchat(t);
                    avoirAchatItemService.save(element);
            });
        }
        return t;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public int deleteById(Long id) {
        int result=0;
        result += avoirAchatItemService.deleteByAvoirAchatId(id);
        result += dao.deleteById(id);
        return result;
    }

    public AvoirAchat findByNumeroFactureAvoirAchat(String numeroFactureAvoirAchat){
        return dao.findByNumeroFactureAvoirAchat(numeroFactureAvoirAchat);
    }
    public int deleteByNumeroFactureAvoirAchat(String numeroFactureAvoirAchat){
        return dao.deleteByNumeroFactureAvoirAchat(numeroFactureAvoirAchat);
    }

    public List<AvoirAchat> findByEntrepriseSocieteId(Long id){
        return dao.findByEntrepriseSocieteId(id);
    }
    public int deleteByEntrepriseSocieteId(Long id){
        return dao.deleteByEntrepriseSocieteId(id);
    }
    public long countByEntrepriseSocieteId(Long id){
        return dao.countByEntrepriseSocieteId(id);
    }
    public List<AvoirAchat> findByFournisseurId(Long id){
        return dao.findByFournisseurId(id);
    }
    public int deleteByFournisseurId(Long id){
        return dao.deleteByFournisseurId(id);
    }
    public long countByFournisseurIce(String ice){
        return dao.countByFournisseurIce(ice);
    }
    public List<AvoirAchat> findByEtatAvoirAchatId(Long id){
        return dao.findByEtatAvoirAchatId(id);
    }
    public int deleteByEtatAvoirAchatId(Long id){
        return dao.deleteByEtatAvoirAchatId(id);
    }
    public long countByEtatAvoirAchatId(Long id){
        return dao.countByEtatAvoirAchatId(id);
    }

    public List<AvoirAchat> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(AvoirAchat.class);
    }

    @Autowired
    private EtatAvoirAchatAdminService etatAvoirAchatService ;
    @Autowired
    private EntrepriseSocieteAdminService entrepriseSocieteService ;
    @Autowired
    private FournisseurAdminService fournisseurService ;
    @Autowired
    private AvoirAchatItemAdminService avoirAchatItemService ;

    public AvoirAchatAdminServiceImpl(AvoirAchatDao dao) {
        super(dao);
    }

}
