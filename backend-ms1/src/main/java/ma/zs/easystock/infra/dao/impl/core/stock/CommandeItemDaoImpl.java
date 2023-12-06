package ma.zs.easystock.infra.dao.impl.core.stock;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.stock.CommandeItemRepository;
import ma.zs.easystock.infra.bean.core.stock.CommandeItemEntity;
import ma.zs.easystock.infra.converter.stock.CommandeItemInfraConverter;
import ma.zs.easystock.domain.dao.stock.CommandeItemDao;
import ma.zs.easystock.domain.model.stock.CommandeItem;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CommandeItemDaoImpl extends AbstractDaoImpl<CommandeItemEntity, CommandeItem, CommandeItemRepository, CommandeItemInfraConverter> implements CommandeItemDao  {


    @Override
    public List<CommandeItem> findByProduitId(Long id){
        List<CommandeItemEntity> list = repository.findByProduitId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByProduitId(Long id){
        return repository.deleteByProduitId(id);
    }
    @Override
    public long countByProduitBarCode(String barCode){
        return repository.countByProduitBarCode(barCode);
    }
    @Override
    public List<CommandeItem> findByTaxeId(Long id){
        List<CommandeItemEntity> list = repository.findByTaxeId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByTaxeId(Long id){
        return repository.deleteByTaxeId(id);
    }
    @Override
    public long countByTaxeId(Long id){
        return repository.countByTaxeId(id);
    }
    @Override
    public List<CommandeItem> findByCommandeId(Long id){
        List<CommandeItemEntity> list = repository.findByCommandeId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByCommandeId(Long id){
        return repository.deleteByCommandeId(id);
    }
    @Override
    public long countByCommandeNumeroCommande(String numeroCommande){
        return repository.countByCommandeNumeroCommande(numeroCommande);
    }



    public CommandeItemDaoImpl(CommandeItemRepository  repository, CommandeItemInfraConverter converter){
        super(repository,converter);
    }
}
