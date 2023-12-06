package ma.zs.easystock.domain.service.impl.admin.reglement;


import ma.zs.easystock.domain.model.reglement.ReglementVente;
import ma.zs.easystock.infra.dao.criteria.core.reglement.ReglementVenteCriteria;
import ma.zs.easystock.domain.dao.reglement.ReglementVenteDao;
import ma.zs.easystock.infra.dao.specification.core.reglement.ReglementVenteSpecification;
import ma.zs.easystock.domain.service.facade.admin.reglement.ReglementVenteAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.reglement.ReglementVenteDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.domain.service.facade.admin.commun.ModeReglementAdminService ;
import ma.zs.easystock.domain.model.commun.ModeReglement ;
import ma.zs.easystock.domain.service.facade.admin.stock.VenteAdminService ;
import ma.zs.easystock.domain.model.stock.Vente ;

import java.util.List;
@Service
public class ReglementVenteAdminServiceImpl extends AbstractServiceImpl<ReglementVente, ReglementVenteCriteria, ReglementVenteDao> implements ReglementVenteAdminService {





    public ReglementVente findByReference(String reference){
        return dao.findByReference(reference);
    }
    public int deleteByReference(String reference){
        return dao.deleteByReference(reference);
    }

    public List<ReglementVente> findByVenteId(Long id){
        return dao.findByVenteId(id);
    }
    public int deleteByVenteId(Long id){
        return dao.deleteByVenteId(id);
    }
    public long countByVenteNumeroFacture(String numeroFacture){
        return dao.countByVenteNumeroFacture(numeroFacture);
    }
    public List<ReglementVente> findByModeReglementId(Long id){
        return dao.findByModeReglementId(id);
    }
    public int deleteByModeReglementId(Long id){
        return dao.deleteByModeReglementId(id);
    }
    public long countByModeReglementId(Long id){
        return dao.countByModeReglementId(id);
    }

    public List<ReglementVente> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(ReglementVente.class);
    }

    @Autowired
    private ModeReglementAdminService modeReglementService ;
    @Autowired
    private VenteAdminService venteService ;

    public ReglementVenteAdminServiceImpl(ReglementVenteDao dao) {
        super(dao);
    }

}
