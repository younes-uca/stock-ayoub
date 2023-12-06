package ma.zs.easystock.infra.dao.impl.core.commun;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.commun.EtatVenteRepository;
import ma.zs.easystock.infra.bean.core.commun.EtatVenteEntity;
import ma.zs.easystock.infra.converter.commun.EtatVenteInfraConverter;
import ma.zs.easystock.domain.dao.commun.EtatVenteDao;
import ma.zs.easystock.domain.model.commun.EtatVente;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EtatVenteDaoImpl extends AbstractDaoImpl<EtatVenteEntity, EtatVente, EtatVenteRepository, EtatVenteInfraConverter> implements EtatVenteDao  {





    public EtatVenteDaoImpl(EtatVenteRepository  repository, EtatVenteInfraConverter converter){
        super(repository,converter);
    }
}
