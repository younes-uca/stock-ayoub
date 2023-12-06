package ma.zs.easystock.infra.dao.impl.core.commun;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.commun.EtatAvoirAchatRepository;
import ma.zs.easystock.infra.bean.core.commun.EtatAvoirAchatEntity;
import ma.zs.easystock.infra.converter.commun.EtatAvoirAchatInfraConverter;
import ma.zs.easystock.domain.dao.commun.EtatAvoirAchatDao;
import ma.zs.easystock.domain.model.commun.EtatAvoirAchat;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EtatAvoirAchatDaoImpl extends AbstractDaoImpl<EtatAvoirAchatEntity, EtatAvoirAchat, EtatAvoirAchatRepository, EtatAvoirAchatInfraConverter> implements EtatAvoirAchatDao  {





    public EtatAvoirAchatDaoImpl(EtatAvoirAchatRepository  repository, EtatAvoirAchatInfraConverter converter){
        super(repository,converter);
    }
}
