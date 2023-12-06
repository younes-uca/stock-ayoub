package ma.zs.easystock.domain.service.impl.admin.Transfert;


import ma.zs.easystock.domain.model.Transfert.Raison;
import ma.zs.easystock.infra.dao.criteria.core.Transfert.RaisonCriteria;
import ma.zs.easystock.domain.dao.Transfert.RaisonDao;
import ma.zs.easystock.infra.dao.specification.core.Transfert.RaisonSpecification;
import ma.zs.easystock.domain.service.facade.admin.Transfert.RaisonAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class RaisonAdminServiceImpl extends AbstractServiceImpl<Raison, RaisonCriteria, RaisonDao> implements RaisonAdminService {







    public List<Raison> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(Raison.class);
    }


    public RaisonAdminServiceImpl(RaisonDao dao) {
        super(dao);
    }

}
