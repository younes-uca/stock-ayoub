package  ma.zs.easystock.infra.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;

import ma.zs.easystock.zynerator.helper.ListUtil;


import ma.zs.easystock.infra.converter.commun.EtatAchatInfraConverter;
import ma.zs.easystock.infra.converter.commun.EntrepriseSocieteInfraConverter;
import ma.zs.easystock.infra.converter.stock.AvoirAchatInfraConverter;
import ma.zs.easystock.infra.converter.stock.AchatItemInfraConverter;
import ma.zs.easystock.infra.converter.stock.AvoirAchatItemInfraConverter;
import ma.zs.easystock.infra.converter.commun.EtatAvoirAchatInfraConverter;
import ma.zs.easystock.infra.converter.stock.TaxeInfraConverter;
import ma.zs.easystock.infra.converter.commun.DepotInfraConverter;
import ma.zs.easystock.infra.converter.commun.FournisseurInfraConverter;
import ma.zs.easystock.infra.converter.stock.ProduitInfraConverter;



import ma.zs.easystock.infra.bean.core.stock.AchatEntity;
import ma.zs.easystock.domain.model.stock.Achat;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class AchatInfraConverter extends AbstractInfraConverter<AchatEntity, Achat> {

    @Autowired
    private EtatAchatInfraConverter etatAchatConverter ;
    @Autowired
    private EntrepriseSocieteInfraConverter entrepriseSocieteConverter ;
    @Autowired
    private AvoirAchatInfraConverter avoirAchatConverter ;
    @Autowired
    private AchatItemInfraConverter achatItemConverter ;
    @Autowired
    private AvoirAchatItemInfraConverter avoirAchatItemConverter ;
    @Autowired
    private EtatAvoirAchatInfraConverter etatAvoirAchatConverter ;
    @Autowired
    private TaxeInfraConverter taxeConverter ;
    @Autowired
    private DepotInfraConverter depotConverter ;
    @Autowired
    private FournisseurInfraConverter fournisseurConverter ;
    @Autowired
    private ProduitInfraConverter produitConverter ;
    private boolean entrepriseSociete;
    private boolean fournisseur;
    private boolean etatAchat;
    private boolean achatItems;
    private boolean avoirs;

    public  AchatInfraConverter(){
        super(AchatEntity.class, Achat.class);
        init(true);
    }

    @Override
    public Achat toModel(AchatEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Achat model = new Achat();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getDateFacture()))
                model.setDateFacture(DateUtil.stringEnToDate(entity.getDateFacture()));
            if(StringUtil.isNotEmpty(entity.getReferenceFacture()))
                model.setReferenceFacture(entity.getReferenceFacture());
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

            if(this.fournisseur && entity.getFournisseur()!=null &&  entity.getFournisseur().getId() != null)
                model.setFournisseur(fournisseurConverter.toModel(entity.getFournisseur())) ;

            if(this.etatAchat && entity.getEtatAchat()!=null &&  entity.getEtatAchat().getId() != null)
                model.setEtatAchat(etatAchatConverter.toModel(entity.getEtatAchat())) ;


            if(this.achatItems && ListUtil.isNotEmpty(entity.getAchatItems()))
                model.setAchatItems(achatItemConverter.toModel(entity.getAchatItems()));
            if(this.avoirs && ListUtil.isNotEmpty(entity.getAvoirs()))
                model.setAvoirs(avoirAchatConverter.toModel(entity.getAvoirs()));


        return model;
        }
    }

    @Override
    public AchatEntity toEntity(Achat model) {
        if (model == null) {
            return null;
        } else {
            AchatEntity entity = new AchatEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(model.getDateFacture()!=null)
             entity.setDateFacture(DateUtil.dateTimeToString(model.getDateFacture()));
            if(StringUtil.isNotEmpty(model.getReferenceFacture()))
             entity.setReferenceFacture(model.getReferenceFacture());
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
        if(this.fournisseur && model.getFournisseur()!=null) {
            entity.setFournisseur(fournisseurConverter.toEntity(model.getFournisseur())) ;
        }
        if(this.etatAchat && model.getEtatAchat()!=null) {
            entity.setEtatAchat(etatAchatConverter.toEntity(model.getEtatAchat())) ;
        }
        if(this.achatItems && ListUtil.isNotEmpty(model.getAchatItems())){
            achatItemConverter.init(true);
            achatItemConverter.setAchat(false);
            entity.setAchatItems(achatItemConverter.toEntity(model.getAchatItems()));
            achatItemConverter.setAchat(true);

        }
        if(this.avoirs && ListUtil.isNotEmpty(model.getAvoirs())){
            avoirAchatConverter.init(true);
            avoirAchatConverter.setAchat(false);
            entity.setAvoirs(avoirAchatConverter.toEntity(model.getAvoirs()));
            avoirAchatConverter.setAchat(true);

        }


        return entity;
        }
    }

    public void initList(boolean value) {
        this.achatItems = value;
        this.avoirs = value;
    }

    public void initObject(boolean value) {
        this.entrepriseSociete = value;
        this.fournisseur = value;
        this.etatAchat = value;
    }


    public EtatAchatInfraConverter getEtatAchatConverter(){
        return this.etatAchatConverter;
    }
    public void setEtatAchatInfraConverter(EtatAchatInfraConverter etatAchatConverter ){
        this.etatAchatConverter = etatAchatConverter;
    }
    public EntrepriseSocieteInfraConverter getEntrepriseSocieteConverter(){
        return this.entrepriseSocieteConverter;
    }
    public void setEntrepriseSocieteInfraConverter(EntrepriseSocieteInfraConverter entrepriseSocieteConverter ){
        this.entrepriseSocieteConverter = entrepriseSocieteConverter;
    }
    public AvoirAchatInfraConverter getAvoirAchatConverter(){
        return this.avoirAchatConverter;
    }
    public void setAvoirAchatInfraConverter(AvoirAchatInfraConverter avoirAchatConverter ){
        this.avoirAchatConverter = avoirAchatConverter;
    }
    public AchatItemInfraConverter getAchatItemConverter(){
        return this.achatItemConverter;
    }
    public void setAchatItemInfraConverter(AchatItemInfraConverter achatItemConverter ){
        this.achatItemConverter = achatItemConverter;
    }
    public AvoirAchatItemInfraConverter getAvoirAchatItemConverter(){
        return this.avoirAchatItemConverter;
    }
    public void setAvoirAchatItemInfraConverter(AvoirAchatItemInfraConverter avoirAchatItemConverter ){
        this.avoirAchatItemConverter = avoirAchatItemConverter;
    }
    public EtatAvoirAchatInfraConverter getEtatAvoirAchatConverter(){
        return this.etatAvoirAchatConverter;
    }
    public void setEtatAvoirAchatInfraConverter(EtatAvoirAchatInfraConverter etatAvoirAchatConverter ){
        this.etatAvoirAchatConverter = etatAvoirAchatConverter;
    }
    public TaxeInfraConverter getTaxeConverter(){
        return this.taxeConverter;
    }
    public void setTaxeInfraConverter(TaxeInfraConverter taxeConverter ){
        this.taxeConverter = taxeConverter;
    }
    public DepotInfraConverter getDepotConverter(){
        return this.depotConverter;
    }
    public void setDepotInfraConverter(DepotInfraConverter depotConverter ){
        this.depotConverter = depotConverter;
    }
    public FournisseurInfraConverter getFournisseurConverter(){
        return this.fournisseurConverter;
    }
    public void setFournisseurInfraConverter(FournisseurInfraConverter fournisseurConverter ){
        this.fournisseurConverter = fournisseurConverter;
    }
    public ProduitInfraConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitInfraConverter(ProduitInfraConverter produitConverter ){
        this.produitConverter = produitConverter;
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
    public boolean  isEtatAchat(){
        return this.etatAchat;
    }
    public void  setEtatAchat(boolean etatAchat){
        this.etatAchat = etatAchat;
    }
    public boolean  isAchatItems(){
        return this.achatItems ;
    }
    public void  setAchatItems(boolean achatItems ){
        this.achatItems  = achatItems ;
    }
    public boolean  isAvoirs(){
        return this.avoirs ;
    }
    public void  setAvoirs(boolean avoirs ){
        this.avoirs  = avoirs ;
    }
}
