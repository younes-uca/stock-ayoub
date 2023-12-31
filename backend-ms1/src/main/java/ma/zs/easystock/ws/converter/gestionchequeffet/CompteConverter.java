package  ma.zs.easystock.ws.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.easystock.ws.converter.gestionchequeffet.BanqueConverter;
import ma.zs.easystock.ws.converter.gestionchequeffet.ProprietaireConverter;



import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.helper.DateUtil;
import ma.zs.easystock.domain.model.gestionchequeffet.Compte;
import ma.zs.easystock.ws.dto.gestionchequeffet.CompteDto;

@Component
public class CompteConverter extends AbstractConverter<Compte, CompteDto> {

    private BanqueConverter banqueConverter ;
    private ProprietaireConverter proprietaireConverter ;
    private boolean banque;
    private boolean proprietaire;

    public  CompteConverter(){
        super(Compte.class, CompteDto.class);
    }

    @Override
    public Compte toItem(CompteDto dto) {
        if (dto == null) {
            return null;
        } else {
        Compte item = new Compte();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getNumeroCompte()))
                item.setNumeroCompte(dto.getNumeroCompte());
            if(StringUtil.isNotEmpty(dto.getSolde()))
                item.setSolde(dto.getSolde());
            if(this.banque && dto.getBanque()!=null &&  dto.getBanque().getId() != null)
                item.setBanque(banqueConverter.toItem(dto.getBanque())) ;

            if(this.proprietaire && dto.getProprietaire()!=null &&  dto.getProprietaire().getId() != null)
                item.setProprietaire(proprietaireConverter.toItem(dto.getProprietaire())) ;




        return item;
        }
    }

    @Override
    public CompteDto toDto(Compte item) {
        if (item == null) {
            return null;
        } else {
            CompteDto dto = new CompteDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getNumeroCompte()))
                dto.setNumeroCompte(item.getNumeroCompte());
            if(StringUtil.isNotEmpty(item.getSolde()))
                dto.setSolde(item.getSolde());
        if(this.banque && item.getBanque()!=null) {
            dto.setBanque(banqueConverter.toDto(item.getBanque())) ;
        }
        if(this.proprietaire && item.getProprietaire()!=null) {
            dto.setProprietaire(proprietaireConverter.toDto(item.getProprietaire())) ;
        }


        return dto;
        }
    }


    public boolean  isBanque(){
        return this.banque;
    }
    public void  setBanque(boolean banque){
        this.banque = banque;
    }
    public boolean  isProprietaire(){
        return this.proprietaire;
    }
    public void  setProprietaire(boolean proprietaire){
        this.proprietaire = proprietaire;
    }
}
