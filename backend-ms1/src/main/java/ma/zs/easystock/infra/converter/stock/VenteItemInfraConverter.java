package  ma.zs.easystock.infra.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;



import ma.zs.easystock.infra.converter.stock.ProduitInfraConverter;
import ma.zs.easystock.infra.converter.stock.VenteInfraConverter;
import ma.zs.easystock.infra.converter.commun.DepotInfraConverter;
import ma.zs.easystock.infra.converter.stock.TaxeInfraConverter;

import ma.zs.easystock.infra.bean.core.stock.ProduitEntity;
import ma.zs.easystock.domain.model.stock.Produit;
import ma.zs.easystock.infra.bean.core.stock.VenteEntity;
import ma.zs.easystock.domain.model.stock.Vente;


import ma.zs.easystock.infra.bean.core.stock.VenteItemEntity;
import ma.zs.easystock.domain.model.stock.VenteItem;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class VenteItemInfraConverter extends AbstractInfraConverter<VenteItemEntity, VenteItem> {

    @Autowired
    private ProduitInfraConverter produitConverter ;
    @Autowired
    private VenteInfraConverter venteConverter ;
    @Autowired
    private DepotInfraConverter depotConverter ;
    @Autowired
    private TaxeInfraConverter taxeConverter ;
    private boolean depot;
    private boolean produit;
    private boolean taxe;
    private boolean vente;

    public  VenteItemInfraConverter(){
        super(VenteItemEntity.class, VenteItem.class);
    }

    @Override
    public VenteItem toModel(VenteItemEntity entity) {
        if (entity == null) {
            return null;
        } else {
        VenteItem model = new VenteItem();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getBarCode()))
                model.setBarCode(entity.getBarCode());
            if(StringUtil.isNotEmpty(entity.getQuantite()))
                model.setQuantite(entity.getQuantite());
            if(StringUtil.isNotEmpty(entity.getQuantiteAvoir()))
                model.setQuantiteAvoir(entity.getQuantiteAvoir());
            if(StringUtil.isNotEmpty(entity.getQuantiteVendue()))
                model.setQuantiteVendue(entity.getQuantiteVendue());
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
            if(this.depot && entity.getDepot()!=null &&  entity.getDepot().getId() != null)
                model.setDepot(depotConverter.toModel(entity.getDepot())) ;

            if(entity.getProduit() != null && entity.getProduit().getId() != null){
                model.setProduit(new Produit());
                model.getProduit().setId(entity.getProduit().getId());
                model.getProduit().setSeuilAlerte(entity.getProduit().getSeuilAlerte());
            }

            if(this.taxe && entity.getTaxe()!=null &&  entity.getTaxe().getId() != null)
                model.setTaxe(taxeConverter.toModel(entity.getTaxe())) ;

            if(entity.getVente() != null && entity.getVente().getId() != null){
                model.setVente(new Vente());
                model.getVente().setId(entity.getVente().getId());
                model.getVente().setNumeroFacture(entity.getVente().getNumeroFacture());
            }




        return model;
        }
    }

    @Override
    public VenteItemEntity toEntity(VenteItem model) {
        if (model == null) {
            return null;
        } else {
            VenteItemEntity entity = new VenteItemEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getBarCode()))
             entity.setBarCode(model.getBarCode());
            if(StringUtil.isNotEmpty(model.getQuantite()))
             entity.setQuantite(model.getQuantite());
            if(StringUtil.isNotEmpty(model.getQuantiteAvoir()))
             entity.setQuantiteAvoir(model.getQuantiteAvoir());
            if(StringUtil.isNotEmpty(model.getQuantiteVendue()))
             entity.setQuantiteVendue(model.getQuantiteVendue());
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
        if(this.depot && model.getDepot()!=null) {
            entity.setDepot(depotConverter.toEntity(model.getDepot())) ;
        }
        if(this.produit && model.getProduit()!=null) {
            entity.setProduit(produitConverter.toEntity(model.getProduit())) ;
        }
        if(this.taxe && model.getTaxe()!=null) {
            entity.setTaxe(taxeConverter.toEntity(model.getTaxe())) ;
        }
        if(this.vente && model.getVente()!=null) {
            entity.setVente(venteConverter.toEntity(model.getVente())) ;
        }


        return entity;
        }
    }


    public void initObject(boolean value) {
        this.depot = value;
        this.produit = value;
        this.taxe = value;
        this.vente = value;
    }


    public ProduitInfraConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitInfraConverter(ProduitInfraConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public VenteInfraConverter getVenteConverter(){
        return this.venteConverter;
    }
    public void setVenteInfraConverter(VenteInfraConverter venteConverter ){
        this.venteConverter = venteConverter;
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
    public boolean  isDepot(){
        return this.depot;
    }
    public void  setDepot(boolean depot){
        this.depot = depot;
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
    public boolean  isVente(){
        return this.vente;
    }
    public void  setVente(boolean vente){
        this.vente = vente;
    }
}
