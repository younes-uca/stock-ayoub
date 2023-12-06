package  ma.zs.easystock.ws.dto.gestionchequeffet;

import ma.zs.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class TypeInstrumentDto  extends AuditBaseDto {

    private String libelle  ;




    public TypeInstrumentDto(){
        super();
    }



    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }








}
