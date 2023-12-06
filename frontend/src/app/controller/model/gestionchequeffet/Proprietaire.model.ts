import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {PersonneDto} from '../commun/Personne.model';

export class ProprietaireDto extends BaseDto{

    public personne: PersonneDto ;
    

    constructor() {
        super();

        this.personne = new PersonneDto() ;

        }

}
