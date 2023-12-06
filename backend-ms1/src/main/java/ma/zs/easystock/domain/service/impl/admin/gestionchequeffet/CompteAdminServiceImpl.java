package ma.zs.easystock.domain.service.impl.admin.gestionchequeffet;


import ma.zs.easystock.domain.model.gestionchequeffet.Compte;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.CompteCriteria;
import ma.zs.easystock.domain.dao.gestionchequeffet.CompteDao;
import ma.zs.easystock.infra.dao.specification.core.gestionchequeffet.CompteSpecification;
import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.CompteAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.BanqueAdminService ;
import ma.zs.easystock.domain.model.gestionchequeffet.Banque ;
import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.ProprietaireAdminService ;
import ma.zs.easystock.domain.model.gestionchequeffet.Proprietaire ;

import java.util.List;
@Service
public class CompteAdminServiceImpl extends AbstractServiceImpl<Compte, CompteCriteria, CompteDao> implements CompteAdminService {






    public List<Compte> findByBanqueId(Long id){
        return dao.findByBanqueId(id);
    }
    public int deleteByBanqueId(Long id){
        return dao.deleteByBanqueId(id);
    }
    public long countByBanqueId(Long id){
        return dao.countByBanqueId(id);
    }
    public List<Compte> findByProprietaireId(Long id){
        return dao.findByProprietaireId(id);
    }
    public int deleteByProprietaireId(Long id){
        return dao.deleteByProprietaireId(id);
    }
    public long countByProprietaireId(Long id){
        return dao.countByProprietaireId(id);
    }

    public List<Compte> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(Compte.class);
    }

    @Autowired
    private BanqueAdminService banqueService ;
    @Autowired
    private ProprietaireAdminService proprietaireService ;

    public CompteAdminServiceImpl(CompteDao dao) {
        super(dao);
    }

}
