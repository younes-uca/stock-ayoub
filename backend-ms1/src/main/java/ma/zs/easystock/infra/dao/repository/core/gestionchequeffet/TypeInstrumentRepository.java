package ma.zs.easystock.infra.dao.repository.core.gestionchequeffet;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.TypeInstrumentEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TypeInstrumentRepository extends AbstractRepository<TypeInstrumentEntity,Long>  {


    @Query("SELECT NEW TypeInstrumentEntity(item.id,item.libelle) FROM TypeInstrumentEntity item")
    List<TypeInstrumentEntity> findAllOptimized();

}
