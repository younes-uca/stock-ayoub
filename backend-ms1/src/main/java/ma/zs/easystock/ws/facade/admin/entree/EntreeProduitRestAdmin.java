package  ma.zs.easystock.ws.facade.admin.entree;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.entree.EntreeProduit;
import ma.zs.easystock.infra.dao.criteria.core.entree.EntreeProduitCriteria;
import ma.zs.easystock.domain.service.facade.admin.entree.EntreeProduitAdminService;
import ma.zs.easystock.ws.converter.entree.EntreeProduitConverter;
import ma.zs.easystock.ws.dto.entree.EntreeProduitDto;
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
@RequestMapping("/api/admin/entreeProduit/")
public class EntreeProduitRestAdmin  extends AbstractController<EntreeProduit, EntreeProduitDto, EntreeProduitCriteria, EntreeProduitAdminService, EntreeProduitConverter> {

    @Override
    @Operation(summary = "Finds a list of all entreeProduits")
    @GetMapping("")
    public ResponseEntity<List<EntreeProduitDto>> findAll(){
        return super.findAll();
    }

    @Override
    @Operation(summary = "Finds an optimized list of all entreeProduits")
    @GetMapping("optimized")
    public ResponseEntity<List<EntreeProduitDto>> findAllOptimized(){
        return super.findAllOptimized();
    }

    @Override
    @Operation(summary = "Finds a entreeProduit by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EntreeProduitDto> findById(@PathVariable Long id){
        return super.findById(id);
    }

    @Operation(summary = "Finds a entreeProduit by reference")
    @GetMapping("reference/{reference}")
    public ResponseEntity<EntreeProduitDto> findByReference(@PathVariable String reference){
        return getResponse(service.findByReference(reference));
    }

    @Operation(summary = "Deletes a entreeProduit by reference")
    @DeleteMapping("reference/{reference}")
    public ResponseEntity<Integer> deleteByReference(@PathVariable String reference){
        return getResponse(service.deleteByReference(reference));
    }

    @Override
    @Operation(summary = "Saves the specified  entreeProduit")
    @PostMapping("")
    public ResponseEntity<EntreeProduitDto> save(@RequestBody EntreeProduitDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  entreeProduit")
    @PutMapping("")
    public ResponseEntity<EntreeProduitDto> update(@RequestBody EntreeProduitDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified entreeProduit")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by fournisseur id")
    @GetMapping("fournisseur/id/{id}")
    public ResponseEntity<List<EntreeProduitDto>> findByFournisseurId(@PathVariable Long id){
        return getResponse(service.findByFournisseurId(id));
    }
    @Operation(summary = "delete by fournisseur id")
    @DeleteMapping("fournisseur/id/{id}")
    public ResponseEntity<Integer> deleteByFournisseurId(@PathVariable Long id){
        return getResponse(service.deleteByFournisseurId(id));
    }
    @Operation(summary = "find by depot id")
    @GetMapping("depot/id/{id}")
    public ResponseEntity<List<EntreeProduitDto>> findByDepotId(@PathVariable Long id){
        return getResponse(service.findByDepotId(id));
    }
    @Operation(summary = "delete by depot id")
    @DeleteMapping("depot/id/{id}")
    public ResponseEntity<Integer> deleteByDepotId(@PathVariable Long id){
        return getResponse(service.deleteByDepotId(id));
    }



    public EntreeProduitRestAdmin (EntreeProduitAdminService service, EntreeProduitConverter converter) {
        super(service, converter);
    }




}
