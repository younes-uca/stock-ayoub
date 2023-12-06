package ma.zs.easystock.domain.service.impl.admin.stock;


import ma.zs.easystock.domain.model.stock.Produit;
import ma.zs.easystock.infra.dao.criteria.core.stock.ProduitCriteria;
import ma.zs.easystock.domain.dao.stock.ProduitDao;
import ma.zs.easystock.infra.dao.specification.core.stock.ProduitSpecification;
import ma.zs.easystock.domain.service.facade.admin.stock.ProduitAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.easystock.domain.service.facade.admin.commun.MarqueAdminService ;
import ma.zs.easystock.domain.model.commun.Marque ;
import ma.zs.easystock.domain.service.facade.admin.commun.UniteMesureAdminService ;
import ma.zs.easystock.domain.model.commun.UniteMesure ;
import ma.zs.easystock.domain.service.facade.admin.stock.StockAdminService ;
import ma.zs.easystock.domain.model.stock.Stock ;
import ma.zs.easystock.domain.service.facade.admin.commun.EntrepriseSocieteAdminService ;
import ma.zs.easystock.domain.model.commun.EntrepriseSociete ;
import ma.zs.easystock.domain.service.facade.admin.commun.CategorieAdminService ;
import ma.zs.easystock.domain.model.commun.Categorie ;

import java.util.List;
@Service
public class ProduitAdminServiceImpl extends AbstractServiceImpl<Produit, ProduitCriteria, ProduitDao> implements ProduitAdminService {


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Produit save(Produit t) {
    
        super.save(t);
        if (t.getStocks() != null) {
                t.getStocks().forEach(element-> {
                    element.setProduit(t);
                    stockService.save(element);
            });
        }
        return t;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public int deleteById(Long id) {
        int result=0;
        result += stockService.deleteByProduitId(id);
        result += dao.deleteById(id);
        return result;
    }

    public Produit findByBarCode(String barCode){
        return dao.findByBarCode(barCode);
    }
    public int deleteByBarCode(String barCode){
        return dao.deleteByBarCode(barCode);
    }

    public List<Produit> findByEntrepriseSocieteId(Long id){
        return dao.findByEntrepriseSocieteId(id);
    }
    public int deleteByEntrepriseSocieteId(Long id){
        return dao.deleteByEntrepriseSocieteId(id);
    }
    public long countByEntrepriseSocieteId(Long id){
        return dao.countByEntrepriseSocieteId(id);
    }
    public List<Produit> findByCategorieId(Long id){
        return dao.findByCategorieId(id);
    }
    public int deleteByCategorieId(Long id){
        return dao.deleteByCategorieId(id);
    }
    public long countByCategorieLibelle(String libelle){
        return dao.countByCategorieLibelle(libelle);
    }
    public List<Produit> findByMarqueId(Long id){
        return dao.findByMarqueId(id);
    }
    public int deleteByMarqueId(Long id){
        return dao.deleteByMarqueId(id);
    }
    public long countByMarqueLibelle(String libelle){
        return dao.countByMarqueLibelle(libelle);
    }
    public List<Produit> findByUniteMesureId(Long id){
        return dao.findByUniteMesureId(id);
    }
    public int deleteByUniteMesureId(Long id){
        return dao.deleteByUniteMesureId(id);
    }
    public long countByUniteMesureLibelle(String libelle){
        return dao.countByUniteMesureLibelle(libelle);
    }

    public List<Produit> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(Produit.class);
    }

    @Autowired
    private MarqueAdminService marqueService ;
    @Autowired
    private UniteMesureAdminService uniteMesureService ;
    @Autowired
    private StockAdminService stockService ;
    @Autowired
    private EntrepriseSocieteAdminService entrepriseSocieteService ;
    @Autowired
    private CategorieAdminService categorieService ;

    public ProduitAdminServiceImpl(ProduitDao dao) {
        super(dao);
    }

}
