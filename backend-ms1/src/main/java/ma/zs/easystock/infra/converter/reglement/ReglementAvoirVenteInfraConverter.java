package  ma.zs.easystock.infra.converter.reglement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;



import ma.zs.easystock.infra.converter.commun.ModeReglementInfraConverter;
import ma.zs.easystock.infra.converter.stock.AvoirVenteInfraConverter;
import ma.zs.easystock.infra.converter.stock.VenteInfraConverter;

import ma.zs.easystock.infra.bean.core.stock.VenteEntity;
import ma.zs.easystock.domain.model.stock.Vente;
import ma.zs.easystock.infra.bean.core.stock.AvoirVenteEntity;
import ma.zs.easystock.domain.model.stock.AvoirVente;


import ma.zs.easystock.infra.bean.core.reglement.ReglementAvoirVenteEntity;
import ma.zs.easystock.domain.model.reglement.ReglementAvoirVente;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class ReglementAvoirVenteInfraConverter extends AbstractInfraConverter<ReglementAvoirVenteEntity, ReglementAvoirVente> {

    @Autowired
    private ModeReglementInfraConverter modeReglementConverter ;
    @Autowired
    private AvoirVenteInfraConverter avoirVenteConverter ;
    @Autowired
    private VenteInfraConverter venteConverter ;
    private boolean vente;
    private boolean modeReglement;
    private boolean avoirVente;

    public  ReglementAvoirVenteInfraConverter(){
        super(ReglementAvoirVenteEntity.class, ReglementAvoirVente.class);
    }

    @Override
    public ReglementAvoirVente toModel(ReglementAvoirVenteEntity entity) {
        if (entity == null) {
            return null;
        } else {
        ReglementAvoirVente model = new ReglementAvoirVente();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getReference()))
                model.setReference(entity.getReference());
            if(StringUtil.isNotEmpty(entity.getDateReglement()))
                model.setDateReglement(DateUtil.stringEnToDate(entity.getDateReglement()));
            if(StringUtil.isNotEmpty(entity.getMontant()))
                model.setMontant(entity.getMontant());
            if(StringUtil.isNotEmpty(entity.getDescription()))
                model.setDescription(entity.getDescription());
            if(entity.getVente() != null && entity.getVente().getId() != null){
                model.setVente(new Vente());
                model.getVente().setId(entity.getVente().getId());
                model.getVente().setNumeroFacture(entity.getVente().getNumeroFacture());
            }

            if(this.modeReglement && entity.getModeReglement()!=null &&  entity.getModeReglement().getId() != null)
                model.setModeReglement(modeReglementConverter.toModel(entity.getModeReglement())) ;

            if(entity.getAvoirVente() != null && entity.getAvoirVente().getId() != null){
                model.setAvoirVente(new AvoirVente());
                model.getAvoirVente().setId(entity.getAvoirVente().getId());
                model.getAvoirVente().setNumeroFactureAvoirVente(entity.getAvoirVente().getNumeroFactureAvoirVente());
            }




        return model;
        }
    }

    @Override
    public ReglementAvoirVenteEntity toEntity(ReglementAvoirVente model) {
        if (model == null) {
            return null;
        } else {
            ReglementAvoirVenteEntity entity = new ReglementAvoirVenteEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getReference()))
             entity.setReference(model.getReference());
            if(model.getDateReglement()!=null)
             entity.setDateReglement(DateUtil.dateTimeToString(model.getDateReglement()));
            if(StringUtil.isNotEmpty(model.getMontant()))
             entity.setMontant(model.getMontant());
            if(StringUtil.isNotEmpty(model.getDescription()))
             entity.setDescription(model.getDescription());
        if(this.vente && model.getVente()!=null) {
            entity.setVente(venteConverter.toEntity(model.getVente())) ;
        }
        if(this.modeReglement && model.getModeReglement()!=null) {
            entity.setModeReglement(modeReglementConverter.toEntity(model.getModeReglement())) ;
        }
        if(this.avoirVente && model.getAvoirVente()!=null) {
            entity.setAvoirVente(avoirVenteConverter.toEntity(model.getAvoirVente())) ;
        }


        return entity;
        }
    }


    public void initObject(boolean value) {
        this.vente = value;
        this.modeReglement = value;
        this.avoirVente = value;
    }


    public ModeReglementInfraConverter getModeReglementConverter(){
        return this.modeReglementConverter;
    }
    public void setModeReglementInfraConverter(ModeReglementInfraConverter modeReglementConverter ){
        this.modeReglementConverter = modeReglementConverter;
    }
    public AvoirVenteInfraConverter getAvoirVenteConverter(){
        return this.avoirVenteConverter;
    }
    public void setAvoirVenteInfraConverter(AvoirVenteInfraConverter avoirVenteConverter ){
        this.avoirVenteConverter = avoirVenteConverter;
    }
    public VenteInfraConverter getVenteConverter(){
        return this.venteConverter;
    }
    public void setVenteInfraConverter(VenteInfraConverter venteConverter ){
        this.venteConverter = venteConverter;
    }
    public boolean  isVente(){
        return this.vente;
    }
    public void  setVente(boolean vente){
        this.vente = vente;
    }
    public boolean  isModeReglement(){
        return this.modeReglement;
    }
    public void  setModeReglement(boolean modeReglement){
        this.modeReglement = modeReglement;
    }
    public boolean  isAvoirVente(){
        return this.avoirVente;
    }
    public void  setAvoirVente(boolean avoirVente){
        this.avoirVente = avoirVente;
    }
}
