package ma.zs.easystock.infra.dao.impl.core.commun;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.commun.UniteMesureRepository;
import ma.zs.easystock.infra.bean.core.commun.UniteMesureEntity;
import ma.zs.easystock.infra.converter.commun.UniteMesureInfraConverter;
import ma.zs.easystock.domain.dao.commun.UniteMesureDao;
import ma.zs.easystock.domain.model.commun.UniteMesure;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UniteMesureDaoImpl extends AbstractDaoImpl<UniteMesureEntity, UniteMesure, UniteMesureRepository, UniteMesureInfraConverter> implements UniteMesureDao  {

    @Override
    public UniteMesure findByLibelle(String libelle){
        UniteMesureEntity entity = repository.findByLibelle(libelle);
        return converter.toModel(entity);
    }

    @Override
    public int deleteByLibelle(String libelle){
        return repository.deleteByLibelle(libelle);
    }

    @Override
    public List<UniteMesure> findAllOptimized(){
    List<UniteMesureEntity> list =  repository.findAllOptimized();
        return converter.toModel(list);
    }




    public UniteMesureDaoImpl(UniteMesureRepository  repository, UniteMesureInfraConverter converter){
        super(repository,converter);
    }
}
