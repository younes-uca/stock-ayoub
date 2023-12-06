package ma.zs.easystock.infra.dao.impl.core.stock;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.stock.CommandeRepository;
import ma.zs.easystock.infra.bean.core.stock.CommandeEntity;
import ma.zs.easystock.infra.converter.stock.CommandeInfraConverter;
import ma.zs.easystock.domain.dao.stock.CommandeDao;
import ma.zs.easystock.domain.model.stock.Commande;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CommandeDaoImpl extends AbstractDaoImpl<CommandeEntity, Commande, CommandeRepository, CommandeInfraConverter> implements CommandeDao  {

    @Override
    public Commande findByNumeroCommande(String numeroCommande){
        CommandeEntity entity = repository.findByNumeroCommande(numeroCommande);
        return converter.toModel(entity);
    }

    @Override
    public int deleteByNumeroCommande(String numeroCommande){
        return repository.deleteByNumeroCommande(numeroCommande);
    }

    @Override
    public List<Commande> findAllOptimized(){
    List<CommandeEntity> list =  repository.findAllOptimized();
        return converter.toModel(list);
    }

    @Override
    public List<Commande> findByClientId(Long id){
        List<CommandeEntity> list = repository.findByClientId(id);
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
    public List<Commande> findByEtatCommandeId(Long id){
        List<CommandeEntity> list = repository.findByEtatCommandeId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByEtatCommandeId(Long id){
        return repository.deleteByEtatCommandeId(id);
    }
    @Override
    public long countByEtatCommandeId(Long id){
        return repository.countByEtatCommandeId(id);
    }



    public CommandeDaoImpl(CommandeRepository  repository, CommandeInfraConverter converter){
        super(repository,converter);
    }
}
