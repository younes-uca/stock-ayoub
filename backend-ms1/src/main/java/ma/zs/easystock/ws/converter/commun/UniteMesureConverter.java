package  ma.zs.easystock.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.helper.DateUtil;
import ma.zs.easystock.domain.model.commun.UniteMesure;
import ma.zs.easystock.ws.dto.commun.UniteMesureDto;

@Component
public class UniteMesureConverter extends AbstractConverter<UniteMesure, UniteMesureDto> {


    public  UniteMesureConverter(){
        super(UniteMesure.class, UniteMesureDto.class);
    }

    @Override
    public UniteMesure toItem(UniteMesureDto dto) {
        if (dto == null) {
            return null;
        } else {
        UniteMesure item = new UniteMesure();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }

    @Override
    public UniteMesureDto toDto(UniteMesure item) {
        if (item == null) {
            return null;
        } else {
            UniteMesureDto dto = new UniteMesureDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


}
