package ma.zs.easystock.infra.dao.repository.core.gestionchequeffet;

import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.PossedeCompteEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PossedeCompteRepository extends AbstractRepository<PossedeCompteEntity,Long>  {

    List<PossedeCompteEntity> findByProprietaireId(Long id);
    int deleteByProprietaireId(Long id);
    long countByProprietaireId(Long id);
    List<PossedeCompteEntity> findByBanqueId(Long id);
    int deleteByBanqueId(Long id);
    long countByBanqueId(Long id);
    List<PossedeCompteEntity> findByCompteId(Long id);
    int deleteByCompteId(Long id);
    long countByCompteId(Long id);


}
