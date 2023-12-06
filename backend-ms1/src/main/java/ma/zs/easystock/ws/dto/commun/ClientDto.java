package  ma.zs.easystock.ws.dto.commun;

import ma.zs.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto  extends AuditBaseDto {

    private String cin  ;




    public ClientDto(){
        super();
    }



    public String getCin(){
        return this.cin;
    }
    public void setCin(String cin){
        this.cin = cin;
    }








}
