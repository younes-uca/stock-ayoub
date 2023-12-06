package ma.zs.easystock.infra.dao.impl.core.gestionchequeffet;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.gestionchequeffet.ProprietaireBanqueRepository;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.ProprietaireBanqueEntity;
import ma.zs.easystock.infra.converter.gestionchequeffet.ProprietaireBanqueInfraConverter;
import ma.zs.easystock.domain.dao.gestionchequeffet.ProprietaireBanqueDao;
import ma.zs.easystock.domain.model.gestionchequeffet.ProprietaireBanque;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ProprietaireBanqueDaoImpl extends AbstractDaoImpl<ProprietaireBanqueEntity, ProprietaireBanque, ProprietaireBanqueRepository, ProprietaireBanqueInfraConverter> implements ProprietaireBanqueDao  {


    @Override
    public List<ProprietaireBanque> findByProprietaireId(Long id){
        List<ProprietaireBanqueEntity> list = repository.findByProprietaireId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByProprietaireId(Long id){
        return repository.deleteByProprietaireId(id);
    }
    @Override
    public long countByProprietaireId(Long id){
        return repository.countByProprietaireId(id);
    }
    @Override
    public List<ProprietaireBanque> findByBanqueId(Long id){
        List<ProprietaireBanqueEntity> list = repository.findByBanqueId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByBanqueId(Long id){
        return repository.deleteByBanqueId(id);
    }
    @Override
    public long countByBanqueId(Long id){
        return repository.countByBanqueId(id);
    }
    @Override
    public List<ProprietaireBanque> findByCompteId(Long id){
        List<ProprietaireBanqueEntity> list = repository.findByCompteId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByCompteId(Long id){
        return repository.deleteByCompteId(id);
    }
    @Override
    public long countByCompteId(Long id){
        return repository.countByCompteId(id);
    }



    public ProprietaireBanqueDaoImpl(ProprietaireBanqueRepository  repository, ProprietaireBanqueInfraConverter converter){
        super(repository,converter);
    }
}
