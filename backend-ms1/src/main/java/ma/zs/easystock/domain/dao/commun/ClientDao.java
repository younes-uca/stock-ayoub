package ma.zs.easystock.domain.dao.commun;

import ma.zs.easystock.domain.model.commun.Client;

import ma.zs.easystock.domain.model.commun.Client;

import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface ClientDao extends IDao<Client> {

    Client findByCin(String cin);
    int deleteByCin(String cin);


    List<Client> findAllOptimized();


}
