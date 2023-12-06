import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {PersonneCriteria} from '../commun/PersonneCriteria.model';

export class ProprietaireCriteria  extends BaseCriteria  {

    public id: number;
  public personne: PersonneCriteria ;
  public personnes: Array<PersonneCriteria> ;

}
