package ma.zs.easystock.domain.service.facade.admin.gestionchequeffet;

import java.util.List;
import ma.zs.easystock.domain.model.gestionchequeffet.ChequeEffet;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.ChequeEffetCriteria;
import ma.zs.easystock.zynerator.service.IService;





public interface ChequeEffetAdminService extends  IService<ChequeEffet,ChequeEffetCriteria>  {
    ChequeEffet findByNumeroChequeEffet(String numeroChequeEffet);
    int deleteByNumeroChequeEffet(String numeroChequeEffet);

    List<ChequeEffet> findByBeneficiaireId(Long id);
    int deleteByBeneficiaireId(Long id);
    long countByBeneficiaireIce(String ice);



}
