package  ma.zs.easystock.infra.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;



import ma.zs.easystock.infra.converter.stock.ProduitInfraConverter;
import ma.zs.easystock.infra.converter.stock.CommandeInfraConverter;
import ma.zs.easystock.infra.converter.stock.TaxeInfraConverter;

import ma.zs.easystock.infra.bean.core.stock.ProduitEntity;
import ma.zs.easystock.domain.model.stock.Produit;
import ma.zs.easystock.infra.bean.core.stock.CommandeEntity;
import ma.zs.easystock.domain.model.stock.Commande;


import ma.zs.easystock.infra.bean.core.stock.CommandeItemEntity;
import ma.zs.easystock.domain.model.stock.CommandeItem;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class CommandeItemInfraConverter extends AbstractInfraConverter<CommandeItemEntity, CommandeItem> {

    @Autowired
    private ProduitInfraConverter produitConverter ;
    @Autowired
    private CommandeInfraConverter commandeConverter ;
    @Autowired
    private TaxeInfraConverter taxeConverter ;
    private boolean produit;
    private boolean taxe;
    private boolean commande;

    public  CommandeItemInfraConverter(){
        super(CommandeItemEntity.class, CommandeItem.class);
    }

    @Override
    public CommandeItem toModel(CommandeItemEntity entity) {
        if (entity == null) {
            return null;
        } else {
        CommandeItem model = new CommandeItem();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getQuantite()))
                model.setQuantite(entity.getQuantite());
            if(StringUtil.isNotEmpty(entity.getPrixUnitaireHt()))
                model.setPrixUnitaireHt(entity.getPrixUnitaireHt());
            if(StringUtil.isNotEmpty(entity.getPrixUnitaireTtc()))
                model.setPrixUnitaireTtc(entity.getPrixUnitaireTtc());
            if(StringUtil.isNotEmpty(entity.getRemise()))
                model.setRemise(entity.getRemise());
            if(StringUtil.isNotEmpty(entity.getMontantHt()))
                model.setMontantHt(entity.getMontantHt());
            if(StringUtil.isNotEmpty(entity.getMontantTtc()))
                model.setMontantTtc(entity.getMontantTtc());
            if(entity.getProduit() != null && entity.getProduit().getId() != null){
                model.setProduit(new Produit());
                model.getProduit().setId(entity.getProduit().getId());
                model.getProduit().setSeuilAlerte(entity.getProduit().getSeuilAlerte());
            }

            if(this.taxe && entity.getTaxe()!=null &&  entity.getTaxe().getId() != null)
                model.setTaxe(taxeConverter.toModel(entity.getTaxe())) ;

            if(entity.getCommande() != null && entity.getCommande().getId() != null){
                model.setCommande(new Commande());
                model.getCommande().setId(entity.getCommande().getId());
                model.getCommande().setNumeroCommande(entity.getCommande().getNumeroCommande());
            }




        return model;
        }
    }

    @Override
    public CommandeItemEntity toEntity(CommandeItem model) {
        if (model == null) {
            return null;
        } else {
            CommandeItemEntity entity = new CommandeItemEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getQuantite()))
             entity.setQuantite(model.getQuantite());
            if(StringUtil.isNotEmpty(model.getPrixUnitaireHt()))
             entity.setPrixUnitaireHt(model.getPrixUnitaireHt());
            if(StringUtil.isNotEmpty(model.getPrixUnitaireTtc()))
             entity.setPrixUnitaireTtc(model.getPrixUnitaireTtc());
            if(StringUtil.isNotEmpty(model.getRemise()))
             entity.setRemise(model.getRemise());
            if(StringUtil.isNotEmpty(model.getMontantHt()))
             entity.setMontantHt(model.getMontantHt());
            if(StringUtil.isNotEmpty(model.getMontantTtc()))
             entity.setMontantTtc(model.getMontantTtc());
        if(this.produit && model.getProduit()!=null) {
            entity.setProduit(produitConverter.toEntity(model.getProduit())) ;
        }
        if(this.taxe && model.getTaxe()!=null) {
            entity.setTaxe(taxeConverter.toEntity(model.getTaxe())) ;
        }
        if(this.commande && model.getCommande()!=null) {
            entity.setCommande(commandeConverter.toEntity(model.getCommande())) ;
        }


        return entity;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.taxe = value;
        this.commande = value;
    }


    public ProduitInfraConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitInfraConverter(ProduitInfraConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public CommandeInfraConverter getCommandeConverter(){
        return this.commandeConverter;
    }
    public void setCommandeInfraConverter(CommandeInfraConverter commandeConverter ){
        this.commandeConverter = commandeConverter;
    }
    public TaxeInfraConverter getTaxeConverter(){
        return this.taxeConverter;
    }
    public void setTaxeInfraConverter(TaxeInfraConverter taxeConverter ){
        this.taxeConverter = taxeConverter;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isTaxe(){
        return this.taxe;
    }
    public void  setTaxe(boolean taxe){
        this.taxe = taxe;
    }
    public boolean  isCommande(){
        return this.commande;
    }
    public void  setCommande(boolean commande){
        this.commande = commande;
    }
}
