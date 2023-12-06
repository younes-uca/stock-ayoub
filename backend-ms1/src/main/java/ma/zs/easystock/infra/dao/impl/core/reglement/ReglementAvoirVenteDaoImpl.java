package ma.zs.easystock.infra.dao.impl.core.reglement;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.reglement.ReglementAvoirVenteRepository;
import ma.zs.easystock.infra.bean.core.reglement.ReglementAvoirVenteEntity;
import ma.zs.easystock.infra.converter.reglement.ReglementAvoirVenteInfraConverter;
import ma.zs.easystock.domain.dao.reglement.ReglementAvoirVenteDao;
import ma.zs.easystock.domain.model.reglement.ReglementAvoirVente;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ReglementAvoirVenteDaoImpl extends AbstractDaoImpl<ReglementAvoirVenteEntity, ReglementAvoirVente, ReglementAvoirVenteRepository, ReglementAvoirVenteInfraConverter> implements ReglementAvoirVenteDao  {

    @Override
    public ReglementAvoirVente findByReference(String reference){
        ReglementAvoirVenteEntity entity = repository.findByReference(reference);
        return converter.toModel(entity);
    }

    @Override
    public int deleteByReference(String reference){
        return repository.deleteByReference(reference);
    }

    @Override
    public List<ReglementAvoirVente> findAllOptimized(){
    List<ReglementAvoirVenteEntity> list =  repository.findAllOptimized();
        return converter.toModel(list);
    }

    @Override
    public List<ReglementAvoirVente> findByVenteId(Long id){
        List<ReglementAvoirVenteEntity> list = repository.findByVenteId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByVenteId(Long id){
        return repository.deleteByVenteId(id);
    }
    @Override
    public long countByVenteNumeroFacture(String numeroFacture){
        return repository.countByVenteNumeroFacture(numeroFacture);
    }
    @Override
    public List<ReglementAvoirVente> findByModeReglementId(Long id){
        List<ReglementAvoirVenteEntity> list = repository.findByModeReglementId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByModeReglementId(Long id){
        return repository.deleteByModeReglementId(id);
    }
    @Override
    public long countByModeReglementId(Long id){
        return repository.countByModeReglementId(id);
    }
    @Override
    public List<ReglementAvoirVente> findByAvoirVenteId(Long id){
        List<ReglementAvoirVenteEntity> list = repository.findByAvoirVenteId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByAvoirVenteId(Long id){
        return repository.deleteByAvoirVenteId(id);
    }
    @Override
    public long countByAvoirVenteNumeroFactureAvoirVente(String numeroFactureAvoirVente){
        return repository.countByAvoirVenteNumeroFactureAvoirVente(numeroFactureAvoirVente);
    }



    public ReglementAvoirVenteDaoImpl(ReglementAvoirVenteRepository  repository, ReglementAvoirVenteInfraConverter converter){
        super(repository,converter);
    }
}
