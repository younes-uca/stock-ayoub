package ma.zs.easystock.domain.service.impl.admin.gestionchequeffet;


import ma.zs.easystock.domain.model.gestionchequeffet.ChequeEffet;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.ChequeEffetCriteria;
import ma.zs.easystock.domain.dao.gestionchequeffet.ChequeEffetDao;
import ma.zs.easystock.infra.dao.specification.core.gestionchequeffet.ChequeEffetSpecification;
import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.ChequeEffetAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.domain.service.facade.admin.commun.FournisseurAdminService ;
import ma.zs.easystock.domain.model.commun.Fournisseur ;

import java.util.List;
@Service
public class ChequeEffetAdminServiceImpl extends AbstractServiceImpl<ChequeEffet, ChequeEffetCriteria, ChequeEffetDao> implements ChequeEffetAdminService {





    public ChequeEffet findByNumeroChequeEffet(String numeroChequeEffet){
        return dao.findByNumeroChequeEffet(numeroChequeEffet);
    }
    public int deleteByNumeroChequeEffet(String numeroChequeEffet){
        return dao.deleteByNumeroChequeEffet(numeroChequeEffet);
    }

    public List<ChequeEffet> findByBeneficiaireId(Long id){
        return dao.findByBeneficiaireId(id);
    }
    public int deleteByBeneficiaireId(Long id){
        return dao.deleteByBeneficiaireId(id);
    }
    public long countByBeneficiaireIce(String ice){
        return dao.countByBeneficiaireIce(ice);
    }

    public List<ChequeEffet> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(ChequeEffet.class);
    }

    @Autowired
    private FournisseurAdminService fournisseurService ;

    public ChequeEffetAdminServiceImpl(ChequeEffetDao dao) {
        super(dao);
    }

}
