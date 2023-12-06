package ma.zs.easystock.domain.service.impl.admin.reglement;


import ma.zs.easystock.domain.model.reglement.ReglementAchat;
import ma.zs.easystock.infra.dao.criteria.core.reglement.ReglementAchatCriteria;
import ma.zs.easystock.domain.dao.reglement.ReglementAchatDao;
import ma.zs.easystock.infra.dao.specification.core.reglement.ReglementAchatSpecification;
import ma.zs.easystock.domain.service.facade.admin.reglement.ReglementAchatAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.reglement.ReglementAchatDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.domain.service.facade.admin.stock.AchatAdminService ;
import ma.zs.easystock.domain.model.stock.Achat ;
import ma.zs.easystock.domain.service.facade.admin.commun.ModeReglementAdminService ;
import ma.zs.easystock.domain.model.commun.ModeReglement ;

import java.util.List;
@Service
public class ReglementAchatAdminServiceImpl extends AbstractServiceImpl<ReglementAchat, ReglementAchatCriteria, ReglementAchatDao> implements ReglementAchatAdminService {





    public ReglementAchat findByReference(String reference){
        return dao.findByReference(reference);
    }
    public int deleteByReference(String reference){
        return dao.deleteByReference(reference);
    }

    public List<ReglementAchat> findByAchatId(Long id){
        return dao.findByAchatId(id);
    }
    public int deleteByAchatId(Long id){
        return dao.deleteByAchatId(id);
    }
    public long countByAchatId(Long id){
        return dao.countByAchatId(id);
    }
    public List<ReglementAchat> findByModeReglementId(Long id){
        return dao.findByModeReglementId(id);
    }
    public int deleteByModeReglementId(Long id){
        return dao.deleteByModeReglementId(id);
    }
    public long countByModeReglementId(Long id){
        return dao.countByModeReglementId(id);
    }

    public List<ReglementAchat> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(ReglementAchat.class);
    }

    @Autowired
    private AchatAdminService achatService ;
    @Autowired
    private ModeReglementAdminService modeReglementService ;

    public ReglementAchatAdminServiceImpl(ReglementAchatDao dao) {
        super(dao);
    }

}
