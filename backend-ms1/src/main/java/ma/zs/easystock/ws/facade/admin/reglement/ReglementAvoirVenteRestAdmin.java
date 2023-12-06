package  ma.zs.easystock.ws.facade.admin.reglement;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.reglement.ReglementAvoirVente;
import ma.zs.easystock.infra.dao.criteria.core.reglement.ReglementAvoirVenteCriteria;
import ma.zs.easystock.domain.service.facade.admin.reglement.ReglementAvoirVenteAdminService;
import ma.zs.easystock.ws.converter.reglement.ReglementAvoirVenteConverter;
import ma.zs.easystock.ws.dto.reglement.ReglementAvoirVenteDto;
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
@RequestMapping("/api/admin/reglementAvoirVente/")
public class ReglementAvoirVenteRestAdmin  extends AbstractController<ReglementAvoirVente, ReglementAvoirVenteDto, ReglementAvoirVenteCriteria, ReglementAvoirVenteAdminService, ReglementAvoirVenteConverter> {

    @Override
    @Operation(summary = "Finds a list of all reglementAvoirVentes")
    @GetMapping("")
    public ResponseEntity<List<ReglementAvoirVenteDto>> findAll(){
        return super.findAll();
    }

    @Override
    @Operation(summary = "Finds an optimized list of all reglementAvoirVentes")
    @GetMapping("optimized")
    public ResponseEntity<List<ReglementAvoirVenteDto>> findAllOptimized(){
        return super.findAllOptimized();
    }

    @Override
    @Operation(summary = "Finds a reglementAvoirVente by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ReglementAvoirVenteDto> findById(@PathVariable Long id){
        return super.findById(id);
    }

    @Operation(summary = "Finds a reglementAvoirVente by reference")
    @GetMapping("reference/{reference}")
    public ResponseEntity<ReglementAvoirVenteDto> findByReference(@PathVariable String reference){
        return getResponse(service.findByReference(reference));
    }

    @Operation(summary = "Deletes a reglementAvoirVente by reference")
    @DeleteMapping("reference/{reference}")
    public ResponseEntity<Integer> deleteByReference(@PathVariable String reference){
        return getResponse(service.deleteByReference(reference));
    }

    @Override
    @Operation(summary = "Saves the specified  reglementAvoirVente")
    @PostMapping("")
    public ResponseEntity<ReglementAvoirVenteDto> save(@RequestBody ReglementAvoirVenteDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  reglementAvoirVente")
    @PutMapping("")
    public ResponseEntity<ReglementAvoirVenteDto> update(@RequestBody ReglementAvoirVenteDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified reglementAvoirVente")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by vente id")
    @GetMapping("vente/id/{id}")
    public ResponseEntity<List<ReglementAvoirVenteDto>> findByVenteId(@PathVariable Long id){
        return getResponse(service.findByVenteId(id));
    }
    @Operation(summary = "delete by vente id")
    @DeleteMapping("vente/id/{id}")
    public ResponseEntity<Integer> deleteByVenteId(@PathVariable Long id){
        return getResponse(service.deleteByVenteId(id));
    }
    @Operation(summary = "find by modeReglement id")
    @GetMapping("modeReglement/id/{id}")
    public ResponseEntity<List<ReglementAvoirVenteDto>> findByModeReglementId(@PathVariable Long id){
        return getResponse(service.findByModeReglementId(id));
    }
    @Operation(summary = "delete by modeReglement id")
    @DeleteMapping("modeReglement/id/{id}")
    public ResponseEntity<Integer> deleteByModeReglementId(@PathVariable Long id){
        return getResponse(service.deleteByModeReglementId(id));
    }
    @Operation(summary = "find by avoirVente id")
    @GetMapping("avoirVente/id/{id}")
    public ResponseEntity<List<ReglementAvoirVenteDto>> findByAvoirVenteId(@PathVariable Long id){
        return getResponse(service.findByAvoirVenteId(id));
    }
    @Operation(summary = "delete by avoirVente id")
    @DeleteMapping("avoirVente/id/{id}")
    public ResponseEntity<Integer> deleteByAvoirVenteId(@PathVariable Long id){
        return getResponse(service.deleteByAvoirVenteId(id));
    }



    public ReglementAvoirVenteRestAdmin (ReglementAvoirVenteAdminService service, ReglementAvoirVenteConverter converter) {
        super(service, converter);
    }




}
