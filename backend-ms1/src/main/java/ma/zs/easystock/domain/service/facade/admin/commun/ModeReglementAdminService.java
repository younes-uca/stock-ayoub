package ma.zs.easystock.domain.service.facade.admin.commun;

import java.util.List;
import ma.zs.easystock.domain.model.commun.ModeReglement;
import ma.zs.easystock.infra.dao.criteria.core.commun.ModeReglementCriteria;
import ma.zs.easystock.zynerator.service.IService;



import ma.zs.easystock.ws.dto.commun.ModeReglementDto;
import org.springframework.http.HttpEntity;


public interface ModeReglementAdminService extends  IService<ModeReglement,ModeReglementCriteria>  {



    HttpEntity<byte[]> createPdf(ModeReglementDto dto) throws Exception;

}
