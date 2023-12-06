import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EtatAvoirVenteDto} from '../commun/EtatAvoirVente.model';
import {AchatDto} from './Achat.model';
import {EntrepriseSocieteDto} from '../commun/EntrepriseSociete.model';
import {ClientDto} from '../commun/Client.model';
import {AvoirVenteItemDto} from './AvoirVenteItem.model';

export class AvoirVenteDto extends BaseDto{

    public barCode: string;

    public codeAvoirVente: string;

    public numeroFactureAvoirVente: string;

   public dateFactureAvoirVente: Date;

    public montantHt: null | number;

    public montantTva: null | number;

    public montantTtc: null | number;

    public description: string;

    public entrepriseSociete: EntrepriseSocieteDto ;
    public client: ClientDto ;
    public etatAvoirVente: EtatAvoirVenteDto ;
    public achat: AchatDto ;
     public avoirVenteItems: Array<AvoirVenteItemDto>;
     public avoirs: Array<AvoirVenteItemDto>;
    

    constructor() {
        super();

        this.barCode = '';
        this.codeAvoirVente = '';
        this.numeroFactureAvoirVente = '';
        this.dateFactureAvoirVente = null;
        this.montantHt = null;
        this.montantTva = null;
        this.montantTtc = null;
        this.description = '';
        this.entrepriseSociete = new EntrepriseSocieteDto() ;
        this.client = new ClientDto() ;
        this.etatAvoirVente = new EtatAvoirVenteDto() ;
        this.achat = new AchatDto() ;
        this.avoirVenteItems = new Array<AvoirVenteItemDto>();
        this.avoirs = new Array<AvoirVenteItemDto>();

        }

}
