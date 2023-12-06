package ma.zs.easystock.domain.service.facade.admin.commun;

import java.util.List;
import ma.zs.easystock.domain.model.commun.Fournisseur;
import ma.zs.easystock.infra.dao.criteria.core.commun.FournisseurCriteria;
import ma.zs.easystock.zynerator.service.IService;



import ma.zs.easystock.ws.dto.commun.FournisseurDto;
import org.springframework.http.HttpEntity;


public interface FournisseurAdminService extends  IService<Fournisseur,FournisseurCriteria>  {
    Fournisseur findByIce(String ice);
    int deleteByIce(String ice);



    HttpEntity<byte[]> createPdf(FournisseurDto dto) throws Exception;

}
