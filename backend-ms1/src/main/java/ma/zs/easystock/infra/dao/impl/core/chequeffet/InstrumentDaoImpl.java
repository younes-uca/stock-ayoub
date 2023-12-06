package ma.zs.easystock.infra.dao.impl.core.chequeffet;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.chequeffet.InstrumentRepository;
import ma.zs.easystock.infra.bean.core.chequeffet.InstrumentEntity;
import ma.zs.easystock.infra.converter.chequeffet.InstrumentInfraConverter;
import ma.zs.easystock.domain.dao.chequeffet.InstrumentDao;
import ma.zs.easystock.domain.model.chequeffet.Instrument;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class InstrumentDaoImpl extends AbstractDaoImpl<InstrumentEntity, Instrument, InstrumentRepository, InstrumentInfraConverter> implements InstrumentDao  {


    @Override
    public List<Instrument> findByTypeInstrumentId(Long id){
        List<InstrumentEntity> list = repository.findByTypeInstrumentId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByTypeInstrumentId(Long id){
        return repository.deleteByTypeInstrumentId(id);
    }
    @Override
    public long countByTypeInstrumentId(Long id){
        return repository.countByTypeInstrumentId(id);
    }
    @Override
    public List<Instrument> findByChequeEffetId(Long id){
        List<InstrumentEntity> list = repository.findByChequeEffetId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByChequeEffetId(Long id){
        return repository.deleteByChequeEffetId(id);
    }
    @Override
    public long countByChequeEffetNumeroChequeEffet(String numeroChequeEffet){
        return repository.countByChequeEffetNumeroChequeEffet(numeroChequeEffet);
    }



    public InstrumentDaoImpl(InstrumentRepository  repository, InstrumentInfraConverter converter){
        super(repository,converter);
    }
}
