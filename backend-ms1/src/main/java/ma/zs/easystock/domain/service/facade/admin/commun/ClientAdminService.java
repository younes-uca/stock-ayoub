package ma.zs.easystock.domain.service.facade.admin.commun;

import java.util.List;
import ma.zs.easystock.domain.model.commun.Client;
import ma.zs.easystock.infra.dao.criteria.core.commun.ClientCriteria;
import ma.zs.easystock.zynerator.service.IService;



import ma.zs.easystock.ws.dto.commun.ClientDto;
import org.springframework.http.HttpEntity;


public interface ClientAdminService extends  IService<Client,ClientCriteria>  {
    Client findByCin(String cin);
    int deleteByCin(String cin);



    HttpEntity<byte[]> createPdf(ClientDto dto) throws Exception;

}
