package  ma.zs.easystock.infra.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;






import ma.zs.easystock.infra.bean.core.commun.ClientEntity;
import ma.zs.easystock.domain.model.commun.Client;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class ClientInfraConverter extends AbstractInfraConverter<ClientEntity, Client> {


    public  ClientInfraConverter(){
        super(ClientEntity.class, Client.class);
    }

    @Override
    public Client toModel(ClientEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Client model = new Client();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getCin()))
                model.setCin(entity.getCin());



        return model;
        }
    }

    @Override
    public ClientEntity toEntity(Client model) {
        if (model == null) {
            return null;
        } else {
            ClientEntity entity = new ClientEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getCin()))
             entity.setCin(model.getCin());


        return entity;
        }
    }


    public void initObject(boolean value) {
    }


}
