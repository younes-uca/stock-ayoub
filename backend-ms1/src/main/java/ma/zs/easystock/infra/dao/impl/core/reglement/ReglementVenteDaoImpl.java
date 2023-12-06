package ma.zs.easystock.infra.dao.impl.core.reglement;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.reglement.ReglementVenteRepository;
import ma.zs.easystock.infra.bean.core.reglement.ReglementVenteEntity;
import ma.zs.easystock.infra.converter.reglement.ReglementVenteInfraConverter;
import ma.zs.easystock.domain.dao.reglement.ReglementVenteDao;
import ma.zs.easystock.domain.model.reglement.ReglementVente;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ReglementVenteDaoImpl extends AbstractDaoImpl<ReglementVenteEntity, ReglementVente, ReglementVenteRepository, ReglementVenteInfraConverter> implements ReglementVenteDao  {

    @Override
    public ReglementVente findByReference(String reference){
        ReglementVenteEntity entity = repository.findByReference(reference);
        return converter.toModel(entity);
    }

    @Override
    public int deleteByReference(String reference){
        return repository.deleteByReference(reference);
    }

    @Override
    public List<ReglementVente> findAllOptimized(){
    List<ReglementVenteEntity> list =  repository.findAllOptimized();
        return converter.toModel(list);
    }

    @Override
    public List<ReglementVente> findByVenteId(Long id){
        List<ReglementVenteEntity> list = repository.findByVenteId(id);
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
    public List<ReglementVente> findByModeReglementId(Long id){
        List<ReglementVenteEntity> list = repository.findByModeReglementId(id);
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



    public ReglementVenteDaoImpl(ReglementVenteRepository  repository, ReglementVenteInfraConverter converter){
        super(repository,converter);
    }
}
