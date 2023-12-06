package  ma.zs.easystock.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.gestionchequeffet.ChequeEffet;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.ChequeEffetCriteria;
import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.ChequeEffetAdminService;
import ma.zs.easystock.ws.converter.gestionchequeffet.ChequeEffetConverter;
import ma.zs.easystock.ws.dto.gestionchequeffet.ChequeEffetDto;
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
@RequestMapping("/api/admin/chequeEffet/")
public class ChequeEffetRestAdmin  extends AbstractController<ChequeEffet, ChequeEffetDto, ChequeEffetCriteria, ChequeEffetAdminService, ChequeEffetConverter> {

    @Override
    @Operation(summary = "Finds a list of all chequeEffets")
    @GetMapping("")
    public ResponseEntity<List<ChequeEffetDto>> findAll(){
        return super.findAll();
    }

    @Override
    @Operation(summary = "Finds an optimized list of all chequeEffets")
    @GetMapping("optimized")
    public ResponseEntity<List<ChequeEffetDto>> findAllOptimized(){
        return super.findAllOptimized();
    }

    @Override
    @Operation(summary = "Finds a chequeEffet by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ChequeEffetDto> findById(@PathVariable Long id){
        return super.findById(id);
    }

    @Operation(summary = "Finds a chequeEffet by numeroChequeEffet")
    @GetMapping("numeroChequeEffet/{numeroChequeEffet}")
    public ResponseEntity<ChequeEffetDto> findByNumeroChequeEffet(@PathVariable String numeroChequeEffet){
        return getResponse(service.findByNumeroChequeEffet(numeroChequeEffet));
    }

    @Operation(summary = "Deletes a chequeEffet by numeroChequeEffet")
    @DeleteMapping("numeroChequeEffet/{numeroChequeEffet}")
    public ResponseEntity<Integer> deleteByNumeroChequeEffet(@PathVariable String numeroChequeEffet){
        return getResponse(service.deleteByNumeroChequeEffet(numeroChequeEffet));
    }

    @Override
    @Operation(summary = "Saves the specified  chequeEffet")
    @PostMapping("")
    public ResponseEntity<ChequeEffetDto> save(@RequestBody ChequeEffetDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  chequeEffet")
    @PutMapping("")
    public ResponseEntity<ChequeEffetDto> update(@RequestBody ChequeEffetDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified chequeEffet")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by beneficiaire id")
    @GetMapping("beneficiaire/id/{id}")
    public ResponseEntity<List<ChequeEffetDto>> findByBeneficiaireId(@PathVariable Long id){
        return getResponse(service.findByBeneficiaireId(id));
    }
    @Operation(summary = "delete by beneficiaire id")
    @DeleteMapping("beneficiaire/id/{id}")
    public ResponseEntity<Integer> deleteByBeneficiaireId(@PathVariable Long id){
        return getResponse(service.deleteByBeneficiaireId(id));
    }



    public ChequeEffetRestAdmin (ChequeEffetAdminService service, ChequeEffetConverter converter) {
        super(service, converter);
    }




}
