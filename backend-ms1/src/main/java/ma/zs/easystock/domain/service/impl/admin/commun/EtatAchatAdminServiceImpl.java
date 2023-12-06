package ma.zs.easystock.domain.service.impl.admin.commun;


import ma.zs.easystock.domain.model.commun.EtatAchat;
import ma.zs.easystock.infra.dao.criteria.core.commun.EtatAchatCriteria;
import ma.zs.easystock.domain.dao.commun.EtatAchatDao;
import ma.zs.easystock.infra.dao.specification.core.commun.EtatAchatSpecification;
import ma.zs.easystock.domain.service.facade.admin.commun.EtatAchatAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.commun.EtatAchatDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class EtatAchatAdminServiceImpl extends AbstractServiceImpl<EtatAchat, EtatAchatCriteria, EtatAchatDao> implements EtatAchatAdminService {







    public List<EtatAchat> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(EtatAchat.class);
    }


    public EtatAchatAdminServiceImpl(EtatAchatDao dao) {
        super(dao);
    }

}
