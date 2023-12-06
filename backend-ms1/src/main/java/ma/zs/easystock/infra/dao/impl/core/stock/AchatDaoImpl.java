package ma.zs.easystock.infra.dao.impl.core.stock;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.stock.AchatRepository;
import ma.zs.easystock.infra.bean.core.stock.AchatEntity;
import ma.zs.easystock.infra.converter.stock.AchatInfraConverter;
import ma.zs.easystock.domain.dao.stock.AchatDao;
import ma.zs.easystock.domain.model.stock.Achat;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AchatDaoImpl extends AbstractDaoImpl<AchatEntity, Achat, AchatRepository, AchatInfraConverter> implements AchatDao  {


    @Override
    public List<Achat> findByEntrepriseSocieteId(Long id){
        List<AchatEntity> list = repository.findByEntrepriseSocieteId(id);
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
    public List<Achat> findByFournisseurId(Long id){
        List<AchatEntity> list = repository.findByFournisseurId(id);
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
    public List<Achat> findByEtatAchatId(Long id){
        List<AchatEntity> list = repository.findByEtatAchatId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByEtatAchatId(Long id){
        return repository.deleteByEtatAchatId(id);
    }
    @Override
    public long countByEtatAchatId(Long id){
        return repository.countByEtatAchatId(id);
    }



    public AchatDaoImpl(AchatRepository  repository, AchatInfraConverter converter){
        super(repository,converter);
    }
}
