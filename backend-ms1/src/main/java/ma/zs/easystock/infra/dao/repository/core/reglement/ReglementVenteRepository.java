package ma.zs.easystock.infra.dao.repository.core.reglement;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.reglement.ReglementVenteEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReglementVenteRepository extends AbstractRepository<ReglementVenteEntity,Long>  {
    ReglementVenteEntity findByReference(String reference);
    int deleteByReference(String reference);

    List<ReglementVenteEntity> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    long countByVenteNumeroFacture(String numeroFacture);
    List<ReglementVenteEntity> findByModeReglementId(Long id);
    int deleteByModeReglementId(Long id);
    long countByModeReglementId(Long id);

    @Query("SELECT NEW ReglementVenteEntity(item.id,item.reference) FROM ReglementVenteEntity item")
    List<ReglementVenteEntity> findAllOptimized();

}
