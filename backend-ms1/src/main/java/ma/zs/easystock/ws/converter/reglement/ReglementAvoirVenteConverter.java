package  ma.zs.easystock.ws.converter.reglement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.easystock.ws.converter.commun.ModeReglementConverter;
import ma.zs.easystock.ws.converter.stock.AvoirVenteConverter;
import ma.zs.easystock.ws.converter.stock.VenteConverter;

import ma.zs.easystock.domain.model.stock.Vente;
import ma.zs.easystock.domain.model.stock.AvoirVente;


import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.helper.DateUtil;
import ma.zs.easystock.domain.model.reglement.ReglementAvoirVente;
import ma.zs.easystock.ws.dto.reglement.ReglementAvoirVenteDto;

@Component
public class ReglementAvoirVenteConverter extends AbstractConverter<ReglementAvoirVente, ReglementAvoirVenteDto> {

    private ModeReglementConverter modeReglementConverter ;
    private AvoirVenteConverter avoirVenteConverter ;
    private VenteConverter venteConverter ;
    private boolean vente;
    private boolean modeReglement;
    private boolean avoirVente;

    public  ReglementAvoirVenteConverter(){
        super(ReglementAvoirVente.class, ReglementAvoirVenteDto.class);
    }

    @Override
    public ReglementAvoirVente toItem(ReglementAvoirVenteDto dto) {
        if (dto == null) {
            return null;
        } else {
        ReglementAvoirVente item = new ReglementAvoirVente();
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
            if(dto.getVente() != null && dto.getVente().getId() != null){
                item.setVente(new Vente());
                item.getVente().setId(dto.getVente().getId());
                item.getVente().setNumeroFacture(dto.getVente().getNumeroFacture());
            }

            if(this.modeReglement && dto.getModeReglement()!=null &&  dto.getModeReglement().getId() != null)
                item.setModeReglement(modeReglementConverter.toItem(dto.getModeReglement())) ;

            if(dto.getAvoirVente() != null && dto.getAvoirVente().getId() != null){
                item.setAvoirVente(new AvoirVente());
                item.getAvoirVente().setId(dto.getAvoirVente().getId());
                item.getAvoirVente().setNumeroFactureAvoirVente(dto.getAvoirVente().getNumeroFactureAvoirVente());
            }




        return item;
        }
    }

    @Override
    public ReglementAvoirVenteDto toDto(ReglementAvoirVente item) {
        if (item == null) {
            return null;
        } else {
            ReglementAvoirVenteDto dto = new ReglementAvoirVenteDto();
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
        if(this.vente && item.getVente()!=null) {
            dto.setVente(venteConverter.toDto(item.getVente())) ;
        }
        if(this.modeReglement && item.getModeReglement()!=null) {
            dto.setModeReglement(modeReglementConverter.toDto(item.getModeReglement())) ;
        }
        if(this.avoirVente && item.getAvoirVente()!=null) {
            dto.setAvoirVente(avoirVenteConverter.toDto(item.getAvoirVente())) ;
        }


        return dto;
        }
    }


    public boolean  isVente(){
        return this.vente;
    }
    public void  setVente(boolean vente){
        this.vente = vente;
    }
    public boolean  isModeReglement(){
        return this.modeReglement;
    }
    public void  setModeReglement(boolean modeReglement){
        this.modeReglement = modeReglement;
    }
    public boolean  isAvoirVente(){
        return this.avoirVente;
    }
    public void  setAvoirVente(boolean avoirVente){
        this.avoirVente = avoirVente;
    }
}
