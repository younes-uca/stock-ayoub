package ma.zs.easystock.infra.dao.impl.core.gestionchequeffet;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.gestionchequeffet.PossedeCompteRepository;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.PossedeCompteEntity;
import ma.zs.easystock.infra.converter.gestionchequeffet.PossedeCompteInfraConverter;
import ma.zs.easystock.domain.dao.gestionchequeffet.PossedeCompteDao;
import ma.zs.easystock.domain.model.gestionchequeffet.PossedeCompte;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PossedeCompteDaoImpl extends AbstractDaoImpl<PossedeCompteEntity, PossedeCompte, PossedeCompteRepository, PossedeCompteInfraConverter> implements PossedeCompteDao  {


    @Override
    public List<PossedeCompte> findByProprietaireId(Long id){
        List<PossedeCompteEntity> list = repository.findByProprietaireId(id);
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
    public List<PossedeCompte> findByBanqueId(Long id){
        List<PossedeCompteEntity> list = repository.findByBanqueId(id);
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
    public List<PossedeCompte> findByCompteId(Long id){
        List<PossedeCompteEntity> list = repository.findByCompteId(id);
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



    public PossedeCompteDaoImpl(PossedeCompteRepository  repository, PossedeCompteInfraConverter converter){
        super(repository,converter);
    }
}
