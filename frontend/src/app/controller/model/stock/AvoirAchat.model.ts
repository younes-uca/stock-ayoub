import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EtatAvoirAchatDto} from '../commun/EtatAvoirAchat.model';
import {EntrepriseSocieteDto} from '../commun/EntrepriseSociete.model';
import {FournisseurDto} from '../commun/Fournisseur.model';
import {AvoirAchatItemDto} from './AvoirAchatItem.model';

export class AvoirAchatDto extends BaseDto{

    public barCode: string;

    public codeAvoirAchat: string;

    public numeroFactureAvoirAchat: string;

   public dateFactureAvoirAchat: Date;

    public montantHt: null | number;

    public montantTva: null | number;

    public montantTtc: null | number;

    public description: string;

    public entrepriseSociete: EntrepriseSocieteDto ;
    public fournisseur: FournisseurDto ;
    public etatAvoirAchat: EtatAvoirAchatDto ;
     public avoirAchatItems: Array<AvoirAchatItemDto>;
    

    constructor() {
        super();

        this.barCode = '';
        this.codeAvoirAchat = '';
        this.numeroFactureAvoirAchat = '';
        this.dateFactureAvoirAchat = null;
        this.montantHt = null;
        this.montantTva = null;
        this.montantTtc = null;
        this.description = '';
        this.entrepriseSociete = new EntrepriseSocieteDto() ;
        this.fournisseur = new FournisseurDto() ;
        this.etatAvoirAchat = new EtatAvoirAchatDto() ;
        this.avoirAchatItems = new Array<AvoirAchatItemDto>();

        }

}
