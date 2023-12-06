package ma.zs.easystock.infra.dao.repository.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.stock.ProduitEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProduitRepository extends AbstractRepository<ProduitEntity,Long>  {
    ProduitEntity findByBarCode(String barCode);
    int deleteByBarCode(String barCode);

    List<ProduitEntity> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<ProduitEntity> findByCategorieId(Long id);
    int deleteByCategorieId(Long id);
    long countByCategorieLibelle(String libelle);
    List<ProduitEntity> findByMarqueId(Long id);
    int deleteByMarqueId(Long id);
    long countByMarqueLibelle(String libelle);
    List<ProduitEntity> findByUniteMesureId(Long id);
    int deleteByUniteMesureId(Long id);
    long countByUniteMesureLibelle(String libelle);

    @Query("SELECT NEW ProduitEntity(item.id,item.seuilAlerte) FROM ProduitEntity item")
    List<ProduitEntity> findAllOptimized();

}
