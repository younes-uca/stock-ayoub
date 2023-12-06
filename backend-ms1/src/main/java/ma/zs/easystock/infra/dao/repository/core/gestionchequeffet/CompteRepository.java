package ma.zs.easystock.infra.dao.repository.core.gestionchequeffet;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.CompteEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CompteRepository extends AbstractRepository<CompteEntity,Long>  {

    List<CompteEntity> findByBanqueId(Long id);
    int deleteByBanqueId(Long id);
    long countByBanqueId(Long id);
    List<CompteEntity> findByProprietaireId(Long id);
    int deleteByProprietaireId(Long id);
    long countByProprietaireId(Long id);

    @Query("SELECT NEW CompteEntity(item.id,item.numeroCompte) FROM CompteEntity item")
    List<CompteEntity> findAllOptimized();

}
