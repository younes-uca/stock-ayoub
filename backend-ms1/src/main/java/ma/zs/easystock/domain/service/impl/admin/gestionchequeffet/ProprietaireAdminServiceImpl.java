package ma.zs.easystock.domain.service.impl.admin.gestionchequeffet;


import ma.zs.easystock.domain.model.gestionchequeffet.Proprietaire;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.ProprietaireCriteria;
import ma.zs.easystock.domain.dao.gestionchequeffet.ProprietaireDao;
import ma.zs.easystock.infra.dao.specification.core.gestionchequeffet.ProprietaireSpecification;
import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.ProprietaireAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.domain.service.facade.admin.commun.PersonneAdminService ;
import ma.zs.easystock.domain.model.commun.Personne ;

import java.util.List;
@Service
public class ProprietaireAdminServiceImpl extends AbstractServiceImpl<Proprietaire, ProprietaireCriteria, ProprietaireDao> implements ProprietaireAdminService {






    public List<Proprietaire> findByPersonneId(Long id){
        return dao.findByPersonneId(id);
    }
    public int deleteByPersonneId(Long id){
        return dao.deleteByPersonneId(id);
    }
    public long countByPersonneTelephone(String telephone){
        return dao.countByPersonneTelephone(telephone);
    }





    public void configure() {
        super.configure(Proprietaire.class);
    }

    @Autowired
    private PersonneAdminService personneService ;

    public ProprietaireAdminServiceImpl(ProprietaireDao dao) {
        super(dao);
    }

}
