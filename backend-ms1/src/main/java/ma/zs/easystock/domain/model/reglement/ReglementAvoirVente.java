package ma.zs.easystock.domain.model.reglement;

import java.util.Objects;
import java.time.LocalDateTime;
import java.util.Date;

import ma.zs.easystock.domain.model.commun.ModeReglement;
import ma.zs.easystock.domain.model.stock.AvoirVente;
import ma.zs.easystock.domain.model.stock.Vente;


import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;

import java.math.BigDecimal;



public class ReglementAvoirVente   extends AuditDomainObject     {

    private Long id;

    private String reference;
    private LocalDateTime dateReglement ;
    private BigDecimal montant = BigDecimal.ZERO;
    private String description;

    private Vente vente ;
    private ModeReglement modeReglement ;
    private AvoirVente avoirVente ;


    public ReglementAvoirVente(){
        super();
    }

    public ReglementAvoirVente(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }
    public ReglementAvoirVente(String reference){
        this.reference = reference ;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public LocalDateTime getDateReglement(){
        return this.dateReglement;
    }
    public void setDateReglement(LocalDateTime dateReglement){
        this.dateReglement = dateReglement;
    }
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }
    public Vente getVente(){
        return this.vente;
    }
    public void setVente(Vente vente){
        this.vente = vente;
    }
    public ModeReglement getModeReglement(){
        return this.modeReglement;
    }
    public void setModeReglement(ModeReglement modeReglement){
        this.modeReglement = modeReglement;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public AvoirVente getAvoirVente(){
        return this.avoirVente;
    }
    public void setAvoirVente(AvoirVente avoirVente){
        this.avoirVente = avoirVente;
    }

    public String getLabel() {
        label = reference;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReglementAvoirVente reglementAvoirVente = (ReglementAvoirVente) o;
        return id != null && id.equals(reglementAvoirVente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

