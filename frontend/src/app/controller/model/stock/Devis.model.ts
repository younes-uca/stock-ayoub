import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {DevisItemDto} from './DevisItem.model';
import {ClientDto} from '../commun/Client.model';

export class DevisDto extends BaseDto{

    public numeroDevis: string;

   public dateDevis: Date;

    public montantHt: null | number;

    public montantTva: null | number;

    public montantTtc: null | number;

    public description: string;

    public client: ClientDto ;
     public devisItems: Array<DevisItemDto>;
    

    constructor() {
        super();

        this.numeroDevis = '';
        this.dateDevis = null;
        this.montantHt = null;
        this.montantTva = null;
        this.montantTtc = null;
        this.description = '';
        this.client = new ClientDto() ;
        this.devisItems = new Array<DevisItemDto>();

        }

}
