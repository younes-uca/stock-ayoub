package ma.zs.easystock.infra.dao.impl.core.commun;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.commun.FournisseurRepository;
import ma.zs.easystock.infra.bean.core.commun.FournisseurEntity;
import ma.zs.easystock.infra.converter.commun.FournisseurInfraConverter;
import ma.zs.easystock.domain.dao.commun.FournisseurDao;
import ma.zs.easystock.domain.model.commun.Fournisseur;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FournisseurDaoImpl extends AbstractDaoImpl<FournisseurEntity, Fournisseur, FournisseurRepository, FournisseurInfraConverter> implements FournisseurDao  {

    @Override
    public Fournisseur findByIce(String ice){
        FournisseurEntity entity = repository.findByIce(ice);
        return converter.toModel(entity);
    }

    @Override
    public int deleteByIce(String ice){
        return repository.deleteByIce(ice);
    }

    @Override
    public List<Fournisseur> findAllOptimized(){
    List<FournisseurEntity> list =  repository.findAllOptimized();
        return converter.toModel(list);
    }




    public FournisseurDaoImpl(FournisseurRepository  repository, FournisseurInfraConverter converter){
        super(repository,converter);
    }
}
