package ma.zs.easystock.infra.dao.impl.core.stock;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.stock.AvoirVenteRepository;
import ma.zs.easystock.infra.bean.core.stock.AvoirVenteEntity;
import ma.zs.easystock.infra.converter.stock.AvoirVenteInfraConverter;
import ma.zs.easystock.domain.dao.stock.AvoirVenteDao;
import ma.zs.easystock.domain.model.stock.AvoirVente;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AvoirVenteDaoImpl extends AbstractDaoImpl<AvoirVenteEntity, AvoirVente, AvoirVenteRepository, AvoirVenteInfraConverter> implements AvoirVenteDao  {

    @Override
    public AvoirVente findByNumeroFactureAvoirVente(String numeroFactureAvoirVente){
        AvoirVenteEntity entity = repository.findByNumeroFactureAvoirVente(numeroFactureAvoirVente);
        return converter.toModel(entity);
    }

    @Override
    public int deleteByNumeroFactureAvoirVente(String numeroFactureAvoirVente){
        return repository.deleteByNumeroFactureAvoirVente(numeroFactureAvoirVente);
    }

    @Override
    public List<AvoirVente> findAllOptimized(){
    List<AvoirVenteEntity> list =  repository.findAllOptimized();
        return converter.toModel(list);
    }

    @Override
    public List<AvoirVente> findByEntrepriseSocieteId(Long id){
        List<AvoirVenteEntity> list = repository.findByEntrepriseSocieteId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByEntrepriseSocieteId(Long id){
        return repository.deleteByEntrepriseSocieteId(id);
    }
    @Override
    public long countByEntrepriseSocieteId(Long id){
        return repository.countByEntrepriseSocieteId(id);
    }
    @Override
    public List<AvoirVente> findByClientId(Long id){
        List<AvoirVenteEntity> list = repository.findByClientId(id);
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
    @Override
    public List<AvoirVente> findByEtatAvoirVenteId(Long id){
        List<AvoirVenteEntity> list = repository.findByEtatAvoirVenteId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByEtatAvoirVenteId(Long id){
        return repository.deleteByEtatAvoirVenteId(id);
    }
    @Override
    public long countByEtatAvoirVenteId(Long id){
        return repository.countByEtatAvoirVenteId(id);
    }
    @Override
    public List<AvoirVente> findByAchatId(Long id){
        List<AvoirVenteEntity> list = repository.findByAchatId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByAchatId(Long id){
        return repository.deleteByAchatId(id);
    }
    @Override
    public long countByAchatId(Long id){
        return repository.countByAchatId(id);
    }



    public AvoirVenteDaoImpl(AvoirVenteRepository  repository, AvoirVenteInfraConverter converter){
        super(repository,converter);
    }
}
