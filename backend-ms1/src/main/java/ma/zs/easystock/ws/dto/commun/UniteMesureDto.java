package  ma.zs.easystock.ws.dto.commun;

import ma.zs.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class UniteMesureDto  extends AuditBaseDto {

    private String libelle  ;




    public UniteMesureDto(){
        super();
    }



    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }








}
