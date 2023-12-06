package ma.zs.easystock.infra.dao.impl.core.commun;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.commun.VilleRepository;
import ma.zs.easystock.infra.bean.core.commun.VilleEntity;
import ma.zs.easystock.infra.converter.commun.VilleInfraConverter;
import ma.zs.easystock.domain.dao.commun.VilleDao;
import ma.zs.easystock.domain.model.commun.Ville;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class VilleDaoImpl extends AbstractDaoImpl<VilleEntity, Ville, VilleRepository, VilleInfraConverter> implements VilleDao  {





    public VilleDaoImpl(VilleRepository  repository, VilleInfraConverter converter){
        super(repository,converter);
    }
}
