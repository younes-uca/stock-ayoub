package ma.zs.easystock.infra.bean.core.stock;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.infra.bean.core.commun.EtatAvoirAchatEntity;
import ma.zs.easystock.infra.bean.core.commun.DepotEntity;
import ma.zs.easystock.infra.bean.core.commun.FournisseurEntity;
import ma.zs.easystock.infra.bean.core.commun.EntrepriseSocieteEntity;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "avoir_achat")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AvoirAchatEntity   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String barCode;
    @Column(length = 500)
    private String codeAvoirAchat;
    @Column(length = 500)
    private String numeroFactureAvoirAchat;
    private LocalDateTime dateFactureAvoirAchat ;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTva = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private EntrepriseSocieteEntity entrepriseSociete ;
    private FournisseurEntity fournisseur ;
    private EtatAvoirAchatEntity etatAvoirAchat ;

    private List<AvoirAchatItemEntity> avoirAchatItems ;

    public AvoirAchatEntity(){
        super();
    }

    public AvoirAchatEntity(Long id,String numeroFactureAvoirAchat){
        this.id = id;
        this.numeroFactureAvoirAchat = numeroFactureAvoirAchat ;
    }
    public AvoirAchatEntity(String numeroFactureAvoirAchat){
        this.numeroFactureAvoirAchat = numeroFactureAvoirAchat ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="avoir_achat_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }    public String getBarCode(){
        return this.barCode;
    }
    public void setBarCode(String barCode){
        this.barCode = barCode;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public EntrepriseSocieteEntity getEntrepriseSociete(){
        return this.entrepriseSociete;
    }
    public void setEntrepriseSociete(EntrepriseSocieteEntity entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public String getCodeAvoirAchat(){
        return this.codeAvoirAchat;
    }
    public void setCodeAvoirAchat(String codeAvoirAchat){
        this.codeAvoirAchat = codeAvoirAchat;
    }    public String getNumeroFactureAvoirAchat(){
        return this.numeroFactureAvoirAchat;
    }
    public void setNumeroFactureAvoirAchat(String numeroFactureAvoirAchat){
        this.numeroFactureAvoirAchat = numeroFactureAvoirAchat;
    }    public LocalDateTime getDateFactureAvoirAchat(){
        return this.dateFactureAvoirAchat;
    }
    public void setDateFactureAvoirAchat(LocalDateTime dateFactureAvoirAchat){
        this.dateFactureAvoirAchat = dateFactureAvoirAchat;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public FournisseurEntity getFournisseur(){
        return this.fournisseur;
    }
    public void setFournisseur(FournisseurEntity fournisseur){
        this.fournisseur = fournisseur;
    }
    @ManyToOne(fetch = FetchType.LAZY)

    public EtatAvoirAchatEntity getEtatAvoirAchat(){
        return this.etatAvoirAchat;
    }
    public void setEtatAvoirAchat(EtatAvoirAchatEntity etatAvoirAchat){
        this.etatAvoirAchat = etatAvoirAchat;
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
    }    @OneToMany(mappedBy = "avoirAchat")

    public List<AvoirAchatItemEntity> getAvoirAchatItems(){
        return this.avoirAchatItems;
    }
    public void setAvoirAchatItems(List<AvoirAchatItemEntity> avoirAchatItems){
        this.avoirAchatItems = avoirAchatItems;
    }

    @Transient
    public String getLabel() {
        label = numeroFactureAvoirAchat;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvoirAchatEntity avoirAchat = (AvoirAchatEntity) o;
        return id != null && id.equals(avoirAchat.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

