package ma.zs.easystock.domain.service.impl.admin.stock;


import ma.zs.easystock.domain.model.stock.Tache;
import ma.zs.easystock.infra.dao.criteria.core.stock.TacheCriteria;
import ma.zs.easystock.domain.dao.stock.TacheDao;
import ma.zs.easystock.infra.dao.specification.core.stock.TacheSpecification;
import ma.zs.easystock.domain.service.facade.admin.stock.TacheAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.domain.service.facade.admin.commun.CollaborateurAdminService ;
import ma.zs.easystock.domain.model.commun.Collaborateur ;

import java.util.List;
@Service
public class TacheAdminServiceImpl extends AbstractServiceImpl<Tache, TacheCriteria, TacheDao> implements TacheAdminService {






    public List<Tache> findByLierAId(Long id){
        return dao.findByLierAId(id);
    }
    public int deleteByLierAId(Long id){
        return dao.deleteByLierAId(id);
    }
    public long countByLierAId(Long id){
        return dao.countByLierAId(id);
    }





    public void configure() {
        super.configure(Tache.class);
    }

    @Autowired
    private CollaborateurAdminService collaborateurService ;

    public TacheAdminServiceImpl(TacheDao dao) {
        super(dao);
    }

}
