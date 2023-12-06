package  ma.zs.easystock.infra.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;



import ma.zs.easystock.infra.converter.gestionchequeffet.BanqueInfraConverter;
import ma.zs.easystock.infra.converter.gestionchequeffet.ProprietaireInfraConverter;
import ma.zs.easystock.infra.converter.gestionchequeffet.CompteInfraConverter;



import ma.zs.easystock.infra.bean.core.gestionchequeffet.ProprietaireBanqueEntity;
import ma.zs.easystock.domain.model.gestionchequeffet.ProprietaireBanque;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class ProprietaireBanqueInfraConverter extends AbstractInfraConverter<ProprietaireBanqueEntity, ProprietaireBanque> {

    @Autowired
    private BanqueInfraConverter banqueConverter ;
    @Autowired
    private ProprietaireInfraConverter proprietaireConverter ;
    @Autowired
    private CompteInfraConverter compteConverter ;
    private boolean proprietaire;
    private boolean banque;
    private boolean compte;

    public  ProprietaireBanqueInfraConverter(){
        super(ProprietaireBanqueEntity.class, ProprietaireBanque.class);
    }

    @Override
    public ProprietaireBanque toModel(ProprietaireBanqueEntity entity) {
        if (entity == null) {
            return null;
        } else {
        ProprietaireBanque model = new ProprietaireBanque();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(this.proprietaire && entity.getProprietaire()!=null &&  entity.getProprietaire().getId() != null)
                model.setProprietaire(proprietaireConverter.toModel(entity.getProprietaire())) ;

            if(this.banque && entity.getBanque()!=null &&  entity.getBanque().getId() != null)
                model.setBanque(banqueConverter.toModel(entity.getBanque())) ;

            if(this.compte && entity.getCompte()!=null &&  entity.getCompte().getId() != null)
                model.setCompte(compteConverter.toModel(entity.getCompte())) ;




        return model;
        }
    }

    @Override
    public ProprietaireBanqueEntity toEntity(ProprietaireBanque model) {
        if (model == null) {
            return null;
        } else {
            ProprietaireBanqueEntity entity = new ProprietaireBanqueEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
        if(this.proprietaire && model.getProprietaire()!=null) {
            entity.setProprietaire(proprietaireConverter.toEntity(model.getProprietaire())) ;
        }
        if(this.banque && model.getBanque()!=null) {
            entity.setBanque(banqueConverter.toEntity(model.getBanque())) ;
        }
        if(this.compte && model.getCompte()!=null) {
            entity.setCompte(compteConverter.toEntity(model.getCompte())) ;
        }


        return entity;
        }
    }


    public void initObject(boolean value) {
        this.proprietaire = value;
        this.banque = value;
        this.compte = value;
    }


    public BanqueInfraConverter getBanqueConverter(){
        return this.banqueConverter;
    }
    public void setBanqueInfraConverter(BanqueInfraConverter banqueConverter ){
        this.banqueConverter = banqueConverter;
    }
    public ProprietaireInfraConverter getProprietaireConverter(){
        return this.proprietaireConverter;
    }
    public void setProprietaireInfraConverter(ProprietaireInfraConverter proprietaireConverter ){
        this.proprietaireConverter = proprietaireConverter;
    }
    public CompteInfraConverter getCompteConverter(){
        return this.compteConverter;
    }
    public void setCompteInfraConverter(CompteInfraConverter compteConverter ){
        this.compteConverter = compteConverter;
    }
    public boolean  isProprietaire(){
        return this.proprietaire;
    }
    public void  setProprietaire(boolean proprietaire){
        this.proprietaire = proprietaire;
    }
    public boolean  isBanque(){
        return this.banque;
    }
    public void  setBanque(boolean banque){
        this.banque = banque;
    }
    public boolean  isCompte(){
        return this.compte;
    }
    public void  setCompte(boolean compte){
        this.compte = compte;
    }
}
