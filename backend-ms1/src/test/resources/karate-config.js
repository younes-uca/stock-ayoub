function fn() {

    
    var config = {};
    
   
    const rootUrlDev = 'http://localhost:8036/';
    const adminCredentialsDev = {"username": "admin","password": "123"};
    const urlDev = 'jdbc:mysql://localhost:3306/peps-order';
    const usernameDev = 'root';
    const passwordDev = '';
    const driverDev = 'com.mysql.cj.jdbc.Driver';


    const rootUrlInit = 'https://stage-host/';
    const adminCredentialsInit = {"username": "admin","password": "123"};
    const urlInit = 'jdbc:mysql://localhost:3306/peps-order';
    const usernameInit = 'root';
    const passwordInit = '';
    const driverInit = 'com.mysql.cj.jdbc.Driver';
    
    
    const rootUrlE2e = 'https://e2e-host/';
    const adminCredentialsE2e = {"username": "admin","password": "123"};
    const urlE2e = 'jdbc:mysql://localhost:3306/peps-order';
    const usernameE2e = 'root';
    const passwordE2e = '';
    const driverE2e = 'com.mysql.cj.jdbc.Driver';
    
    var env = karate.env; // get java system property 'karate.env'
    if (!env || env=='dev') {
        env = 'dev';
        config.rootUrl = rootUrlDev;
        config.adminCredentials = adminCredentialsDev;
        config.datasource = { username: usernameDev, password: passwordDev, url: urlDev, driverClassName: driverDev }
    }
    if (env == 'int') {
        // over-ride only those that need to be
        config.rootUrl = rootUrlInit;
        config.adminCredentials = adminCredentialsInit;
        config.datasource = { username: usernameInit, password: passwordInit, url: urlInit, driverClassName: driverInit }
    } else if (env == 'e2e') {
        config.rootUrl = rootUrlE2e;
        config.adminCredentials = adminCredentialsE2e;
        config.datasource = { username: usernameE2e, password: passwordE2e, url: urlE2e, driverClassName: driverE2e }
    }

    config.actuatorUri = config.rootUrl + 'actuator/';
    config.adminUri = config.rootUrl + 'api/admin/';

        config.collaborateurUrl = config.adminUri + 'collaborateur/';
    config.fournisseurUrl = config.adminUri + 'fournisseur/';
    config.sortieProduitItemUrl = config.adminUri + 'sortieProduitItem/';
    config.proprietaireUrl = config.adminUri + 'proprietaire/';
    config.reglementVenteUrl = config.adminUri + 'reglementVente/';
    config.proprietaireBanqueUrl = config.adminUri + 'proprietaireBanque/';
    config.taxeUrl = config.adminUri + 'taxe/';
    config.entreeProduitUrl = config.adminUri + 'entreeProduit/';
    config.achatItemUrl = config.adminUri + 'achatItem/';
    config.categorieUrl = config.adminUri + 'categorie/';
    config.commandeItemUrl = config.adminUri + 'commandeItem/';
    config.avoirAchatUrl = config.adminUri + 'avoirAchat/';
    config.reglementAvoirAchatUrl = config.adminUri + 'reglementAvoirAchat/';
    config.transactionUrl = config.adminUri + 'transaction/';
    config.etatAvoirVenteUrl = config.adminUri + 'etatAvoirVente/';
    config.instrumentUrl = config.adminUri + 'instrument/';
    config.achatUrl = config.adminUri + 'achat/';
    config.bonPourItemUrl = config.adminUri + 'bonPourItem/';
    config.avoirAchatItemUrl = config.adminUri + 'avoirAchatItem/';
    config.etatAvoirAchatUrl = config.adminUri + 'etatAvoirAchat/';
    config.depenseUrl = config.adminUri + 'depense/';
    config.venteItemUrl = config.adminUri + 'venteItem/';
    config.devisUrl = config.adminUri + 'devis/';
    config.depotUrl = config.adminUri + 'depot/';
    config.avoirVenteUrl = config.adminUri + 'avoirVente/';
    config.reglementAchatUrl = config.adminUri + 'reglementAchat/';
    config.villeUrl = config.adminUri + 'ville/';
    config.inventaireItemUrl = config.adminUri + 'inventaireItem/';
    config.produitUrl = config.adminUri + 'produit/';
    config.typeTransactionUrl = config.adminUri + 'typeTransaction/';
    config.uniteMesureUrl = config.adminUri + 'uniteMesure/';
    config.stockUrl = config.adminUri + 'stock/';
    config.compteUrl = config.adminUri + 'compte/';
    config.etatCommandeUrl = config.adminUri + 'etatCommande/';
    config.chequeEffetUrl = config.adminUri + 'chequeEffet/';
    config.possedeCompteUrl = config.adminUri + 'possedeCompte/';
    config.clientUrl = config.adminUri + 'client/';
    config.inventaireUrl = config.adminUri + 'inventaire/';
    config.transfertUrl = config.adminUri + 'transfert/';
    config.commandeItemUrl = config.adminUri + 'commandeItem/';
    config.transfertItemUrl = config.adminUri + 'transfertItem/';
    config.venteUrl = config.adminUri + 'vente/';
    config.commandeUrl = config.adminUri + 'commande/';
    config.sortieProduitUrl = config.adminUri + 'sortieProduit/';
    config.etatAchatUrl = config.adminUri + 'etatAchat/';
    config.raisonUrl = config.adminUri + 'raison/';
    config.entreeProduitItemUrl = config.adminUri + 'entreeProduitItem/';
    config.marqueUrl = config.adminUri + 'marque/';
    config.entrepriseSocieteUrl = config.adminUri + 'entrepriseSociete/';
    config.reglementAvoirVenteUrl = config.adminUri + 'reglementAvoirVente/';
    config.bonPourUrl = config.adminUri + 'bonPour/';
    config.tacheUrl = config.adminUri + 'tache/';
    config.typeInstrumentUrl = config.adminUri + 'typeInstrument/';
    config.personneUrl = config.adminUri + 'personne/';
    config.etatVenteUrl = config.adminUri + 'etatVente/';
    config.devisItemUrl = config.adminUri + 'devisItem/';
    config.modeReglementUrl = config.adminUri + 'modeReglement/';
    config.avoirVenteItemUrl = config.adminUri + 'avoirVenteItem/';
    config.banqueUrl = config.adminUri + 'banque/';

    common = karate.callSingle('classpath:common.feature', config);
    config.uniqueId = common.uniqueId
    config.db = common.db
    config.adminToken = common.adminToken
    config.env = env;

    karate.log('karate.env =', karate.env);
    karate.log('config =', config);
    // don't waste time waiting for a connection or if servers don't respond within 5 seconds
    karate.configure('connectTimeout', 5000);
    karate.configure('readTimeout', 5000);
    return config;
}
