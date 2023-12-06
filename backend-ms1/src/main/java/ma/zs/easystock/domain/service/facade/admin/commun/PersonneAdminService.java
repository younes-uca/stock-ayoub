package ma.zs.easystock.domain.service.facade.admin.commun;

import java.util.List;
import ma.zs.easystock.domain.model.commun.Personne;
import ma.zs.easystock.infra.dao.criteria.core.commun.PersonneCriteria;
import ma.zs.easystock.zynerator.service.IService;



import ma.zs.easystock.ws.dto.commun.PersonneDto;
import org.springframework.http.HttpEntity;


public interface PersonneAdminService extends  IService<Personne,PersonneCriteria>  {
    Personne findByTelephone(String telephone);
    int deleteByTelephone(String telephone);

    List<Personne> findByVilleId(Long id);
    int deleteByVilleId(Long id);
    long countByVilleId(Long id);


    HttpEntity<byte[]> createPdf(PersonneDto dto) throws Exception;

}
