package ma.zs.easystock.domain.service.facade.admin.commun;

import java.util.List;
import ma.zs.easystock.domain.model.commun.UniteMesure;
import ma.zs.easystock.infra.dao.criteria.core.commun.UniteMesureCriteria;
import ma.zs.easystock.zynerator.service.IService;



import ma.zs.easystock.ws.dto.commun.UniteMesureDto;
import org.springframework.http.HttpEntity;


public interface UniteMesureAdminService extends  IService<UniteMesure,UniteMesureCriteria>  {
    UniteMesure findByLibelle(String libelle);
    int deleteByLibelle(String libelle);



    HttpEntity<byte[]> createPdf(UniteMesureDto dto) throws Exception;

}
