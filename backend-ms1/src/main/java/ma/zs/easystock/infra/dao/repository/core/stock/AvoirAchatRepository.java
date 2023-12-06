package ma.zs.easystock.infra.dao.repository.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.stock.AvoirAchatEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AvoirAchatRepository extends AbstractRepository<AvoirAchatEntity,Long>  {
    AvoirAchatEntity findByNumeroFactureAvoirAchat(String numeroFactureAvoirAchat);
    int deleteByNumeroFactureAvoirAchat(String numeroFactureAvoirAchat);

    List<AvoirAchatEntity> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<AvoirAchatEntity> findByFournisseurId(Long id);
    int deleteByFournisseurId(Long id);
    long countByFournisseurIce(String ice);
    List<AvoirAchatEntity> findByEtatAvoirAchatId(Long id);
    int deleteByEtatAvoirAchatId(Long id);
    long countByEtatAvoirAchatId(Long id);

    @Query("SELECT NEW AvoirAchatEntity(item.id,item.numeroFactureAvoirAchat) FROM AvoirAchatEntity item")
    List<AvoirAchatEntity> findAllOptimized();

}
