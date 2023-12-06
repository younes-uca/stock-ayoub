package ma.zs.easystock.infra.dao.impl.core.stock;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.stock.DevisRepository;
import ma.zs.easystock.infra.bean.core.stock.DevisEntity;
import ma.zs.easystock.infra.converter.stock.DevisInfraConverter;
import ma.zs.easystock.domain.dao.stock.DevisDao;
import ma.zs.easystock.domain.model.stock.Devis;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DevisDaoImpl extends AbstractDaoImpl<DevisEntity, Devis, DevisRepository, DevisInfraConverter> implements DevisDao  {

    @Override
    public Devis findByNumeroDevis(String numeroDevis){
        DevisEntity entity = repository.findByNumeroDevis(numeroDevis);
        return converter.toModel(entity);
    }

    @Override
    public int deleteByNumeroDevis(String numeroDevis){
        return repository.deleteByNumeroDevis(numeroDevis);
    }

    @Override
    public List<Devis> findAllOptimized(){
    List<DevisEntity> list =  repository.findAllOptimized();
        return converter.toModel(list);
    }

    @Override
    public List<Devis> findByClientId(Long id){
        List<DevisEntity> list = repository.findByClientId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByClientId(Long id){
        return repository.deleteByClientId(id);
    }
    @Override
    public long countByClientCin(String cin){
        return repository.countByClientCin(cin);
    }



    public DevisDaoImpl(DevisRepository  repository, DevisInfraConverter converter){
        super(repository,converter);
    }
}
