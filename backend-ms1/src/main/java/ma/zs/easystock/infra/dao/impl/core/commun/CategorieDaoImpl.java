package ma.zs.easystock.infra.dao.impl.core.commun;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.commun.CategorieRepository;
import ma.zs.easystock.infra.bean.core.commun.CategorieEntity;
import ma.zs.easystock.infra.converter.commun.CategorieInfraConverter;
import ma.zs.easystock.domain.dao.commun.CategorieDao;
import ma.zs.easystock.domain.model.commun.Categorie;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CategorieDaoImpl extends AbstractDaoImpl<CategorieEntity, Categorie, CategorieRepository, CategorieInfraConverter> implements CategorieDao  {

    @Override
    public Categorie findByLibelle(String libelle){
        CategorieEntity entity = repository.findByLibelle(libelle);
        return converter.toModel(entity);
    }

    @Override
    public int deleteByLibelle(String libelle){
        return repository.deleteByLibelle(libelle);
    }

    @Override
    public List<Categorie> findAllOptimized(){
    List<CategorieEntity> list =  repository.findAllOptimized();
        return converter.toModel(list);
    }




    public CategorieDaoImpl(CategorieRepository  repository, CategorieInfraConverter converter){
        super(repository,converter);
    }
}
