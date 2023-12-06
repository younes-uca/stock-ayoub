package ma.zs.easystock.infra.dao.impl.core.commun;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.commun.EtatAchatRepository;
import ma.zs.easystock.infra.bean.core.commun.EtatAchatEntity;
import ma.zs.easystock.infra.converter.commun.EtatAchatInfraConverter;
import ma.zs.easystock.domain.dao.commun.EtatAchatDao;
import ma.zs.easystock.domain.model.commun.EtatAchat;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EtatAchatDaoImpl extends AbstractDaoImpl<EtatAchatEntity, EtatAchat, EtatAchatRepository, EtatAchatInfraConverter> implements EtatAchatDao  {





    public EtatAchatDaoImpl(EtatAchatRepository  repository, EtatAchatInfraConverter converter){
        super(repository,converter);
    }
}
