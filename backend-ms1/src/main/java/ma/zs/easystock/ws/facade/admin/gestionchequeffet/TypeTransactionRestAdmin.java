package  ma.zs.easystock.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.gestionchequeffet.TypeTransaction;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.TypeTransactionCriteria;
import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.TypeTransactionAdminService;
import ma.zs.easystock.ws.converter.gestionchequeffet.TypeTransactionConverter;
import ma.zs.easystock.ws.dto.gestionchequeffet.TypeTransactionDto;
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
@RequestMapping("/api/admin/typeTransaction/")
public class TypeTransactionRestAdmin  extends AbstractController<TypeTransaction, TypeTransactionDto, TypeTransactionCriteria, TypeTransactionAdminService, TypeTransactionConverter> {

    @Override
    @Operation(summary = "Finds a list of all typeTransactions")
    @GetMapping("")
    public ResponseEntity<List<TypeTransactionDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a typeTransaction by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TypeTransactionDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  typeTransaction")
    @PostMapping("")
    public ResponseEntity<TypeTransactionDto> save(@RequestBody TypeTransactionDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  typeTransaction")
    @PutMapping("")
    public ResponseEntity<TypeTransactionDto> update(@RequestBody TypeTransactionDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified typeTransaction")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }






    public TypeTransactionRestAdmin (TypeTransactionAdminService service, TypeTransactionConverter converter) {
        super(service, converter);
    }




}
