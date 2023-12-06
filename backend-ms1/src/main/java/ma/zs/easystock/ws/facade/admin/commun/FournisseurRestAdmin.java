package  ma.zs.easystock.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.commun.Fournisseur;
import ma.zs.easystock.infra.dao.criteria.core.commun.FournisseurCriteria;
import ma.zs.easystock.domain.service.facade.admin.commun.FournisseurAdminService;
import ma.zs.easystock.ws.converter.commun.FournisseurConverter;
import ma.zs.easystock.ws.dto.commun.FournisseurDto;
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
@RequestMapping("/api/admin/fournisseur/")
public class FournisseurRestAdmin  extends AbstractController<Fournisseur, FournisseurDto, FournisseurCriteria, FournisseurAdminService, FournisseurConverter> {

    @Override
    @Operation(summary = "Finds a list of all fournisseurs")
    @GetMapping("")
    public ResponseEntity<List<FournisseurDto>> findAll(){
        return super.findAll();
    }

    @Override
    @Operation(summary = "Finds an optimized list of all fournisseurs")
    @GetMapping("optimized")
    public ResponseEntity<List<FournisseurDto>> findAllOptimized(){
        return super.findAllOptimized();
    }

    @Override
    @Operation(summary = "Finds a fournisseur by id")
    @GetMapping("id/{id}")
    public ResponseEntity<FournisseurDto> findById(@PathVariable Long id){
        return super.findById(id);
    }

    @Operation(summary = "Finds a fournisseur by ice")
    @GetMapping("ice/{ice}")
    public ResponseEntity<FournisseurDto> findByIce(@PathVariable String ice){
        return getResponse(service.findByIce(ice));
    }

    @Operation(summary = "Deletes a fournisseur by ice")
    @DeleteMapping("ice/{ice}")
    public ResponseEntity<Integer> deleteByIce(@PathVariable String ice){
        return getResponse(service.deleteByIce(ice));
    }

    @Override
    @Operation(summary = "Saves the specified  fournisseur")
    @PostMapping("")
    public ResponseEntity<FournisseurDto> save(@RequestBody FournisseurDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  fournisseur")
    @PutMapping("")
    public ResponseEntity<FournisseurDto> update(@RequestBody FournisseurDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified fournisseur")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }






    public FournisseurRestAdmin (FournisseurAdminService service, FournisseurConverter converter) {
        super(service, converter);
    }




}
