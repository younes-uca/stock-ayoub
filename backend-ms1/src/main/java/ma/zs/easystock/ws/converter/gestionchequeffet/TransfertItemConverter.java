package  ma.zs.easystock.ws.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.easystock.ws.converter.stock.ProduitConverter;
import ma.zs.easystock.ws.converter.gestionchequeffet.TransfertConverter;
import ma.zs.easystock.ws.converter.commun.DepotConverter;

import ma.zs.easystock.domain.model.stock.Produit;
import ma.zs.easystock.domain.model.gestionchequeffet.Transfert;


import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.helper.DateUtil;
import ma.zs.easystock.domain.model.gestionchequeffet.TransfertItem;
import ma.zs.easystock.ws.dto.gestionchequeffet.TransfertItemDto;

@Component
public class TransfertItemConverter extends AbstractConverter<TransfertItem, TransfertItemDto> {

    private ProduitConverter produitConverter ;
    private TransfertConverter transfertConverter ;
    private DepotConverter depotConverter ;
    private boolean depot;
    private boolean produit;
    private boolean transfert;

    public  TransfertItemConverter(){
        super(TransfertItem.class, TransfertItemDto.class);
    }

    @Override
    public TransfertItem toItem(TransfertItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        TransfertItem item = new TransfertItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getQuantite()))
                item.setQuantite(dto.getQuantite());
            if(this.depot && dto.getDepot()!=null &&  dto.getDepot().getId() != null)
                item.setDepot(depotConverter.toItem(dto.getDepot())) ;

            if(dto.getProduit() != null && dto.getProduit().getId() != null){
                item.setProduit(new Produit());
                item.getProduit().setId(dto.getProduit().getId());
                item.getProduit().setSeuilAlerte(dto.getProduit().getSeuilAlerte());
            }

            if(dto.getTransfert() != null && dto.getTransfert().getId() != null){
                item.setTransfert(new Transfert());
                item.getTransfert().setId(dto.getTransfert().getId());
                item.getTransfert().setId(dto.getTransfert().getId());
            }




        return item;
        }
    }

    @Override
    public TransfertItemDto toDto(TransfertItem item) {
        if (item == null) {
            return null;
        } else {
            TransfertItemDto dto = new TransfertItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
        if(this.depot && item.getDepot()!=null) {
            dto.setDepot(depotConverter.toDto(item.getDepot())) ;
        }
        if(this.produit && item.getProduit()!=null) {
            dto.setProduit(produitConverter.toDto(item.getProduit())) ;
        }
        if(this.transfert && item.getTransfert()!=null) {
            dto.setTransfert(transfertConverter.toDto(item.getTransfert())) ;
        }


        return dto;
        }
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
    public boolean  isTransfert(){
        return this.transfert;
    }
    public void  setTransfert(boolean transfert){
        this.transfert = transfert;
    }
}
