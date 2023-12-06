package  ma.zs.easystock.infra.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;

import ma.zs.easystock.zynerator.helper.ListUtil;


import ma.zs.easystock.infra.converter.commun.EtatAvoirAchatInfraConverter;
import ma.zs.easystock.infra.converter.commun.DepotInfraConverter;
import ma.zs.easystock.infra.converter.stock.TaxeInfraConverter;
import ma.zs.easystock.infra.converter.commun.FournisseurInfraConverter;
import ma.zs.easystock.infra.converter.stock.ProduitInfraConverter;
import ma.zs.easystock.infra.converter.commun.EntrepriseSocieteInfraConverter;
import ma.zs.easystock.infra.converter.stock.AvoirAchatItemInfraConverter;



import ma.zs.easystock.infra.bean.core.stock.AvoirAchatEntity;
import ma.zs.easystock.domain.model.stock.AvoirAchat;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class AvoirAchatInfraConverter extends AbstractInfraConverter<AvoirAchatEntity, AvoirAchat> {

    @Autowired
    private EtatAvoirAchatInfraConverter etatAvoirAchatConverter ;
    @Autowired
    private DepotInfraConverter depotConverter ;
    @Autowired
    private TaxeInfraConverter taxeConverter ;
    @Autowired
    private FournisseurInfraConverter fournisseurConverter ;
    @Autowired
    private ProduitInfraConverter produitConverter ;
    @Autowired
    private EntrepriseSocieteInfraConverter entrepriseSocieteConverter ;
    @Autowired
    private AvoirAchatItemInfraConverter avoirAchatItemConverter ;
    private boolean entrepriseSociete;
    private boolean fournisseur;
    private boolean etatAvoirAchat;
    private boolean avoirAchatItems;

    public  AvoirAchatInfraConverter(){
        super(AvoirAchatEntity.class, AvoirAchat.class);
        init(true);
    }

    @Override
    public AvoirAchat toModel(AvoirAchatEntity entity) {
        if (entity == null) {
            return null;
        } else {
        AvoirAchat model = new AvoirAchat();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getBarCode()))
                model.setBarCode(entity.getBarCode());
            if(StringUtil.isNotEmpty(entity.getCodeAvoirAchat()))
                model.setCodeAvoirAchat(entity.getCodeAvoirAchat());
            if(StringUtil.isNotEmpty(entity.getNumeroFactureAvoirAchat()))
                model.setNumeroFactureAvoirAchat(entity.getNumeroFactureAvoirAchat());
            if(StringUtil.isNotEmpty(entity.getDateFactureAvoirAchat()))
                model.setDateFactureAvoirAchat(DateUtil.stringEnToDate(entity.getDateFactureAvoirAchat()));
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

            if(this.etatAvoirAchat && entity.getEtatAvoirAchat()!=null &&  entity.getEtatAvoirAchat().getId() != null)
                model.setEtatAvoirAchat(etatAvoirAchatConverter.toModel(entity.getEtatAvoirAchat())) ;


            if(this.avoirAchatItems && ListUtil.isNotEmpty(entity.getAvoirAchatItems()))
                model.setAvoirAchatItems(avoirAchatItemConverter.toModel(entity.getAvoirAchatItems()));


        return model;
        }
    }

    @Override
    public AvoirAchatEntity toEntity(AvoirAchat model) {
        if (model == null) {
            return null;
        } else {
            AvoirAchatEntity entity = new AvoirAchatEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getBarCode()))
             entity.setBarCode(model.getBarCode());
            if(StringUtil.isNotEmpty(model.getCodeAvoirAchat()))
             entity.setCodeAvoirAchat(model.getCodeAvoirAchat());
            if(StringUtil.isNotEmpty(model.getNumeroFactureAvoirAchat()))
             entity.setNumeroFactureAvoirAchat(model.getNumeroFactureAvoirAchat());
            if(model.getDateFactureAvoirAchat()!=null)
             entity.setDateFactureAvoirAchat(DateUtil.dateTimeToString(model.getDateFactureAvoirAchat()));
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
        if(this.etatAvoirAchat && model.getEtatAvoirAchat()!=null) {
            entity.setEtatAvoirAchat(etatAvoirAchatConverter.toEntity(model.getEtatAvoirAchat())) ;
        }
        if(this.avoirAchatItems && ListUtil.isNotEmpty(model.getAvoirAchatItems())){
            avoirAchatItemConverter.init(true);
            avoirAchatItemConverter.setAvoirAchat(false);
            entity.setAvoirAchatItems(avoirAchatItemConverter.toEntity(model.getAvoirAchatItems()));
            avoirAchatItemConverter.setAvoirAchat(true);

        }


        return entity;
        }
    }

    public void initList(boolean value) {
        this.avoirAchatItems = value;
    }

    public void initObject(boolean value) {
        this.entrepriseSociete = value;
        this.fournisseur = value;
        this.etatAvoirAchat = value;
    }


    public EtatAvoirAchatInfraConverter getEtatAvoirAchatConverter(){
        return this.etatAvoirAchatConverter;
    }
    public void setEtatAvoirAchatInfraConverter(EtatAvoirAchatInfraConverter etatAvoirAchatConverter ){
        this.etatAvoirAchatConverter = etatAvoirAchatConverter;
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
    public EntrepriseSocieteInfraConverter getEntrepriseSocieteConverter(){
        return this.entrepriseSocieteConverter;
    }
    public void setEntrepriseSocieteInfraConverter(EntrepriseSocieteInfraConverter entrepriseSocieteConverter ){
        this.entrepriseSocieteConverter = entrepriseSocieteConverter;
    }
    public AvoirAchatItemInfraConverter getAvoirAchatItemConverter(){
        return this.avoirAchatItemConverter;
    }
    public void setAvoirAchatItemInfraConverter(AvoirAchatItemInfraConverter avoirAchatItemConverter ){
        this.avoirAchatItemConverter = avoirAchatItemConverter;
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
