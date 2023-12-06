package  ma.zs.easystock.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.commun.Personne;
import ma.zs.easystock.infra.dao.criteria.core.commun.PersonneCriteria;
import ma.zs.easystock.domain.service.facade.admin.commun.PersonneAdminService;
import ma.zs.easystock.ws.converter.commun.PersonneConverter;
import ma.zs.easystock.ws.dto.commun.PersonneDto;
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
@RequestMapping("/api/admin/personne/")
public class PersonneRestAdmin  extends AbstractController<Personne, PersonneDto, PersonneCriteria, PersonneAdminService, PersonneConverter> {

    @Override
    @Operation(summary = "Finds a list of all personnes")
    @GetMapping("")
    public ResponseEntity<List<PersonneDto>> findAll(){
        return super.findAll();
    }

    @Override
    @Operation(summary = "Finds an optimized list of all personnes")
    @GetMapping("optimized")
    public ResponseEntity<List<PersonneDto>> findAllOptimized(){
        return super.findAllOptimized();
    }

    @Override
    @Operation(summary = "Finds a personne by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PersonneDto> findById(@PathVariable Long id){
        return super.findById(id);
    }

    @Operation(summary = "Finds a personne by telephone")
    @GetMapping("telephone/{telephone}")
    public ResponseEntity<PersonneDto> findByTelephone(@PathVariable String telephone){
        return getResponse(service.findByTelephone(telephone));
    }

    @Operation(summary = "Deletes a personne by telephone")
    @DeleteMapping("telephone/{telephone}")
    public ResponseEntity<Integer> deleteByTelephone(@PathVariable String telephone){
        return getResponse(service.deleteByTelephone(telephone));
    }

    @Override
    @Operation(summary = "Saves the specified  personne")
    @PostMapping("")
    public ResponseEntity<PersonneDto> save(@RequestBody PersonneDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  personne")
    @PutMapping("")
    public ResponseEntity<PersonneDto> update(@RequestBody PersonneDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified personne")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by ville id")
    @GetMapping("ville/id/{id}")
    public ResponseEntity<List<PersonneDto>> findByVilleId(@PathVariable Long id){
        return getResponse(service.findByVilleId(id));
    }
    @Operation(summary = "delete by ville id")
    @DeleteMapping("ville/id/{id}")
    public ResponseEntity<Integer> deleteByVilleId(@PathVariable Long id){
        return getResponse(service.deleteByVilleId(id));
    }



    public PersonneRestAdmin (PersonneAdminService service, PersonneConverter converter) {
        super(service, converter);
    }




}
