import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class ClientDto extends BaseDto{

    public cin: string;

    

    constructor() {
        super();

        this.cin = '';

        }

}
