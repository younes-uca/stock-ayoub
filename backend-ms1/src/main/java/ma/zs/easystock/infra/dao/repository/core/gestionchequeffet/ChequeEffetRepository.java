package ma.zs.easystock.infra.dao.repository.core.gestionchequeffet;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.infra.bean.core.gestionchequeffet.ChequeEffetEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ChequeEffetRepository extends AbstractRepository<ChequeEffetEntity,Long>  {
    ChequeEffetEntity findByNumeroChequeEffet(String numeroChequeEffet);
    int deleteByNumeroChequeEffet(String numeroChequeEffet);

    List<ChequeEffetEntity> findByBeneficiaireId(Long id);
    int deleteByBeneficiaireId(Long id);
    long countByBeneficiaireIce(String ice);

    @Query("SELECT NEW ChequeEffetEntity(item.id,item.numeroChequeEffet) FROM ChequeEffetEntity item")
    List<ChequeEffetEntity> findAllOptimized();

}
