package ma.zs.easystock.infra.dao.impl.core.commun;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.commun.ModeReglementRepository;
import ma.zs.easystock.infra.bean.core.commun.ModeReglementEntity;
import ma.zs.easystock.infra.converter.commun.ModeReglementInfraConverter;
import ma.zs.easystock.domain.dao.commun.ModeReglementDao;
import ma.zs.easystock.domain.model.commun.ModeReglement;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ModeReglementDaoImpl extends AbstractDaoImpl<ModeReglementEntity, ModeReglement, ModeReglementRepository, ModeReglementInfraConverter> implements ModeReglementDao  {





    public ModeReglementDaoImpl(ModeReglementRepository  repository, ModeReglementInfraConverter converter){
        super(repository,converter);
    }
}
