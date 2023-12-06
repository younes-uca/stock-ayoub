package ma.zs.easystock.infra.dao.impl.core.gestionchequeffet;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.gestionchequeffet.ChequeEffetRepository;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.ChequeEffetEntity;
import ma.zs.easystock.infra.converter.gestionchequeffet.ChequeEffetInfraConverter;
import ma.zs.easystock.domain.dao.gestionchequeffet.ChequeEffetDao;
import ma.zs.easystock.domain.model.gestionchequeffet.ChequeEffet;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ChequeEffetDaoImpl extends AbstractDaoImpl<ChequeEffetEntity, ChequeEffet, ChequeEffetRepository, ChequeEffetInfraConverter> implements ChequeEffetDao  {

    @Override
    public ChequeEffet findByNumeroChequeEffet(String numeroChequeEffet){
        ChequeEffetEntity entity = repository.findByNumeroChequeEffet(numeroChequeEffet);
        return converter.toModel(entity);
    }

    @Override
    public int deleteByNumeroChequeEffet(String numeroChequeEffet){
        return repository.deleteByNumeroChequeEffet(numeroChequeEffet);
    }

    @Override
    public List<ChequeEffet> findAllOptimized(){
    List<ChequeEffetEntity> list =  repository.findAllOptimized();
        return converter.toModel(list);
    }

    @Override
    public List<ChequeEffet> findByBeneficiaireId(Long id){
        List<ChequeEffetEntity> list = repository.findByBeneficiaireId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByBeneficiaireId(Long id){
        return repository.deleteByBeneficiaireId(id);
    }
    @Override
    public long countByBeneficiaireIce(String ice){
        return repository.countByBeneficiaireIce(ice);
    }



    public ChequeEffetDaoImpl(ChequeEffetRepository  repository, ChequeEffetInfraConverter converter){
        super(repository,converter);
    }
}
