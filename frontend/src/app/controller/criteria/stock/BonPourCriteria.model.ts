import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {BonPourItemCriteria} from './BonPourItemCriteria.model';
import {ClientCriteria} from '../commun/ClientCriteria.model';

export class BonPourCriteria  extends BaseCriteria  {

    public id: number;
    public numeroBonPour: string;
    public numeroBonPourLike: string;
    public dateBonPour: Date;
    public dateBonPourFrom: Date;
    public dateBonPourTo: Date;
     public montantHt: number;
     public montantHtMin: number;
     public montantHtMax: number;
     public montantTva: number;
     public montantTvaMin: number;
     public montantTvaMax: number;
     public montantTtc: number;
     public montantTtcMin: number;
     public montantTtcMax: number;
    public description: string;
    public descriptionLike: string;
  public client: ClientCriteria ;
  public clients: Array<ClientCriteria> ;
      public bonPourItems: Array<BonPourItemCriteria>;

}
