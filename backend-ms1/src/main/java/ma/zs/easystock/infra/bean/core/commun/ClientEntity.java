package ma.zs.easystock.infra.bean.core.commun;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;



import jakarta.persistence.*;

@Entity
@Table(name = "client")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientEntity   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String cin;



    public ClientEntity(){
        super();
    }

    public ClientEntity(Long id,String cin){
        this.id = id;
        this.cin = cin ;
    }
    public ClientEntity(String cin){
        this.cin = cin ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="client_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }    public String getCin(){
        return this.cin;
    }
    public void setCin(String cin){
        this.cin = cin;
    }
    @Transient
    public String getLabel() {
        label = cin;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity client = (ClientEntity) o;
        return id != null && id.equals(client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

