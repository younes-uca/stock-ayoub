package  ma.zs.easystock.ws.facade.admin.reglement;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.reglement.ReglementVente;
import ma.zs.easystock.infra.dao.criteria.core.reglement.ReglementVenteCriteria;
import ma.zs.easystock.domain.service.facade.admin.reglement.ReglementVenteAdminService;
import ma.zs.easystock.ws.converter.reglement.ReglementVenteConverter;
import ma.zs.easystock.ws.dto.reglement.ReglementVenteDto;
import ma.zs.easystock.zynerator.controller.AbstractController;
import ma.zs.easystock.zynerator.dto.AuditEntityDto;
import ma.zs.easystock.zynerator.helper.PaginatedList;



import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.easystock.zynerator.process.Result;

import org.springframework.http.HttpEntity;


@RestController
@RequestMapping("/api/admin/reglementVente/")
public class ReglementVenteRestAdmin  extends AbstractController<ReglementVente, ReglementVenteDto, ReglementVenteCriteria, ReglementVenteAdminService, ReglementVenteConverter> {

    @Override
    @Operation(summary = "Finds a list of all reglementVentes")
    @GetMapping("")
    public ResponseEntity<List<ReglementVenteDto>> findAll(){
        return super.findAll();
    }

    @Override
    @Operation(summary = "Finds an optimized list of all reglementVentes")
    @GetMapping("optimized")
    public ResponseEntity<List<ReglementVenteDto>> findAllOptimized(){
        return super.findAllOptimized();
    }

    @Override
    @Operation(summary = "Finds a reglementVente by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ReglementVenteDto> findById(@PathVariable Long id){
        return super.findById(id);
    }

    @Operation(summary = "Finds a reglementVente by reference")
    @GetMapping("reference/{reference}")
    public ResponseEntity<ReglementVenteDto> findByReference(@PathVariable String reference){
        return getResponse(service.findByReference(reference));
    }

    @Operation(summary = "Deletes a reglementVente by reference")
    @DeleteMapping("reference/{reference}")
    public ResponseEntity<Integer> deleteByReference(@PathVariable String reference){
        return getResponse(service.deleteByReference(reference));
    }

    @Override
    @Operation(summary = "Saves the specified  reglementVente")
    @PostMapping("")
    public ResponseEntity<ReglementVenteDto> save(@RequestBody ReglementVenteDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  reglementVente")
    @PutMapping("")
    public ResponseEntity<ReglementVenteDto> update(@RequestBody ReglementVenteDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified reglementVente")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by vente id")
    @GetMapping("vente/id/{id}")
    public ResponseEntity<List<ReglementVenteDto>> findByVenteId(@PathVariable Long id){
        return getResponse(service.findByVenteId(id));
    }
    @Operation(summary = "delete by vente id")
    @DeleteMapping("vente/id/{id}")
    public ResponseEntity<Integer> deleteByVenteId(@PathVariable Long id){
        return getResponse(service.deleteByVenteId(id));
    }
    @Operation(summary = "find by modeReglement id")
    @GetMapping("modeReglement/id/{id}")
    public ResponseEntity<List<ReglementVenteDto>> findByModeReglementId(@PathVariable Long id){
        return getResponse(service.findByModeReglementId(id));
    }
    @Operation(summary = "delete by modeReglement id")
    @DeleteMapping("modeReglement/id/{id}")
    public ResponseEntity<Integer> deleteByModeReglementId(@PathVariable Long id){
        return getResponse(service.deleteByModeReglementId(id));
    }



    public ReglementVenteRestAdmin (ReglementVenteAdminService service, ReglementVenteConverter converter) {
        super(service, converter);
    }




}
