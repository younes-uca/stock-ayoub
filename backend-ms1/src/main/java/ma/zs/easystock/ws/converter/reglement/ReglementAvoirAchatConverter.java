package  ma.zs.easystock.ws.converter.reglement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.easystock.ws.converter.stock.AchatConverter;
import ma.zs.easystock.ws.converter.commun.ModeReglementConverter;
import ma.zs.easystock.ws.converter.stock.AvoirAchatConverter;

import ma.zs.easystock.domain.model.stock.Achat;
import ma.zs.easystock.domain.model.stock.AvoirAchat;


import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.helper.DateUtil;
import ma.zs.easystock.domain.model.reglement.ReglementAvoirAchat;
import ma.zs.easystock.ws.dto.reglement.ReglementAvoirAchatDto;

@Component
public class ReglementAvoirAchatConverter extends AbstractConverter<ReglementAvoirAchat, ReglementAvoirAchatDto> {

    private AchatConverter achatConverter ;
    private ModeReglementConverter modeReglementConverter ;
    private AvoirAchatConverter avoirAchatConverter ;
    private boolean achat;
    private boolean modeReglement;
    private boolean avoirAchat;

    public  ReglementAvoirAchatConverter(){
        super(ReglementAvoirAchat.class, ReglementAvoirAchatDto.class);
    }

    @Override
    public ReglementAvoirAchat toItem(ReglementAvoirAchatDto dto) {
        if (dto == null) {
            return null;
        } else {
        ReglementAvoirAchat item = new ReglementAvoirAchat();
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

            if(dto.getAvoirAchat() != null && dto.getAvoirAchat().getId() != null){
                item.setAvoirAchat(new AvoirAchat());
                item.getAvoirAchat().setId(dto.getAvoirAchat().getId());
                item.getAvoirAchat().setNumeroFactureAvoirAchat(dto.getAvoirAchat().getNumeroFactureAvoirAchat());
            }




        return item;
        }
    }

    @Override
    public ReglementAvoirAchatDto toDto(ReglementAvoirAchat item) {
        if (item == null) {
            return null;
        } else {
            ReglementAvoirAchatDto dto = new ReglementAvoirAchatDto();
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
        if(this.avoirAchat && item.getAvoirAchat()!=null) {
            dto.setAvoirAchat(avoirAchatConverter.toDto(item.getAvoirAchat())) ;
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
    public boolean  isAvoirAchat(){
        return this.avoirAchat;
    }
    public void  setAvoirAchat(boolean avoirAchat){
        this.avoirAchat = avoirAchat;
    }
}
