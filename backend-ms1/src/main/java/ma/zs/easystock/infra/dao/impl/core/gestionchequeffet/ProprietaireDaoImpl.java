package ma.zs.easystock.infra.dao.impl.core.gestionchequeffet;

import ma.zs.easystock.zynerator.dao.AbstractDaoImpl;

import ma.zs.easystock.infra.dao.repository.core.gestionchequeffet.ProprietaireRepository;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.ProprietaireEntity;
import ma.zs.easystock.infra.converter.gestionchequeffet.ProprietaireInfraConverter;
import ma.zs.easystock.domain.dao.gestionchequeffet.ProprietaireDao;
import ma.zs.easystock.domain.model.gestionchequeffet.Proprietaire;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ProprietaireDaoImpl extends AbstractDaoImpl<ProprietaireEntity, Proprietaire, ProprietaireRepository, ProprietaireInfraConverter> implements ProprietaireDao  {


    @Override
    public List<Proprietaire> findByPersonneId(Long id){
        List<ProprietaireEntity> list = repository.findByPersonneId(id);
        return converter.toModel(list);
    }
    @Override
    public int deleteByPersonneId(Long id){
        return repository.deleteByPersonneId(id);
    }
    @Override
    public long countByPersonneTelephone(String telephone){
        return repository.countByPersonneTelephone(telephone);
    }



    public ProprietaireDaoImpl(ProprietaireRepository  repository, ProprietaireInfraConverter converter){
        super(repository,converter);
    }
}
