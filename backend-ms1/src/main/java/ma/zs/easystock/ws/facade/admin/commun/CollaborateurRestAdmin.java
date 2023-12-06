package  ma.zs.easystock.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.commun.Collaborateur;
import ma.zs.easystock.infra.dao.criteria.core.commun.CollaborateurCriteria;
import ma.zs.easystock.domain.service.facade.admin.commun.CollaborateurAdminService;
import ma.zs.easystock.ws.converter.commun.CollaborateurConverter;
import ma.zs.easystock.ws.dto.commun.CollaborateurDto;
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
@RequestMapping("/api/admin/collaborateur/")
public class CollaborateurRestAdmin  extends AbstractController<Collaborateur, CollaborateurDto, CollaborateurCriteria, CollaborateurAdminService, CollaborateurConverter> {

    @Override
    @Operation(summary = "Finds a list of all collaborateurs")
    @GetMapping("")
    public ResponseEntity<List<CollaborateurDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a collaborateur by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CollaborateurDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  collaborateur")
    @PostMapping("")
    public ResponseEntity<CollaborateurDto> save(@RequestBody CollaborateurDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  collaborateur")
    @PutMapping("")
    public ResponseEntity<CollaborateurDto> update(@RequestBody CollaborateurDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified collaborateur")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }






    public CollaborateurRestAdmin (CollaborateurAdminService service, CollaborateurConverter converter) {
        super(service, converter);
    }




}
