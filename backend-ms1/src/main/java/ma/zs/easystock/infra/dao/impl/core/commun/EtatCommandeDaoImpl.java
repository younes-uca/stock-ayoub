package ma.zs.easystock.infra.dao.impl.core.commun;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.commun.EtatCommandeRepository;
import ma.zs.easystock.infra.bean.core.commun.EtatCommandeEntity;
import ma.zs.easystock.infra.converter.commun.EtatCommandeInfraConverter;
import ma.zs.easystock.domain.dao.commun.EtatCommandeDao;
import ma.zs.easystock.domain.model.commun.EtatCommande;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EtatCommandeDaoImpl extends AbstractDaoImpl<EtatCommandeEntity, EtatCommande, EtatCommandeRepository, EtatCommandeInfraConverter> implements EtatCommandeDao  {





    public EtatCommandeDaoImpl(EtatCommandeRepository  repository, EtatCommandeInfraConverter converter){
        super(repository,converter);
    }
}
