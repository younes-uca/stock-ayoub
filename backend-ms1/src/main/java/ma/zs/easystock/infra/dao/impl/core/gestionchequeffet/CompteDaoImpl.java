package ma.zs.easystock.infra.dao.impl.core.gestionchequeffet;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.gestionchequeffet.CompteRepository;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.CompteEntity;
import ma.zs.easystock.infra.converter.gestionchequeffet.CompteInfraConverter;
import ma.zs.easystock.domain.dao.gestionchequeffet.CompteDao;
import ma.zs.easystock.domain.model.gestionchequeffet.Compte;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CompteDaoImpl extends AbstractDaoImpl<CompteEntity, Compte, CompteRepository, CompteInfraConverter> implements CompteDao  {


    @Override
    public List<Compte> findByBanqueId(Long id){
        List<CompteEntity> list = repository.findByBanqueId(id);
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
    public List<Compte> findByProprietaireId(Long id){
        List<CompteEntity> list = repository.findByProprietaireId(id);
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



    public CompteDaoImpl(CompteRepository  repository, CompteInfraConverter converter){
        super(repository,converter);
    }
}
