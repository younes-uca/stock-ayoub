package ma.zs.easystock.infra.dao.repository.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.stock.TaxeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaxeRepository extends AbstractRepository<TaxeEntity,Long>  {


    @Query("SELECT NEW TaxeEntity(item.id,item.libelle) FROM TaxeEntity item")
    List<TaxeEntity> findAllOptimized();

}
