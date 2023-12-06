package  ma.zs.easystock.ws.facade.admin.entree;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.entree.SortieProduit;
import ma.zs.easystock.infra.dao.criteria.core.entree.SortieProduitCriteria;
import ma.zs.easystock.domain.service.facade.admin.entree.SortieProduitAdminService;
import ma.zs.easystock.ws.converter.entree.SortieProduitConverter;
import ma.zs.easystock.ws.dto.entree.SortieProduitDto;
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
@RequestMapping("/api/admin/sortieProduit/")
public class SortieProduitRestAdmin  extends AbstractController<SortieProduit, SortieProduitDto, SortieProduitCriteria, SortieProduitAdminService, SortieProduitConverter> {

    @Override
    @Operation(summary = "Finds a list of all sortieProduits")
    @GetMapping("")
    public ResponseEntity<List<SortieProduitDto>> findAll(){
        return super.findAll();
    }

    @Override
    @Operation(summary = "Finds an optimized list of all sortieProduits")
    @GetMapping("optimized")
    public ResponseEntity<List<SortieProduitDto>> findAllOptimized(){
        return super.findAllOptimized();
    }

    @Override
    @Operation(summary = "Finds a sortieProduit by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SortieProduitDto> findById(@PathVariable Long id){
        return super.findById(id);
    }

    @Operation(summary = "Finds a sortieProduit by reference")
    @GetMapping("reference/{reference}")
    public ResponseEntity<SortieProduitDto> findByReference(@PathVariable String reference){
        return getResponse(service.findByReference(reference));
    }

    @Operation(summary = "Deletes a sortieProduit by reference")
    @DeleteMapping("reference/{reference}")
    public ResponseEntity<Integer> deleteByReference(@PathVariable String reference){
        return getResponse(service.deleteByReference(reference));
    }

    @Override
    @Operation(summary = "Saves the specified  sortieProduit")
    @PostMapping("")
    public ResponseEntity<SortieProduitDto> save(@RequestBody SortieProduitDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  sortieProduit")
    @PutMapping("")
    public ResponseEntity<SortieProduitDto> update(@RequestBody SortieProduitDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified sortieProduit")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by depot id")
    @GetMapping("depot/id/{id}")
    public ResponseEntity<List<SortieProduitDto>> findByDepotId(@PathVariable Long id){
        return getResponse(service.findByDepotId(id));
    }
    @Operation(summary = "delete by depot id")
    @DeleteMapping("depot/id/{id}")
    public ResponseEntity<Integer> deleteByDepotId(@PathVariable Long id){
        return getResponse(service.deleteByDepotId(id));
    }



    public SortieProduitRestAdmin (SortieProduitAdminService service, SortieProduitConverter converter) {
        super(service, converter);
    }




}
