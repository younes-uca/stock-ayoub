package ma.zs.easystock.domain.service.impl.admin.stock;


import ma.zs.easystock.domain.model.stock.AvoirVente;
import ma.zs.easystock.infra.dao.criteria.core.stock.AvoirVenteCriteria;
import ma.zs.easystock.domain.dao.stock.AvoirVenteDao;
import ma.zs.easystock.infra.dao.specification.core.stock.AvoirVenteSpecification;
import ma.zs.easystock.domain.service.facade.admin.stock.AvoirVenteAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.easystock.domain.service.facade.admin.commun.EtatAvoirVenteAdminService ;
import ma.zs.easystock.domain.model.commun.EtatAvoirVente ;
import ma.zs.easystock.domain.service.facade.admin.stock.AchatAdminService ;
import ma.zs.easystock.domain.model.stock.Achat ;
import ma.zs.easystock.domain.service.facade.admin.commun.EntrepriseSocieteAdminService ;
import ma.zs.easystock.domain.model.commun.EntrepriseSociete ;
import ma.zs.easystock.domain.service.facade.admin.commun.ClientAdminService ;
import ma.zs.easystock.domain.model.commun.Client ;
import ma.zs.easystock.domain.service.facade.admin.stock.AvoirVenteItemAdminService ;
import ma.zs.easystock.domain.model.stock.AvoirVenteItem ;

import java.util.List;
@Service
public class AvoirVenteAdminServiceImpl extends AbstractServiceImpl<AvoirVente, AvoirVenteCriteria, AvoirVenteDao> implements AvoirVenteAdminService {


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public AvoirVente save(AvoirVente t) {
    
        super.save(t);
        if (t.getAvoirVenteItems() != null) {
                t.getAvoirVenteItems().forEach(element-> {
                    element.setAvoirVente(t);
                    avoirVenteItemService.save(element);
            });
        }
        if (t.getAvoirs() != null) {
                t.getAvoirs().forEach(element-> {
                    element.setAvoirVente(t);
                    avoirVenteItemService.save(element);
            });
        }
        return t;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public int deleteById(Long id) {
        int result=0;
        result += avoirVenteItemService.deleteByAvoirVenteId(id);
        result += avoirVenteItemService.deleteByAvoirVenteId(id);
        result += dao.deleteById(id);
        return result;
    }

    public AvoirVente findByNumeroFactureAvoirVente(String numeroFactureAvoirVente){
        return dao.findByNumeroFactureAvoirVente(numeroFactureAvoirVente);
    }
    public int deleteByNumeroFactureAvoirVente(String numeroFactureAvoirVente){
        return dao.deleteByNumeroFactureAvoirVente(numeroFactureAvoirVente);
    }

    public List<AvoirVente> findByEntrepriseSocieteId(Long id){
        return dao.findByEntrepriseSocieteId(id);
    }
    public int deleteByEntrepriseSocieteId(Long id){
        return dao.deleteByEntrepriseSocieteId(id);
    }
    public long countByEntrepriseSocieteId(Long id){
        return dao.countByEntrepriseSocieteId(id);
    }
    public List<AvoirVente> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }
    public long countByClientCin(String cin){
        return dao.countByClientCin(cin);
    }
    public List<AvoirVente> findByEtatAvoirVenteId(Long id){
        return dao.findByEtatAvoirVenteId(id);
    }
    public int deleteByEtatAvoirVenteId(Long id){
        return dao.deleteByEtatAvoirVenteId(id);
    }
    public long countByEtatAvoirVenteId(Long id){
        return dao.countByEtatAvoirVenteId(id);
    }
    public List<AvoirVente> findByAchatId(Long id){
        return dao.findByAchatId(id);
    }
    public int deleteByAchatId(Long id){
        return dao.deleteByAchatId(id);
    }
    public long countByAchatId(Long id){
        return dao.countByAchatId(id);
    }

    public List<AvoirVente> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(AvoirVente.class);
    }

    @Autowired
    private EtatAvoirVenteAdminService etatAvoirVenteService ;
    @Autowired
    private AchatAdminService achatService ;
    @Autowired
    private EntrepriseSocieteAdminService entrepriseSocieteService ;
    @Autowired
    private ClientAdminService clientService ;
    @Autowired
    private AvoirVenteItemAdminService avoirVenteItemService ;

    public AvoirVenteAdminServiceImpl(AvoirVenteDao dao) {
        super(dao);
    }

}
