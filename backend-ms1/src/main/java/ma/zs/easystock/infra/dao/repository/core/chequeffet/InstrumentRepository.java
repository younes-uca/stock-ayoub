package ma.zs.easystock.infra.dao.repository.core.chequeffet;

import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.chequeffet.InstrumentEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InstrumentRepository extends AbstractRepository<InstrumentEntity,Long>  {

    List<InstrumentEntity> findByTypeInstrumentId(Long id);
    int deleteByTypeInstrumentId(Long id);
    long countByTypeInstrumentId(Long id);
    List<InstrumentEntity> findByChequeEffetId(Long id);
    int deleteByChequeEffetId(Long id);
    long countByChequeEffetNumeroChequeEffet(String numeroChequeEffet);


}
