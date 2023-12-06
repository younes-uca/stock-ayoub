package ma.zs.easystock.domain.service.impl.admin.reglement;


import ma.zs.easystock.domain.model.reglement.ReglementAvoirVente;
import ma.zs.easystock.infra.dao.criteria.core.reglement.ReglementAvoirVenteCriteria;
import ma.zs.easystock.domain.dao.reglement.ReglementAvoirVenteDao;
import ma.zs.easystock.infra.dao.specification.core.reglement.ReglementAvoirVenteSpecification;
import ma.zs.easystock.domain.service.facade.admin.reglement.ReglementAvoirVenteAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.reglement.ReglementAvoirVenteDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.domain.service.facade.admin.commun.ModeReglementAdminService ;
import ma.zs.easystock.domain.model.commun.ModeReglement ;
import ma.zs.easystock.domain.service.facade.admin.stock.AvoirVenteAdminService ;
import ma.zs.easystock.domain.model.stock.AvoirVente ;
import ma.zs.easystock.domain.service.facade.admin.stock.VenteAdminService ;
import ma.zs.easystock.domain.model.stock.Vente ;

import java.util.List;
@Service
public class ReglementAvoirVenteAdminServiceImpl extends AbstractServiceImpl<ReglementAvoirVente, ReglementAvoirVenteCriteria, ReglementAvoirVenteDao> implements ReglementAvoirVenteAdminService {





    public ReglementAvoirVente findByReference(String reference){
        return dao.findByReference(reference);
    }
    public int deleteByReference(String reference){
        return dao.deleteByReference(reference);
    }

    public List<ReglementAvoirVente> findByVenteId(Long id){
        return dao.findByVenteId(id);
    }
    public int deleteByVenteId(Long id){
        return dao.deleteByVenteId(id);
    }
    public long countByVenteNumeroFacture(String numeroFacture){
        return dao.countByVenteNumeroFacture(numeroFacture);
    }
    public List<ReglementAvoirVente> findByModeReglementId(Long id){
        return dao.findByModeReglementId(id);
    }
    public int deleteByModeReglementId(Long id){
        return dao.deleteByModeReglementId(id);
    }
    public long countByModeReglementId(Long id){
        return dao.countByModeReglementId(id);
    }
    public List<ReglementAvoirVente> findByAvoirVenteId(Long id){
        return dao.findByAvoirVenteId(id);
    }
    public int deleteByAvoirVenteId(Long id){
        return dao.deleteByAvoirVenteId(id);
    }
    public long countByAvoirVenteNumeroFactureAvoirVente(String numeroFactureAvoirVente){
        return dao.countByAvoirVenteNumeroFactureAvoirVente(numeroFactureAvoirVente);
    }

    public List<ReglementAvoirVente> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(ReglementAvoirVente.class);
    }

    @Autowired
    private ModeReglementAdminService modeReglementService ;
    @Autowired
    private AvoirVenteAdminService avoirVenteService ;
    @Autowired
    private VenteAdminService venteService ;

    public ReglementAvoirVenteAdminServiceImpl(ReglementAvoirVenteDao dao) {
        super(dao);
    }

}
