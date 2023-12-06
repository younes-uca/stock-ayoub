package  ma.zs.easystock.ws.dto.gestionchequeffet;

import ma.zs.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



import ma.zs.easystock.ws.dto.commun.PersonneDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProprietaireDto  extends AuditBaseDto {


    private PersonneDto personne ;



    public ProprietaireDto(){
        super();
    }




    public PersonneDto getPersonne(){
        return this.personne;
    }

    public void setPersonne(PersonneDto personne){
        this.personne = personne;
    }






}
