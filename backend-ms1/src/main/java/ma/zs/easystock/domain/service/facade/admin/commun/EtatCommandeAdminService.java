package ma.zs.easystock.domain.service.facade.admin.commun;

import java.util.List;
import ma.zs.easystock.domain.model.commun.EtatCommande;
import ma.zs.easystock.infra.dao.criteria.core.commun.EtatCommandeCriteria;
import ma.zs.easystock.zynerator.service.IService;



import ma.zs.easystock.ws.dto.commun.EtatCommandeDto;
import org.springframework.http.HttpEntity;


public interface EtatCommandeAdminService extends  IService<EtatCommande,EtatCommandeCriteria>  {



    HttpEntity<byte[]> createPdf(EtatCommandeDto dto) throws Exception;

}
