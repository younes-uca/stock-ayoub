package ma.zs.easystock.infra.dao.repository.core.reglement;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.reglement.ReglementAvoirVenteEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReglementAvoirVenteRepository extends AbstractRepository<ReglementAvoirVenteEntity,Long>  {
    ReglementAvoirVenteEntity findByReference(String reference);
    int deleteByReference(String reference);

    List<ReglementAvoirVenteEntity> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    long countByVenteNumeroFacture(String numeroFacture);
    List<ReglementAvoirVenteEntity> findByModeReglementId(Long id);
    int deleteByModeReglementId(Long id);
    long countByModeReglementId(Long id);
    List<ReglementAvoirVenteEntity> findByAvoirVenteId(Long id);
    int deleteByAvoirVenteId(Long id);
    long countByAvoirVenteNumeroFactureAvoirVente(String numeroFactureAvoirVente);

    @Query("SELECT NEW ReglementAvoirVenteEntity(item.id,item.reference) FROM ReglementAvoirVenteEntity item")
    List<ReglementAvoirVenteEntity> findAllOptimized();

}
