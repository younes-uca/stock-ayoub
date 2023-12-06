package ma.zs.easystock.infra.dao.repository.core.gestionchequeffet;

import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.ProprietaireBanqueEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProprietaireBanqueRepository extends AbstractRepository<ProprietaireBanqueEntity,Long>  {

    List<ProprietaireBanqueEntity> findByProprietaireId(Long id);
    int deleteByProprietaireId(Long id);
    long countByProprietaireId(Long id);
    List<ProprietaireBanqueEntity> findByBanqueId(Long id);
    int deleteByBanqueId(Long id);
    long countByBanqueId(Long id);
    List<ProprietaireBanqueEntity> findByCompteId(Long id);
    int deleteByCompteId(Long id);
    long countByCompteId(Long id);


}
