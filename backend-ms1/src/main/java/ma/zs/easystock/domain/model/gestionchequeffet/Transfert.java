package ma.zs.easystock.domain.model.gestionchequeffet;

import java.util.Objects;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Date;

import ma.zs.easystock.domain.model.stock.Produit;
import ma.zs.easystock.domain.model.Transfert.Raison;
import ma.zs.easystock.domain.model.commun.Depot;


import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;




public class Transfert   extends AuditDomainObject     {

    private Long id;

    private String reference;
    private LocalDateTime dateTransfert ;
    private String description;

    private Raison raison ;

    private List<TransfertItem> transfertItems ;

    public Transfert(){
        super();
    }

    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public Raison getRaison(){
        return this.raison;
    }
    public void setRaison(Raison raison){
        this.raison = raison;
    }
    public LocalDateTime getDateTransfert(){
        return this.dateTransfert;
    }
    public void setDateTransfert(LocalDateTime dateTransfert){
        this.dateTransfert = dateTransfert;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public List<TransfertItem> getTransfertItems(){
        return this.transfertItems;
    }
    public void setTransfertItems(List<TransfertItem> transfertItems){
        this.transfertItems = transfertItems;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transfert transfert = (Transfert) o;
        return id != null && id.equals(transfert.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

