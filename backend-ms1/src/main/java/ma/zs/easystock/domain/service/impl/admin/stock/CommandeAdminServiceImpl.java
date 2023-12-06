package ma.zs.easystock.domain.service.impl.admin.stock;


import ma.zs.easystock.domain.model.stock.Commande;
import ma.zs.easystock.infra.dao.criteria.core.stock.CommandeCriteria;
import ma.zs.easystock.domain.dao.stock.CommandeDao;
import ma.zs.easystock.infra.dao.specification.core.stock.CommandeSpecification;
import ma.zs.easystock.domain.service.facade.admin.stock.CommandeAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.easystock.domain.service.facade.admin.commun.ClientAdminService ;
import ma.zs.easystock.domain.model.commun.Client ;
import ma.zs.easystock.domain.service.facade.admin.stock.CommandeItemAdminService ;
import ma.zs.easystock.domain.model.stock.CommandeItem ;
import ma.zs.easystock.domain.service.facade.admin.commun.EtatCommandeAdminService ;
import ma.zs.easystock.domain.model.commun.EtatCommande ;

import java.util.List;
@Service
public class CommandeAdminServiceImpl extends AbstractServiceImpl<Commande, CommandeCriteria, CommandeDao> implements CommandeAdminService {


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Commande save(Commande t) {
    
        super.save(t);
        if (t.getCommandeItems() != null) {
                t.getCommandeItems().forEach(element-> {
                    element.setCommande(t);
                    commandeItemService.save(element);
            });
        }
        return t;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public int deleteById(Long id) {
        int result=0;
        result += commandeItemService.deleteByCommandeId(id);
        result += dao.deleteById(id);
        return result;
    }

    public Commande findByNumeroCommande(String numeroCommande){
        return dao.findByNumeroCommande(numeroCommande);
    }
    public int deleteByNumeroCommande(String numeroCommande){
        return dao.deleteByNumeroCommande(numeroCommande);
    }

    public List<Commande> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }
    public long countByClientCin(String cin){
        return dao.countByClientCin(cin);
    }
    public List<Commande> findByEtatCommandeId(Long id){
        return dao.findByEtatCommandeId(id);
    }
    public int deleteByEtatCommandeId(Long id){
        return dao.deleteByEtatCommandeId(id);
    }
    public long countByEtatCommandeId(Long id){
        return dao.countByEtatCommandeId(id);
    }

    public List<Commande> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(Commande.class);
    }

    @Autowired
    private ClientAdminService clientService ;
    @Autowired
    private CommandeItemAdminService commandeItemService ;
    @Autowired
    private EtatCommandeAdminService etatCommandeService ;

    public CommandeAdminServiceImpl(CommandeDao dao) {
        super(dao);
    }

}
