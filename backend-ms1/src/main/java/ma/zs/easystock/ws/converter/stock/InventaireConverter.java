package  ma.zs.easystock.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.helper.ListUtil;

import ma.zs.easystock.ws.converter.stock.ProduitConverter;
import ma.zs.easystock.ws.converter.stock.InventaireItemConverter;
import ma.zs.easystock.ws.converter.commun.EntrepriseSocieteConverter;
import ma.zs.easystock.ws.converter.commun.DepotConverter;



import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.helper.DateUtil;
import ma.zs.easystock.domain.model.stock.Inventaire;
import ma.zs.easystock.ws.dto.stock.InventaireDto;

@Component
public class InventaireConverter extends AbstractConverter<Inventaire, InventaireDto> {

    private ProduitConverter produitConverter ;
    private InventaireItemConverter inventaireItemConverter ;
    private EntrepriseSocieteConverter entrepriseSocieteConverter ;
    private DepotConverter depotConverter ;
    private boolean entrepriseSociete;
    private boolean depot;
    private boolean inventaireItems;

    public  InventaireConverter(){
        super(Inventaire.class, InventaireDto.class);
        init(true);
    }

    @Override
    public Inventaire toItem(InventaireDto dto) {
        if (dto == null) {
            return null;
        } else {
        Inventaire item = new Inventaire();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDateInventaire()))
                item.setDateInventaire(DateUtil.stringEnToDate(dto.getDateInventaire()));
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.entrepriseSociete && dto.getEntrepriseSociete()!=null &&  dto.getEntrepriseSociete().getId() != null)
                item.setEntrepriseSociete(entrepriseSocieteConverter.toItem(dto.getEntrepriseSociete())) ;

            if(this.depot && dto.getDepot()!=null &&  dto.getDepot().getId() != null)
                item.setDepot(depotConverter.toItem(dto.getDepot())) ;


            if(this.inventaireItems && ListUtil.isNotEmpty(dto.getInventaireItems()))
                item.setInventaireItems(inventaireItemConverter.toItem(dto.getInventaireItems()));


        return item;
        }
    }

    @Override
    public InventaireDto toDto(Inventaire item) {
        if (item == null) {
            return null;
        } else {
            InventaireDto dto = new InventaireDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDateInventaire()!=null)
                dto.setDateInventaire(DateUtil.dateTimeToString(item.getDateInventaire()));
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.entrepriseSociete && item.getEntrepriseSociete()!=null) {
            dto.setEntrepriseSociete(entrepriseSocieteConverter.toDto(item.getEntrepriseSociete())) ;
        }
        if(this.depot && item.getDepot()!=null) {
            dto.setDepot(depotConverter.toDto(item.getDepot())) ;
        }
        if(this.inventaireItems && ListUtil.isNotEmpty(item.getInventaireItems())){
            inventaireItemConverter.init(true);
            inventaireItemConverter.setInventaire(false);
            dto.setInventaireItems(inventaireItemConverter.toDto(item.getInventaireItems()));
            inventaireItemConverter.setInventaire(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.inventaireItems = value;
    }

    public boolean  isEntrepriseSociete(){
        return this.entrepriseSociete;
    }
    public void  setEntrepriseSociete(boolean entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public boolean  isDepot(){
        return this.depot;
    }
    public void  setDepot(boolean depot){
        this.depot = depot;
    }
    public boolean  isInventaireItems(){
        return this.inventaireItems ;
    }
    public void  setInventaireItems(boolean inventaireItems ){
        this.inventaireItems  = inventaireItems ;
    }
}
