import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class CollaborateurDto extends BaseDto{

    public prenom: string;

    

    constructor() {
        super();

        this.prenom = '';

        }

}
