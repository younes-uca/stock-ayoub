package  ma.zs.easystock.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.helper.ListUtil;

import ma.zs.easystock.ws.converter.stock.ProduitConverter;
import ma.zs.easystock.ws.converter.stock.BonPourItemConverter;
import ma.zs.easystock.ws.converter.commun.ClientConverter;
import ma.zs.easystock.ws.converter.stock.TaxeConverter;



import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.helper.DateUtil;
import ma.zs.easystock.domain.model.stock.BonPour;
import ma.zs.easystock.ws.dto.stock.BonPourDto;

@Component
public class BonPourConverter extends AbstractConverter<BonPour, BonPourDto> {

    private ProduitConverter produitConverter ;
    private BonPourItemConverter bonPourItemConverter ;
    private ClientConverter clientConverter ;
    private TaxeConverter taxeConverter ;
    private boolean client;
    private boolean bonPourItems;

    public  BonPourConverter(){
        super(BonPour.class, BonPourDto.class);
        init(true);
    }

    @Override
    public BonPour toItem(BonPourDto dto) {
        if (dto == null) {
            return null;
        } else {
        BonPour item = new BonPour();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getNumeroBonPour()))
                item.setNumeroBonPour(dto.getNumeroBonPour());
            if(StringUtil.isNotEmpty(dto.getDateBonPour()))
                item.setDateBonPour(DateUtil.stringEnToDate(dto.getDateBonPour()));
            if(StringUtil.isNotEmpty(dto.getMontantHt()))
                item.setMontantHt(dto.getMontantHt());
            if(StringUtil.isNotEmpty(dto.getMontantTva()))
                item.setMontantTva(dto.getMontantTva());
            if(StringUtil.isNotEmpty(dto.getMontantTtc()))
                item.setMontantTtc(dto.getMontantTtc());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.client && dto.getClient()!=null &&  dto.getClient().getId() != null)
                item.setClient(clientConverter.toItem(dto.getClient())) ;


            if(this.bonPourItems && ListUtil.isNotEmpty(dto.getBonPourItems()))
                item.setBonPourItems(bonPourItemConverter.toItem(dto.getBonPourItems()));


        return item;
        }
    }

    @Override
    public BonPourDto toDto(BonPour item) {
        if (item == null) {
            return null;
        } else {
            BonPourDto dto = new BonPourDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getNumeroBonPour()))
                dto.setNumeroBonPour(item.getNumeroBonPour());
            if(item.getDateBonPour()!=null)
                dto.setDateBonPour(DateUtil.dateTimeToString(item.getDateBonPour()));
            if(StringUtil.isNotEmpty(item.getMontantHt()))
                dto.setMontantHt(item.getMontantHt());
            if(StringUtil.isNotEmpty(item.getMontantTva()))
                dto.setMontantTva(item.getMontantTva());
            if(StringUtil.isNotEmpty(item.getMontantTtc()))
                dto.setMontantTtc(item.getMontantTtc());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.client && item.getClient()!=null) {
            dto.setClient(clientConverter.toDto(item.getClient())) ;
        }
        if(this.bonPourItems && ListUtil.isNotEmpty(item.getBonPourItems())){
            bonPourItemConverter.init(true);
            bonPourItemConverter.setBonPour(false);
            dto.setBonPourItems(bonPourItemConverter.toDto(item.getBonPourItems()));
            bonPourItemConverter.setBonPour(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.bonPourItems = value;
    }

    public boolean  isClient(){
        return this.client;
    }
    public void  setClient(boolean client){
        this.client = client;
    }
    public boolean  isBonPourItems(){
        return this.bonPourItems ;
    }
    public void  setBonPourItems(boolean bonPourItems ){
        this.bonPourItems  = bonPourItems ;
    }
}
