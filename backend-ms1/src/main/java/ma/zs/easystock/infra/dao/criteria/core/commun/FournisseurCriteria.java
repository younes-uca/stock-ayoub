package  ma.zs.easystock.infra.dao.criteria.core.commun;



import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class FournisseurCriteria extends  BaseCriteria  {

    private String ice;
    private String iceLike;



    public FournisseurCriteria(){}

    public String getIce(){
        return this.ice;
    }
    public void setIce(String ice){
        this.ice = ice;
    }
    public String getIceLike(){
        return this.iceLike;
    }
    public void setIceLike(String iceLike){
        this.iceLike = iceLike;
    }


}
