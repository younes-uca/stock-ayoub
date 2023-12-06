package ma.zs.easystock.domain.service.impl.admin.commun;


import ma.zs.easystock.domain.model.commun.EtatAvoirVente;
import ma.zs.easystock.infra.dao.criteria.core.commun.EtatAvoirVenteCriteria;
import ma.zs.easystock.domain.dao.commun.EtatAvoirVenteDao;
import ma.zs.easystock.infra.dao.specification.core.commun.EtatAvoirVenteSpecification;
import ma.zs.easystock.domain.service.facade.admin.commun.EtatAvoirVenteAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.commun.EtatAvoirVenteDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class EtatAvoirVenteAdminServiceImpl extends AbstractServiceImpl<EtatAvoirVente, EtatAvoirVenteCriteria, EtatAvoirVenteDao> implements EtatAvoirVenteAdminService {







    public List<EtatAvoirVente> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(EtatAvoirVente.class);
    }


    public EtatAvoirVenteAdminServiceImpl(EtatAvoirVenteDao dao) {
        super(dao);
    }

}
