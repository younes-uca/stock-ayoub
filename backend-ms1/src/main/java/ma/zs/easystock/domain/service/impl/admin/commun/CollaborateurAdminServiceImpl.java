package ma.zs.easystock.domain.service.impl.admin.commun;


import ma.zs.easystock.domain.model.commun.Collaborateur;
import ma.zs.easystock.infra.dao.criteria.core.commun.CollaborateurCriteria;
import ma.zs.easystock.domain.dao.commun.CollaborateurDao;
import ma.zs.easystock.infra.dao.specification.core.commun.CollaborateurSpecification;
import ma.zs.easystock.domain.service.facade.admin.commun.CollaborateurAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class CollaborateurAdminServiceImpl extends AbstractServiceImpl<Collaborateur, CollaborateurCriteria, CollaborateurDao> implements CollaborateurAdminService {







    public List<Collaborateur> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(Collaborateur.class);
    }


    public CollaborateurAdminServiceImpl(CollaborateurDao dao) {
        super(dao);
    }

}
