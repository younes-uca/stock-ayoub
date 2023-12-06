package  ma.zs.easystock.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.easystock.ws.converter.commun.VilleConverter;



import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.helper.DateUtil;
import ma.zs.easystock.domain.model.commun.Personne;
import ma.zs.easystock.ws.dto.commun.PersonneDto;

@Component
public class PersonneConverter extends AbstractConverter<Personne, PersonneDto> {

    private VilleConverter villeConverter ;
    private boolean ville;

    public  PersonneConverter(){
        super(Personne.class, PersonneDto.class);
    }

    @Override
    public Personne toItem(PersonneDto dto) {
        if (dto == null) {
            return null;
        } else {
        Personne item = new Personne();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getNom()))
                item.setNom(dto.getNom());
            if(StringUtil.isNotEmpty(dto.getTelephone()))
                item.setTelephone(dto.getTelephone());
            if(StringUtil.isNotEmpty(dto.getAdresse()))
                item.setAdresse(dto.getAdresse());
            if(StringUtil.isNotEmpty(dto.getCreance()))
                item.setCreance(dto.getCreance());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.ville && dto.getVille()!=null &&  dto.getVille().getId() != null)
                item.setVille(villeConverter.toItem(dto.getVille())) ;




        return item;
        }
    }

    @Override
    public PersonneDto toDto(Personne item) {
        if (item == null) {
            return null;
        } else {
            PersonneDto dto = new PersonneDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getNom()))
                dto.setNom(item.getNom());
            if(StringUtil.isNotEmpty(item.getTelephone()))
                dto.setTelephone(item.getTelephone());
            if(StringUtil.isNotEmpty(item.getAdresse()))
                dto.setAdresse(item.getAdresse());
            if(StringUtil.isNotEmpty(item.getCreance()))
                dto.setCreance(item.getCreance());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.ville && item.getVille()!=null) {
            dto.setVille(villeConverter.toDto(item.getVille())) ;
        }


        return dto;
        }
    }


    public boolean  isVille(){
        return this.ville;
    }
    public void  setVille(boolean ville){
        this.ville = ville;
    }
}
