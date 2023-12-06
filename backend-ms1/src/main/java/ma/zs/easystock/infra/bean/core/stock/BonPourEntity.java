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
@Table(name = "bon_pour")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BonPourEntity   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String numeroBonPour;
    private LocalDateTime dateBonPour ;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTva = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private ClientEntity client ;

    private List<BonPourItemEntity> bonPourItems ;

    public BonPourEntity(){
        super();
    }

    public BonPourEntity(Long id,String numeroBonPour){
        this.id = id;
        this.numeroBonPour = numeroBonPour ;
    }
    public BonPourEntity(String numeroBonPour){
        this.numeroBonPour = numeroBonPour ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="bon_pour_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }    public String getNumeroBonPour(){
        return this.numeroBonPour;
    }
    public void setNumeroBonPour(String numeroBonPour){
        this.numeroBonPour = numeroBonPour;
    }    public LocalDateTime getDateBonPour(){
        return this.dateBonPour;
    }
    public void setDateBonPour(LocalDateTime dateBonPour){
        this.dateBonPour = dateBonPour;
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
    }    @OneToMany(mappedBy = "bonPour")

    public List<BonPourItemEntity> getBonPourItems(){
        return this.bonPourItems;
    }
    public void setBonPourItems(List<BonPourItemEntity> bonPourItems){
        this.bonPourItems = bonPourItems;
    }

    @Transient
    public String getLabel() {
        label = numeroBonPour;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonPourEntity bonPour = (BonPourEntity) o;
        return id != null && id.equals(bonPour.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

