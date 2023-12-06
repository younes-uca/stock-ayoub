package ma.zs.easystock.domain.service.impl.admin.gestionchequeffet;


import ma.zs.easystock.domain.model.gestionchequeffet.Transfert;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.TransfertCriteria;
import ma.zs.easystock.domain.dao.gestionchequeffet.TransfertDao;
import ma.zs.easystock.infra.dao.specification.core.gestionchequeffet.TransfertSpecification;
import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.TransfertAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.TransfertItemAdminService ;
import ma.zs.easystock.domain.model.gestionchequeffet.TransfertItem ;
import ma.zs.easystock.domain.service.facade.admin.Transfert.RaisonAdminService ;
import ma.zs.easystock.domain.model.Transfert.Raison ;

import java.util.List;
@Service
public class TransfertAdminServiceImpl extends AbstractServiceImpl<Transfert, TransfertCriteria, TransfertDao> implements TransfertAdminService {


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Transfert save(Transfert t) {
    
        super.save(t);
        if (t.getTransfertItems() != null) {
                t.getTransfertItems().forEach(element-> {
                    element.setTransfert(t);
                    transfertItemService.save(element);
            });
        }
        return t;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public int deleteById(Long id) {
        int result=0;
        result += transfertItemService.deleteByTransfertId(id);
        result += dao.deleteById(id);
        return result;
    }


    public List<Transfert> findByRaisonId(Long id){
        return dao.findByRaisonId(id);
    }
    public int deleteByRaisonId(Long id){
        return dao.deleteByRaisonId(id);
    }
    public long countByRaisonId(Long id){
        return dao.countByRaisonId(id);
    }





    public void configure() {
        super.configure(Transfert.class);
    }

    @Autowired
    private TransfertItemAdminService transfertItemService ;
    @Autowired
    private RaisonAdminService raisonService ;

    public TransfertAdminServiceImpl(TransfertDao dao) {
        super(dao);
    }

}
