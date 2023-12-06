package ma.zs.easystock.domain.service.impl.admin.stock;


import ma.zs.easystock.domain.model.stock.BonPour;
import ma.zs.easystock.infra.dao.criteria.core.stock.BonPourCriteria;
import ma.zs.easystock.domain.dao.stock.BonPourDao;
import ma.zs.easystock.infra.dao.specification.core.stock.BonPourSpecification;
import ma.zs.easystock.domain.service.facade.admin.stock.BonPourAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.easystock.domain.service.facade.admin.stock.BonPourItemAdminService ;
import ma.zs.easystock.domain.model.stock.BonPourItem ;
import ma.zs.easystock.domain.service.facade.admin.commun.ClientAdminService ;
import ma.zs.easystock.domain.model.commun.Client ;

import java.util.List;
@Service
public class BonPourAdminServiceImpl extends AbstractServiceImpl<BonPour, BonPourCriteria, BonPourDao> implements BonPourAdminService {


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public BonPour save(BonPour t) {
    
        super.save(t);
        if (t.getBonPourItems() != null) {
                t.getBonPourItems().forEach(element-> {
                    element.setBonPour(t);
                    bonPourItemService.save(element);
            });
        }
        return t;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public int deleteById(Long id) {
        int result=0;
        result += bonPourItemService.deleteByBonPourId(id);
        result += dao.deleteById(id);
        return result;
    }

    public BonPour findByNumeroBonPour(String numeroBonPour){
        return dao.findByNumeroBonPour(numeroBonPour);
    }
    public int deleteByNumeroBonPour(String numeroBonPour){
        return dao.deleteByNumeroBonPour(numeroBonPour);
    }

    public List<BonPour> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }
    public long countByClientCin(String cin){
        return dao.countByClientCin(cin);
    }

    public List<BonPour> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(BonPour.class);
    }

    @Autowired
    private BonPourItemAdminService bonPourItemService ;
    @Autowired
    private ClientAdminService clientService ;

    public BonPourAdminServiceImpl(BonPourDao dao) {
        super(dao);
    }

}
