package ma.zs.easystock.infra.bean.core.reglement;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.infra.bean.core.commun.ModeReglementEntity;
import ma.zs.easystock.infra.bean.core.stock.AvoirVenteEntity;
import ma.zs.easystock.infra.bean.core.stock.VenteEntity;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "reglement_avoir_vente")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReglementAvoirVenteEntity   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime dateReglement ;
    private BigDecimal montant = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private VenteEntity vente ;
    private ModeReglementEntity modeReglement ;
    private AvoirVenteEntity avoirVente ;


    public ReglementAvoirVenteEntity(){
        super();
    }

    public ReglementAvoirVenteEntity(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }
    public ReglementAvoirVenteEntity(String reference){
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="reglement_avoir_vente_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }    public LocalDateTime getDateReglement(){
        return this.dateReglement;
    }
    public void setDateReglement(LocalDateTime dateReglement){
        this.dateReglement = dateReglement;
    }    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public VenteEntity getVente(){
        return this.vente;
    }
    public void setVente(VenteEntity vente){
        this.vente = vente;
    }
    @ManyToOne(fetch = FetchType.LAZY)

    public ModeReglementEntity getModeReglement(){
        return this.modeReglement;
    }
    public void setModeReglement(ModeReglementEntity modeReglement){
        this.modeReglement = modeReglement;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public AvoirVenteEntity getAvoirVente(){
        return this.avoirVente;
    }
    public void setAvoirVente(AvoirVenteEntity avoirVente){
        this.avoirVente = avoirVente;
    }

    @Transient
    public String getLabel() {
        label = reference;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReglementAvoirVenteEntity reglementAvoirVente = (ReglementAvoirVenteEntity) o;
        return id != null && id.equals(reglementAvoirVente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

