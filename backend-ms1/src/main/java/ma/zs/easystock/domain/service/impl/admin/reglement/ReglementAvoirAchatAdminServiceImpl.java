package ma.zs.easystock.domain.service.impl.admin.reglement;


import ma.zs.easystock.domain.model.reglement.ReglementAvoirAchat;
import ma.zs.easystock.infra.dao.criteria.core.reglement.ReglementAvoirAchatCriteria;
import ma.zs.easystock.domain.dao.reglement.ReglementAvoirAchatDao;
import ma.zs.easystock.infra.dao.specification.core.reglement.ReglementAvoirAchatSpecification;
import ma.zs.easystock.domain.service.facade.admin.reglement.ReglementAvoirAchatAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.reglement.ReglementAvoirAchatDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.domain.service.facade.admin.stock.AchatAdminService ;
import ma.zs.easystock.domain.model.stock.Achat ;
import ma.zs.easystock.domain.service.facade.admin.commun.ModeReglementAdminService ;
import ma.zs.easystock.domain.model.commun.ModeReglement ;
import ma.zs.easystock.domain.service.facade.admin.stock.AvoirAchatAdminService ;
import ma.zs.easystock.domain.model.stock.AvoirAchat ;

import java.util.List;
@Service
public class ReglementAvoirAchatAdminServiceImpl extends AbstractServiceImpl<ReglementAvoirAchat, ReglementAvoirAchatCriteria, ReglementAvoirAchatDao> implements ReglementAvoirAchatAdminService {





    public ReglementAvoirAchat findByReference(String reference){
        return dao.findByReference(reference);
    }
    public int deleteByReference(String reference){
        return dao.deleteByReference(reference);
    }

    public List<ReglementAvoirAchat> findByAchatId(Long id){
        return dao.findByAchatId(id);
    }
    public int deleteByAchatId(Long id){
        return dao.deleteByAchatId(id);
    }
    public long countByAchatId(Long id){
        return dao.countByAchatId(id);
    }
    public List<ReglementAvoirAchat> findByModeReglementId(Long id){
        return dao.findByModeReglementId(id);
    }
    public int deleteByModeReglementId(Long id){
        return dao.deleteByModeReglementId(id);
    }
    public long countByModeReglementId(Long id){
        return dao.countByModeReglementId(id);
    }
    public List<ReglementAvoirAchat> findByAvoirAchatId(Long id){
        return dao.findByAvoirAchatId(id);
    }
    public int deleteByAvoirAchatId(Long id){
        return dao.deleteByAvoirAchatId(id);
    }
    public long countByAvoirAchatNumeroFactureAvoirAchat(String numeroFactureAvoirAchat){
        return dao.countByAvoirAchatNumeroFactureAvoirAchat(numeroFactureAvoirAchat);
    }

    public List<ReglementAvoirAchat> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(ReglementAvoirAchat.class);
    }

    @Autowired
    private AchatAdminService achatService ;
    @Autowired
    private ModeReglementAdminService modeReglementService ;
    @Autowired
    private AvoirAchatAdminService avoirAchatService ;

    public ReglementAvoirAchatAdminServiceImpl(ReglementAvoirAchatDao dao) {
        super(dao);
    }

}
