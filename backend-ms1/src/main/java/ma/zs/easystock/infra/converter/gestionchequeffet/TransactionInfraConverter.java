package  ma.zs.easystock.infra.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.converter.AbstractInfraConverter;



import ma.zs.easystock.infra.converter.gestionchequeffet.TypeTransactionInfraConverter;
import ma.zs.easystock.infra.converter.chequeffet.InstrumentInfraConverter;
import ma.zs.easystock.infra.converter.gestionchequeffet.CompteInfraConverter;



import ma.zs.easystock.infra.bean.core.gestionchequeffet.TransactionEntity;
import ma.zs.easystock.domain.model.gestionchequeffet.Transaction;

import ma.zs.easystock.zynerator.helper.StringUtil;
import ma.zs.easystock.zynerator.helper.DateUtil;

@Component
public class TransactionInfraConverter extends AbstractInfraConverter<TransactionEntity, Transaction> {

    @Autowired
    private TypeTransactionInfraConverter typeTransactionConverter ;
    @Autowired
    private InstrumentInfraConverter instrumentConverter ;
    @Autowired
    private CompteInfraConverter compteConverter ;
    private boolean typeTransaction;
    private boolean instrument;
    private boolean compte;

    public  TransactionInfraConverter(){
        super(TransactionEntity.class, Transaction.class);
    }

    @Override
    public Transaction toModel(TransactionEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Transaction model = new Transaction();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getDateTransaction()))
                model.setDateTransaction(DateUtil.stringEnToDate(entity.getDateTransaction()));
            if(StringUtil.isNotEmpty(entity.getDateEncaissement()))
                model.setDateEncaissement(DateUtil.stringEnToDate(entity.getDateEncaissement()));
            if(StringUtil.isNotEmpty(entity.getPathCheque()))
                model.setPathCheque(entity.getPathCheque());
            if(StringUtil.isNotEmpty(entity.getDescription()))
                model.setDescription(entity.getDescription());
            if(this.typeTransaction && entity.getTypeTransaction()!=null &&  entity.getTypeTransaction().getId() != null)
                model.setTypeTransaction(typeTransactionConverter.toModel(entity.getTypeTransaction())) ;

            if(this.instrument && entity.getInstrument()!=null &&  entity.getInstrument().getId() != null)
                model.setInstrument(instrumentConverter.toModel(entity.getInstrument())) ;

            if(this.compte && entity.getCompte()!=null &&  entity.getCompte().getId() != null)
                model.setCompte(compteConverter.toModel(entity.getCompte())) ;




        return model;
        }
    }

    @Override
    public TransactionEntity toEntity(Transaction model) {
        if (model == null) {
            return null;
        } else {
            TransactionEntity entity = new TransactionEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(model.getDateTransaction()!=null)
             entity.setDateTransaction(DateUtil.dateTimeToString(model.getDateTransaction()));
            if(model.getDateEncaissement()!=null)
             entity.setDateEncaissement(DateUtil.dateTimeToString(model.getDateEncaissement()));
            if(StringUtil.isNotEmpty(model.getPathCheque()))
             entity.setPathCheque(model.getPathCheque());
            if(StringUtil.isNotEmpty(model.getDescription()))
             entity.setDescription(model.getDescription());
        if(this.typeTransaction && model.getTypeTransaction()!=null) {
            entity.setTypeTransaction(typeTransactionConverter.toEntity(model.getTypeTransaction())) ;
        }
        if(this.instrument && model.getInstrument()!=null) {
            entity.setInstrument(instrumentConverter.toEntity(model.getInstrument())) ;
        }
        if(this.compte && model.getCompte()!=null) {
            entity.setCompte(compteConverter.toEntity(model.getCompte())) ;
        }


        return entity;
        }
    }


    public void initObject(boolean value) {
        this.typeTransaction = value;
        this.instrument = value;
        this.compte = value;
    }


    public TypeTransactionInfraConverter getTypeTransactionConverter(){
        return this.typeTransactionConverter;
    }
    public void setTypeTransactionInfraConverter(TypeTransactionInfraConverter typeTransactionConverter ){
        this.typeTransactionConverter = typeTransactionConverter;
    }
    public InstrumentInfraConverter getInstrumentConverter(){
        return this.instrumentConverter;
    }
    public void setInstrumentInfraConverter(InstrumentInfraConverter instrumentConverter ){
        this.instrumentConverter = instrumentConverter;
    }
    public CompteInfraConverter getCompteConverter(){
        return this.compteConverter;
    }
    public void setCompteInfraConverter(CompteInfraConverter compteConverter ){
        this.compteConverter = compteConverter;
    }
    public boolean  isTypeTransaction(){
        return this.typeTransaction;
    }
    public void  setTypeTransaction(boolean typeTransaction){
        this.typeTransaction = typeTransaction;
    }
    public boolean  isInstrument(){
        return this.instrument;
    }
    public void  setInstrument(boolean instrument){
        this.instrument = instrument;
    }
    public boolean  isCompte(){
        return this.compte;
    }
    public void  setCompte(boolean compte){
        this.compte = compte;
    }
}
