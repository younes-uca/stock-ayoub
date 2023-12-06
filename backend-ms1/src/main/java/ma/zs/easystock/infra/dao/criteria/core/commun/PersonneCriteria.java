package  ma.zs.easystock.infra.dao.criteria.core.commun;



import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class PersonneCriteria extends  BaseCriteria  {

    private String nom;
    private String nomLike;
    private String telephone;
    private String telephoneLike;
    private String adresse;
    private String adresseLike;
    private String creance;
    private String creanceMin;
    private String creanceMax;
    private String description;
    private String descriptionLike;

    private VilleCriteria ville ;
    private List<VilleCriteria> villes ;


    public PersonneCriteria(){}

    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getNomLike(){
        return this.nomLike;
    }
    public void setNomLike(String nomLike){
        this.nomLike = nomLike;
    }

    public String getTelephone(){
        return this.telephone;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }
    public String getTelephoneLike(){
        return this.telephoneLike;
    }
    public void setTelephoneLike(String telephoneLike){
        this.telephoneLike = telephoneLike;
    }

    public String getAdresse(){
        return this.adresse;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }
    public String getAdresseLike(){
        return this.adresseLike;
    }
    public void setAdresseLike(String adresseLike){
        this.adresseLike = adresseLike;
    }

    public String getCreance(){
        return this.creance;
    }
    public void setCreance(String creance){
        this.creance = creance;
    }   
    public String getCreanceMin(){
        return this.creanceMin;
    }
    public void setCreanceMin(String creanceMin){
        this.creanceMin = creanceMin;
    }
    public String getCreanceMax(){
        return this.creanceMax;
    }
    public void setCreanceMax(String creanceMax){
        this.creanceMax = creanceMax;
    }
      
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }


    public VilleCriteria getVille(){
        return this.ville;
    }

    public void setVille(VilleCriteria ville){
        this.ville = ville;
    }
    public List<VilleCriteria> getVilles(){
        return this.villes;
    }

    public void setVilles(List<VilleCriteria> villes){
        this.villes = villes;
    }
}
