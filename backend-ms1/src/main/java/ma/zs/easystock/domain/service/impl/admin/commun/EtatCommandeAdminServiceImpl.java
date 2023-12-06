package ma.zs.easystock.domain.service.impl.admin.commun;


import ma.zs.easystock.domain.model.commun.EtatCommande;
import ma.zs.easystock.infra.dao.criteria.core.commun.EtatCommandeCriteria;
import ma.zs.easystock.domain.dao.commun.EtatCommandeDao;
import ma.zs.easystock.infra.dao.specification.core.commun.EtatCommandeSpecification;
import ma.zs.easystock.domain.service.facade.admin.commun.EtatCommandeAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.commun.EtatCommandeDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class EtatCommandeAdminServiceImpl extends AbstractServiceImpl<EtatCommande, EtatCommandeCriteria, EtatCommandeDao> implements EtatCommandeAdminService {







    public List<EtatCommande> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(EtatCommande.class);
    }


    public EtatCommandeAdminServiceImpl(EtatCommandeDao dao) {
        super(dao);
    }

}
