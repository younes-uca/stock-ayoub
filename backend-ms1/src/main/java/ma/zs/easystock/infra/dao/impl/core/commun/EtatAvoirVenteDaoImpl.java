package ma.zs.easystock.infra.dao.impl.core.commun;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.commun.EtatAvoirVenteRepository;
import ma.zs.easystock.infra.bean.core.commun.EtatAvoirVenteEntity;
import ma.zs.easystock.infra.converter.commun.EtatAvoirVenteInfraConverter;
import ma.zs.easystock.domain.dao.commun.EtatAvoirVenteDao;
import ma.zs.easystock.domain.model.commun.EtatAvoirVente;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EtatAvoirVenteDaoImpl extends AbstractDaoImpl<EtatAvoirVenteEntity, EtatAvoirVente, EtatAvoirVenteRepository, EtatAvoirVenteInfraConverter> implements EtatAvoirVenteDao  {





    public EtatAvoirVenteDaoImpl(EtatAvoirVenteRepository  repository, EtatAvoirVenteInfraConverter converter){
        super(repository,converter);
    }
}
