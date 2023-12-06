package ma.zs.easystock.infra.dao.impl.core.gestionchequeffet;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.gestionchequeffet.BanqueRepository;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.BanqueEntity;
import ma.zs.easystock.infra.converter.gestionchequeffet.BanqueInfraConverter;
import ma.zs.easystock.domain.dao.gestionchequeffet.BanqueDao;
import ma.zs.easystock.domain.model.gestionchequeffet.Banque;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BanqueDaoImpl extends AbstractDaoImpl<BanqueEntity, Banque, BanqueRepository, BanqueInfraConverter> implements BanqueDao  {





    public BanqueDaoImpl(BanqueRepository  repository, BanqueInfraConverter converter){
        super(repository,converter);
    }
}
