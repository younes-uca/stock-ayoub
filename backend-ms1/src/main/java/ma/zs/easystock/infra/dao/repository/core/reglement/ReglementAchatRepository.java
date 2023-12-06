package ma.zs.easystock.infra.dao.repository.core.reglement;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.reglement.ReglementAchatEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReglementAchatRepository extends AbstractRepository<ReglementAchatEntity,Long>  {
    ReglementAchatEntity findByReference(String reference);
    int deleteByReference(String reference);

    List<ReglementAchatEntity> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    long countByAchatId(Long id);
    List<ReglementAchatEntity> findByModeReglementId(Long id);
    int deleteByModeReglementId(Long id);
    long countByModeReglementId(Long id);

    @Query("SELECT NEW ReglementAchatEntity(item.id,item.reference) FROM ReglementAchatEntity item")
    List<ReglementAchatEntity> findAllOptimized();

}
