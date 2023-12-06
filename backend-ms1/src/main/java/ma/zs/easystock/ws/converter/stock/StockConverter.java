package  ma.zs.easystock.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.easystock.ws.converter.stock.ProduitConverter;
import ma.zs.easystock.ws.converter.commun.DepotConverter;

import ma.zs.easystock.domain.model.stock.Produit;


import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.helper.DateUtil;
import ma.zs.easystock.domain.model.stock.Stock;
import ma.zs.easystock.ws.dto.stock.StockDto;

@Component
public class StockConverter extends AbstractConverter<Stock, StockDto> {

    private ProduitConverter produitConverter ;
    private DepotConverter depotConverter ;
    private boolean produit;
    private boolean depot;

    public  StockConverter(){
        super(Stock.class, StockDto.class);
    }

    @Override
    public Stock toItem(StockDto dto) {
        if (dto == null) {
            return null;
        } else {
        Stock item = new Stock();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getQuantite()))
                item.setQuantite(dto.getQuantite());
            if(dto.getProduit() != null && dto.getProduit().getId() != null){
                item.setProduit(new Produit());
                item.getProduit().setId(dto.getProduit().getId());
                item.getProduit().setSeuilAlerte(dto.getProduit().getSeuilAlerte());
            }

            if(this.depot && dto.getDepot()!=null &&  dto.getDepot().getId() != null)
                item.setDepot(depotConverter.toItem(dto.getDepot())) ;




        return item;
        }
    }

    @Override
    public StockDto toDto(Stock item) {
        if (item == null) {
            return null;
        } else {
            StockDto dto = new StockDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
        if(this.produit && item.getProduit()!=null) {
            dto.setProduit(produitConverter.toDto(item.getProduit())) ;
        }
        if(this.depot && item.getDepot()!=null) {
            dto.setDepot(depotConverter.toDto(item.getDepot())) ;
        }


        return dto;
        }
    }


    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isDepot(){
        return this.depot;
    }
    public void  setDepot(boolean depot){
        this.depot = depot;
    }
}
