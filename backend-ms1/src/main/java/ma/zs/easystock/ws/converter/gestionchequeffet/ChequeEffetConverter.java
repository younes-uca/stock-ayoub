package  ma.zs.easystock.ws.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.easystock.ws.converter.commun.FournisseurConverter;



import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.helper.DateUtil;
import ma.zs.easystock.domain.model.gestionchequeffet.ChequeEffet;
import ma.zs.easystock.ws.dto.gestionchequeffet.ChequeEffetDto;

@Component
public class ChequeEffetConverter extends AbstractConverter<ChequeEffet, ChequeEffetDto> {

    private FournisseurConverter fournisseurConverter ;
    private boolean beneficiaire;

    public  ChequeEffetConverter(){
        super(ChequeEffet.class, ChequeEffetDto.class);
    }

    @Override
    public ChequeEffet toItem(ChequeEffetDto dto) {
        if (dto == null) {
            return null;
        } else {
        ChequeEffet item = new ChequeEffet();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getNumeroChequeEffet()))
                item.setNumeroChequeEffet(dto.getNumeroChequeEffet());
            if(StringUtil.isNotEmpty(dto.getDateEmission()))
                item.setDateEmission(DateUtil.stringEnToDate(dto.getDateEmission()));
            if(StringUtil.isNotEmpty(dto.getMontant()))
                item.setMontant(dto.getMontant());
            if(this.beneficiaire && dto.getBeneficiaire()!=null &&  dto.getBeneficiaire().getId() != null)
                item.setBeneficiaire(fournisseurConverter.toItem(dto.getBeneficiaire())) ;




        return item;
        }
    }

    @Override
    public ChequeEffetDto toDto(ChequeEffet item) {
        if (item == null) {
            return null;
        } else {
            ChequeEffetDto dto = new ChequeEffetDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getNumeroChequeEffet()))
                dto.setNumeroChequeEffet(item.getNumeroChequeEffet());
            if(item.getDateEmission()!=null)
                dto.setDateEmission(DateUtil.dateTimeToString(item.getDateEmission()));
            if(StringUtil.isNotEmpty(item.getMontant()))
                dto.setMontant(item.getMontant());
        if(this.beneficiaire && item.getBeneficiaire()!=null) {
            dto.setBeneficiaire(fournisseurConverter.toDto(item.getBeneficiaire())) ;
        }


        return dto;
        }
    }


    public boolean  isBeneficiaire(){
        return this.beneficiaire;
    }
    public void  setBeneficiaire(boolean beneficiaire){
        this.beneficiaire = beneficiaire;
    }
}
