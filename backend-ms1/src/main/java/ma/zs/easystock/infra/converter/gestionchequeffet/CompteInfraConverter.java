package  ma.zs.easystock.infra.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;



import ma.zs.easystock.infra.converter.gestionchequeffet.BanqueInfraConverter;
import ma.zs.easystock.infra.converter.gestionchequeffet.ProprietaireInfraConverter;



import ma.zs.easystock.infra.bean.core.gestionchequeffet.CompteEntity;
import ma.zs.easystock.domain.model.gestionchequeffet.Compte;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class CompteInfraConverter extends AbstractInfraConverter<CompteEntity, Compte> {

    @Autowired
    private BanqueInfraConverter banqueConverter ;
    @Autowired
    private ProprietaireInfraConverter proprietaireConverter ;
    private boolean banque;
    private boolean proprietaire;

    public  CompteInfraConverter(){
        super(CompteEntity.class, Compte.class);
    }

    @Override
    public Compte toModel(CompteEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Compte model = new Compte();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getNumeroCompte()))
                model.setNumeroCompte(entity.getNumeroCompte());
            if(StringUtil.isNotEmpty(entity.getSolde()))
                model.setSolde(entity.getSolde());
            if(this.banque && entity.getBanque()!=null &&  entity.getBanque().getId() != null)
                model.setBanque(banqueConverter.toModel(entity.getBanque())) ;

            if(this.proprietaire && entity.getProprietaire()!=null &&  entity.getProprietaire().getId() != null)
                model.setProprietaire(proprietaireConverter.toModel(entity.getProprietaire())) ;




        return model;
        }
    }

    @Override
    public CompteEntity toEntity(Compte model) {
        if (model == null) {
            return null;
        } else {
            CompteEntity entity = new CompteEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getNumeroCompte()))
             entity.setNumeroCompte(model.getNumeroCompte());
            if(StringUtil.isNotEmpty(model.getSolde()))
             entity.setSolde(model.getSolde());
        if(this.banque && model.getBanque()!=null) {
            entity.setBanque(banqueConverter.toEntity(model.getBanque())) ;
        }
        if(this.proprietaire && model.getProprietaire()!=null) {
            entity.setProprietaire(proprietaireConverter.toEntity(model.getProprietaire())) ;
        }


        return entity;
        }
    }


    public void initObject(boolean value) {
        this.banque = value;
        this.proprietaire = value;
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
    public boolean  isBanque(){
        return this.banque;
    }
    public void  setBanque(boolean banque){
        this.banque = banque;
    }
    public boolean  isProprietaire(){
        return this.proprietaire;
    }
    public void  setProprietaire(boolean proprietaire){
        this.proprietaire = proprietaire;
    }
}
