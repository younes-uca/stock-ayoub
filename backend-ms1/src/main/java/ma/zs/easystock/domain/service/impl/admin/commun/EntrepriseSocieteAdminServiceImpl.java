package ma.zs.easystock.domain.service.impl.admin.commun;


import ma.zs.easystock.domain.model.commun.EntrepriseSociete;
import ma.zs.easystock.infra.dao.criteria.core.commun.EntrepriseSocieteCriteria;
import ma.zs.easystock.domain.dao.commun.EntrepriseSocieteDao;
import ma.zs.easystock.infra.dao.specification.core.commun.EntrepriseSocieteSpecification;
import ma.zs.easystock.domain.service.facade.admin.commun.EntrepriseSocieteAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class EntrepriseSocieteAdminServiceImpl extends AbstractServiceImpl<EntrepriseSociete, EntrepriseSocieteCriteria, EntrepriseSocieteDao> implements EntrepriseSocieteAdminService {







    public List<EntrepriseSociete> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(EntrepriseSociete.class);
    }


    public EntrepriseSocieteAdminServiceImpl(EntrepriseSocieteDao dao) {
        super(dao);
    }

}
