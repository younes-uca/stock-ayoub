package  ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet;


import ma.zs.easystock.infra.dao.criteria.core.commun.PersonneCriteria;

import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ProprietaireCriteria extends  BaseCriteria  {


    private PersonneCriteria personne ;
    private List<PersonneCriteria> personnes ;


    public ProprietaireCriteria(){}


    public PersonneCriteria getPersonne(){
        return this.personne;
    }

    public void setPersonne(PersonneCriteria personne){
        this.personne = personne;
    }
    public List<PersonneCriteria> getPersonnes(){
        return this.personnes;
    }

    public void setPersonnes(List<PersonneCriteria> personnes){
        this.personnes = personnes;
    }
}
