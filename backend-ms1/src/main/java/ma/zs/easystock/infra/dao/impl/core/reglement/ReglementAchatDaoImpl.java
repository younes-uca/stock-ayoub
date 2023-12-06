package ma.zs.easystock.infra.dao.impl.core.reglement;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.reglement.ReglementAchatRepository;
import ma.zs.easystock.infra.bean.core.reglement.ReglementAchatEntity;
import ma.zs.easystock.infra.converter.reglement.ReglementAchatInfraConverter;
import ma.zs.easystock.domain.dao.reglement.ReglementAchatDao;
import ma.zs.easystock.domain.model.reglement.ReglementAchat;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ReglementAchatDaoImpl extends AbstractDaoImpl<ReglementAchatEntity, ReglementAchat, ReglementAchatRepository, ReglementAchatInfraConverter> implements ReglementAchatDao  {

    @Override
    public ReglementAchat findByReference(String reference){
        ReglementAchatEntity entity = repository.findByReference(reference);
        return converter.toModel(entity);
    }

    @Override
    public int deleteByReference(String reference){
        return repository.deleteByReference(reference);
    }

    @Override
    public List<ReglementAchat> findAllOptimized(){
    List<ReglementAchatEntity> list =  repository.findAllOptimized();
        return converter.toModel(list);
    }

    @Override
    public List<ReglementAchat> findByAchatId(Long id){
        List<ReglementAchatEntity> list = repository.findByAchatId(id);
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
    public List<ReglementAchat> findByModeReglementId(Long id){
        List<ReglementAchatEntity> list = repository.findByModeReglementId(id);
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



    public ReglementAchatDaoImpl(ReglementAchatRepository  repository, ReglementAchatInfraConverter converter){
        super(repository,converter);
    }
}
