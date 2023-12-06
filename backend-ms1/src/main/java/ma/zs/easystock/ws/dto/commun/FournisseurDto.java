package  ma.zs.easystock.ws.dto.commun;

import ma.zs.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class FournisseurDto  extends AuditBaseDto {

    private String ice  ;




    public FournisseurDto(){
        super();
    }



    public String getIce(){
        return this.ice;
    }
    public void setIce(String ice){
        this.ice = ice;
    }








}
