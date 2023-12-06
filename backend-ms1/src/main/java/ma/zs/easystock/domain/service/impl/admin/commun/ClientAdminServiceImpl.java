package ma.zs.easystock.domain.service.impl.admin.commun;


import ma.zs.easystock.domain.model.commun.Client;
import ma.zs.easystock.infra.dao.criteria.core.commun.ClientCriteria;
import ma.zs.easystock.domain.dao.commun.ClientDao;
import ma.zs.easystock.infra.dao.specification.core.commun.ClientSpecification;
import ma.zs.easystock.domain.service.facade.admin.commun.ClientAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.commun.ClientDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ClientAdminServiceImpl extends AbstractServiceImpl<Client, ClientCriteria, ClientDao> implements ClientAdminService {





    public Client findByCin(String cin){
        return dao.findByCin(cin);
    }
    public int deleteByCin(String cin){
        return dao.deleteByCin(cin);
    }


    public List<Client> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(Client.class);
    }


    public ClientAdminServiceImpl(ClientDao dao) {
        super(dao);
    }

}
