package  ma.zs.easystock.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.gestionchequeffet.Compte;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.CompteCriteria;
import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.CompteAdminService;
import ma.zs.easystock.ws.converter.gestionchequeffet.CompteConverter;
import ma.zs.easystock.ws.dto.gestionchequeffet.CompteDto;
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
@RequestMapping("/api/admin/compte/")
public class CompteRestAdmin  extends AbstractController<Compte, CompteDto, CompteCriteria, CompteAdminService, CompteConverter> {

    @Override
    @Operation(summary = "Finds a list of all comptes")
    @GetMapping("")
    public ResponseEntity<List<CompteDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a compte by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CompteDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  compte")
    @PostMapping("")
    public ResponseEntity<CompteDto> save(@RequestBody CompteDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  compte")
    @PutMapping("")
    public ResponseEntity<CompteDto> update(@RequestBody CompteDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified compte")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by banque id")
    @GetMapping("banque/id/{id}")
    public ResponseEntity<List<CompteDto>> findByBanqueId(@PathVariable Long id){
        return getResponse(service.findByBanqueId(id));
    }
    @Operation(summary = "delete by banque id")
    @DeleteMapping("banque/id/{id}")
    public ResponseEntity<Integer> deleteByBanqueId(@PathVariable Long id){
        return getResponse(service.deleteByBanqueId(id));
    }
    @Operation(summary = "find by proprietaire id")
    @GetMapping("proprietaire/id/{id}")
    public ResponseEntity<List<CompteDto>> findByProprietaireId(@PathVariable Long id){
        return getResponse(service.findByProprietaireId(id));
    }
    @Operation(summary = "delete by proprietaire id")
    @DeleteMapping("proprietaire/id/{id}")
    public ResponseEntity<Integer> deleteByProprietaireId(@PathVariable Long id){
        return getResponse(service.deleteByProprietaireId(id));
    }



    public CompteRestAdmin (CompteAdminService service, CompteConverter converter) {
        super(service, converter);
    }




}
