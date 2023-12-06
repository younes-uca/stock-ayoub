package ma.zs.easystock.domain.service.impl.admin.commun;


import ma.zs.easystock.domain.model.commun.Categorie;
import ma.zs.easystock.infra.dao.criteria.core.commun.CategorieCriteria;
import ma.zs.easystock.domain.dao.commun.CategorieDao;
import ma.zs.easystock.infra.dao.specification.core.commun.CategorieSpecification;
import ma.zs.easystock.domain.service.facade.admin.commun.CategorieAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class CategorieAdminServiceImpl extends AbstractServiceImpl<Categorie, CategorieCriteria, CategorieDao> implements CategorieAdminService {





    public Categorie findByLibelle(String libelle){
        return dao.findByLibelle(libelle);
    }
    public int deleteByLibelle(String libelle){
        return dao.deleteByLibelle(libelle);
    }


    public List<Categorie> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(Categorie.class);
    }


    public CategorieAdminServiceImpl(CategorieDao dao) {
        super(dao);
    }

}
