import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ProduitDto} from './Produit.model';
import {AvoirAchatDto} from './AvoirAchat.model';
import {DepotDto} from '../commun/Depot.model';
import {TaxeDto} from './Taxe.model';

export class AvoirAchatItemDto extends BaseDto{

    public barCode: string;

    public quantite: null | number;

    public quantiteAvoir: null | number;

    public quantiteVendue: null | number;

    public prixUnitaireHt: null | number;

    public prixUnitaireTtc: null | number;

    public remise: null | number;

    public montantHt: null | number;

    public montantTtc: null | number;

    public depot: DepotDto ;
    public produit: ProduitDto ;
    public taxe: TaxeDto ;
    public avoirAchat: AvoirAchatDto ;
    

    constructor() {
        super();

        this.barCode = '';
        this.quantite = null;
        this.quantiteAvoir = null;
        this.quantiteVendue = null;
        this.prixUnitaireHt = null;
        this.prixUnitaireTtc = null;
        this.remise = null;
        this.montantHt = null;
        this.montantTtc = null;
        this.depot = new DepotDto() ;
        this.produit = new ProduitDto() ;
        this.taxe = new TaxeDto() ;
        this.avoirAchat = new AvoirAchatDto() ;

        }

}
