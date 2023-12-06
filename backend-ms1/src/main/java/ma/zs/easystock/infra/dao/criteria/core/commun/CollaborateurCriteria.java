package  ma.zs.easystock.infra.dao.criteria.core.commun;



import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class CollaborateurCriteria extends  BaseCriteria  {

    private String prenom;
    private String prenomLike;



    public CollaborateurCriteria(){}

    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public String getPrenomLike(){
        return this.prenomLike;
    }
    public void setPrenomLike(String prenomLike){
        this.prenomLike = prenomLike;
    }


}
