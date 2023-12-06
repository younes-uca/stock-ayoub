package  ma.zs.easystock.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.helper.ListUtil;

import ma.zs.easystock.ws.converter.commun.EtatAvoirAchatConverter;
import ma.zs.easystock.ws.converter.commun.DepotConverter;
import ma.zs.easystock.ws.converter.stock.TaxeConverter;
import ma.zs.easystock.ws.converter.commun.FournisseurConverter;
import ma.zs.easystock.ws.converter.stock.ProduitConverter;
import ma.zs.easystock.ws.converter.commun.EntrepriseSocieteConverter;
import ma.zs.easystock.ws.converter.stock.AvoirAchatItemConverter;



import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.helper.DateUtil;
import ma.zs.easystock.domain.model.stock.AvoirAchat;
import ma.zs.easystock.ws.dto.stock.AvoirAchatDto;

@Component
public class AvoirAchatConverter extends AbstractConverter<AvoirAchat, AvoirAchatDto> {

    private EtatAvoirAchatConverter etatAvoirAchatConverter ;
    private DepotConverter depotConverter ;
    private TaxeConverter taxeConverter ;
    private FournisseurConverter fournisseurConverter ;
    private ProduitConverter produitConverter ;
    private EntrepriseSocieteConverter entrepriseSocieteConverter ;
    private AvoirAchatItemConverter avoirAchatItemConverter ;
    private boolean entrepriseSociete;
    private boolean fournisseur;
    private boolean etatAvoirAchat;
    private boolean avoirAchatItems;

    public  AvoirAchatConverter(){
        super(AvoirAchat.class, AvoirAchatDto.class);
        init(true);
    }

    @Override
    public AvoirAchat toItem(AvoirAchatDto dto) {
        if (dto == null) {
            return null;
        } else {
        AvoirAchat item = new AvoirAchat();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getBarCode()))
                item.setBarCode(dto.getBarCode());
            if(StringUtil.isNotEmpty(dto.getCodeAvoirAchat()))
                item.setCodeAvoirAchat(dto.getCodeAvoirAchat());
            if(StringUtil.isNotEmpty(dto.getNumeroFactureAvoirAchat()))
                item.setNumeroFactureAvoirAchat(dto.getNumeroFactureAvoirAchat());
            if(StringUtil.isNotEmpty(dto.getDateFactureAvoirAchat()))
                item.setDateFactureAvoirAchat(DateUtil.stringEnToDate(dto.getDateFactureAvoirAchat()));
            if(StringUtil.isNotEmpty(dto.getMontantHt()))
                item.setMontantHt(dto.getMontantHt());
            if(StringUtil.isNotEmpty(dto.getMontantTva()))
                item.setMontantTva(dto.getMontantTva());
            if(StringUtil.isNotEmpty(dto.getMontantTtc()))
                item.setMontantTtc(dto.getMontantTtc());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.entrepriseSociete && dto.getEntrepriseSociete()!=null &&  dto.getEntrepriseSociete().getId() != null)
                item.setEntrepriseSociete(entrepriseSocieteConverter.toItem(dto.getEntrepriseSociete())) ;

            if(this.fournisseur && dto.getFournisseur()!=null &&  dto.getFournisseur().getId() != null)
                item.setFournisseur(fournisseurConverter.toItem(dto.getFournisseur())) ;

            if(this.etatAvoirAchat && dto.getEtatAvoirAchat()!=null &&  dto.getEtatAvoirAchat().getId() != null)
                item.setEtatAvoirAchat(etatAvoirAchatConverter.toItem(dto.getEtatAvoirAchat())) ;


            if(this.avoirAchatItems && ListUtil.isNotEmpty(dto.getAvoirAchatItems()))
                item.setAvoirAchatItems(avoirAchatItemConverter.toItem(dto.getAvoirAchatItems()));


        return item;
        }
    }

    @Override
    public AvoirAchatDto toDto(AvoirAchat item) {
        if (item == null) {
            return null;
        } else {
            AvoirAchatDto dto = new AvoirAchatDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getBarCode()))
                dto.setBarCode(item.getBarCode());
            if(StringUtil.isNotEmpty(item.getCodeAvoirAchat()))
                dto.setCodeAvoirAchat(item.getCodeAvoirAchat());
            if(StringUtil.isNotEmpty(item.getNumeroFactureAvoirAchat()))
                dto.setNumeroFactureAvoirAchat(item.getNumeroFactureAvoirAchat());
            if(item.getDateFactureAvoirAchat()!=null)
                dto.setDateFactureAvoirAchat(DateUtil.dateTimeToString(item.getDateFactureAvoirAchat()));
            if(StringUtil.isNotEmpty(item.getMontantHt()))
                dto.setMontantHt(item.getMontantHt());
            if(StringUtil.isNotEmpty(item.getMontantTva()))
                dto.setMontantTva(item.getMontantTva());
            if(StringUtil.isNotEmpty(item.getMontantTtc()))
                dto.setMontantTtc(item.getMontantTtc());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.entrepriseSociete && item.getEntrepriseSociete()!=null) {
            dto.setEntrepriseSociete(entrepriseSocieteConverter.toDto(item.getEntrepriseSociete())) ;
        }
        if(this.fournisseur && item.getFournisseur()!=null) {
            dto.setFournisseur(fournisseurConverter.toDto(item.getFournisseur())) ;
        }
        if(this.etatAvoirAchat && item.getEtatAvoirAchat()!=null) {
            dto.setEtatAvoirAchat(etatAvoirAchatConverter.toDto(item.getEtatAvoirAchat())) ;
        }
        if(this.avoirAchatItems && ListUtil.isNotEmpty(item.getAvoirAchatItems())){
            avoirAchatItemConverter.init(true);
            avoirAchatItemConverter.setAvoirAchat(false);
            dto.setAvoirAchatItems(avoirAchatItemConverter.toDto(item.getAvoirAchatItems()));
            avoirAchatItemConverter.setAvoirAchat(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.avoirAchatItems = value;
    }

    public boolean  isEntrepriseSociete(){
        return this.entrepriseSociete;
    }
    public void  setEntrepriseSociete(boolean entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public boolean  isFournisseur(){
        return this.fournisseur;
    }
    public void  setFournisseur(boolean fournisseur){
        this.fournisseur = fournisseur;
    }
    public boolean  isEtatAvoirAchat(){
        return this.etatAvoirAchat;
    }
    public void  setEtatAvoirAchat(boolean etatAvoirAchat){
        this.etatAvoirAchat = etatAvoirAchat;
    }
    public boolean  isAvoirAchatItems(){
        return this.avoirAchatItems ;
    }
    public void  setAvoirAchatItems(boolean avoirAchatItems ){
        this.avoirAchatItems  = avoirAchatItems ;
    }
}
