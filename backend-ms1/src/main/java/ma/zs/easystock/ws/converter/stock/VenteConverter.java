package  ma.zs.easystock.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.helper.ListUtil;

import ma.zs.easystock.ws.converter.stock.AvoirVenteConverter;
import ma.zs.easystock.ws.converter.stock.VenteItemConverter;
import ma.zs.easystock.ws.converter.stock.AchatConverter;
import ma.zs.easystock.ws.converter.commun.EntrepriseSocieteConverter;
import ma.zs.easystock.ws.converter.commun.EtatAvoirVenteConverter;
import ma.zs.easystock.ws.converter.commun.DepotConverter;
import ma.zs.easystock.ws.converter.stock.TaxeConverter;
import ma.zs.easystock.ws.converter.stock.AvoirVenteItemConverter;
import ma.zs.easystock.ws.converter.commun.EtatVenteConverter;
import ma.zs.easystock.ws.converter.stock.ProduitConverter;
import ma.zs.easystock.ws.converter.commun.ClientConverter;



import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.helper.DateUtil;
import ma.zs.easystock.domain.model.stock.Vente;
import ma.zs.easystock.ws.dto.stock.VenteDto;

@Component
public class VenteConverter extends AbstractConverter<Vente, VenteDto> {

    private AvoirVenteConverter avoirVenteConverter ;
    private VenteItemConverter venteItemConverter ;
    private AchatConverter achatConverter ;
    private EntrepriseSocieteConverter entrepriseSocieteConverter ;
    private EtatAvoirVenteConverter etatAvoirVenteConverter ;
    private DepotConverter depotConverter ;
    private TaxeConverter taxeConverter ;
    private AvoirVenteItemConverter avoirVenteItemConverter ;
    private EtatVenteConverter etatVenteConverter ;
    private ProduitConverter produitConverter ;
    private ClientConverter clientConverter ;
    private boolean entrepriseSociete;
    private boolean client;
    private boolean etatVente;
    private boolean venteItems;
    private boolean avoirs;

    public  VenteConverter(){
        super(Vente.class, VenteDto.class);
        init(true);
    }

    @Override
    public Vente toItem(VenteDto dto) {
        if (dto == null) {
            return null;
        } else {
        Vente item = new Vente();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getBarCode()))
                item.setBarCode(dto.getBarCode());
            if(StringUtil.isNotEmpty(dto.getCodeVente()))
                item.setCodeVente(dto.getCodeVente());
            if(StringUtil.isNotEmpty(dto.getDateFacture()))
                item.setDateFacture(DateUtil.stringEnToDate(dto.getDateFacture()));
            if(StringUtil.isNotEmpty(dto.getNumeroFacture()))
                item.setNumeroFacture(dto.getNumeroFacture());
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

            if(this.etatVente && dto.getEtatVente()!=null &&  dto.getEtatVente().getId() != null)
                item.setEtatVente(etatVenteConverter.toItem(dto.getEtatVente())) ;


            if(this.venteItems && ListUtil.isNotEmpty(dto.getVenteItems()))
                item.setVenteItems(venteItemConverter.toItem(dto.getVenteItems()));
            if(this.avoirs && ListUtil.isNotEmpty(dto.getAvoirs()))
                item.setAvoirs(avoirVenteConverter.toItem(dto.getAvoirs()));


        return item;
        }
    }

    @Override
    public VenteDto toDto(Vente item) {
        if (item == null) {
            return null;
        } else {
            VenteDto dto = new VenteDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getBarCode()))
                dto.setBarCode(item.getBarCode());
            if(StringUtil.isNotEmpty(item.getCodeVente()))
                dto.setCodeVente(item.getCodeVente());
            if(item.getDateFacture()!=null)
                dto.setDateFacture(DateUtil.dateTimeToString(item.getDateFacture()));
            if(StringUtil.isNotEmpty(item.getNumeroFacture()))
                dto.setNumeroFacture(item.getNumeroFacture());
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
        if(this.etatVente && item.getEtatVente()!=null) {
            dto.setEtatVente(etatVenteConverter.toDto(item.getEtatVente())) ;
        }
        if(this.venteItems && ListUtil.isNotEmpty(item.getVenteItems())){
            venteItemConverter.init(true);
            venteItemConverter.setVente(false);
            dto.setVenteItems(venteItemConverter.toDto(item.getVenteItems()));
            venteItemConverter.setVente(true);

        }
        if(this.avoirs && ListUtil.isNotEmpty(item.getAvoirs())){
            avoirVenteConverter.init(true);
            avoirVenteConverter.setVente(false);
            dto.setAvoirs(avoirVenteConverter.toDto(item.getAvoirs()));
            avoirVenteConverter.setVente(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.venteItems = value;
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
    public boolean  isEtatVente(){
        return this.etatVente;
    }
    public void  setEtatVente(boolean etatVente){
        this.etatVente = etatVente;
    }
    public boolean  isVenteItems(){
        return this.venteItems ;
    }
    public void  setVenteItems(boolean venteItems ){
        this.venteItems  = venteItems ;
    }
    public boolean  isAvoirs(){
        return this.avoirs ;
    }
    public void  setAvoirs(boolean avoirs ){
        this.avoirs  = avoirs ;
    }
}
