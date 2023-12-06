package  ma.zs.easystock.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.helper.ListUtil;

import ma.zs.easystock.ws.converter.commun.MarqueConverter;
import ma.zs.easystock.ws.converter.commun.UniteMesureConverter;
import ma.zs.easystock.ws.converter.stock.StockConverter;
import ma.zs.easystock.ws.converter.commun.EntrepriseSocieteConverter;
import ma.zs.easystock.ws.converter.commun.CategorieConverter;
import ma.zs.easystock.ws.converter.commun.DepotConverter;



import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.helper.DateUtil;
import ma.zs.easystock.domain.model.stock.Produit;
import ma.zs.easystock.ws.dto.stock.ProduitDto;

@Component
public class ProduitConverter extends AbstractConverter<Produit, ProduitDto> {

    private MarqueConverter marqueConverter ;
    private UniteMesureConverter uniteMesureConverter ;
    private StockConverter stockConverter ;
    private EntrepriseSocieteConverter entrepriseSocieteConverter ;
    private CategorieConverter categorieConverter ;
    private DepotConverter depotConverter ;
    private boolean entrepriseSociete;
    private boolean categorie;
    private boolean marque;
    private boolean uniteMesure;
    private boolean stocks;

    public  ProduitConverter(){
        super(Produit.class, ProduitDto.class);
        init(true);
    }

    @Override
    public Produit toItem(ProduitDto dto) {
        if (dto == null) {
            return null;
        } else {
        Produit item = new Produit();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getBarCode()))
                item.setBarCode(dto.getBarCode());
            if(StringUtil.isNotEmpty(dto.getDesignation()))
                item.setDesignation(dto.getDesignation());
            if(StringUtil.isNotEmpty(dto.getQuantite()))
                item.setQuantite(dto.getQuantite());
            if(StringUtil.isNotEmpty(dto.getPrixAchatMoyen()))
                item.setPrixAchatMoyen(dto.getPrixAchatMoyen());
            if(StringUtil.isNotEmpty(dto.getPrixVente()))
                item.setPrixVente(dto.getPrixVente());
            if(StringUtil.isNotEmpty(dto.getPathPhoto()))
                item.setPathPhoto(dto.getPathPhoto());
            if(StringUtil.isNotEmpty(dto.getSeuilAlerte()))
                item.setSeuilAlerte(dto.getSeuilAlerte());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.entrepriseSociete && dto.getEntrepriseSociete()!=null &&  dto.getEntrepriseSociete().getId() != null)
                item.setEntrepriseSociete(entrepriseSocieteConverter.toItem(dto.getEntrepriseSociete())) ;

            if(this.categorie && dto.getCategorie()!=null &&  dto.getCategorie().getId() != null)
                item.setCategorie(categorieConverter.toItem(dto.getCategorie())) ;

            if(this.marque && dto.getMarque()!=null &&  dto.getMarque().getId() != null)
                item.setMarque(marqueConverter.toItem(dto.getMarque())) ;

            if(this.uniteMesure && dto.getUniteMesure()!=null &&  dto.getUniteMesure().getId() != null)
                item.setUniteMesure(uniteMesureConverter.toItem(dto.getUniteMesure())) ;


            if(this.stocks && ListUtil.isNotEmpty(dto.getStocks()))
                item.setStocks(stockConverter.toItem(dto.getStocks()));


        return item;
        }
    }

    @Override
    public ProduitDto toDto(Produit item) {
        if (item == null) {
            return null;
        } else {
            ProduitDto dto = new ProduitDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(StringUtil.isNotEmpty(item.getBarCode()))
                dto.setBarCode(item.getBarCode());
            if(StringUtil.isNotEmpty(item.getDesignation()))
                dto.setDesignation(item.getDesignation());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
            if(StringUtil.isNotEmpty(item.getPrixAchatMoyen()))
                dto.setPrixAchatMoyen(item.getPrixAchatMoyen());
            if(StringUtil.isNotEmpty(item.getPrixVente()))
                dto.setPrixVente(item.getPrixVente());
            if(StringUtil.isNotEmpty(item.getPathPhoto()))
                dto.setPathPhoto(item.getPathPhoto());
            if(StringUtil.isNotEmpty(item.getSeuilAlerte()))
                dto.setSeuilAlerte(item.getSeuilAlerte());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.entrepriseSociete && item.getEntrepriseSociete()!=null) {
            dto.setEntrepriseSociete(entrepriseSocieteConverter.toDto(item.getEntrepriseSociete())) ;
        }
        if(this.categorie && item.getCategorie()!=null) {
            dto.setCategorie(categorieConverter.toDto(item.getCategorie())) ;
        }
        if(this.marque && item.getMarque()!=null) {
            dto.setMarque(marqueConverter.toDto(item.getMarque())) ;
        }
        if(this.uniteMesure && item.getUniteMesure()!=null) {
            dto.setUniteMesure(uniteMesureConverter.toDto(item.getUniteMesure())) ;
        }
        if(this.stocks && ListUtil.isNotEmpty(item.getStocks())){
            stockConverter.init(true);
            stockConverter.setProduit(false);
            dto.setStocks(stockConverter.toDto(item.getStocks()));
            stockConverter.setProduit(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.stocks = value;
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
