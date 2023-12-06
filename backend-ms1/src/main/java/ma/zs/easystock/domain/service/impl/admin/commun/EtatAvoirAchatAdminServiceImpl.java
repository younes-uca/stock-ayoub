package ma.zs.easystock.domain.service.impl.admin.commun;


import ma.zs.easystock.domain.model.commun.EtatAvoirAchat;
import ma.zs.easystock.infra.dao.criteria.core.commun.EtatAvoirAchatCriteria;
import ma.zs.easystock.domain.dao.commun.EtatAvoirAchatDao;
import ma.zs.easystock.infra.dao.specification.core.commun.EtatAvoirAchatSpecification;
import ma.zs.easystock.domain.service.facade.admin.commun.EtatAvoirAchatAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.commun.EtatAvoirAchatDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class EtatAvoirAchatAdminServiceImpl extends AbstractServiceImpl<EtatAvoirAchat, EtatAvoirAchatCriteria, EtatAvoirAchatDao> implements EtatAvoirAchatAdminService {







    public List<EtatAvoirAchat> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(EtatAvoirAchat.class);
    }


    public EtatAvoirAchatAdminServiceImpl(EtatAvoirAchatDao dao) {
        super(dao);
    }

}
