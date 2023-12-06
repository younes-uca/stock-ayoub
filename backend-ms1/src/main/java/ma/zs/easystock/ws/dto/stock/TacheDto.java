package  ma.zs.easystock.ws.dto.stock;

import ma.zs.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.ws.dto.commun.CollaborateurDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class TacheDto  extends AuditBaseDto {

    private String dateDebut ;
    private String dateFin ;
    private String description  ;

    private CollaborateurDto lierA ;



    public TacheDto(){
        super();
    }



    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateDebut(){
        return this.dateDebut;
    }
    public void setDateDebut(String dateDebut){
        this.dateDebut = dateDebut;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(String dateFin){
        this.dateFin = dateFin;
    }

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public CollaborateurDto getLierA(){
        return this.lierA;
    }

    public void setLierA(CollaborateurDto lierA){
        this.lierA = lierA;
    }






}
