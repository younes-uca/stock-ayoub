package ma.zs.easystock.domain.dao.stock;

import ma.zs.easystock.domain.model.stock.Produit;

import ma.zs.easystock.domain.model.stock.Produit;

import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface ProduitDao extends IDao<Produit> {

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

    List<Produit> findAllOptimized();


}
