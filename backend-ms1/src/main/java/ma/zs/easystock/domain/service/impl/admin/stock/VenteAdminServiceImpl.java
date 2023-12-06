package ma.zs.easystock.domain.service.impl.admin.stock;


import ma.zs.easystock.domain.model.stock.Vente;
import ma.zs.easystock.infra.dao.criteria.core.stock.VenteCriteria;
import ma.zs.easystock.domain.dao.stock.VenteDao;
import ma.zs.easystock.infra.dao.specification.core.stock.VenteSpecification;
import ma.zs.easystock.domain.service.facade.admin.stock.VenteAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.easystock.domain.service.facade.admin.commun.EtatVenteAdminService ;
import ma.zs.easystock.domain.model.commun.EtatVente ;
import ma.zs.easystock.domain.service.facade.admin.stock.AvoirVenteAdminService ;
import ma.zs.easystock.domain.model.stock.AvoirVente ;
import ma.zs.easystock.domain.service.facade.admin.commun.EntrepriseSocieteAdminService ;
import ma.zs.easystock.domain.model.commun.EntrepriseSociete ;
import ma.zs.easystock.domain.service.facade.admin.stock.VenteItemAdminService ;
import ma.zs.easystock.domain.model.stock.VenteItem ;
import ma.zs.easystock.domain.service.facade.admin.commun.ClientAdminService ;
import ma.zs.easystock.domain.model.commun.Client ;

import java.util.List;
@Service
public class VenteAdminServiceImpl extends AbstractServiceImpl<Vente, VenteCriteria, VenteDao> implements VenteAdminService {


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Vente save(Vente t) {
    
        super.save(t);
        if (t.getVenteItems() != null) {
                t.getVenteItems().forEach(element-> {
                    element.setVente(t);
                    venteItemService.save(element);
            });
        }
        if (t.getAvoirs() != null) {
                t.getAvoirs().forEach(element-> {
                    element.setVente(t);
                    avoirVenteService.save(element);
            });
        }
        return t;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public int deleteById(Long id) {
        int result=0;
        result += venteItemService.deleteByVenteId(id);
        result += avoirVenteService.deleteByVenteId(id);
        result += dao.deleteById(id);
        return result;
    }

    public Vente findByNumeroFacture(String numeroFacture){
        return dao.findByNumeroFacture(numeroFacture);
    }
    public int deleteByNumeroFacture(String numeroFacture){
        return dao.deleteByNumeroFacture(numeroFacture);
    }

    public List<Vente> findByEntrepriseSocieteId(Long id){
        return dao.findByEntrepriseSocieteId(id);
    }
    public int deleteByEntrepriseSocieteId(Long id){
        return dao.deleteByEntrepriseSocieteId(id);
    }
    public long countByEntrepriseSocieteId(Long id){
        return dao.countByEntrepriseSocieteId(id);
    }
    public List<Vente> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }
    public long countByClientCin(String cin){
        return dao.countByClientCin(cin);
    }
    public List<Vente> findByEtatVenteId(Long id){
        return dao.findByEtatVenteId(id);
    }
    public int deleteByEtatVenteId(Long id){
        return dao.deleteByEtatVenteId(id);
    }
    public long countByEtatVenteId(Long id){
        return dao.countByEtatVenteId(id);
    }

    public List<Vente> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(Vente.class);
    }

    @Autowired
    private EtatVenteAdminService etatVenteService ;
    @Autowired
    private AvoirVenteAdminService avoirVenteService ;
    @Autowired
    private EntrepriseSocieteAdminService entrepriseSocieteService ;
    @Autowired
    private VenteItemAdminService venteItemService ;
    @Autowired
    private ClientAdminService clientService ;

    public VenteAdminServiceImpl(VenteDao dao) {
        super(dao);
    }

}
