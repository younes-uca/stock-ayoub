package  ma.zs.easystock.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.commun.UniteMesure;
import ma.zs.easystock.infra.dao.criteria.core.commun.UniteMesureCriteria;
import ma.zs.easystock.domain.service.facade.admin.commun.UniteMesureAdminService;
import ma.zs.easystock.ws.converter.commun.UniteMesureConverter;
import ma.zs.easystock.ws.dto.commun.UniteMesureDto;
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
@RequestMapping("/api/admin/uniteMesure/")
public class UniteMesureRestAdmin  extends AbstractController<UniteMesure, UniteMesureDto, UniteMesureCriteria, UniteMesureAdminService, UniteMesureConverter> {

    @Override
    @Operation(summary = "Finds a list of all uniteMesures")
    @GetMapping("")
    public ResponseEntity<List<UniteMesureDto>> findAll(){
        return super.findAll();
    }

    @Override
    @Operation(summary = "Finds an optimized list of all uniteMesures")
    @GetMapping("optimized")
    public ResponseEntity<List<UniteMesureDto>> findAllOptimized(){
        return super.findAllOptimized();
    }

    @Override
    @Operation(summary = "Finds a uniteMesure by id")
    @GetMapping("id/{id}")
    public ResponseEntity<UniteMesureDto> findById(@PathVariable Long id){
        return super.findById(id);
    }

    @Operation(summary = "Finds a uniteMesure by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<UniteMesureDto> findByLibelle(@PathVariable String libelle){
        return getResponse(service.findByLibelle(libelle));
    }

    @Operation(summary = "Deletes a uniteMesure by libelle")
    @DeleteMapping("libelle/{libelle}")
    public ResponseEntity<Integer> deleteByLibelle(@PathVariable String libelle){
        return getResponse(service.deleteByLibelle(libelle));
    }

    @Override
    @Operation(summary = "Saves the specified  uniteMesure")
    @PostMapping("")
    public ResponseEntity<UniteMesureDto> save(@RequestBody UniteMesureDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  uniteMesure")
    @PutMapping("")
    public ResponseEntity<UniteMesureDto> update(@RequestBody UniteMesureDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified uniteMesure")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }






    public UniteMesureRestAdmin (UniteMesureAdminService service, UniteMesureConverter converter) {
        super(service, converter);
    }




}
