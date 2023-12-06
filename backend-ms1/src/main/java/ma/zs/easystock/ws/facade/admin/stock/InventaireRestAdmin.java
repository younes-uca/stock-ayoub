package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.stock.Inventaire;
import ma.zs.easystock.infra.dao.criteria.core.stock.InventaireCriteria;
import ma.zs.easystock.domain.service.facade.admin.stock.InventaireAdminService;
import ma.zs.easystock.ws.converter.stock.InventaireConverter;
import ma.zs.easystock.ws.dto.stock.InventaireDto;
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
@RequestMapping("/api/admin/inventaire/")
public class InventaireRestAdmin  extends AbstractController<Inventaire, InventaireDto, InventaireCriteria, InventaireAdminService, InventaireConverter> {

    @Override
    @Operation(summary = "Finds a list of all inventaires")
    @GetMapping("")
    public ResponseEntity<List<InventaireDto>> findAll(){
        return super.findAll();
    }

    @Override
    @Operation(summary = "Finds an optimized list of all inventaires")
    @GetMapping("optimized")
    public ResponseEntity<List<InventaireDto>> findAllOptimized(){
        return super.findAllOptimized();
    }

    @Override
    @Operation(summary = "Finds a inventaire by id")
    @GetMapping("id/{id}")
    public ResponseEntity<InventaireDto> findById(@PathVariable Long id){
        return super.findById(id);
    }

    @Operation(summary = "Finds a inventaire by reference")
    @GetMapping("reference/{reference}")
    public ResponseEntity<InventaireDto> findByReference(@PathVariable String reference){
        return getResponse(service.findByReference(reference));
    }

    @Operation(summary = "Deletes a inventaire by reference")
    @DeleteMapping("reference/{reference}")
    public ResponseEntity<Integer> deleteByReference(@PathVariable String reference){
        return getResponse(service.deleteByReference(reference));
    }

    @Override
    @Operation(summary = "Saves the specified  inventaire")
    @PostMapping("")
    public ResponseEntity<InventaireDto> save(@RequestBody InventaireDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  inventaire")
    @PutMapping("")
    public ResponseEntity<InventaireDto> update(@RequestBody InventaireDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified inventaire")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by entrepriseSociete id")
    @GetMapping("entrepriseSociete/id/{id}")
    public ResponseEntity<List<InventaireDto>> findByEntrepriseSocieteId(@PathVariable Long id){
        return getResponse(service.findByEntrepriseSocieteId(id));
    }
    @Operation(summary = "delete by entrepriseSociete id")
    @DeleteMapping("entrepriseSociete/id/{id}")
    public ResponseEntity<Integer> deleteByEntrepriseSocieteId(@PathVariable Long id){
        return getResponse(service.deleteByEntrepriseSocieteId(id));
    }
    @Operation(summary = "find by depot id")
    @GetMapping("depot/id/{id}")
    public ResponseEntity<List<InventaireDto>> findByDepotId(@PathVariable Long id){
        return getResponse(service.findByDepotId(id));
    }
    @Operation(summary = "delete by depot id")
    @DeleteMapping("depot/id/{id}")
    public ResponseEntity<Integer> deleteByDepotId(@PathVariable Long id){
        return getResponse(service.deleteByDepotId(id));
    }



    public InventaireRestAdmin (InventaireAdminService service, InventaireConverter converter) {
        super(service, converter);
    }




}
