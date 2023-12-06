package ma.zs.easystock.infra.dao.repository.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.stock.CommandeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommandeRepository extends AbstractRepository<CommandeEntity,Long>  {
    CommandeEntity findByNumeroCommande(String numeroCommande);
    int deleteByNumeroCommande(String numeroCommande);

    List<CommandeEntity> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientCin(String cin);
    List<CommandeEntity> findByEtatCommandeId(Long id);
    int deleteByEtatCommandeId(Long id);
    long countByEtatCommandeId(Long id);

    @Query("SELECT NEW CommandeEntity(item.id,item.numeroCommande) FROM CommandeEntity item")
    List<CommandeEntity> findAllOptimized();

}
