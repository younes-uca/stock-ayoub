package ma.zs.easystock.infra.dao.repository.core.reglement;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.reglement.ReglementAvoirAchatEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReglementAvoirAchatRepository extends AbstractRepository<ReglementAvoirAchatEntity,Long>  {
    ReglementAvoirAchatEntity findByReference(String reference);
    int deleteByReference(String reference);

    List<ReglementAvoirAchatEntity> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    long countByAchatId(Long id);
    List<ReglementAvoirAchatEntity> findByModeReglementId(Long id);
    int deleteByModeReglementId(Long id);
    long countByModeReglementId(Long id);
    List<ReglementAvoirAchatEntity> findByAvoirAchatId(Long id);
    int deleteByAvoirAchatId(Long id);
    long countByAvoirAchatNumeroFactureAvoirAchat(String numeroFactureAvoirAchat);

    @Query("SELECT NEW ReglementAvoirAchatEntity(item.id,item.reference) FROM ReglementAvoirAchatEntity item")
    List<ReglementAvoirAchatEntity> findAllOptimized();

}
