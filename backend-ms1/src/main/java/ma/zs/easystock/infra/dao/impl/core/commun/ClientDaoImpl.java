package ma.zs.easystock.infra.dao.impl.core.commun;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.commun.ClientRepository;
import ma.zs.easystock.infra.bean.core.commun.ClientEntity;
import ma.zs.easystock.infra.converter.commun.ClientInfraConverter;
import ma.zs.easystock.domain.dao.commun.ClientDao;
import ma.zs.easystock.domain.model.commun.Client;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ClientDaoImpl extends AbstractDaoImpl<ClientEntity, Client, ClientRepository, ClientInfraConverter> implements ClientDao  {

    @Override
    public Client findByCin(String cin){
        ClientEntity entity = repository.findByCin(cin);
        return converter.toModel(entity);
    }

    @Override
    public int deleteByCin(String cin){
        return repository.deleteByCin(cin);
    }

    @Override
    public List<Client> findAllOptimized(){
    List<ClientEntity> list =  repository.findAllOptimized();
        return converter.toModel(list);
    }




    public ClientDaoImpl(ClientRepository  repository, ClientInfraConverter converter){
        super(repository,converter);
    }
}
