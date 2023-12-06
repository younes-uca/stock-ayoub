package  ma.zs.easystock.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.gestionchequeffet.Transfert;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.TransfertCriteria;
import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.TransfertAdminService;
import ma.zs.easystock.ws.converter.gestionchequeffet.TransfertConverter;
import ma.zs.easystock.ws.dto.gestionchequeffet.TransfertDto;
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
@RequestMapping("/api/admin/transfert/")
public class TransfertRestAdmin  extends AbstractController<Transfert, TransfertDto, TransfertCriteria, TransfertAdminService, TransfertConverter> {

    @Override
    @Operation(summary = "Finds a list of all transferts")
    @GetMapping("")
    public ResponseEntity<List<TransfertDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a transfert by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TransfertDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  transfert")
    @PostMapping("")
    public ResponseEntity<TransfertDto> save(@RequestBody TransfertDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  transfert")
    @PutMapping("")
    public ResponseEntity<TransfertDto> update(@RequestBody TransfertDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified transfert")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by raison id")
    @GetMapping("raison/id/{id}")
    public ResponseEntity<List<TransfertDto>> findByRaisonId(@PathVariable Long id){
        return getResponse(service.findByRaisonId(id));
    }
    @Operation(summary = "delete by raison id")
    @DeleteMapping("raison/id/{id}")
    public ResponseEntity<Integer> deleteByRaisonId(@PathVariable Long id){
        return getResponse(service.deleteByRaisonId(id));
    }



    public TransfertRestAdmin (TransfertAdminService service, TransfertConverter converter) {
        super(service, converter);
    }




}
