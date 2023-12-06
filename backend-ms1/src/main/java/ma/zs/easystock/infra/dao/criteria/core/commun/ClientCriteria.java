package  ma.zs.easystock.infra.dao.criteria.core.commun;



import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ClientCriteria extends  BaseCriteria  {

    private String cin;
    private String cinLike;



    public ClientCriteria(){}

    public String getCin(){
        return this.cin;
    }
    public void setCin(String cin){
        this.cin = cin;
    }
    public String getCinLike(){
        return this.cinLike;
    }
    public void setCinLike(String cinLike){
        this.cinLike = cinLike;
    }


}
