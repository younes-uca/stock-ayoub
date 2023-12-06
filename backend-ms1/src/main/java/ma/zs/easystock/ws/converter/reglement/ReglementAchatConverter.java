package  ma.zs.easystock.ws.converter.reglement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.easystock.ws.converter.stock.AchatConverter;
import ma.zs.easystock.ws.converter.commun.ModeReglementConverter;

import ma.zs.easystock.domain.model.stock.Achat;


import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.helper.DateUtil;
import ma.zs.easystock.domain.model.reglement.ReglementAchat;
import ma.zs.easystock.ws.dto.reglement.ReglementAchatDto;

@Component
public class ReglementAchatConverter extends AbstractConverter<ReglementAchat, ReglementAchatDto> {

    private AchatConverter achatConverter ;
    private ModeReglementConverter modeReglementConverter ;
    private boolean achat;
    private boolean modeReglement;

    public  ReglementAchatConverter(){
        super(ReglementAchat.class, ReglementAchatDto.class);
    }

    @Override
    public ReglementAchat toItem(ReglementAchatDto dto) {
        if (dto == null) {
            return null;
        } else {
        ReglementAchat item = new ReglementAchat();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDateReglement()))
                item.setDateReglement(DateUtil.stringEnToDate(dto.getDateReglement()));
            if(StringUtil.isNotEmpty(dto.getMontant()))
                item.setMontant(dto.getMontant());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(dto.getAchat() != null && dto.getAchat().getId() != null){
                item.setAchat(new Achat());
                item.getAchat().setId(dto.getAchat().getId());
                item.getAchat().setId(dto.getAchat().getId());
            }

            if(this.modeReglement && dto.getModeReglement()!=null &&  dto.getModeReglement().getId() != null)
                item.setModeReglement(modeReglementConverter.toItem(dto.getModeReglement())) ;




        return item;
        }
    }

    @Override
    public ReglementAchatDto toDto(ReglementAchat item) {
        if (item == null) {
            return null;
        } else {
            ReglementAchatDto dto = new ReglementAchatDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDateReglement()!=null)
                dto.setDateReglement(DateUtil.dateTimeToString(item.getDateReglement()));
            if(StringUtil.isNotEmpty(item.getMontant()))
                dto.setMontant(item.getMontant());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.achat && item.getAchat()!=null) {
            dto.setAchat(achatConverter.toDto(item.getAchat())) ;
        }
        if(this.modeReglement && item.getModeReglement()!=null) {
            dto.setModeReglement(modeReglementConverter.toDto(item.getModeReglement())) ;
        }


        return dto;
        }
    }


    public boolean  isAchat(){
        return this.achat;
    }
    public void  setAchat(boolean achat){
        this.achat = achat;
    }
    public boolean  isModeReglement(){
        return this.modeReglement;
    }
    public void  setModeReglement(boolean modeReglement){
        this.modeReglement = modeReglement;
    }
}
