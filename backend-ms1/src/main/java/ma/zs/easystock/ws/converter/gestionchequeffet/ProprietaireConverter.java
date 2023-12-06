package  ma.zs.easystock.ws.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.easystock.ws.converter.commun.PersonneConverter;



import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.helper.DateUtil;
import ma.zs.easystock.domain.model.gestionchequeffet.Proprietaire;
import ma.zs.easystock.ws.dto.gestionchequeffet.ProprietaireDto;

@Component
public class ProprietaireConverter extends AbstractConverter<Proprietaire, ProprietaireDto> {

    private PersonneConverter personneConverter ;
    private boolean personne;

    public  ProprietaireConverter(){
        super(Proprietaire.class, ProprietaireDto.class);
    }

    @Override
    public Proprietaire toItem(ProprietaireDto dto) {
        if (dto == null) {
            return null;
        } else {
        Proprietaire item = new Proprietaire();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(this.personne && dto.getPersonne()!=null &&  dto.getPersonne().getId() != null)
                item.setPersonne(personneConverter.toItem(dto.getPersonne())) ;




        return item;
        }
    }

    @Override
    public ProprietaireDto toDto(Proprietaire item) {
        if (item == null) {
            return null;
        } else {
            ProprietaireDto dto = new ProprietaireDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
        if(this.personne && item.getPersonne()!=null) {
            dto.setPersonne(personneConverter.toDto(item.getPersonne())) ;
        }


        return dto;
        }
    }


    public boolean  isPersonne(){
        return this.personne;
    }
    public void  setPersonne(boolean personne){
        this.personne = personne;
    }
}
