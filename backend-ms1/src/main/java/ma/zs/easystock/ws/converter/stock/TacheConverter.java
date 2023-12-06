package  ma.zs.easystock.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.easystock.ws.converter.commun.CollaborateurConverter;



import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.helper.DateUtil;
import ma.zs.easystock.domain.model.stock.Tache;
import ma.zs.easystock.ws.dto.stock.TacheDto;

@Component
public class TacheConverter extends AbstractConverter<Tache, TacheDto> {

    private CollaborateurConverter collaborateurConverter ;
    private boolean lierA;

    public  TacheConverter(){
        super(Tache.class, TacheDto.class);
    }

    @Override
    public Tache toItem(TacheDto dto) {
        if (dto == null) {
            return null;
        } else {
        Tache item = new Tache();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateDebut()))
                item.setDateDebut(DateUtil.stringEnToDate(dto.getDateDebut()));
            if(StringUtil.isNotEmpty(dto.getDateFin()))
                item.setDateFin(DateUtil.stringEnToDate(dto.getDateFin()));
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.lierA && dto.getLierA()!=null &&  dto.getLierA().getId() != null)
                item.setLierA(collaborateurConverter.toItem(dto.getLierA())) ;




        return item;
        }
    }

    @Override
    public TacheDto toDto(Tache item) {
        if (item == null) {
            return null;
        } else {
            TacheDto dto = new TacheDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateDebut()!=null)
                dto.setDateDebut(DateUtil.dateTimeToString(item.getDateDebut()));
            if(item.getDateFin()!=null)
                dto.setDateFin(DateUtil.dateTimeToString(item.getDateFin()));
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.lierA && item.getLierA()!=null) {
            dto.setLierA(collaborateurConverter.toDto(item.getLierA())) ;
        }


        return dto;
        }
    }


    public boolean  isLierA(){
        return this.lierA;
    }
    public void  setLierA(boolean lierA){
        this.lierA = lierA;
    }
}
