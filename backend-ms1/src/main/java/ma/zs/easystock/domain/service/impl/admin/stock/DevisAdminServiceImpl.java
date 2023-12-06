package ma.zs.easystock.domain.service.impl.admin.stock;


import ma.zs.easystock.domain.model.stock.Devis;
import ma.zs.easystock.infra.dao.criteria.core.stock.DevisCriteria;
import ma.zs.easystock.domain.dao.stock.DevisDao;
import ma.zs.easystock.infra.dao.specification.core.stock.DevisSpecification;
import ma.zs.easystock.domain.service.facade.admin.stock.DevisAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.easystock.domain.service.facade.admin.stock.DevisItemAdminService ;
import ma.zs.easystock.domain.model.stock.DevisItem ;
import ma.zs.easystock.domain.service.facade.admin.commun.ClientAdminService ;
import ma.zs.easystock.domain.model.commun.Client ;

import java.util.List;
@Service
public class DevisAdminServiceImpl extends AbstractServiceImpl<Devis, DevisCriteria, DevisDao> implements DevisAdminService {


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Devis save(Devis t) {
    
        super.save(t);
        if (t.getDevisItems() != null) {
                t.getDevisItems().forEach(element-> {
                    element.setDevis(t);
                    devisItemService.save(element);
            });
        }
        return t;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public int deleteById(Long id) {
        int result=0;
        result += devisItemService.deleteByDevisId(id);
        result += dao.deleteById(id);
        return result;
    }

    public Devis findByNumeroDevis(String numeroDevis){
        return dao.findByNumeroDevis(numeroDevis);
    }
    public int deleteByNumeroDevis(String numeroDevis){
        return dao.deleteByNumeroDevis(numeroDevis);
    }

    public List<Devis> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }
    public long countByClientCin(String cin){
        return dao.countByClientCin(cin);
    }

    public List<Devis> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(Devis.class);
    }

    @Autowired
    private DevisItemAdminService devisItemService ;
    @Autowired
    private ClientAdminService clientService ;

    public DevisAdminServiceImpl(DevisDao dao) {
        super(dao);
    }

}
