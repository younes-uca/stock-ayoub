package ma.zs.easystock.infra.dao.repository.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.stock.VenteEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VenteRepository extends AbstractRepository<VenteEntity,Long>  {
    VenteEntity findByNumeroFacture(String numeroFacture);
    int deleteByNumeroFacture(String numeroFacture);

    List<VenteEntity> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<VenteEntity> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientCin(String cin);
    List<VenteEntity> findByEtatVenteId(Long id);
    int deleteByEtatVenteId(Long id);
    long countByEtatVenteId(Long id);

    @Query("SELECT NEW VenteEntity(item.id,item.numeroFacture) FROM VenteEntity item")
    List<VenteEntity> findAllOptimized();

}
