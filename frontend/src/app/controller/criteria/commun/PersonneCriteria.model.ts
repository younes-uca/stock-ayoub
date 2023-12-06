import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {VilleCriteria} from './VilleCriteria.model';

export class PersonneCriteria  extends BaseCriteria  {

    public id: number;
    public nom: string;
    public nomLike: string;
    public telephone: string;
    public telephoneLike: string;
    public adresse: string;
    public adresseLike: string;
     public creance: number;
     public creanceMin: number;
     public creanceMax: number;
    public description: string;
    public descriptionLike: string;
  public ville: VilleCriteria ;
  public villes: Array<VilleCriteria> ;

}
