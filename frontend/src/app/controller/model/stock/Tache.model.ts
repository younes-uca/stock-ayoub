import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {CollaborateurDto} from '../commun/Collaborateur.model';

export class TacheDto extends BaseDto{

   public dateDebut: Date;

   public dateFin: Date;

    public description: string;

    public lierA: CollaborateurDto ;
    

    constructor() {
        super();

        this.dateDebut = null;
        this.dateFin = null;
        this.description = '';
        this.lierA = new CollaborateurDto() ;

        }

}
