package ma.zs.easystock.infra.bean.core.stock;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.infra.bean.core.commun.EntrepriseSocieteEntity;
import ma.zs.easystock.infra.bean.core.commun.EtatAvoirVenteEntity;
import ma.zs.easystock.infra.bean.core.commun.DepotEntity;
import ma.zs.easystock.infra.bean.core.commun.EtatVenteEntity;
import ma.zs.easystock.infra.bean.core.commun.ClientEntity;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "vente")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VenteEntity   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String barCode;
    @Column(length = 500)
    private String codeVente;
    private LocalDateTime dateFacture ;
    @Column(length = 500)
    private String numeroFacture;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTva = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private EntrepriseSocieteEntity entrepriseSociete ;
    private ClientEntity client ;
    private EtatVenteEntity etatVente ;

    private List<VenteItemEntity> venteItems ;
    private List<AvoirVenteEntity> avoirs ;

    public VenteEntity(){
        super();
    }

    public VenteEntity(Long id,String numeroFacture){
        this.id = id;
        this.numeroFacture = numeroFacture ;
    }
    public VenteEntity(String numeroFacture){
        this.numeroFacture = numeroFacture ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="vente_seq")
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
    public String getCodeVente(){
        return this.codeVente;
    }
    public void setCodeVente(String codeVente){
        this.codeVente = codeVente;
    }    public LocalDateTime getDateFacture(){
        return this.dateFacture;
    }
    public void setDateFacture(LocalDateTime dateFacture){
        this.dateFacture = dateFacture;
    }    public String getNumeroFacture(){
        return this.numeroFacture;
    }
    public void setNumeroFacture(String numeroFacture){
        this.numeroFacture = numeroFacture;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public ClientEntity getClient(){
        return this.client;
    }
    public void setClient(ClientEntity client){
        this.client = client;
    }
    @ManyToOne(fetch = FetchType.LAZY)

    public EtatVenteEntity getEtatVente(){
        return this.etatVente;
    }
    public void setEtatVente(EtatVenteEntity etatVente){
        this.etatVente = etatVente;
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
    }    @OneToMany(mappedBy = "vente")

    public List<VenteItemEntity> getVenteItems(){
        return this.venteItems;
    }
    public void setVenteItems(List<VenteItemEntity> venteItems){
        this.venteItems = venteItems;
    }
    @OneToMany

    public List<AvoirVenteEntity> getAvoirs(){
        return this.avoirs;
    }
    public void setAvoirs(List<AvoirVenteEntity> avoirs){
        this.avoirs = avoirs;
    }

    @Transient
    public String getLabel() {
        label = numeroFacture;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VenteEntity vente = (VenteEntity) o;
        return id != null && id.equals(vente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

