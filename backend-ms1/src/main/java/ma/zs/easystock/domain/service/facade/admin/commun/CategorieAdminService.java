package ma.zs.easystock.domain.service.facade.admin.commun;

import java.util.List;
import ma.zs.easystock.domain.model.commun.Categorie;
import ma.zs.easystock.infra.dao.criteria.core.commun.CategorieCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface CategorieAdminService extends  IService<Categorie,CategorieCriteria>  {
    Categorie findByLibelle(String libelle);
    int deleteByLibelle(String libelle);




}
