package ma.zs.easystock.domain.service.impl.admin.commun;


import ma.zs.easystock.domain.model.commun.EtatVente;
import ma.zs.easystock.infra.dao.criteria.core.commun.EtatVenteCriteria;
import ma.zs.easystock.domain.dao.commun.EtatVenteDao;
import ma.zs.easystock.infra.dao.specification.core.commun.EtatVenteSpecification;
import ma.zs.easystock.domain.service.facade.admin.commun.EtatVenteAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.commun.EtatVenteDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class EtatVenteAdminServiceImpl extends AbstractServiceImpl<EtatVente, EtatVenteCriteria, EtatVenteDao> implements EtatVenteAdminService {







    public List<EtatVente> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(EtatVente.class);
    }


    public EtatVenteAdminServiceImpl(EtatVenteDao dao) {
        super(dao);
    }

}
