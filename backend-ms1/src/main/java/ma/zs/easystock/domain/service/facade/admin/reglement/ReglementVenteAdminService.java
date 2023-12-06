package ma.zs.easystock.domain.service.facade.admin.reglement;

import java.util.List;
import ma.zs.easystock.domain.model.reglement.ReglementVente;
import ma.zs.easystock.infra.dao.criteria.core.reglement.ReglementVenteCriteria;
import ma.zs.easystock.zynerator.service.IService;



import ma.zs.easystock.ws.dto.reglement.ReglementVenteDto;
import org.springframework.http.HttpEntity;


public interface ReglementVenteAdminService extends  IService<ReglementVente,ReglementVenteCriteria>  {
    ReglementVente findByReference(String reference);
    int deleteByReference(String reference);

    List<ReglementVente> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    long countByVenteNumeroFacture(String numeroFacture);
    List<ReglementVente> findByModeReglementId(Long id);
    int deleteByModeReglementId(Long id);
    long countByModeReglementId(Long id);


    HttpEntity<byte[]> createPdf(ReglementVenteDto dto) throws Exception;

}
