package ma.zs.easystock.domain.dao.gestionchequeffet;

import ma.zs.easystock.domain.model.gestionchequeffet.Proprietaire;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface ProprietaireDao extends IDao<Proprietaire> {


    List<Proprietaire> findByPersonneId(Long id);
    int deleteByPersonneId(Long id);
    long countByPersonneTelephone(String telephone);



}
