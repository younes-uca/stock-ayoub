package ma.zs.easystock.domain.dao.gestionchequeffet;

import ma.zs.easystock.domain.model.gestionchequeffet.ChequeEffet;

import ma.zs.easystock.domain.model.gestionchequeffet.ChequeEffet;

import java.util.List;
import ma.zs.easystock.zynerator.dao.IDao;


public interface ChequeEffetDao extends IDao<ChequeEffet> {

    ChequeEffet findByNumeroChequeEffet(String numeroChequeEffet);
    int deleteByNumeroChequeEffet(String numeroChequeEffet);

    List<ChequeEffet> findByBeneficiaireId(Long id);
    int deleteByBeneficiaireId(Long id);
    long countByBeneficiaireIce(String ice);

    List<ChequeEffet> findAllOptimized();


}
