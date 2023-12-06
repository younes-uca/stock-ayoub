package ma.zs.easystock.infra.dao.impl.core.gestionchequeffet;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.gestionchequeffet.TypeTransactionRepository;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.TypeTransactionEntity;
import ma.zs.easystock.infra.converter.gestionchequeffet.TypeTransactionInfraConverter;
import ma.zs.easystock.domain.dao.gestionchequeffet.TypeTransactionDao;
import ma.zs.easystock.domain.model.gestionchequeffet.TypeTransaction;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TypeTransactionDaoImpl extends AbstractDaoImpl<TypeTransactionEntity, TypeTransaction, TypeTransactionRepository, TypeTransactionInfraConverter> implements TypeTransactionDao  {





    public TypeTransactionDaoImpl(TypeTransactionRepository  repository, TypeTransactionInfraConverter converter){
        super(repository,converter);
    }
}
