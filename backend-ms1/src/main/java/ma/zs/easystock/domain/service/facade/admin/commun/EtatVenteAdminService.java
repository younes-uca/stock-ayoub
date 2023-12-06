package ma.zs.easystock.domain.service.facade.admin.commun;

import java.util.List;
import ma.zs.easystock.domain.model.commun.EtatVente;
import ma.zs.easystock.infra.dao.criteria.core.commun.EtatVenteCriteria;
import ma.zs.easystock.zynerator.service.IService;



import ma.zs.easystock.ws.dto.commun.EtatVenteDto;
import org.springframework.http.HttpEntity;


public interface EtatVenteAdminService extends  IService<EtatVente,EtatVenteCriteria>  {



    HttpEntity<byte[]> createPdf(EtatVenteDto dto) throws Exception;

}
