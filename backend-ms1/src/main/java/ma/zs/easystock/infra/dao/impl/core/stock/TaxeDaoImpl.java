package ma.zs.easystock.infra.dao.impl.core.stock;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.stock.TaxeRepository;
import ma.zs.easystock.infra.bean.core.stock.TaxeEntity;
import ma.zs.easystock.infra.converter.stock.TaxeInfraConverter;
import ma.zs.easystock.domain.dao.stock.TaxeDao;
import ma.zs.easystock.domain.model.stock.Taxe;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TaxeDaoImpl extends AbstractDaoImpl<TaxeEntity, Taxe, TaxeRepository, TaxeInfraConverter> implements TaxeDao  {





    public TaxeDaoImpl(TaxeRepository  repository, TaxeInfraConverter converter){
        super(repository,converter);
    }
}
