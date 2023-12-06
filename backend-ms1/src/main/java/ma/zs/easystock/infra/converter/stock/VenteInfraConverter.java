package  ma.zs.easystock.infra.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;

import ma.zs.easystock.zynerator.helper.ListUtil;


import ma.zs.easystock.infra.converter.stock.AvoirVenteInfraConverter;
import ma.zs.easystock.infra.converter.stock.VenteItemInfraConverter;
import ma.zs.easystock.infra.converter.stock.AchatInfraConverter;
import ma.zs.easystock.infra.converter.commun.EntrepriseSocieteInfraConverter;
import ma.zs.easystock.infra.converter.commun.EtatAvoirVenteInfraConverter;
import ma.zs.easystock.infra.converter.commun.DepotInfraConverter;
import ma.zs.easystock.infra.converter.stock.TaxeInfraConverter;
import ma.zs.easystock.infra.converter.stock.AvoirVenteItemInfraConverter;
import ma.zs.easystock.infra.converter.commun.EtatVenteInfraConverter;
import ma.zs.easystock.infra.converter.stock.ProduitInfraConverter;
import ma.zs.easystock.infra.converter.commun.ClientInfraConverter;



import ma.zs.easystock.infra.bean.core.stock.VenteEntity;
import ma.zs.easystock.domain.model.stock.Vente;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class VenteInfraConverter extends AbstractInfraConverter<VenteEntity, Vente> {

    @Autowired
    private AvoirVenteInfraConverter avoirVenteConverter ;
    @Autowired
    private VenteItemInfraConverter venteItemConverter ;
    @Autowired
    private AchatInfraConverter achatConverter ;
    @Autowired
    private EntrepriseSocieteInfraConverter entrepriseSocieteConverter ;
    @Autowired
    private EtatAvoirVenteInfraConverter etatAvoirVenteConverter ;
    @Autowired
    private DepotInfraConverter depotConverter ;
    @Autowired
    private TaxeInfraConverter taxeConverter ;
    @Autowired
    private AvoirVenteItemInfraConverter avoirVenteItemConverter ;
    @Autowired
    private EtatVenteInfraConverter etatVenteConverter ;
    @Autowired
    private ProduitInfraConverter produitConverter ;
    @Autowired
    private ClientInfraConverter clientConverter ;
    private boolean entrepriseSociete;
    private boolean client;
    private boolean etatVente;
    private boolean venteItems;
    private boolean avoirs;

    public  VenteInfraConverter(){
        super(VenteEntity.class, Vente.class);
        init(true);
    }

    @Override
    public Vente toModel(VenteEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Vente model = new Vente();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getBarCode()))
                model.setBarCode(entity.getBarCode());
            if(StringUtil.isNotEmpty(entity.getCodeVente()))
                model.setCodeVente(entity.getCodeVente());
            if(StringUtil.isNotEmpty(entity.getDateFacture()))
                model.setDateFacture(DateUtil.stringEnToDate(entity.getDateFacture()));
            if(StringUtil.isNotEmpty(entity.getNumeroFacture()))
                model.setNumeroFacture(entity.getNumeroFacture());
            if(StringUtil.isNotEmpty(entity.getMontantHt()))
                model.setMontantHt(entity.getMontantHt());
            if(StringUtil.isNotEmpty(entity.getMontantTva()))
                model.setMontantTva(entity.getMontantTva());
            if(StringUtil.isNotEmpty(entity.getMontantTtc()))
                model.setMontantTtc(entity.getMontantTtc());
            if(StringUtil.isNotEmpty(entity.getDescription()))
                model.setDescription(entity.getDescription());
            if(this.entrepriseSociete && entity.getEntrepriseSociete()!=null &&  entity.getEntrepriseSociete().getId() != null)
                model.setEntrepriseSociete(entrepriseSocieteConverter.toModel(entity.getEntrepriseSociete())) ;

            if(this.client && entity.getClient()!=null &&  entity.getClient().getId() != null)
                model.setClient(clientConverter.toModel(entity.getClient())) ;

            if(this.etatVente && entity.getEtatVente()!=null &&  entity.getEtatVente().getId() != null)
                model.setEtatVente(etatVenteConverter.toModel(entity.getEtatVente())) ;


            if(this.venteItems && ListUtil.isNotEmpty(entity.getVenteItems()))
                model.setVenteItems(venteItemConverter.toModel(entity.getVenteItems()));
            if(this.avoirs && ListUtil.isNotEmpty(entity.getAvoirs()))
                model.setAvoirs(avoirVenteConverter.toModel(entity.getAvoirs()));


        return model;
        }
    }

    @Override
    public VenteEntity toEntity(Vente model) {
        if (model == null) {
            return null;
        } else {
            VenteEntity entity = new VenteEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getBarCode()))
             entity.setBarCode(model.getBarCode());
            if(StringUtil.isNotEmpty(model.getCodeVente()))
             entity.setCodeVente(model.getCodeVente());
            if(model.getDateFacture()!=null)
             entity.setDateFacture(DateUtil.dateTimeToString(model.getDateFacture()));
            if(StringUtil.isNotEmpty(model.getNumeroFacture()))
             entity.setNumeroFacture(model.getNumeroFacture());
            if(StringUtil.isNotEmpty(model.getMontantHt()))
             entity.setMontantHt(model.getMontantHt());
            if(StringUtil.isNotEmpty(model.getMontantTva()))
             entity.setMontantTva(model.getMontantTva());
            if(StringUtil.isNotEmpty(model.getMontantTtc()))
             entity.setMontantTtc(model.getMontantTtc());
            if(StringUtil.isNotEmpty(model.getDescription()))
             entity.setDescription(model.getDescription());
        if(this.entrepriseSociete && model.getEntrepriseSociete()!=null) {
            entity.setEntrepriseSociete(entrepriseSocieteConverter.toEntity(model.getEntrepriseSociete())) ;
        }
        if(this.client && model.getClient()!=null) {
            entity.setClient(clientConverter.toEntity(model.getClient())) ;
        }
        if(this.etatVente && model.getEtatVente()!=null) {
            entity.setEtatVente(etatVenteConverter.toEntity(model.getEtatVente())) ;
        }
        if(this.venteItems && ListUtil.isNotEmpty(model.getVenteItems())){
            venteItemConverter.init(true);
            venteItemConverter.setVente(false);
            entity.setVenteItems(venteItemConverter.toEntity(model.getVenteItems()));
            venteItemConverter.setVente(true);

        }
        if(this.avoirs && ListUtil.isNotEmpty(model.getAvoirs())){
            avoirVenteConverter.init(true);
            avoirVenteConverter.setVente(false);
            entity.setAvoirs(avoirVenteConverter.toEntity(model.getAvoirs()));
            avoirVenteConverter.setVente(true);

        }


        return entity;
        }
    }

    public void initList(boolean value) {
        this.venteItems = value;
        this.avoirs = value;
    }

    public void initObject(boolean value) {
        this.entrepriseSociete = value;
        this.client = value;
        this.etatVente = value;
    }


    public AvoirVenteInfraConverter getAvoirVenteConverter(){
        return this.avoirVenteConverter;
    }
    public void setAvoirVenteInfraConverter(AvoirVenteInfraConverter avoirVenteConverter ){
        this.avoirVenteConverter = avoirVenteConverter;
    }
    public VenteItemInfraConverter getVenteItemConverter(){
        return this.venteItemConverter;
    }
    public void setVenteItemInfraConverter(VenteItemInfraConverter venteItemConverter ){
        this.venteItemConverter = venteItemConverter;
    }
    public AchatInfraConverter getAchatConverter(){
        return this.achatConverter;
    }
    public void setAchatInfraConverter(AchatInfraConverter achatConverter ){
        this.achatConverter = achatConverter;
    }
    public EntrepriseSocieteInfraConverter getEntrepriseSocieteConverter(){
        return this.entrepriseSocieteConverter;
    }
    public void setEntrepriseSocieteInfraConverter(EntrepriseSocieteInfraConverter entrepriseSocieteConverter ){
        this.entrepriseSocieteConverter = entrepriseSocieteConverter;
    }
    public EtatAvoirVenteInfraConverter getEtatAvoirVenteConverter(){
        return this.etatAvoirVenteConverter;
    }
    public void setEtatAvoirVenteInfraConverter(EtatAvoirVenteInfraConverter etatAvoirVenteConverter ){
        this.etatAvoirVenteConverter = etatAvoirVenteConverter;
    }
    public DepotInfraConverter getDepotConverter(){
        return this.depotConverter;
    }
    public void setDepotInfraConverter(DepotInfraConverter depotConverter ){
        this.depotConverter = depotConverter;
    }
    public TaxeInfraConverter getTaxeConverter(){
        return this.taxeConverter;
    }
    public void setTaxeInfraConverter(TaxeInfraConverter taxeConverter ){
        this.taxeConverter = taxeConverter;
    }
    public AvoirVenteItemInfraConverter getAvoirVenteItemConverter(){
        return this.avoirVenteItemConverter;
    }
    public void setAvoirVenteItemInfraConverter(AvoirVenteItemInfraConverter avoirVenteItemConverter ){
        this.avoirVenteItemConverter = avoirVenteItemConverter;
    }
    public EtatVenteInfraConverter getEtatVenteConverter(){
        return this.etatVenteConverter;
    }
    public void setEtatVenteInfraConverter(EtatVenteInfraConverter etatVenteConverter ){
        this.etatVenteConverter = etatVenteConverter;
    }
    public ProduitInfraConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitInfraConverter(ProduitInfraConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public ClientInfraConverter getClientConverter(){
        return this.clientConverter;
    }
    public void setClientInfraConverter(ClientInfraConverter clientConverter ){
        this.clientConverter = clientConverter;
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
