package ma.zs.easystock.domain.service.impl.admin.commun;


import ma.zs.easystock.domain.model.commun.Marque;
import ma.zs.easystock.infra.dao.criteria.core.commun.MarqueCriteria;
import ma.zs.easystock.domain.dao.commun.MarqueDao;
import ma.zs.easystock.infra.dao.specification.core.commun.MarqueSpecification;
import ma.zs.easystock.domain.service.facade.admin.commun.MarqueAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class MarqueAdminServiceImpl extends AbstractServiceImpl<Marque, MarqueCriteria, MarqueDao> implements MarqueAdminService {





    public Marque findByLibelle(String libelle){
        return dao.findByLibelle(libelle);
    }
    public int deleteByLibelle(String libelle){
        return dao.deleteByLibelle(libelle);
    }


    public List<Marque> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(Marque.class);
    }


    public MarqueAdminServiceImpl(MarqueDao dao) {
        super(dao);
    }

}
