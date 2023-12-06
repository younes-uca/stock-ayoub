package ma.zs.easystock.domain.model.commun;

import java.util.Objects;



import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;




public class Client   extends AuditDomainObject     {

    private Long id;

    private String cin;



    public Client(){
        super();
    }

    public Client(Long id,String cin){
        this.id = id;
        this.cin = cin ;
    }
    public Client(String cin){
        this.cin = cin ;
    }
    public String getCin(){
        return this.cin;
    }
    public void setCin(String cin){
        this.cin = cin;
    }

    public String getLabel() {
        label = cin;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id != null && id.equals(client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

