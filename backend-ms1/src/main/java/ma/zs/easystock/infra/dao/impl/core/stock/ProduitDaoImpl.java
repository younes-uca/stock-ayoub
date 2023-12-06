package ma.zs.easystock.infra.dao.impl.core.stock;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.stock.ProduitRepository;
import ma.zs.easystock.infra.bean.core.stock.ProduitEntity;
import ma.zs.easystock.infra.converter.stock.ProduitInfraConverter;
import ma.zs.easystock.domain.dao.stock.ProduitDao;
import ma.zs.easystock.domain.model.stock.Produit;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ProduitDaoImpl extends AbstractDaoImpl<ProduitEntity, Produit, ProduitRepository, ProduitInfraConverter> implements ProduitDao  {

    @Override
    public Produit findByBarCode(String barCode){
        ProduitEntity entity = repository.findByBarCode(barCode);
        return converter.toModel(entity);
    }

    @Override
    public int deleteByBarCode(String barCode){
        return repository.deleteByBarCode(barCode);
    }

    @Override
    public List<Produit> findAllOptimized(){
    List<ProduitEntity> list =  repository.findAllOptimized();
        return converter.toModel(list);
    }

    @Override
    public List<Produit> findByEntrepriseSocieteId(Long id){
        List<ProduitEntity> list = repository.findByEntrepriseSocieteId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByEntrepriseSocieteId(Long id){
        return repository.deleteByEntrepriseSocieteId(id);
    }
    @Override
    public long countByEntrepriseSocieteId(Long id){
        return repository.countByEntrepriseSocieteId(id);
    }
    @Override
    public List<Produit> findByCategorieId(Long id){
        List<ProduitEntity> list = repository.findByCategorieId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByCategorieId(Long id){
        return repository.deleteByCategorieId(id);
    }
    @Override
    public long countByCategorieLibelle(String libelle){
        return repository.countByCategorieLibelle(libelle);
    }
    @Override
    public List<Produit> findByMarqueId(Long id){
        List<ProduitEntity> list = repository.findByMarqueId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByMarqueId(Long id){
        return repository.deleteByMarqueId(id);
    }
    @Override
    public long countByMarqueLibelle(String libelle){
        return repository.countByMarqueLibelle(libelle);
    }
    @Override
    public List<Produit> findByUniteMesureId(Long id){
        List<ProduitEntity> list = repository.findByUniteMesureId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByUniteMesureId(Long id){
        return repository.deleteByUniteMesureId(id);
    }
    @Override
    public long countByUniteMesureLibelle(String libelle){
        return repository.countByUniteMesureLibelle(libelle);
    }



    public ProduitDaoImpl(ProduitRepository  repository, ProduitInfraConverter converter){
        super(repository,converter);
    }
}
