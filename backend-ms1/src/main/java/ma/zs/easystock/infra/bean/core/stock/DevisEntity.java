package ma.zs.easystock.infra.bean.core.stock;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.infra.bean.core.commun.ClientEntity;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "devis")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DevisEntity   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String numeroDevis;
    private LocalDateTime dateDevis ;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTva = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private ClientEntity client ;

    private List<DevisItemEntity> devisItems ;

    public DevisEntity(){
        super();
    }

    public DevisEntity(Long id,String numeroDevis){
        this.id = id;
        this.numeroDevis = numeroDevis ;
    }
    public DevisEntity(String numeroDevis){
        this.numeroDevis = numeroDevis ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="devis_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }    public String getNumeroDevis(){
        return this.numeroDevis;
    }
    public void setNumeroDevis(String numeroDevis){
        this.numeroDevis = numeroDevis;
    }    public LocalDateTime getDateDevis(){
        return this.dateDevis;
    }
    public void setDateDevis(LocalDateTime dateDevis){
        this.dateDevis = dateDevis;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public ClientEntity getClient(){
        return this.client;
    }
    public void setClient(ClientEntity client){
        this.client = client;
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
    }    @OneToMany(mappedBy = "devis")

    public List<DevisItemEntity> getDevisItems(){
        return this.devisItems;
    }
    public void setDevisItems(List<DevisItemEntity> devisItems){
        this.devisItems = devisItems;
    }

    @Transient
    public String getLabel() {
        label = numeroDevis;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DevisEntity devis = (DevisEntity) o;
        return id != null && id.equals(devis.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

