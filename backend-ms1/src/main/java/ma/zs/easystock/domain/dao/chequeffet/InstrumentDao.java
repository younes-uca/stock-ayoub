package ma.zs.easystock.domain.dao.chequeffet;

import ma.zs.easystock.domain.model.chequeffet.Instrument;


import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface InstrumentDao extends IDao<Instrument> {


    List<Instrument> findByTypeInstrumentId(Long id);
    int deleteByTypeInstrumentId(Long id);
    long countByTypeInstrumentId(Long id);
    List<Instrument> findByChequeEffetId(Long id);
    int deleteByChequeEffetId(Long id);
    long countByChequeEffetNumeroChequeEffet(String numeroChequeEffet);



}
