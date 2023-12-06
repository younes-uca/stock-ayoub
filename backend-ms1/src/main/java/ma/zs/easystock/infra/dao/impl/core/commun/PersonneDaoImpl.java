package ma.zs.easystock.infra.dao.impl.core.commun;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.commun.PersonneRepository;
import ma.zs.easystock.infra.bean.core.commun.PersonneEntity;
import ma.zs.easystock.infra.converter.commun.PersonneInfraConverter;
import ma.zs.easystock.domain.dao.commun.PersonneDao;
import ma.zs.easystock.domain.model.commun.Personne;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PersonneDaoImpl extends AbstractDaoImpl<PersonneEntity, Personne, PersonneRepository, PersonneInfraConverter> implements PersonneDao  {

    @Override
    public Personne findByTelephone(String telephone){
        PersonneEntity entity = repository.findByTelephone(telephone);
        return converter.toModel(entity);
    }

    @Override
    public int deleteByTelephone(String telephone){
        return repository.deleteByTelephone(telephone);
    }

    @Override
    public List<Personne> findAllOptimized(){
    List<PersonneEntity> list =  repository.findAllOptimized();
        return converter.toModel(list);
    }

    @Override
    public List<Personne> findByVilleId(Long id){
        List<PersonneEntity> list = repository.findByVilleId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByVilleId(Long id){
        return repository.deleteByVilleId(id);
    }
    @Override
    public long countByVilleId(Long id){
        return repository.countByVilleId(id);
    }



    public PersonneDaoImpl(PersonneRepository  repository, PersonneInfraConverter converter){
        super(repository,converter);
    }
}
