package ma.zs.easystock.domain.service.impl.admin.commun;


import ma.zs.easystock.domain.model.commun.Fournisseur;
import ma.zs.easystock.infra.dao.criteria.core.commun.FournisseurCriteria;
import ma.zs.easystock.domain.dao.commun.FournisseurDao;
import ma.zs.easystock.infra.dao.specification.core.commun.FournisseurSpecification;
import ma.zs.easystock.domain.service.facade.admin.commun.FournisseurAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.commun.FournisseurDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class FournisseurAdminServiceImpl extends AbstractServiceImpl<Fournisseur, FournisseurCriteria, FournisseurDao> implements FournisseurAdminService {





    public Fournisseur findByIce(String ice){
        return dao.findByIce(ice);
    }
    public int deleteByIce(String ice){
        return dao.deleteByIce(ice);
    }


    public List<Fournisseur> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(Fournisseur.class);
    }


    public FournisseurAdminServiceImpl(FournisseurDao dao) {
        super(dao);
    }

}
