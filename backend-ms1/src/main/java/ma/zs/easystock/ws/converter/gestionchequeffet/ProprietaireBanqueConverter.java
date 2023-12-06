package  ma.zs.easystock.ws.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.easystock.ws.converter.gestionchequeffet.BanqueConverter;
import ma.zs.easystock.ws.converter.gestionchequeffet.ProprietaireConverter;
import ma.zs.easystock.ws.converter.gestionchequeffet.CompteConverter;



import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.helper.DateUtil;
import ma.zs.easystock.domain.model.gestionchequeffet.ProprietaireBanque;
import ma.zs.easystock.ws.dto.gestionchequeffet.ProprietaireBanqueDto;

@Component
public class ProprietaireBanqueConverter extends AbstractConverter<ProprietaireBanque, ProprietaireBanqueDto> {

    private BanqueConverter banqueConverter ;
    private ProprietaireConverter proprietaireConverter ;
    private CompteConverter compteConverter ;
    private boolean proprietaire;
    private boolean banque;
    private boolean compte;

    public  ProprietaireBanqueConverter(){
        super(ProprietaireBanque.class, ProprietaireBanqueDto.class);
    }

    @Override
    public ProprietaireBanque toItem(ProprietaireBanqueDto dto) {
        if (dto == null) {
            return null;
        } else {
        ProprietaireBanque item = new ProprietaireBanque();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(this.proprietaire && dto.getProprietaire()!=null &&  dto.getProprietaire().getId() != null)
                item.setProprietaire(proprietaireConverter.toItem(dto.getProprietaire())) ;

            if(this.banque && dto.getBanque()!=null &&  dto.getBanque().getId() != null)
                item.setBanque(banqueConverter.toItem(dto.getBanque())) ;

            if(this.compte && dto.getCompte()!=null &&  dto.getCompte().getId() != null)
                item.setCompte(compteConverter.toItem(dto.getCompte())) ;




        return item;
        }
    }

    @Override
    public ProprietaireBanqueDto toDto(ProprietaireBanque item) {
        if (item == null) {
            return null;
        } else {
            ProprietaireBanqueDto dto = new ProprietaireBanqueDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
        if(this.proprietaire && item.getProprietaire()!=null) {
            dto.setProprietaire(proprietaireConverter.toDto(item.getProprietaire())) ;
        }
        if(this.banque && item.getBanque()!=null) {
            dto.setBanque(banqueConverter.toDto(item.getBanque())) ;
        }
        if(this.compte && item.getCompte()!=null) {
            dto.setCompte(compteConverter.toDto(item.getCompte())) ;
        }


        return dto;
        }
    }


    public boolean  isProprietaire(){
        return this.proprietaire;
    }
    public void  setProprietaire(boolean proprietaire){
        this.proprietaire = proprietaire;
    }
    public boolean  isBanque(){
        return this.banque;
    }
    public void  setBanque(boolean banque){
        this.banque = banque;
    }
    public boolean  isCompte(){
        return this.compte;
    }
    public void  setCompte(boolean compte){
        this.compte = compte;
    }
}
