package  ma.zs.easystock.ws.dto.commun;

import ma.zs.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class CollaborateurDto  extends AuditBaseDto {

    private String prenom  ;




    public CollaborateurDto(){
        super();
    }



    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }








}
