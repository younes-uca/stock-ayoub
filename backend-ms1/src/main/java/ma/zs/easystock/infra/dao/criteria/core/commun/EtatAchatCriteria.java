package  ma.zs.easystock.infra.dao.criteria.core.commun;



import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class EtatAchatCriteria extends  BaseCriteria  {

    private String libelle;
    private String libelleLike;



    public EtatAchatCriteria(){}

    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getLibelleLike(){
        return this.libelleLike;
    }
    public void setLibelleLike(String libelleLike){
        this.libelleLike = libelleLike;
    }


}
