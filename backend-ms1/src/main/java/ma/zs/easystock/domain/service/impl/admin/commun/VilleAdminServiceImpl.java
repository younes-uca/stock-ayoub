package ma.zs.easystock.domain.service.impl.admin.commun;


import ma.zs.easystock.domain.model.commun.Ville;
import ma.zs.easystock.infra.dao.criteria.core.commun.VilleCriteria;
import ma.zs.easystock.domain.dao.commun.VilleDao;
import ma.zs.easystock.infra.dao.specification.core.commun.VilleSpecification;
import ma.zs.easystock.domain.service.facade.admin.commun.VilleAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.commun.VilleDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class VilleAdminServiceImpl extends AbstractServiceImpl<Ville, VilleCriteria, VilleDao> implements VilleAdminService {











    public void configure() {
        super.configure(Ville.class);
    }


    public VilleAdminServiceImpl(VilleDao dao) {
        super(dao);
    }

}
