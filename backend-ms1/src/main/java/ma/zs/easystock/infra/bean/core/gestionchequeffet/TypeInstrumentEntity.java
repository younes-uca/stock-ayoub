package ma.zs.easystock.infra.bean.core.gestionchequeffet;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;



import jakarta.persistence.*;

@Entity
@Table(name = "type_instrument")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TypeInstrumentEntity   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;



    public TypeInstrumentEntity(){
        super();
    }

    public TypeInstrumentEntity(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public TypeInstrumentEntity(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="type_instrument_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeInstrumentEntity typeInstrument = (TypeInstrumentEntity) o;
        return id != null && id.equals(typeInstrument.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

