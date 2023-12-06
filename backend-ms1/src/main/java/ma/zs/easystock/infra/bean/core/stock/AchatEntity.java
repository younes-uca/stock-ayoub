package ma.zs.easystock.infra.bean.core.stock;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.infra.bean.core.commun.EtatAchatEntity;
import ma.zs.easystock.infra.bean.core.commun.EntrepriseSocieteEntity;
import ma.zs.easystock.infra.bean.core.commun.EtatAvoirAchatEntity;
import ma.zs.easystock.infra.bean.core.commun.DepotEntity;
import ma.zs.easystock.infra.bean.core.commun.FournisseurEntity;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "achat")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AchatEntity   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateFacture ;
    @Column(length = 500)
    private String referenceFacture;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTva = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private EntrepriseSocieteEntity entrepriseSociete ;
    private FournisseurEntity fournisseur ;
    private EtatAchatEntity etatAchat ;

    private List<AchatItemEntity> achatItems ;
    private List<AvoirAchatEntity> avoirs ;

    public AchatEntity(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="achat_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public EntrepriseSocieteEntity getEntrepriseSociete(){
        return this.entrepriseSociete;
    }
    public void setEntrepriseSociete(EntrepriseSocieteEntity entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public LocalDateTime getDateFacture(){
        return this.dateFacture;
    }
    public void setDateFacture(LocalDateTime dateFacture){
        this.dateFacture = dateFacture;
    }    public String getReferenceFacture(){
        return this.referenceFacture;
    }
    public void setReferenceFacture(String referenceFacture){
        this.referenceFacture = referenceFacture;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public FournisseurEntity getFournisseur(){
        return this.fournisseur;
    }
    public void setFournisseur(FournisseurEntity fournisseur){
        this.fournisseur = fournisseur;
    }
    @ManyToOne(fetch = FetchType.LAZY)

    public EtatAchatEntity getEtatAchat(){
        return this.etatAchat;
    }
    public void setEtatAchat(EtatAchatEntity etatAchat){
        this.etatAchat = etatAchat;
    }
    public BigDecimal getMontantHt(){
        return this.montantHt;
    }
    public void setMontantHt(BigDecimal montantHt){
        this.montantHt = montantHt;
    }    public BigDecimal getMontantTva(){
        return this.montantTva;
    }
    public void setMontantTva(BigDecimal montantTva){
        this.montantTva = montantTva;
    }    public BigDecimal getMontantTtc(){
        return this.montantTtc;
    }
    public void setMontantTtc(BigDecimal montantTtc){
        this.montantTtc = montantTtc;
    }    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }    @OneToMany(mappedBy = "achat")

    public List<AchatItemEntity> getAchatItems(){
        return this.achatItems;
    }
    public void setAchatItems(List<AchatItemEntity> achatItems){
        this.achatItems = achatItems;
    }
    @OneToMany

    public List<AvoirAchatEntity> getAvoirs(){
        return this.avoirs;
    }
    public void setAvoirs(List<AvoirAchatEntity> avoirs){
        this.avoirs = avoirs;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AchatEntity achat = (AchatEntity) o;
        return id != null && id.equals(achat.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

