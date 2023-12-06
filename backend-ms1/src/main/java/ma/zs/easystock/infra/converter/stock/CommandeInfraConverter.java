package  ma.zs.easystock.infra.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;

import ma.zs.easystock.zynerator.helper.ListUtil;


import ma.zs.easystock.infra.converter.stock.ProduitInfraConverter;
import ma.zs.easystock.infra.converter.commun.ClientInfraConverter;
import ma.zs.easystock.infra.converter.stock.CommandeItemInfraConverter;
import ma.zs.easystock.infra.converter.stock.TaxeInfraConverter;
import ma.zs.easystock.infra.converter.commun.EtatCommandeInfraConverter;



import ma.zs.easystock.infra.bean.core.stock.CommandeEntity;
import ma.zs.easystock.domain.model.stock.Commande;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class CommandeInfraConverter extends AbstractInfraConverter<CommandeEntity, Commande> {

    @Autowired
    private ProduitInfraConverter produitConverter ;
    @Autowired
    private ClientInfraConverter clientConverter ;
    @Autowired
    private CommandeItemInfraConverter commandeItemConverter ;
    @Autowired
    private TaxeInfraConverter taxeConverter ;
    @Autowired
    private EtatCommandeInfraConverter etatCommandeConverter ;
    private boolean client;
    private boolean etatCommande;
    private boolean commandeItems;

    public  CommandeInfraConverter(){
        super(CommandeEntity.class, Commande.class);
        init(true);
    }

    @Override
    public Commande toModel(CommandeEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Commande model = new Commande();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getBarCode()))
                model.setBarCode(entity.getBarCode());
            if(StringUtil.isNotEmpty(entity.getNumeroCommande()))
                model.setNumeroCommande(entity.getNumeroCommande());
            if(StringUtil.isNotEmpty(entity.getDateCommande()))
                model.setDateCommande(DateUtil.stringEnToDate(entity.getDateCommande()));
            if(StringUtil.isNotEmpty(entity.getMontantHt()))
                model.setMontantHt(entity.getMontantHt());
            if(StringUtil.isNotEmpty(entity.getMontantTva()))
                model.setMontantTva(entity.getMontantTva());
            if(StringUtil.isNotEmpty(entity.getMontantTtc()))
                model.setMontantTtc(entity.getMontantTtc());
            if(StringUtil.isNotEmpty(entity.getDescription()))
                model.setDescription(entity.getDescription());
            if(this.client && entity.getClient()!=null &&  entity.getClient().getId() != null)
                model.setClient(clientConverter.toModel(entity.getClient())) ;

            if(this.etatCommande && entity.getEtatCommande()!=null &&  entity.getEtatCommande().getId() != null)
                model.setEtatCommande(etatCommandeConverter.toModel(entity.getEtatCommande())) ;


            if(this.commandeItems && ListUtil.isNotEmpty(entity.getCommandeItems()))
                model.setCommandeItems(commandeItemConverter.toModel(entity.getCommandeItems()));


        return model;
        }
    }

    @Override
    public CommandeEntity toEntity(Commande model) {
        if (model == null) {
            return null;
        } else {
            CommandeEntity entity = new CommandeEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getBarCode()))
             entity.setBarCode(model.getBarCode());
            if(StringUtil.isNotEmpty(model.getNumeroCommande()))
             entity.setNumeroCommande(model.getNumeroCommande());
            if(model.getDateCommande()!=null)
             entity.setDateCommande(DateUtil.dateTimeToString(model.getDateCommande()));
            if(StringUtil.isNotEmpty(model.getMontantHt()))
             entity.setMontantHt(model.getMontantHt());
            if(StringUtil.isNotEmpty(model.getMontantTva()))
             entity.setMontantTva(model.getMontantTva());
            if(StringUtil.isNotEmpty(model.getMontantTtc()))
             entity.setMontantTtc(model.getMontantTtc());
            if(StringUtil.isNotEmpty(model.getDescription()))
             entity.setDescription(model.getDescription());
        if(this.client && model.getClient()!=null) {
            entity.setClient(clientConverter.toEntity(model.getClient())) ;
        }
        if(this.etatCommande && model.getEtatCommande()!=null) {
            entity.setEtatCommande(etatCommandeConverter.toEntity(model.getEtatCommande())) ;
        }
        if(this.commandeItems && ListUtil.isNotEmpty(model.getCommandeItems())){
            commandeItemConverter.init(true);
            commandeItemConverter.setCommande(false);
            entity.setCommandeItems(commandeItemConverter.toEntity(model.getCommandeItems()));
            commandeItemConverter.setCommande(true);

        }


        return entity;
        }
    }

    public void initList(boolean value) {
        this.commandeItems = value;
    }

    public void initObject(boolean value) {
        this.client = value;
        this.etatCommande = value;
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
    public CommandeItemInfraConverter getCommandeItemConverter(){
        return this.commandeItemConverter;
    }
    public void setCommandeItemInfraConverter(CommandeItemInfraConverter commandeItemConverter ){
        this.commandeItemConverter = commandeItemConverter;
    }
    public TaxeInfraConverter getTaxeConverter(){
        return this.taxeConverter;
    }
    public void setTaxeInfraConverter(TaxeInfraConverter taxeConverter ){
        this.taxeConverter = taxeConverter;
    }
    public EtatCommandeInfraConverter getEtatCommandeConverter(){
        return this.etatCommandeConverter;
    }
    public void setEtatCommandeInfraConverter(EtatCommandeInfraConverter etatCommandeConverter ){
        this.etatCommandeConverter = etatCommandeConverter;
    }
    public boolean  isClient(){
        return this.client;
    }
    public void  setClient(boolean client){
        this.client = client;
    }
    public boolean  isEtatCommande(){
        return this.etatCommande;
    }
    public void  setEtatCommande(boolean etatCommande){
        this.etatCommande = etatCommande;
    }
    public boolean  isCommandeItems(){
        return this.commandeItems ;
    }
    public void  setCommandeItems(boolean commandeItems ){
        this.commandeItems  = commandeItems ;
    }
}
