package ma.zs.easystock.infra.dao.repository.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.stock.AvoirVenteEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AvoirVenteRepository extends AbstractRepository<AvoirVenteEntity,Long>  {
    AvoirVenteEntity findByNumeroFactureAvoirVente(String numeroFactureAvoirVente);
    int deleteByNumeroFactureAvoirVente(String numeroFactureAvoirVente);

    List<AvoirVenteEntity> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<AvoirVenteEntity> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientCin(String cin);
    List<AvoirVenteEntity> findByEtatAvoirVenteId(Long id);
    int deleteByEtatAvoirVenteId(Long id);
    long countByEtatAvoirVenteId(Long id);
    List<AvoirVenteEntity> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    long countByAchatId(Long id);

    @Query("SELECT NEW AvoirVenteEntity(item.id,item.numeroFactureAvoirVente) FROM AvoirVenteEntity item")
    List<AvoirVenteEntity> findAllOptimized();

}
