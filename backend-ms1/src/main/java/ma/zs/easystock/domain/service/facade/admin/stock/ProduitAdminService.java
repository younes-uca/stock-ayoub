package ma.zs.easystock.domain.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.domain.model.stock.Produit;
import ma.zs.easystock.infra.dao.criteria.core.stock.ProduitCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface ProduitAdminService extends  IService<Produit,ProduitCriteria>  {
    Produit findByBarCode(String barCode);
    int deleteByBarCode(String barCode);

    List<Produit> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<Produit> findByCategorieId(Long id);
    int deleteByCategorieId(Long id);
    long countByCategorieLibelle(String libelle);
    List<Produit> findByMarqueId(Long id);
    int deleteByMarqueId(Long id);
    long countByMarqueLibelle(String libelle);
    List<Produit> findByUniteMesureId(Long id);
    int deleteByUniteMesureId(Long id);
    long countByUniteMesureLibelle(String libelle);



}
