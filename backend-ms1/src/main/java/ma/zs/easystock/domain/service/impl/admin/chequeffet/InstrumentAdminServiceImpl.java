package ma.zs.easystock.domain.service.impl.admin.chequeffet;


import ma.zs.easystock.domain.model.chequeffet.Instrument;
import ma.zs.easystock.infra.dao.criteria.core.chequeffet.InstrumentCriteria;
import ma.zs.easystock.domain.dao.chequeffet.InstrumentDao;
import ma.zs.easystock.infra.dao.specification.core.chequeffet.InstrumentSpecification;
import ma.zs.easystock.domain.service.facade.admin.chequeffet.InstrumentAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.ChequeEffetAdminService ;
import ma.zs.easystock.domain.model.gestionchequeffet.ChequeEffet ;
import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.TypeInstrumentAdminService ;
import ma.zs.easystock.domain.model.gestionchequeffet.TypeInstrument ;

import java.util.List;
@Service
public class InstrumentAdminServiceImpl extends AbstractServiceImpl<Instrument, InstrumentCriteria, InstrumentDao> implements InstrumentAdminService {






    public List<Instrument> findByTypeInstrumentId(Long id){
        return dao.findByTypeInstrumentId(id);
    }
    public int deleteByTypeInstrumentId(Long id){
        return dao.deleteByTypeInstrumentId(id);
    }
    public long countByTypeInstrumentId(Long id){
        return dao.countByTypeInstrumentId(id);
    }
    public List<Instrument> findByChequeEffetId(Long id){
        return dao.findByChequeEffetId(id);
    }
    public int deleteByChequeEffetId(Long id){
        return dao.deleteByChequeEffetId(id);
    }
    public long countByChequeEffetNumeroChequeEffet(String numeroChequeEffet){
        return dao.countByChequeEffetNumeroChequeEffet(numeroChequeEffet);
    }





    public void configure() {
        super.configure(Instrument.class);
    }

    @Autowired
    private ChequeEffetAdminService chequeEffetService ;
    @Autowired
    private TypeInstrumentAdminService typeInstrumentService ;

    public InstrumentAdminServiceImpl(InstrumentDao dao) {
        super(dao);
    }

}
