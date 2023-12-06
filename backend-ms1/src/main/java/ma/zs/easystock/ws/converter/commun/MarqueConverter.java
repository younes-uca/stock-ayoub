package  ma.zs.easystock.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.helper.DateUtil;
import ma.zs.easystock.domain.model.commun.Marque;
import ma.zs.easystock.ws.dto.commun.MarqueDto;

@Component
public class MarqueConverter extends AbstractConverter<Marque, MarqueDto> {


    public  MarqueConverter(){
        super(Marque.class, MarqueDto.class);
    }

    @Override
    public Marque toItem(MarqueDto dto) {
        if (dto == null) {
            return null;
        } else {
        Marque item = new Marque();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }

    @Override
    public MarqueDto toDto(Marque item) {
        if (item == null) {
            return null;
        } else {
            MarqueDto dto = new MarqueDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


}
