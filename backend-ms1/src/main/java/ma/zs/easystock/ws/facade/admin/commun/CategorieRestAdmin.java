package  ma.zs.easystock.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.commun.Categorie;
import ma.zs.easystock.infra.dao.criteria.core.commun.CategorieCriteria;
import ma.zs.easystock.domain.service.facade.admin.commun.CategorieAdminService;
import ma.zs.easystock.ws.converter.commun.CategorieConverter;
import ma.zs.easystock.ws.dto.commun.CategorieDto;
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
@RequestMapping("/api/admin/categorie/")
public class CategorieRestAdmin  extends AbstractController<Categorie, CategorieDto, CategorieCriteria, CategorieAdminService, CategorieConverter> {

    @Override
    @Operation(summary = "Finds a list of all categories")
    @GetMapping("")
    public ResponseEntity<List<CategorieDto>> findAll(){
        return super.findAll();
    }

    @Override
    @Operation(summary = "Finds an optimized list of all categories")
    @GetMapping("optimized")
    public ResponseEntity<List<CategorieDto>> findAllOptimized(){
        return super.findAllOptimized();
    }

    @Override
    @Operation(summary = "Finds a categorie by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CategorieDto> findById(@PathVariable Long id){
        return super.findById(id);
    }

    @Operation(summary = "Finds a categorie by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<CategorieDto> findByLibelle(@PathVariable String libelle){
        return getResponse(service.findByLibelle(libelle));
    }

    @Operation(summary = "Deletes a categorie by libelle")
    @DeleteMapping("libelle/{libelle}")
    public ResponseEntity<Integer> deleteByLibelle(@PathVariable String libelle){
        return getResponse(service.deleteByLibelle(libelle));
    }

    @Override
    @Operation(summary = "Saves the specified  categorie")
    @PostMapping("")
    public ResponseEntity<CategorieDto> save(@RequestBody CategorieDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  categorie")
    @PutMapping("")
    public ResponseEntity<CategorieDto> update(@RequestBody CategorieDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified categorie")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }






    public CategorieRestAdmin (CategorieAdminService service, CategorieConverter converter) {
        super(service, converter);
    }




}
