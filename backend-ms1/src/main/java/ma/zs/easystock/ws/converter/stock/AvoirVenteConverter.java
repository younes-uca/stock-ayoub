package  ma.zs.easystock.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.helper.ListUtil;

import ma.zs.easystock.ws.converter.commun.EtatAvoirVenteConverter;
import ma.zs.easystock.ws.converter.commun.DepotConverter;
import ma.zs.easystock.ws.converter.stock.TaxeConverter;
import ma.zs.easystock.ws.converter.stock.AvoirVenteItemConverter;
import ma.zs.easystock.ws.converter.stock.ProduitConverter;
import ma.zs.easystock.ws.converter.stock.AchatConverter;
import ma.zs.easystock.ws.converter.commun.EntrepriseSocieteConverter;
import ma.zs.easystock.ws.converter.commun.ClientConverter;

import ma.zs.easystock.domain.model.stock.Achat;


import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.helper.DateUtil;
import ma.zs.easystock.domain.model.stock.AvoirVente;
import ma.zs.easystock.ws.dto.stock.AvoirVenteDto;

@Component
public class AvoirVenteConverter extends AbstractConverter<AvoirVente, AvoirVenteDto> {

    private EtatAvoirVenteConverter etatAvoirVenteConverter ;
    private DepotConverter depotConverter ;
    private TaxeConverter taxeConverter ;
    private AvoirVenteItemConverter avoirVenteItemConverter ;
    private ProduitConverter produitConverter ;
    private AchatConverter achatConverter ;
    private EntrepriseSocieteConverter entrepriseSocieteConverter ;
    private ClientConverter clientConverter ;
    private boolean entrepriseSociete;
    private boolean client;
    private boolean etatAvoirVente;
    private boolean achat;
    private boolean avoirVenteItems;
    private boolean avoirs;

    public  AvoirVenteConverter(){
        super(AvoirVente.class, AvoirVenteDto.class);
        init(true);
    }

    @Override
    public AvoirVente toItem(AvoirVenteDto dto) {
        if (dto == null) {
            return null;
        } else {
        AvoirVente item = new AvoirVente();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getBarCode()))
                item.setBarCode(dto.getBarCode());
            if(StringUtil.isNotEmpty(dto.getCodeAvoirVente()))
                item.setCodeAvoirVente(dto.getCodeAvoirVente());
            if(StringUtil.isNotEmpty(dto.getNumeroFactureAvoirVente()))
                item.setNumeroFactureAvoirVente(dto.getNumeroFactureAvoirVente());
            if(StringUtil.isNotEmpty(dto.getDateFactureAvoirVente()))
                item.setDateFactureAvoirVente(DateUtil.stringEnToDate(dto.getDateFactureAvoirVente()));
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

            if(this.client && dto.getClient()!=null &&  dto.getClient().getId() != null)
                item.setClient(clientConverter.toItem(dto.getClient())) ;

            if(this.etatAvoirVente && dto.getEtatAvoirVente()!=null &&  dto.getEtatAvoirVente().getId() != null)
                item.setEtatAvoirVente(etatAvoirVenteConverter.toItem(dto.getEtatAvoirVente())) ;

            if(dto.getAchat() != null && dto.getAchat().getId() != null){
                item.setAchat(new Achat());
                item.getAchat().setId(dto.getAchat().getId());
                item.getAchat().setId(dto.getAchat().getId());
            }


            if(this.avoirVenteItems && ListUtil.isNotEmpty(dto.getAvoirVenteItems()))
                item.setAvoirVenteItems(avoirVenteItemConverter.toItem(dto.getAvoirVenteItems()));
            if(this.avoirs && ListUtil.isNotEmpty(dto.getAvoirs()))
                item.setAvoirs(avoirVenteItemConverter.toItem(dto.getAvoirs()));


        return item;
        }
    }

    @Override
    public AvoirVenteDto toDto(AvoirVente item) {
        if (item == null) {
            return null;
        } else {
            AvoirVenteDto dto = new AvoirVenteDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getBarCode()))
                dto.setBarCode(item.getBarCode());
            if(StringUtil.isNotEmpty(item.getCodeAvoirVente()))
                dto.setCodeAvoirVente(item.getCodeAvoirVente());
            if(StringUtil.isNotEmpty(item.getNumeroFactureAvoirVente()))
                dto.setNumeroFactureAvoirVente(item.getNumeroFactureAvoirVente());
            if(item.getDateFactureAvoirVente()!=null)
                dto.setDateFactureAvoirVente(DateUtil.dateTimeToString(item.getDateFactureAvoirVente()));
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
        if(this.client && item.getClient()!=null) {
            dto.setClient(clientConverter.toDto(item.getClient())) ;
        }
        if(this.etatAvoirVente && item.getEtatAvoirVente()!=null) {
            dto.setEtatAvoirVente(etatAvoirVenteConverter.toDto(item.getEtatAvoirVente())) ;
        }
        if(this.achat && item.getAchat()!=null) {
            dto.setAchat(achatConverter.toDto(item.getAchat())) ;
        }
        if(this.avoirVenteItems && ListUtil.isNotEmpty(item.getAvoirVenteItems())){
            avoirVenteItemConverter.init(true);
            avoirVenteItemConverter.setAvoirVente(false);
            dto.setAvoirVenteItems(avoirVenteItemConverter.toDto(item.getAvoirVenteItems()));
            avoirVenteItemConverter.setAvoirVente(true);

        }
        if(this.avoirs && ListUtil.isNotEmpty(item.getAvoirs())){
            avoirVenteItemConverter.init(true);
            avoirVenteItemConverter.setAvoirVente(false);
            dto.setAvoirs(avoirVenteItemConverter.toDto(item.getAvoirs()));
            avoirVenteItemConverter.setAvoirVente(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.avoirVenteItems = value;
        this.avoirs = value;
    }

    public boolean  isEntrepriseSociete(){
        return this.entrepriseSociete;
    }
    public void  setEntrepriseSociete(boolean entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public boolean  isClient(){
        return this.client;
    }
    public void  setClient(boolean client){
        this.client = client;
    }
    public boolean  isEtatAvoirVente(){
        return this.etatAvoirVente;
    }
    public void  setEtatAvoirVente(boolean etatAvoirVente){
        this.etatAvoirVente = etatAvoirVente;
    }
    public boolean  isAchat(){
        return this.achat;
    }
    public void  setAchat(boolean achat){
        this.achat = achat;
    }
    public boolean  isAvoirVenteItems(){
        return this.avoirVenteItems ;
    }
    public void  setAvoirVenteItems(boolean avoirVenteItems ){
        this.avoirVenteItems  = avoirVenteItems ;
    }
    public boolean  isAvoirs(){
        return this.avoirs ;
    }
    public void  setAvoirs(boolean avoirs ){
        this.avoirs  = avoirs ;
    }
}
