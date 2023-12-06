package ma.zs.easystock.domain.service.impl.admin.gestionchequeffet;


import ma.zs.easystock.domain.model.gestionchequeffet.Banque;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.BanqueCriteria;
import ma.zs.easystock.domain.dao.gestionchequeffet.BanqueDao;
import ma.zs.easystock.infra.dao.specification.core.gestionchequeffet.BanqueSpecification;
import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.BanqueAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class BanqueAdminServiceImpl extends AbstractServiceImpl<Banque, BanqueCriteria, BanqueDao> implements BanqueAdminService {







    public List<Banque> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(Banque.class);
    }


    public BanqueAdminServiceImpl(BanqueDao dao) {
        super(dao);
    }

}
