package ma.zs.easystock.domain.service.impl.admin.commun;


import ma.zs.easystock.domain.model.commun.UniteMesure;
import ma.zs.easystock.infra.dao.criteria.core.commun.UniteMesureCriteria;
import ma.zs.easystock.domain.dao.commun.UniteMesureDao;
import ma.zs.easystock.infra.dao.specification.core.commun.UniteMesureSpecification;
import ma.zs.easystock.domain.service.facade.admin.commun.UniteMesureAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.commun.UniteMesureDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class UniteMesureAdminServiceImpl extends AbstractServiceImpl<UniteMesure, UniteMesureCriteria, UniteMesureDao> implements UniteMesureAdminService {





    public UniteMesure findByLibelle(String libelle){
        return dao.findByLibelle(libelle);
    }
    public int deleteByLibelle(String libelle){
        return dao.deleteByLibelle(libelle);
    }


    public List<UniteMesure> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(UniteMesure.class);
    }


    public UniteMesureAdminServiceImpl(UniteMesureDao dao) {
        super(dao);
    }

}
