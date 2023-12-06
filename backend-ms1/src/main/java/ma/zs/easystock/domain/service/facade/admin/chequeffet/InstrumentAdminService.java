package ma.zs.easystock.domain.service.facade.admin.chequeffet;

import java.util.List;
import ma.zs.easystock.domain.model.chequeffet.Instrument;
import ma.zs.easystock.infra.dao.criteria.core.chequeffet.InstrumentCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface InstrumentAdminService extends  IService<Instrument,InstrumentCriteria>  {

    List<Instrument> findByTypeInstrumentId(Long id);
    int deleteByTypeInstrumentId(Long id);
    long countByTypeInstrumentId(Long id);
    List<Instrument> findByChequeEffetId(Long id);
    int deleteByChequeEffetId(Long id);
    long countByChequeEffetNumeroChequeEffet(String numeroChequeEffet);



}
