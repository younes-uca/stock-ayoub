package ma.zs.easystock.infra.dao.impl.core.stock;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.stock.VenteRepository;
import ma.zs.easystock.infra.bean.core.stock.VenteEntity;
import ma.zs.easystock.infra.converter.stock.VenteInfraConverter;
import ma.zs.easystock.domain.dao.stock.VenteDao;
import ma.zs.easystock.domain.model.stock.Vente;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class VenteDaoImpl extends AbstractDaoImpl<VenteEntity, Vente, VenteRepository, VenteInfraConverter> implements VenteDao  {

    @Override
    public Vente findByNumeroFacture(String numeroFacture){
        VenteEntity entity = repository.findByNumeroFacture(numeroFacture);
        return converter.toModel(entity);
    }

    @Override
    public int deleteByNumeroFacture(String numeroFacture){
        return repository.deleteByNumeroFacture(numeroFacture);
    }

    @Override
    public List<Vente> findAllOptimized(){
    List<VenteEntity> list =  repository.findAllOptimized();
        return converter.toModel(list);
    }

    @Override
    public List<Vente> findByEntrepriseSocieteId(Long id){
        List<VenteEntity> list = repository.findByEntrepriseSocieteId(id);
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
    public List<Vente> findByClientId(Long id){
        List<VenteEntity> list = repository.findByClientId(id);
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
    public List<Vente> findByEtatVenteId(Long id){
        List<VenteEntity> list = repository.findByEtatVenteId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByEtatVenteId(Long id){
        return repository.deleteByEtatVenteId(id);
    }
    @Override
    public long countByEtatVenteId(Long id){
        return repository.countByEtatVenteId(id);
    }



    public VenteDaoImpl(VenteRepository  repository, VenteInfraConverter converter){
        super(repository,converter);
    }
}
