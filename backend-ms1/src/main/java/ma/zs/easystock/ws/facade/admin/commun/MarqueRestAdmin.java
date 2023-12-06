package  ma.zs.easystock.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.commun.Marque;
import ma.zs.easystock.infra.dao.criteria.core.commun.MarqueCriteria;
import ma.zs.easystock.domain.service.facade.admin.commun.MarqueAdminService;
import ma.zs.easystock.ws.converter.commun.MarqueConverter;
import ma.zs.easystock.ws.dto.commun.MarqueDto;
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
@RequestMapping("/api/admin/marque/")
public class MarqueRestAdmin  extends AbstractController<Marque, MarqueDto, MarqueCriteria, MarqueAdminService, MarqueConverter> {

    @Override
    @Operation(summary = "Finds a list of all marques")
    @GetMapping("")
    public ResponseEntity<List<MarqueDto>> findAll(){
        return super.findAll();
    }

    @Override
    @Operation(summary = "Finds an optimized list of all marques")
    @GetMapping("optimized")
    public ResponseEntity<List<MarqueDto>> findAllOptimized(){
        return super.findAllOptimized();
    }

    @Override
    @Operation(summary = "Finds a marque by id")
    @GetMapping("id/{id}")
    public ResponseEntity<MarqueDto> findById(@PathVariable Long id){
        return super.findById(id);
    }

    @Operation(summary = "Finds a marque by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<MarqueDto> findByLibelle(@PathVariable String libelle){
        return getResponse(service.findByLibelle(libelle));
    }

    @Operation(summary = "Deletes a marque by libelle")
    @DeleteMapping("libelle/{libelle}")
    public ResponseEntity<Integer> deleteByLibelle(@PathVariable String libelle){
        return getResponse(service.deleteByLibelle(libelle));
    }

    @Override
    @Operation(summary = "Saves the specified  marque")
    @PostMapping("")
    public ResponseEntity<MarqueDto> save(@RequestBody MarqueDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  marque")
    @PutMapping("")
    public ResponseEntity<MarqueDto> update(@RequestBody MarqueDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified marque")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }






    public MarqueRestAdmin (MarqueAdminService service, MarqueConverter converter) {
        super(service, converter);
    }




}
