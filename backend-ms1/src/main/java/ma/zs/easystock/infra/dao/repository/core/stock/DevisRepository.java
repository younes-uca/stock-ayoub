package ma.zs.easystock.infra.dao.repository.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.stock.DevisEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DevisRepository extends AbstractRepository<DevisEntity,Long>  {
    DevisEntity findByNumeroDevis(String numeroDevis);
    int deleteByNumeroDevis(String numeroDevis);

    List<DevisEntity> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientCin(String cin);

    @Query("SELECT NEW DevisEntity(item.id,item.numeroDevis) FROM DevisEntity item")
    List<DevisEntity> findAllOptimized();

}
