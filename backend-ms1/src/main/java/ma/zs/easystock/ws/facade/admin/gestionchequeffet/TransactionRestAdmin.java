package  ma.zs.easystock.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.gestionchequeffet.Transaction;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.TransactionCriteria;
import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.TransactionAdminService;
import ma.zs.easystock.ws.converter.gestionchequeffet.TransactionConverter;
import ma.zs.easystock.ws.dto.gestionchequeffet.TransactionDto;
import ma.zs.easystock.zynerator.controller.AbstractController;
import ma.zs.easystock.zynerator.dto.AuditEntityDto;
import ma.zs.easystock.zynerator.helper.PaginatedList;



import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.easystock.zynerator.process.Result;



@RestController
@RequestMapping("/api/admin/transaction/")
public class TransactionRestAdmin  extends AbstractController<Transaction, TransactionDto, TransactionCriteria, TransactionAdminService, TransactionConverter> {

    @Override
    @Operation(summary = "Finds a list of all transactions")
    @GetMapping("")
    public ResponseEntity<List<TransactionDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a transaction by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TransactionDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  transaction")
    @PostMapping("")
    public ResponseEntity<TransactionDto> save(@RequestBody TransactionDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  transaction")
    @PutMapping("")
    public ResponseEntity<TransactionDto> update(@RequestBody TransactionDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified transaction")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by typeTransaction id")
    @GetMapping("typeTransaction/id/{id}")
    public ResponseEntity<List<TransactionDto>> findByTypeTransactionId(@PathVariable Long id){
        return getResponse(service.findByTypeTransactionId(id));
    }
    @Operation(summary = "delete by typeTransaction id")
    @DeleteMapping("typeTransaction/id/{id}")
    public ResponseEntity<Integer> deleteByTypeTransactionId(@PathVariable Long id){
        return getResponse(service.deleteByTypeTransactionId(id));
    }
    @Operation(summary = "find by instrument id")
    @GetMapping("instrument/id/{id}")
    public ResponseEntity<List<TransactionDto>> findByInstrumentId(@PathVariable Long id){
        return getResponse(service.findByInstrumentId(id));
    }
    @Operation(summary = "delete by instrument id")
    @DeleteMapping("instrument/id/{id}")
    public ResponseEntity<Integer> deleteByInstrumentId(@PathVariable Long id){
        return getResponse(service.deleteByInstrumentId(id));
    }
    @Operation(summary = "find by compte id")
    @GetMapping("compte/id/{id}")
    public ResponseEntity<List<TransactionDto>> findByCompteId(@PathVariable Long id){
        return getResponse(service.findByCompteId(id));
    }
    @Operation(summary = "delete by compte id")
    @DeleteMapping("compte/id/{id}")
    public ResponseEntity<Integer> deleteByCompteId(@PathVariable Long id){
        return getResponse(service.deleteByCompteId(id));
    }



    public TransactionRestAdmin (TransactionAdminService service, TransactionConverter converter) {
        super(service, converter);
    }




}
