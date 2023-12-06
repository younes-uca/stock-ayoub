package ma.zs.easystock.infra.bean.core.stock;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.infra.bean.core.commun.ClientEntity;
import ma.zs.easystock.infra.bean.core.commun.EtatCommandeEntity;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "commande")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommandeEntity   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String barCode;
    @Column(length = 500)
    private String numeroCommande;
    private LocalDateTime dateCommande ;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTva = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private ClientEntity client ;
    private EtatCommandeEntity etatCommande ;

    private List<CommandeItemEntity> commandeItems ;

    public CommandeEntity(){
        super();
    }

    public CommandeEntity(Long id,String numeroCommande){
        this.id = id;
        this.numeroCommande = numeroCommande ;
    }
    public CommandeEntity(String numeroCommande){
        this.numeroCommande = numeroCommande ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="commande_seq")
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
    }    public String getNumeroCommande(){
        return this.numeroCommande;
    }
    public void setNumeroCommande(String numeroCommande){
        this.numeroCommande = numeroCommande;
    }    public LocalDateTime getDateCommande(){
        return this.dateCommande;
    }
    public void setDateCommande(LocalDateTime dateCommande){
        this.dateCommande = dateCommande;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public ClientEntity getClient(){
        return this.client;
    }
    public void setClient(ClientEntity client){
        this.client = client;
    }
    @ManyToOne(fetch = FetchType.LAZY)

    public EtatCommandeEntity getEtatCommande(){
        return this.etatCommande;
    }
    public void setEtatCommande(EtatCommandeEntity etatCommande){
        this.etatCommande = etatCommande;
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
    }    @OneToMany(mappedBy = "commande")

    public List<CommandeItemEntity> getCommandeItems(){
        return this.commandeItems;
    }
    public void setCommandeItems(List<CommandeItemEntity> commandeItems){
        this.commandeItems = commandeItems;
    }

    @Transient
    public String getLabel() {
        label = numeroCommande;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommandeEntity commande = (CommandeEntity) o;
        return id != null && id.equals(commande.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

