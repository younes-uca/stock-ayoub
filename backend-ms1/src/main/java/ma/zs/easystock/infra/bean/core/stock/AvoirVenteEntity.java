package ma.zs.easystock.infra.bean.core.stock;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.infra.bean.core.commun.EtatAvoirVenteEntity;
import ma.zs.easystock.infra.bean.core.commun.DepotEntity;
import ma.zs.easystock.infra.bean.core.commun.EntrepriseSocieteEntity;
import ma.zs.easystock.infra.bean.core.commun.ClientEntity;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "avoir_vente")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AvoirVenteEntity   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String barCode;
    @Column(length = 500)
    private String codeAvoirVente;
    @Column(length = 500)
    private String numeroFactureAvoirVente;
    private LocalDateTime dateFactureAvoirVente ;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTva = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private EntrepriseSocieteEntity entrepriseSociete ;
    private ClientEntity client ;
    private EtatAvoirVenteEntity etatAvoirVente ;
    private AchatEntity achat ;

    private List<AvoirVenteItemEntity> avoirVenteItems ;
    private List<AvoirVenteItemEntity> avoirs ;

    public AvoirVenteEntity(){
        super();
    }

    public AvoirVenteEntity(Long id,String numeroFactureAvoirVente){
        this.id = id;
        this.numeroFactureAvoirVente = numeroFactureAvoirVente ;
    }
    public AvoirVenteEntity(String numeroFactureAvoirVente){
        this.numeroFactureAvoirVente = numeroFactureAvoirVente ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="avoir_vente_seq")
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
    public String getCodeAvoirVente(){
        return this.codeAvoirVente;
    }
    public void setCodeAvoirVente(String codeAvoirVente){
        this.codeAvoirVente = codeAvoirVente;
    }    public String getNumeroFactureAvoirVente(){
        return this.numeroFactureAvoirVente;
    }
    public void setNumeroFactureAvoirVente(String numeroFactureAvoirVente){
        this.numeroFactureAvoirVente = numeroFactureAvoirVente;
    }    public LocalDateTime getDateFactureAvoirVente(){
        return this.dateFactureAvoirVente;
    }
    public void setDateFactureAvoirVente(LocalDateTime dateFactureAvoirVente){
        this.dateFactureAvoirVente = dateFactureAvoirVente;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public ClientEntity getClient(){
        return this.client;
    }
    public void setClient(ClientEntity client){
        this.client = client;
    }
    @ManyToOne(fetch = FetchType.LAZY)

    public EtatAvoirVenteEntity getEtatAvoirVente(){
        return this.etatAvoirVente;
    }
    public void setEtatAvoirVente(EtatAvoirVenteEntity etatAvoirVente){
        this.etatAvoirVente = etatAvoirVente;
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
    }    @OneToMany(mappedBy = "avoirVente")

    public List<AvoirVenteItemEntity> getAvoirVenteItems(){
        return this.avoirVenteItems;
    }
    public void setAvoirVenteItems(List<AvoirVenteItemEntity> avoirVenteItems){
        this.avoirVenteItems = avoirVenteItems;
    }
    @OneToMany(mappedBy = "avoirVente")

    public List<AvoirVenteItemEntity> getAvoirs(){
        return this.avoirs;
    }
    public void setAvoirs(List<AvoirVenteItemEntity> avoirs){
        this.avoirs = avoirs;
    }
    @ManyToOne(fetch = FetchType.LAZY)

    public AchatEntity getAchat(){
        return this.achat;
    }
    public void setAchat(AchatEntity achat){
        this.achat = achat;
    }

    @Transient
    public String getLabel() {
        label = numeroFactureAvoirVente;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvoirVenteEntity avoirVente = (AvoirVenteEntity) o;
        return id != null && id.equals(avoirVente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

