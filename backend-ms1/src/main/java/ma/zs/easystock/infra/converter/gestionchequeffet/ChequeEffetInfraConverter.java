package  ma.zs.easystock.infra.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;



import ma.zs.easystock.infra.converter.commun.FournisseurInfraConverter;



import ma.zs.easystock.infra.bean.core.gestionchequeffet.ChequeEffetEntity;
import ma.zs.easystock.domain.model.gestionchequeffet.ChequeEffet;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class ChequeEffetInfraConverter extends AbstractInfraConverter<ChequeEffetEntity, ChequeEffet> {

    @Autowired
    private FournisseurInfraConverter fournisseurConverter ;
    private boolean beneficiaire;

    public  ChequeEffetInfraConverter(){
        super(ChequeEffetEntity.class, ChequeEffet.class);
    }

    @Override
    public ChequeEffet toModel(ChequeEffetEntity entity) {
        if (entity == null) {
            return null;
        } else {
        ChequeEffet model = new ChequeEffet();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getNumeroChequeEffet()))
                model.setNumeroChequeEffet(entity.getNumeroChequeEffet());
            if(StringUtil.isNotEmpty(entity.getDateEmission()))
                model.setDateEmission(DateUtil.stringEnToDate(entity.getDateEmission()));
            if(StringUtil.isNotEmpty(entity.getMontant()))
                model.setMontant(entity.getMontant());
            if(this.beneficiaire && entity.getBeneficiaire()!=null &&  entity.getBeneficiaire().getId() != null)
                model.setBeneficiaire(fournisseurConverter.toModel(entity.getBeneficiaire())) ;




        return model;
        }
    }

    @Override
    public ChequeEffetEntity toEntity(ChequeEffet model) {
        if (model == null) {
            return null;
        } else {
            ChequeEffetEntity entity = new ChequeEffetEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getNumeroChequeEffet()))
             entity.setNumeroChequeEffet(model.getNumeroChequeEffet());
            if(model.getDateEmission()!=null)
             entity.setDateEmission(DateUtil.dateTimeToString(model.getDateEmission()));
            if(StringUtil.isNotEmpty(model.getMontant()))
             entity.setMontant(model.getMontant());
        if(this.beneficiaire && model.getBeneficiaire()!=null) {
            entity.setBeneficiaire(fournisseurConverter.toEntity(model.getBeneficiaire())) ;
        }


        return entity;
        }
    }


    public void initObject(boolean value) {
        this.beneficiaire = value;
    }


    public FournisseurInfraConverter getFournisseurConverter(){
        return this.fournisseurConverter;
    }
    public void setFournisseurInfraConverter(FournisseurInfraConverter fournisseurConverter ){
        this.fournisseurConverter = fournisseurConverter;
    }
    public boolean  isBeneficiaire(){
        return this.beneficiaire;
    }
    public void  setBeneficiaire(boolean beneficiaire){
        this.beneficiaire = beneficiaire;
    }
}
