package ma.zs.easystock.infra.dao.impl.core.stock;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.stock.AvoirAchatRepository;
import ma.zs.easystock.infra.bean.core.stock.AvoirAchatEntity;
import ma.zs.easystock.infra.converter.stock.AvoirAchatInfraConverter;
import ma.zs.easystock.domain.dao.stock.AvoirAchatDao;
import ma.zs.easystock.domain.model.stock.AvoirAchat;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AvoirAchatDaoImpl extends AbstractDaoImpl<AvoirAchatEntity, AvoirAchat, AvoirAchatRepository, AvoirAchatInfraConverter> implements AvoirAchatDao  {

    @Override
    public AvoirAchat findByNumeroFactureAvoirAchat(String numeroFactureAvoirAchat){
        AvoirAchatEntity entity = repository.findByNumeroFactureAvoirAchat(numeroFactureAvoirAchat);
        return converter.toModel(entity);
    }

    @Override
    public int deleteByNumeroFactureAvoirAchat(String numeroFactureAvoirAchat){
        return repository.deleteByNumeroFactureAvoirAchat(numeroFactureAvoirAchat);
    }

    @Override
    public List<AvoirAchat> findAllOptimized(){
    List<AvoirAchatEntity> list =  repository.findAllOptimized();
        return converter.toModel(list);
    }

    @Override
    public List<AvoirAchat> findByEntrepriseSocieteId(Long id){
        List<AvoirAchatEntity> list = repository.findByEntrepriseSocieteId(id);
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
    public List<AvoirAchat> findByFournisseurId(Long id){
        List<AvoirAchatEntity> list = repository.findByFournisseurId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByFournisseurId(Long id){
        return repository.deleteByFournisseurId(id);
    }
    @Override
    public long countByFournisseurIce(String ice){
        return repository.countByFournisseurIce(ice);
    }
    @Override
    public List<AvoirAchat> findByEtatAvoirAchatId(Long id){
        List<AvoirAchatEntity> list = repository.findByEtatAvoirAchatId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByEtatAvoirAchatId(Long id){
        return repository.deleteByEtatAvoirAchatId(id);
    }
    @Override
    public long countByEtatAvoirAchatId(Long id){
        return repository.countByEtatAvoirAchatId(id);
    }



    public AvoirAchatDaoImpl(AvoirAchatRepository  repository, AvoirAchatInfraConverter converter){
        super(repository,converter);
    }
}
