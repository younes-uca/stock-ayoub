package ma.zs.easystock.domain.service.facade.admin.reglement;

import java.util.List;
import ma.zs.easystock.domain.model.reglement.ReglementAvoirAchat;
import ma.zs.easystock.infra.dao.criteria.core.reglement.ReglementAvoirAchatCriteria;
import ma.zs.easystock.zynerator.service.IService;



import ma.zs.easystock.ws.dto.reglement.ReglementAvoirAchatDto;
import org.springframework.http.HttpEntity;


public interface ReglementAvoirAchatAdminService extends  IService<ReglementAvoirAchat,ReglementAvoirAchatCriteria>  {
    ReglementAvoirAchat findByReference(String reference);
    int deleteByReference(String reference);

    List<ReglementAvoirAchat> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    long countByAchatId(Long id);
    List<ReglementAvoirAchat> findByModeReglementId(Long id);
    int deleteByModeReglementId(Long id);
    long countByModeReglementId(Long id);
    List<ReglementAvoirAchat> findByAvoirAchatId(Long id);
    int deleteByAvoirAchatId(Long id);
    long countByAvoirAchatNumeroFactureAvoirAchat(String numeroFactureAvoirAchat);


    HttpEntity<byte[]> createPdf(ReglementAvoirAchatDto dto) throws Exception;

}
