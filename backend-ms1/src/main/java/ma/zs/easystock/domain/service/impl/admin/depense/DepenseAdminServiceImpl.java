package ma.zs.easystock.domain.service.impl.admin.depense;


import ma.zs.easystock.domain.model.depense.Depense;
import ma.zs.easystock.infra.dao.criteria.core.depense.DepenseCriteria;
import ma.zs.easystock.domain.dao.depense.DepenseDao;
import ma.zs.easystock.infra.dao.specification.core.depense.DepenseSpecification;
import ma.zs.easystock.domain.service.facade.admin.depense.DepenseAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class DepenseAdminServiceImpl extends AbstractServiceImpl<Depense, DepenseCriteria, DepenseDao> implements DepenseAdminService {











    public void configure() {
        super.configure(Depense.class);
    }


    public DepenseAdminServiceImpl(DepenseDao dao) {
        super(dao);
    }

}
