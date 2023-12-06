package ma.zs.easystock.domain.service.facade.admin.commun;

import java.util.List;
import ma.zs.easystock.domain.model.commun.Depot;
import ma.zs.easystock.infra.dao.criteria.core.commun.DepotCriteria;
import ma.zs.easystock.zynerator.service.IService;



import ma.zs.easystock.ws.dto.commun.DepotDto;
import org.springframework.http.HttpEntity;


public interface DepotAdminService extends  IService<Depot,DepotCriteria>  {



    HttpEntity<byte[]> createPdf(DepotDto dto) throws Exception;

}
