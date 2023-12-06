package ma.zs.easystock.infra.dao.repository.core.gestionchequeffet;

import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.ProprietaireEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProprietaireRepository extends AbstractRepository<ProprietaireEntity,Long>  {

    List<ProprietaireEntity> findByPersonneId(Long id);
    int deleteByPersonneId(Long id);
    long countByPersonneTelephone(String telephone);


}
