package ma.zs.easystock.infra.dao.impl.core.reglement;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.reglement.ReglementAvoirAchatRepository;
import ma.zs.easystock.infra.bean.core.reglement.ReglementAvoirAchatEntity;
import ma.zs.easystock.infra.converter.reglement.ReglementAvoirAchatInfraConverter;
import ma.zs.easystock.domain.dao.reglement.ReglementAvoirAchatDao;
import ma.zs.easystock.domain.model.reglement.ReglementAvoirAchat;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ReglementAvoirAchatDaoImpl extends AbstractDaoImpl<ReglementAvoirAchatEntity, ReglementAvoirAchat, ReglementAvoirAchatRepository, ReglementAvoirAchatInfraConverter> implements ReglementAvoirAchatDao  {

    @Override
    public ReglementAvoirAchat findByReference(String reference){
        ReglementAvoirAchatEntity entity = repository.findByReference(reference);
        return converter.toModel(entity);
    }

    @Override
    public int deleteByReference(String reference){
        return repository.deleteByReference(reference);
    }

    @Override
    public List<ReglementAvoirAchat> findAllOptimized(){
    List<ReglementAvoirAchatEntity> list =  repository.findAllOptimized();
        return converter.toModel(list);
    }

    @Override
    public List<ReglementAvoirAchat> findByAchatId(Long id){
        List<ReglementAvoirAchatEntity> list = repository.findByAchatId(id);
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
    @Override
    public List<ReglementAvoirAchat> findByModeReglementId(Long id){
        List<ReglementAvoirAchatEntity> list = repository.findByModeReglementId(id);
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
    public List<ReglementAvoirAchat> findByAvoirAchatId(Long id){
        List<ReglementAvoirAchatEntity> list = repository.findByAvoirAchatId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByAvoirAchatId(Long id){
        return repository.deleteByAvoirAchatId(id);
    }
    @Override
    public long countByAvoirAchatNumeroFactureAvoirAchat(String numeroFactureAvoirAchat){
        return repository.countByAvoirAchatNumeroFactureAvoirAchat(numeroFactureAvoirAchat);
    }



    public ReglementAvoirAchatDaoImpl(ReglementAvoirAchatRepository  repository, ReglementAvoirAchatInfraConverter converter){
        super(repository,converter);
    }
}
