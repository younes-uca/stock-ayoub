package  ma.zs.easystock.infra.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;

import ma.zs.easystock.zynerator.helper.ListUtil;


import ma.zs.easystock.infra.converter.commun.MarqueInfraConverter;
import ma.zs.easystock.infra.converter.commun.UniteMesureInfraConverter;
import ma.zs.easystock.infra.converter.stock.StockInfraConverter;
import ma.zs.easystock.infra.converter.commun.EntrepriseSocieteInfraConverter;
import ma.zs.easystock.infra.converter.commun.CategorieInfraConverter;
import ma.zs.easystock.infra.converter.commun.DepotInfraConverter;



import ma.zs.easystock.infra.bean.core.stock.ProduitEntity;
import ma.zs.easystock.domain.model.stock.Produit;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class ProduitInfraConverter extends AbstractInfraConverter<ProduitEntity, Produit> {

    @Autowired
    private MarqueInfraConverter marqueConverter ;
    @Autowired
    private UniteMesureInfraConverter uniteMesureConverter ;
    @Autowired
    private StockInfraConverter stockConverter ;
    @Autowired
    private EntrepriseSocieteInfraConverter entrepriseSocieteConverter ;
    @Autowired
    private CategorieInfraConverter categorieConverter ;
    @Autowired
    private DepotInfraConverter depotConverter ;
    private boolean entrepriseSociete;
    private boolean categorie;
    private boolean marque;
    private boolean uniteMesure;
    private boolean stocks;

    public  ProduitInfraConverter(){
        super(ProduitEntity.class, Produit.class);
        init(true);
    }

    @Override
    public Produit toModel(ProduitEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Produit model = new Produit();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getReference()))
                model.setReference(entity.getReference());
            if(StringUtil.isNotEmpty(entity.getBarCode()))
                model.setBarCode(entity.getBarCode());
            if(StringUtil.isNotEmpty(entity.getDesignation()))
                model.setDesignation(entity.getDesignation());
            if(StringUtil.isNotEmpty(entity.getQuantite()))
                model.setQuantite(entity.getQuantite());
            if(StringUtil.isNotEmpty(entity.getPrixAchatMoyen()))
                model.setPrixAchatMoyen(entity.getPrixAchatMoyen());
            if(StringUtil.isNotEmpty(entity.getPrixVente()))
                model.setPrixVente(entity.getPrixVente());
            if(StringUtil.isNotEmpty(entity.getPathPhoto()))
                model.setPathPhoto(entity.getPathPhoto());
            if(StringUtil.isNotEmpty(entity.getSeuilAlerte()))
                model.setSeuilAlerte(entity.getSeuilAlerte());
            if(StringUtil.isNotEmpty(entity.getDescription()))
                model.setDescription(entity.getDescription());
            if(this.entrepriseSociete && entity.getEntrepriseSociete()!=null &&  entity.getEntrepriseSociete().getId() != null)
                model.setEntrepriseSociete(entrepriseSocieteConverter.toModel(entity.getEntrepriseSociete())) ;

            if(this.categorie && entity.getCategorie()!=null &&  entity.getCategorie().getId() != null)
                model.setCategorie(categorieConverter.toModel(entity.getCategorie())) ;

            if(this.marque && entity.getMarque()!=null &&  entity.getMarque().getId() != null)
                model.setMarque(marqueConverter.toModel(entity.getMarque())) ;

            if(this.uniteMesure && entity.getUniteMesure()!=null &&  entity.getUniteMesure().getId() != null)
                model.setUniteMesure(uniteMesureConverter.toModel(entity.getUniteMesure())) ;


            if(this.stocks && ListUtil.isNotEmpty(entity.getStocks()))
                model.setStocks(stockConverter.toModel(entity.getStocks()));


        return model;
        }
    }

    @Override
    public ProduitEntity toEntity(Produit model) {
        if (model == null) {
            return null;
        } else {
            ProduitEntity entity = new ProduitEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getReference()))
             entity.setReference(model.getReference());
            if(StringUtil.isNotEmpty(model.getBarCode()))
             entity.setBarCode(model.getBarCode());
            if(StringUtil.isNotEmpty(model.getDesignation()))
             entity.setDesignation(model.getDesignation());
            if(StringUtil.isNotEmpty(model.getQuantite()))
             entity.setQuantite(model.getQuantite());
            if(StringUtil.isNotEmpty(model.getPrixAchatMoyen()))
             entity.setPrixAchatMoyen(model.getPrixAchatMoyen());
            if(StringUtil.isNotEmpty(model.getPrixVente()))
             entity.setPrixVente(model.getPrixVente());
            if(StringUtil.isNotEmpty(model.getPathPhoto()))
             entity.setPathPhoto(model.getPathPhoto());
            if(StringUtil.isNotEmpty(model.getSeuilAlerte()))
             entity.setSeuilAlerte(model.getSeuilAlerte());
            if(StringUtil.isNotEmpty(model.getDescription()))
             entity.setDescription(model.getDescription());
        if(this.entrepriseSociete && model.getEntrepriseSociete()!=null) {
            entity.setEntrepriseSociete(entrepriseSocieteConverter.toEntity(model.getEntrepriseSociete())) ;
        }
        if(this.categorie && model.getCategorie()!=null) {
            entity.setCategorie(categorieConverter.toEntity(model.getCategorie())) ;
        }
        if(this.marque && model.getMarque()!=null) {
            entity.setMarque(marqueConverter.toEntity(model.getMarque())) ;
        }
        if(this.uniteMesure && model.getUniteMesure()!=null) {
            entity.setUniteMesure(uniteMesureConverter.toEntity(model.getUniteMesure())) ;
        }
        if(this.stocks && ListUtil.isNotEmpty(model.getStocks())){
            stockConverter.init(true);
            stockConverter.setProduit(false);
            entity.setStocks(stockConverter.toEntity(model.getStocks()));
            stockConverter.setProduit(true);

        }


        return entity;
        }
    }

    public void initList(boolean value) {
        this.stocks = value;
    }

    public void initObject(boolean value) {
        this.entrepriseSociete = value;
        this.categorie = value;
        this.marque = value;
        this.uniteMesure = value;
    }


    public MarqueInfraConverter getMarqueConverter(){
        return this.marqueConverter;
    }
    public void setMarqueInfraConverter(MarqueInfraConverter marqueConverter ){
        this.marqueConverter = marqueConverter;
    }
    public UniteMesureInfraConverter getUniteMesureConverter(){
        return this.uniteMesureConverter;
    }
    public void setUniteMesureInfraConverter(UniteMesureInfraConverter uniteMesureConverter ){
        this.uniteMesureConverter = uniteMesureConverter;
    }
    public StockInfraConverter getStockConverter(){
        return this.stockConverter;
    }
    public void setStockInfraConverter(StockInfraConverter stockConverter ){
        this.stockConverter = stockConverter;
    }
    public EntrepriseSocieteInfraConverter getEntrepriseSocieteConverter(){
        return this.entrepriseSocieteConverter;
    }
    public void setEntrepriseSocieteInfraConverter(EntrepriseSocieteInfraConverter entrepriseSocieteConverter ){
        this.entrepriseSocieteConverter = entrepriseSocieteConverter;
    }
    public CategorieInfraConverter getCategorieConverter(){
        return this.categorieConverter;
    }
    public void setCategorieInfraConverter(CategorieInfraConverter categorieConverter ){
        this.categorieConverter = categorieConverter;
    }
    public DepotInfraConverter getDepotConverter(){
        return this.depotConverter;
    }
    public void setDepotInfraConverter(DepotInfraConverter depotConverter ){
        this.depotConverter = depotConverter;
    }
    public boolean  isEntrepriseSociete(){
        return this.entrepriseSociete;
    }
    public void  setEntrepriseSociete(boolean entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public boolean  isCategorie(){
        return this.categorie;
    }
    public void  setCategorie(boolean categorie){
        this.categorie = categorie;
    }
    public boolean  isMarque(){
        return this.marque;
    }
    public void  setMarque(boolean marque){
        this.marque = marque;
    }
    public boolean  isUniteMesure(){
        return this.uniteMesure;
    }
    public void  setUniteMesure(boolean uniteMesure){
        this.uniteMesure = uniteMesure;
    }
    public boolean  isStocks(){
        return this.stocks ;
    }
    public void  setStocks(boolean stocks ){
        this.stocks  = stocks ;
    }
}
