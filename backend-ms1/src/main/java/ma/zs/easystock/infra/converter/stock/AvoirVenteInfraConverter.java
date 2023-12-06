package  ma.zs.easystock.infra.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;

import ma.zs.easystock.zynerator.helper.ListUtil;


import ma.zs.easystock.infra.converter.commun.EtatAvoirVenteInfraConverter;
import ma.zs.easystock.infra.converter.commun.DepotInfraConverter;
import ma.zs.easystock.infra.converter.stock.TaxeInfraConverter;
import ma.zs.easystock.infra.converter.stock.AvoirVenteItemInfraConverter;
import ma.zs.easystock.infra.converter.stock.ProduitInfraConverter;
import ma.zs.easystock.infra.converter.stock.AchatInfraConverter;
import ma.zs.easystock.infra.converter.commun.EntrepriseSocieteInfraConverter;
import ma.zs.easystock.infra.converter.commun.ClientInfraConverter;

import ma.zs.easystock.infra.bean.core.stock.AchatEntity;
import ma.zs.easystock.domain.model.stock.Achat;


import ma.zs.easystock.infra.bean.core.stock.AvoirVenteEntity;
import ma.zs.easystock.domain.model.stock.AvoirVente;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class AvoirVenteInfraConverter extends AbstractInfraConverter<AvoirVenteEntity, AvoirVente> {

    @Autowired
    private EtatAvoirVenteInfraConverter etatAvoirVenteConverter ;
    @Autowired
    private DepotInfraConverter depotConverter ;
    @Autowired
    private TaxeInfraConverter taxeConverter ;
    @Autowired
    private AvoirVenteItemInfraConverter avoirVenteItemConverter ;
    @Autowired
    private ProduitInfraConverter produitConverter ;
    @Autowired
    private AchatInfraConverter achatConverter ;
    @Autowired
    private EntrepriseSocieteInfraConverter entrepriseSocieteConverter ;
    @Autowired
    private ClientInfraConverter clientConverter ;
    private boolean entrepriseSociete;
    private boolean client;
    private boolean etatAvoirVente;
    private boolean achat;
    private boolean avoirVenteItems;
    private boolean avoirs;

    public  AvoirVenteInfraConverter(){
        super(AvoirVenteEntity.class, AvoirVente.class);
        init(true);
    }

    @Override
    public AvoirVente toModel(AvoirVenteEntity entity) {
        if (entity == null) {
            return null;
        } else {
        AvoirVente model = new AvoirVente();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getBarCode()))
                model.setBarCode(entity.getBarCode());
            if(StringUtil.isNotEmpty(entity.getCodeAvoirVente()))
                model.setCodeAvoirVente(entity.getCodeAvoirVente());
            if(StringUtil.isNotEmpty(entity.getNumeroFactureAvoirVente()))
                model.setNumeroFactureAvoirVente(entity.getNumeroFactureAvoirVente());
            if(StringUtil.isNotEmpty(entity.getDateFactureAvoirVente()))
                model.setDateFactureAvoirVente(DateUtil.stringEnToDate(entity.getDateFactureAvoirVente()));
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

            if(this.etatAvoirVente && entity.getEtatAvoirVente()!=null &&  entity.getEtatAvoirVente().getId() != null)
                model.setEtatAvoirVente(etatAvoirVenteConverter.toModel(entity.getEtatAvoirVente())) ;

            if(entity.getAchat() != null && entity.getAchat().getId() != null){
                model.setAchat(new Achat());
                model.getAchat().setId(entity.getAchat().getId());
                model.getAchat().setId(entity.getAchat().getId());
            }


            if(this.avoirVenteItems && ListUtil.isNotEmpty(entity.getAvoirVenteItems()))
                model.setAvoirVenteItems(avoirVenteItemConverter.toModel(entity.getAvoirVenteItems()));
            if(this.avoirs && ListUtil.isNotEmpty(entity.getAvoirs()))
                model.setAvoirs(avoirVenteItemConverter.toModel(entity.getAvoirs()));


        return model;
        }
    }

    @Override
    public AvoirVenteEntity toEntity(AvoirVente model) {
        if (model == null) {
            return null;
        } else {
            AvoirVenteEntity entity = new AvoirVenteEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getBarCode()))
             entity.setBarCode(model.getBarCode());
            if(StringUtil.isNotEmpty(model.getCodeAvoirVente()))
             entity.setCodeAvoirVente(model.getCodeAvoirVente());
            if(StringUtil.isNotEmpty(model.getNumeroFactureAvoirVente()))
             entity.setNumeroFactureAvoirVente(model.getNumeroFactureAvoirVente());
            if(model.getDateFactureAvoirVente()!=null)
             entity.setDateFactureAvoirVente(DateUtil.dateTimeToString(model.getDateFactureAvoirVente()));
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
        if(this.etatAvoirVente && model.getEtatAvoirVente()!=null) {
            entity.setEtatAvoirVente(etatAvoirVenteConverter.toEntity(model.getEtatAvoirVente())) ;
        }
        if(this.achat && model.getAchat()!=null) {
            entity.setAchat(achatConverter.toEntity(model.getAchat())) ;
        }
        if(this.avoirVenteItems && ListUtil.isNotEmpty(model.getAvoirVenteItems())){
            avoirVenteItemConverter.init(true);
            avoirVenteItemConverter.setAvoirVente(false);
            entity.setAvoirVenteItems(avoirVenteItemConverter.toEntity(model.getAvoirVenteItems()));
            avoirVenteItemConverter.setAvoirVente(true);

        }
        if(this.avoirs && ListUtil.isNotEmpty(model.getAvoirs())){
            avoirVenteItemConverter.init(true);
            avoirVenteItemConverter.setAvoirVente(false);
            entity.setAvoirs(avoirVenteItemConverter.toEntity(model.getAvoirs()));
            avoirVenteItemConverter.setAvoirVente(true);

        }


        return entity;
        }
    }

    public void initList(boolean value) {
        this.avoirVenteItems = value;
        this.avoirs = value;
    }

    public void initObject(boolean value) {
        this.entrepriseSociete = value;
        this.client = value;
        this.etatAvoirVente = value;
        this.achat = value;
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
    public ProduitInfraConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitInfraConverter(ProduitInfraConverter produitConverter ){
        this.produitConverter = produitConverter;
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
