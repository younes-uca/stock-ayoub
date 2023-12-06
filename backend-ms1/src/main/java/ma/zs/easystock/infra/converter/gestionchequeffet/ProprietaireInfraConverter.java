package  ma.zs.easystock.infra.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;



import ma.zs.easystock.infra.converter.commun.PersonneInfraConverter;



import ma.zs.easystock.infra.bean.core.gestionchequeffet.ProprietaireEntity;
import ma.zs.easystock.domain.model.gestionchequeffet.Proprietaire;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class ProprietaireInfraConverter extends AbstractInfraConverter<ProprietaireEntity, Proprietaire> {

    @Autowired
    private PersonneInfraConverter personneConverter ;
    private boolean personne;

    public  ProprietaireInfraConverter(){
        super(ProprietaireEntity.class, Proprietaire.class);
    }

    @Override
    public Proprietaire toModel(ProprietaireEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Proprietaire model = new Proprietaire();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(this.personne && entity.getPersonne()!=null &&  entity.getPersonne().getId() != null)
                model.setPersonne(personneConverter.toModel(entity.getPersonne())) ;




        return model;
        }
    }

    @Override
    public ProprietaireEntity toEntity(Proprietaire model) {
        if (model == null) {
            return null;
        } else {
            ProprietaireEntity entity = new ProprietaireEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
        if(this.personne && model.getPersonne()!=null) {
            entity.setPersonne(personneConverter.toEntity(model.getPersonne())) ;
        }


        return entity;
        }
    }


    public void initObject(boolean value) {
        this.personne = value;
    }


    public PersonneInfraConverter getPersonneConverter(){
        return this.personneConverter;
    }
    public void setPersonneInfraConverter(PersonneInfraConverter personneConverter ){
        this.personneConverter = personneConverter;
    }
    public boolean  isPersonne(){
        return this.personne;
    }
    public void  setPersonne(boolean personne){
        this.personne = personne;
    }
}
