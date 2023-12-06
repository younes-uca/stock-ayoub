package ma.zs.easystock.domain.service.impl.admin.commun;


import ma.zs.easystock.domain.model.commun.Personne;
import ma.zs.easystock.infra.dao.criteria.core.commun.PersonneCriteria;
import ma.zs.easystock.domain.dao.commun.PersonneDao;
import ma.zs.easystock.infra.dao.specification.core.commun.PersonneSpecification;
import ma.zs.easystock.domain.service.facade.admin.commun.PersonneAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.commun.PersonneDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.domain.service.facade.admin.commun.VilleAdminService ;
import ma.zs.easystock.domain.model.commun.Ville ;

import java.util.List;
@Service
public class PersonneAdminServiceImpl extends AbstractServiceImpl<Personne, PersonneCriteria, PersonneDao> implements PersonneAdminService {





    public Personne findByTelephone(String telephone){
        return dao.findByTelephone(telephone);
    }
    public int deleteByTelephone(String telephone){
        return dao.deleteByTelephone(telephone);
    }

    public List<Personne> findByVilleId(Long id){
        return dao.findByVilleId(id);
    }
    public int deleteByVilleId(Long id){
        return dao.deleteByVilleId(id);
    }
    public long countByVilleId(Long id){
        return dao.countByVilleId(id);
    }

    public List<Personne> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(Personne.class);
    }

    @Autowired
    private VilleAdminService villeService ;

    public PersonneAdminServiceImpl(PersonneDao dao) {
        super(dao);
    }

}
