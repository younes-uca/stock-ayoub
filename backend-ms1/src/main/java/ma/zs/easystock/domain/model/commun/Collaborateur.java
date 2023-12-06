package ma.zs.easystock.domain.model.commun;

import java.util.Objects;



import ma.zs.easystock.zynerator.domain.AuditDomainObject;
import java.util.Objects;




public class Collaborateur   extends AuditDomainObject     {

    private Long id;

    private String prenom;



    public Collaborateur(){
        super();
    }

    public Collaborateur(Long id,String prenom){
        this.id = id;
        this.prenom = prenom ;
    }
    public Collaborateur(String prenom){
        this.prenom = prenom ;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    public String getLabel() {
        label = prenom;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collaborateur collaborateur = (Collaborateur) o;
        return id != null && id.equals(collaborateur.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

