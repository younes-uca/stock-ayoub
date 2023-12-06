package  ma.zs.easystock.infra.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;



import ma.zs.easystock.infra.converter.commun.VilleInfraConverter;



import ma.zs.easystock.infra.bean.core.commun.PersonneEntity;
import ma.zs.easystock.domain.model.commun.Personne;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class PersonneInfraConverter extends AbstractInfraConverter<PersonneEntity, Personne> {

    @Autowired
    private VilleInfraConverter villeConverter ;
    private boolean ville;

    public  PersonneInfraConverter(){
        super(PersonneEntity.class, Personne.class);
    }

    @Override
    public Personne toModel(PersonneEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Personne model = new Personne();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getNom()))
                model.setNom(entity.getNom());
            if(StringUtil.isNotEmpty(entity.getTelephone()))
                model.setTelephone(entity.getTelephone());
            if(StringUtil.isNotEmpty(entity.getAdresse()))
                model.setAdresse(entity.getAdresse());
            if(StringUtil.isNotEmpty(entity.getCreance()))
                model.setCreance(entity.getCreance());
            if(StringUtil.isNotEmpty(entity.getDescription()))
                model.setDescription(entity.getDescription());
            if(this.ville && entity.getVille()!=null &&  entity.getVille().getId() != null)
                model.setVille(villeConverter.toModel(entity.getVille())) ;




        return model;
        }
    }

    @Override
    public PersonneEntity toEntity(Personne model) {
        if (model == null) {
            return null;
        } else {
            PersonneEntity entity = new PersonneEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getNom()))
             entity.setNom(model.getNom());
            if(StringUtil.isNotEmpty(model.getTelephone()))
             entity.setTelephone(model.getTelephone());
            if(StringUtil.isNotEmpty(model.getAdresse()))
             entity.setAdresse(model.getAdresse());
            if(StringUtil.isNotEmpty(model.getCreance()))
             entity.setCreance(model.getCreance());
            if(StringUtil.isNotEmpty(model.getDescription()))
             entity.setDescription(model.getDescription());
        if(this.ville && model.getVille()!=null) {
            entity.setVille(villeConverter.toEntity(model.getVille())) ;
        }


        return entity;
        }
    }


    public void initObject(boolean value) {
        this.ville = value;
    }


    public VilleInfraConverter getVilleConverter(){
        return this.villeConverter;
    }
    public void setVilleInfraConverter(VilleInfraConverter villeConverter ){
        this.villeConverter = villeConverter;
    }
    public boolean  isVille(){
        return this.ville;
    }
    public void  setVille(boolean ville){
        this.ville = ville;
    }
}
