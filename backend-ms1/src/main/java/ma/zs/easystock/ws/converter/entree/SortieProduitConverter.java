package  ma.zs.easystock.ws.converter.entree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.helper.ListUtil;

import ma.zs.easystock.ws.converter.stock.SortieProduitItemConverter;
import ma.zs.easystock.ws.converter.stock.ProduitConverter;
import ma.zs.easystock.ws.converter.commun.DepotConverter;



import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.helper.DateUtil;
import ma.zs.easystock.domain.model.entree.SortieProduit;
import ma.zs.easystock.ws.dto.entree.SortieProduitDto;

@Component
public class SortieProduitConverter extends AbstractConverter<SortieProduit, SortieProduitDto> {

    private SortieProduitItemConverter sortieProduitItemConverter ;
    private ProduitConverter produitConverter ;
    private DepotConverter depotConverter ;
    private boolean depot;
    private boolean sortieProduitItems;

    public  SortieProduitConverter(){
        super(SortieProduit.class, SortieProduitDto.class);
        init(true);
    }

    @Override
    public SortieProduit toItem(SortieProduitDto dto) {
        if (dto == null) {
            return null;
        } else {
        SortieProduit item = new SortieProduit();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDateSortieProduit()))
                item.setDateSortieProduit(DateUtil.stringEnToDate(dto.getDateSortieProduit()));
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.depot && dto.getDepot()!=null &&  dto.getDepot().getId() != null)
                item.setDepot(depotConverter.toItem(dto.getDepot())) ;


            if(this.sortieProduitItems && ListUtil.isNotEmpty(dto.getSortieProduitItems()))
                item.setSortieProduitItems(sortieProduitItemConverter.toItem(dto.getSortieProduitItems()));


        return item;
        }
    }

    @Override
    public SortieProduitDto toDto(SortieProduit item) {
        if (item == null) {
            return null;
        } else {
            SortieProduitDto dto = new SortieProduitDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDateSortieProduit()!=null)
                dto.setDateSortieProduit(DateUtil.dateTimeToString(item.getDateSortieProduit()));
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.depot && item.getDepot()!=null) {
            dto.setDepot(depotConverter.toDto(item.getDepot())) ;
        }
        if(this.sortieProduitItems && ListUtil.isNotEmpty(item.getSortieProduitItems())){
            sortieProduitItemConverter.init(true);
            sortieProduitItemConverter.setSortieProduit(false);
            dto.setSortieProduitItems(sortieProduitItemConverter.toDto(item.getSortieProduitItems()));
            sortieProduitItemConverter.setSortieProduit(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.sortieProduitItems = value;
    }

    public boolean  isDepot(){
        return this.depot;
    }
    public void  setDepot(boolean depot){
        this.depot = depot;
    }
    public boolean  isSortieProduitItems(){
        return this.sortieProduitItems ;
    }
    public void  setSortieProduitItems(boolean sortieProduitItems ){
        this.sortieProduitItems  = sortieProduitItems ;
    }
}
