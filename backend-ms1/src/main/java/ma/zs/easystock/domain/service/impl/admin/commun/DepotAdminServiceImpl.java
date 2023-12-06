package ma.zs.easystock.domain.service.impl.admin.commun;


import ma.zs.easystock.domain.model.commun.Depot;
import ma.zs.easystock.infra.dao.criteria.core.commun.DepotCriteria;
import ma.zs.easystock.domain.dao.commun.DepotDao;
import ma.zs.easystock.infra.dao.specification.core.commun.DepotSpecification;
import ma.zs.easystock.domain.service.facade.admin.commun.DepotAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.commun.DepotDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class DepotAdminServiceImpl extends AbstractServiceImpl<Depot, DepotCriteria, DepotDao> implements DepotAdminService {







    public List<Depot> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(Depot.class);
    }


    public DepotAdminServiceImpl(DepotDao dao) {
        super(dao);
    }

}
