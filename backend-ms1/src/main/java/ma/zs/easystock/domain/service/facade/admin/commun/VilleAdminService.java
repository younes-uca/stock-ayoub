package ma.zs.easystock.domain.service.facade.admin.commun;

import java.util.List;
import ma.zs.easystock.domain.model.commun.Ville;
import ma.zs.easystock.infra.dao.criteria.core.commun.VilleCriteria;
import ma.zs.easystock.zynerator.service.IService;



import ma.zs.easystock.ws.dto.commun.VilleDto;
import org.springframework.http.HttpEntity;


public interface VilleAdminService extends  IService<Ville,VilleCriteria>  {



    HttpEntity<byte[]> createPdf(VilleDto dto) throws Exception;

}
