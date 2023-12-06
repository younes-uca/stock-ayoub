package ma.zs.easystock.domain.service.impl.admin.commun;


import ma.zs.easystock.domain.model.commun.ModeReglement;
import ma.zs.easystock.infra.dao.criteria.core.commun.ModeReglementCriteria;
import ma.zs.easystock.domain.dao.commun.ModeReglementDao;
import ma.zs.easystock.infra.dao.specification.core.commun.ModeReglementSpecification;
import ma.zs.easystock.domain.service.facade.admin.commun.ModeReglementAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.commun.ModeReglementDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ModeReglementAdminServiceImpl extends AbstractServiceImpl<ModeReglement, ModeReglementCriteria, ModeReglementDao> implements ModeReglementAdminService {







    public List<ModeReglement> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(ModeReglement.class);
    }


    public ModeReglementAdminServiceImpl(ModeReglementDao dao) {
        super(dao);
    }

}
