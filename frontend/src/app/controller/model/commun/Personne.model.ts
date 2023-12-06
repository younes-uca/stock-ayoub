import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {VilleDto} from './Ville.model';

export class PersonneDto extends BaseDto{

    public nom: string;

    public telephone: string;

    public adresse: string;

    public creance: null | number;

    public description: string;

    public ville: VilleDto ;
    

    constructor() {
        super();

        this.nom = '';
        this.telephone = '';
        this.adresse = '';
        this.creance = null;
        this.description = '';
        this.ville = new VilleDto() ;

        }

}
