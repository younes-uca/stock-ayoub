package ma.zs.easystock.domain.service.impl.admin.gestionchequeffet;


import ma.zs.easystock.domain.model.gestionchequeffet.PossedeCompte;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.PossedeCompteCriteria;
import ma.zs.easystock.domain.dao.gestionchequeffet.PossedeCompteDao;
import ma.zs.easystock.infra.dao.specification.core.gestionchequeffet.PossedeCompteSpecification;
import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.PossedeCompteAdminService;
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
import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.CompteAdminService ;
import ma.zs.easystock.domain.model.gestionchequeffet.Compte ;

import java.util.List;
@Service
public class PossedeCompteAdminServiceImpl extends AbstractServiceImpl<PossedeCompte, PossedeCompteCriteria, PossedeCompteDao> implements PossedeCompteAdminService {






    public List<PossedeCompte> findByProprietaireId(Long id){
        return dao.findByProprietaireId(id);
    }
    public int deleteByProprietaireId(Long id){
        return dao.deleteByProprietaireId(id);
    }
    public long countByProprietaireId(Long id){
        return dao.countByProprietaireId(id);
    }
    public List<PossedeCompte> findByBanqueId(Long id){
        return dao.findByBanqueId(id);
    }
    public int deleteByBanqueId(Long id){
        return dao.deleteByBanqueId(id);
    }
    public long countByBanqueId(Long id){
        return dao.countByBanqueId(id);
    }
    public List<PossedeCompte> findByCompteId(Long id){
        return dao.findByCompteId(id);
    }
    public int deleteByCompteId(Long id){
        return dao.deleteByCompteId(id);
    }
    public long countByCompteId(Long id){
        return dao.countByCompteId(id);
    }





    public void configure() {
        super.configure(PossedeCompte.class);
    }

    @Autowired
    private BanqueAdminService banqueService ;
    @Autowired
    private ProprietaireAdminService proprietaireService ;
    @Autowired
    private CompteAdminService compteService ;

    public PossedeCompteAdminServiceImpl(PossedeCompteDao dao) {
        super(dao);
    }

}
