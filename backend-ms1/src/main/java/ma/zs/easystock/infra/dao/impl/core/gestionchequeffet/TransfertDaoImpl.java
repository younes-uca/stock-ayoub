package ma.zs.easystock.infra.dao.impl.core.gestionchequeffet;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.gestionchequeffet.TransfertRepository;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.TransfertEntity;
import ma.zs.easystock.infra.converter.gestionchequeffet.TransfertInfraConverter;
import ma.zs.easystock.domain.dao.gestionchequeffet.TransfertDao;
import ma.zs.easystock.domain.model.gestionchequeffet.Transfert;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TransfertDaoImpl extends AbstractDaoImpl<TransfertEntity, Transfert, TransfertRepository, TransfertInfraConverter> implements TransfertDao  {


    @Override
    public List<Transfert> findByRaisonId(Long id){
        List<TransfertEntity> list = repository.findByRaisonId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByRaisonId(Long id){
        return repository.deleteByRaisonId(id);
    }
    @Override
    public long countByRaisonId(Long id){
        return repository.countByRaisonId(id);
    }



    public TransfertDaoImpl(TransfertRepository  repository, TransfertInfraConverter converter){
        super(repository,converter);
    }
}
