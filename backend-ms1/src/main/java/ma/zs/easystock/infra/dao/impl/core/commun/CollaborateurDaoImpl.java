package ma.zs.easystock.infra.dao.impl.core.commun;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.commun.CollaborateurRepository;
import ma.zs.easystock.infra.bean.core.commun.CollaborateurEntity;
import ma.zs.easystock.infra.converter.commun.CollaborateurInfraConverter;
import ma.zs.easystock.domain.dao.commun.CollaborateurDao;
import ma.zs.easystock.domain.model.commun.Collaborateur;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CollaborateurDaoImpl extends AbstractDaoImpl<CollaborateurEntity, Collaborateur, CollaborateurRepository, CollaborateurInfraConverter> implements CollaborateurDao  {





    public CollaborateurDaoImpl(CollaborateurRepository  repository, CollaborateurInfraConverter converter){
        super(repository,converter);
    }
}
